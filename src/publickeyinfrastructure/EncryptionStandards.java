/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author somil
 */
public class EncryptionStandards {
    private SecretKey key;
    private File File;
    private String message;
    private String DecryptString;
    private long TotalSize;
    private String AlgoType;

    public EncryptionStandards(String filenm,long TotalSize,String algo) {
        File=new File(filenm);
        this.TotalSize=TotalSize;
        message=null;
        DecryptString=null;
        AlgoType=algo;
        try {
            key=KeyGenerator.getInstance(AlgoType).generateKey();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No such algo:des");
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public EncryptionStandards(String msg,String algo) {
        File=null;
        AlgoType=algo;
        message=msg;
        TotalSize=msg.length();
        DecryptString=null;
        try {
            key=KeyGenerator.getInstance(AlgoType).generateKey();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No such algo:des");
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public EncryptionStandards(String Algo,SecretKey key,String DataEncryptionString) {
        File=null;
        AlgoType=Algo;
        this.DecryptString=DataEncryptionString;
        message=null;
        TotalSize=0;
        this.key=key;
}
    public EncryptionStandards(String algo,SecretKey key,String DataEncryptionString,File file) {
        File=file;
        AlgoType=algo;
        this.DecryptString=DataEncryptionString;
        message=null;
        TotalSize=0;
        this.key=key;
}

    SecretKey getKey() {
        return key;
    }
      String getDecryptedMessage() {
        return DecryptString;
    }
    
    public void encrypt()
    {
        FileInputStream fst; 
        byte[] arr=new byte[(int)TotalSize];
        if(!message.isEmpty())try {
            arr=message.getBytes("UTF8");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported");
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
            return ; 
        }
        else{
            try {
                fst=new FileInputStream(File);
                fst.read(arr, 0, (int) TotalSize);
                arr = new String(arr).getBytes("UTF8");
            } catch (FileNotFoundException ex) {
                EndUser.DisplayMessage("File not found", "Error", 0); 
                Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
                return;
            } catch (IOException ex) {
                EndUser.DisplayMessage("FIle reading error", "Error", 0); 
                Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
            return;
            }
        }
        Cipher ecipher;
        try {
            ecipher = Cipher.getInstance(AlgoType);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No such Algo"); 
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
         return; } catch (NoSuchPaddingException ex) 
        {System.out.println("No such padding");
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
        return; }
        try {
            ecipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
        return;  }
         byte[] enc;
        try {
           enc = ecipher.doFinal(arr);
            enc = BASE64EncoderStream.encode(enc);
            
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause());
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
       return ; }

           DecryptString=new String(enc);   
    }
    public void decrypt()
    {
       Cipher dcipher = null;
        try {
            dcipher = Cipher.getInstance(AlgoType);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCause());return ;}
                byte[] dec=BASE64DecoderStream.decode(DecryptString.getBytes());
byte[] utf8;
        try {
            utf8 = dcipher.doFinal(dec);
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println(ex.getCause());return; }
        try {
            // create new string based on the specified charse
           
            String decrypt=new String(utf8, "UTF8");
            if(File==null) message=decrypt;
            else {
                FileOutputStream fos=new FileOutputStream(File);
                fos.write(decrypt.getBytes());
                
            }
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println(ex.getCause());} catch (IOException ex) {
            EndUser.DisplayMessage("Error while file creation", "error", 0);Logger.getLogger(EncryptionStandards.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
}