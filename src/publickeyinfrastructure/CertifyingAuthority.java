/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.AuthorityKeyIdentifierExtension;
import sun.security.x509.BasicConstraintsExtension;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateExtensions;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.ExtendedKeyUsageExtension;
import sun.security.x509.KeyIdentifier;
import sun.security.x509.KeyUsageExtension;
import sun.security.x509.NetscapeCertTypeExtension;
import sun.security.x509.SubjectKeyIdentifierExtension;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/**
 *
 * @author somil
 */
public class CertifyingAuthority {
   
    private X500Name MyName;
    private KeyPair MyKey;
    private String SIG_ALGORITHM;
    private char CAType;
    private int followInterCANo;

    public CertifyingAuthority() {
    
    }

    public X500Name getMyName() {
        return MyName;
    }
    public static String getEmail(X500Name name)
    {
        int k=name.toString().indexOf("EMAILADDRESS=");
            if(k!=-1){
             int x=name.toString().indexOf(',', k+13);
             if(x==-1)x=name.toString().length();
                return name.toString().substring(k+13,x);
            }
            else return null;
    }
     public static String DisplayName(X500Name name) {
        try {
            String dn="";
            if(name.getCommonName()!=null)dn+=name.getCommonName()+"\n";
            if(getEmail(name)!=null)dn+=getEmail(name)+"\n";
              if(name.getOrganizationalUnit()!=null)dn+=name.getOrganizationalUnit()+"\n";
               if(name.getOrganization()!=null)dn+=name.getOrganization()+"\n";
                if(name.getLocality()!=null)dn+=name.getLocality()+"\n";
                 if(name.getState()!=null)dn+=name.getState()+"\n";
                  if(name.getCountry()!=null)dn+=name.getCountry()+"\n";
                  return dn;
        } catch (IOException ex) {
            Logger.getLogger(CertifyingAuthority.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
     }
   
    public KeyPair getMyKey() {
        return MyKey;
    }

    public String getSIG_ALGORITHM() {
        return SIG_ALGORITHM;
    }

    public char getCAType() {
        return CAType;
    }

    public int getFollowInterCANo() {
        return followInterCANo;
    }
    
    
     public static String getNameInfo(String CN, String EMAIL,String Org, String OrgUnit, String Loc, String State, String Coun)
     {
         String dn="";
         if(CN.isEmpty()==false)dn+="CN="+CN+",";
         if(EMAIL.isEmpty()==false)dn+="EMAIL="+EMAIL+",";
         if(Org.isEmpty()==false)dn+="O="+Org+",";
         if(OrgUnit.isEmpty()==false)dn+="OU="+OrgUnit+",";
         if(Loc.isEmpty()==false)dn+="L="+Loc+",";
         if(State.isEmpty()==false)dn+="ST="+State+",";
         if(Coun.isEmpty()==false)dn+="C="+Coun+",";
        if(dn.isEmpty()==false)dn=dn.substring(0, dn.length()-1);
         return dn;
     }
                    
    X509Certificate generateCertificate(String dn, PublicKey pkey, int days)
    {
        X509CertImpl cert=null;
        try {
            PrivateKey privkey = MyKey.getPrivate();
            X509CertInfo info = new X509CertInfo();
            Date from = new Date();
            Date to = new Date(from.getTime() + days * 86400000l);
            CertificateValidity interval = new CertificateValidity(from, to);
            BigInteger sn = new BigInteger(64, new SecureRandom());
            X500Name owner = new X500Name(dn);
            info.set(X509CertInfo.EXTENSIONS,getCertificateExtensions(pkey, MyKey.getPublic(), (CAType != 2),followInterCANo ));
            info.set(X509CertInfo.VALIDITY, interval);
            info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(sn));
            info.set(X509CertInfo.SUBJECT, new CertificateSubjectName(owner));
            info.set(X509CertInfo.ISSUER, new CertificateIssuerName(MyName));
            info.set(X509CertInfo.KEY, new CertificateX509Key(pkey));
            info.set(X509CertInfo.VERSION, CertificateVersion.V3);
            AlgorithmId algo = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
            info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));
            
            // Sign the cert to identify the algorithm that's used.
            cert = new X509CertImpl(info);
            cert.sign(privkey, SIG_ALGORITHM);
            
            // Update the algorith, and resign.
            algo = (AlgorithmId)cert.get(X509CertImpl.SIG_ALG);
            info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algo);
            cert = new X509CertImpl(info);
            cert.sign(privkey, SIG_ALGORITHM);
            
        } catch (IOException | NoSuchAlgorithmException | SignatureException | NoSuchProviderException|CertificateException | InvalidKeyException ex) {
            System.err.println(ex);
            Logger.getLogger(CertifyingAuthority.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    return cert;
    }  

 private static CertificateExtensions getCertificateExtensions( 
   PublicKey pubKey, PublicKey caPubKey,boolean isca,int pathLen) { 
        try {
            //create extensions for all types-root, intermediate,issuing
            CertificateExtensions ext = new CertificateExtensions();
            boolean root=pubKey==caPubKey;
            ext.set(SubjectKeyIdentifierExtension.NAME,
                    new SubjectKeyIdentifierExtension(new KeyIdentifier(pubKey)
                            .getIdentifier()));
            if(!root)
                ext.set(AuthorityKeyIdentifierExtension.NAME,
                        new AuthorityKeyIdentifierExtension(
                                new KeyIdentifier(caPubKey), null, null));
            // Basic Constraints
            ext.set(BasicConstraintsExtension.NAME, new BasicConstraintsExtension(
                    /* isCritical */Boolean.TRUE, /* isCA */isca, /* pathLen */pathLen));
            
            // Netscape Cert Type Extension
            
            boolean[] ncteOk = new boolean[8];
            if(!isca)
            {
                ncteOk[0] = true; // SSL_CLIENT
                ncteOk[1] = true; // SSL_SERVER
                NetscapeCertTypeExtension ncte = new NetscapeCertTypeExtension(ncteOk);
                ncte = new NetscapeCertTypeExtension(Boolean.FALSE, ncte.getExtensionValue());
                ext.set(NetscapeCertTypeExtension.NAME, ncte);
            }
            // Key Usage Extension
            // "digitalSignature", // (0),
            // "nonRepudiation", // (1)
            // "keyEncipherment", // (2),
            // "dataEncipherment", // (3),
            // "keyAgreement", // (4),
            // "keyCertSign", // (5),
            // "cRLSign", // (6),
            // "encipherOnly", // (7),
            // "decipherOnly", // (8)
            // "contentCommitment" // also (1)
            boolean[] kueOk = new boolean[9];
            if(isca)
            {
                kueOk[5] = true;
                kueOk[6] = true;
            }
            else
            {kueOk[0] = true;
            kueOk[2] = true;
            }
            
            KeyUsageExtension kue = new KeyUsageExtension(kueOk);
            ext.set(KeyUsageExtension.NAME, kue);
            
            // Extended Key Usage Extension
            int[] serverAuthOidData = { 1, 3, 6, 1, 5, 5, 7, 3, 1 };
            ObjectIdentifier serverAuthOid = new ObjectIdentifier(serverAuthOidData);
            int[] clientAuthOidData = { 1, 3, 6, 1, 5, 5, 7, 3, 2 };
            ObjectIdentifier clientAuthOid = new ObjectIdentifier(clientAuthOidData);
            Vector<ObjectIdentifier> v = new Vector<ObjectIdentifier>();
            if(!isca)
                
            {v.add(serverAuthOid);
            v.add(clientAuthOid);
            ExtendedKeyUsageExtension ekue = new ExtendedKeyUsageExtension(Boolean.FALSE, v);
            ext.set(ExtendedKeyUsageExtension.NAME, ekue);
            } 
            return ext;
        } catch (IOException ex) {
            Logger.getLogger(CertifyingAuthority.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
 } 
 
}
