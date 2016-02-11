/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author somil
 */
public class EndUser {
    public static final String SENDER_STATUSES[] = {"Transferring",
    "Transferred", "Cancelled", "Error","Handshaking","Verifying UserName...","Verified","Requesting...Sending Certificates","Request Accepted..Sending key","Encrypting","Refused intake"};
    public static final String RECEIVER_STATUSES[] = {"Receiving",
    "Received", "Cancelled", "Error","Receiving Credentials...","Verifying Credentials","Request Granted","Waiting for data","Decrypting"};
   public static X509Certificate certificate;

    private static int BufferSize;
    private static String AlgoType;
    private static String DestiFolder;
    private static String MyName;
    private static String CAIP;
    private static String CASign;
    private static EndUserInterface board;
    private static KeyPair pair;
    public EndUser()
    {
       
       FileInputStream inStream = null;
        try {
            //new Receiver().run();
            MyName=SettingsStorageDatabase.seek((byte)1);
            CAIP=SettingsStorageDatabase.seek((byte)4);
            BufferSize=Integer.parseInt(SettingsStorageDatabase.seek((byte)2));
            DestiFolder= SettingsStorageDatabase.seek((byte)3);
            AlgoType=SettingsStorageDatabase.seek((byte)5);
           /* try {//key pair generation
                KeyFactory fact=KeyFactory.getInstance("RSA");
                byte[] encodedPrivateKey = SettingsStorageDatabase.seek((byte)7).getBytes();
                byte[] encodedPublicKey = SettingsStorageDatabase.seek((byte)6).getBytes();
                    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
                        encodedPublicKey);
                PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
                        encodedPrivateKey);
                PublicKey publicKey;
                
                publicKey = fact.generatePublic(publicKeySpec);
                PrivateKey privateKey = fact.generatePrivate(privateKeySpec);
                
                pair=new KeyPair(publicKey, privateKey);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
                Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
            }catch (InvalidKeySpecException ex) {
                EndUser.DisplayMessage("Settings.properties has been tampered", "Tampering", 0);
                Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            //load certificate
            try{
            inStream = new FileInputStream("MyCertificate.cer");
            }
            catch(FileNotFoundException ex)
            {
                
            }
            CertificateFactory cf = null;
            try {
                cf = CertificateFactory.getInstance("X.509");
                certificate = (X509Certificate)cf.generateCertificate(inStream);
                System.out.println(certificate.getPublicKey());
            } catch (java.security.cert.CertificateException ex) {
                DisplayMessage(ex.getMessage(), "Certificate Error", 0); System.out.println(ex);
                Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
            }
                inStream.close();
             
            MyName=certificate.getSubjectDN().getName();
            MyName=MyName.substring(3, MyName.indexOf(','));
            CASign=certificate.getIssuerX500Principal().getName();
            CASign=CASign.substring(3, CASign.indexOf(','));
            board=new EndUserInterface(this);
            board.setVisible(true);
            board.setFocusableWindowState(true);//to transfer focus to window
        } catch (IOException ex) {
            System.err.println(ex.getCause()); Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static int getBufferSize() {
        return BufferSize;
    }
     public boolean isFileValid(String filename)
    {
        final char[] ILLEGAL_CHARACTERS= { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
        if(filename.length()>25)return false;
       File f = new File(filename);
  try {//tries to form filename, if seperator present then obtained filename and original would not match
    if(!f.getCanonicalFile().getName().equals(filename))return false;
    int k;
    for(k=0;k<ILLEGAL_CHARACTERS.length;k++)
    {
        if(filename.indexOf(ILLEGAL_CHARACTERS[k])!=-1)break;
    }
    if(k!=ILLEGAL_CHARACTERS.length)return false;
        return true;
  } catch (IOException e) {
    return false;
  }
    }
   public static PublicKey getPublicKey()
   {
     return pair.getPublic();
   }
public static PrivateKey getPrivateKey()
   {
     return pair.getPrivate();
   }

    public static void setBufferSize(int BufferSize) {
        EndUser.BufferSize = BufferSize;
   }

    public static String getAlgoType() {
        return AlgoType;
    }

    public static void setAlgoType(String AlgoType) {
        EndUser.AlgoType = AlgoType;
    }

    public static String getDestiFolder() {
        return DestiFolder;
    }

    public static void setDestiFolder(String DestiFolder) {
        EndUser.DestiFolder = DestiFolder;
    }

    public static String getMyName() {
        return MyName;
    }


    public static String getCAIP() {
        return CAIP;
    }

    public static void setCAIP(String CAIP) {
        EndUser.CAIP = CAIP;
    }

    public static String getCASign() {
        return CASign;
    }
    
     void actionCancel(SenderSideTransfer SelectedSenderTransfer) {
     if(SelectedSenderTransfer==null)return;
     SelectedSenderTransfer.cancel();
    }
     void actionCancel(ReceiverSideTransfer SelectedReceiverTransfer) {
     if(SelectedReceiverTransfer==null)return;
     SelectedReceiverTransfer.cancel();
    }
    
  static void DisplayMessage(String str, String title,int choice)
   {
       board.DisplayMessage(str, title, choice);
   }
   public static byte[] RSAEncrypt(Key key,String msg)
  {
      byte[] encArray = null;
        try { 
            Cipher cipher=Cipher.getInstance("RSA/None/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
       encArray=cipher.doFinal(msg.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException|IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause()); Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return encArray;
        }
public static String RSADecrypt(Key key,byte[] msg)
  {
        
      try { 
            Cipher cipher=Cipher.getInstance("RSA/None/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
       return new String(cipher.doFinal(msg));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException|IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause()); Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        }
private static String convertByteArrayToHexString(byte[] arrayBytes) {
    StringBuilder stringBuffer = new StringBuilder();
    for (int i = 0; i < arrayBytes.length; i++) {
        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                .substring(1));
    }
    return stringBuffer.toString();
}
public static String HashCreate(String msg, final String Algo)
{
        try {
            MessageDigest digest = MessageDigest.getInstance(Algo);
            byte[] hashBytes = digest.digest(msg.getBytes("UTF8"));
             return convertByteArrayToHexString(hashBytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println(ex.getCause());
            Logger.getLogger(EndUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
private class Receiver implements Runnable
{

        @Override
        public void run() {
            while(true)
            {
    try {
       ServerSocket serviceSocket = new ServerSocket(10000, 10, null);
                new ReceiverSideTransfer(serviceSocket.accept()).run();
    }
    catch (IOException e) {
        EndUser.DisplayMessage("Could not obtain connection", "No connection", 0);
    }
        }
   }
    
}
}