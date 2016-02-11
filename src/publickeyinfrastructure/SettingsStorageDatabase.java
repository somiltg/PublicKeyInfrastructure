/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author somil
 */
public class SettingsStorageDatabase {
   private static Properties properties=new Properties();
    
    public static boolean update(byte choice,String updated)
    {
        try {
            FileOutputStream fos = new FileOutputStream("Settings.properties");
             switch(choice)
            {
                case 0: properties.setProperty("SystemType",updated); break;
                case 1: properties.setProperty("SystemID",updated); break;
                    case 2: properties.setProperty("BufferSize",updated); break;
                   case 3: properties.setProperty("DestPath",updated); break;
                       case 4:properties.getProperty("CAIP"); break;
                       case 5:properties.getProperty("EncAlgo"); break;
                       case 6: properties.getProperty("PublicKey"); break;
                       case 7: properties.getProperty("PrivateKey"); break;
                           
            }
             properties.store(fos,"");
            fos.close();
            
        } catch (Exception ex) {
             System.out.println("hi"); System.out.println(ex);return false;
        }
        return true;
    }
    
    public static String seek(byte choice)
    {
        try {
            FileInputStream fis = new FileInputStream("Settings.properties");
            properties.load(fis);
            fis.close();
            switch(choice)
            {
                case 0: return properties.getProperty("SystemType");
                case 1: return properties.getProperty("SystemID");
                    case 2: System.out.println(properties.getProperty("BufferSize"));
                        return properties.getProperty("BufferSize");
                        case 3: return properties.getProperty("DestPath");
                        case 4: return properties.getProperty("CAIP");
                             case 5: return properties.getProperty("EncAlgo");
                             case 6: return properties.getProperty("PublicKey");
                             case 7: return properties.getProperty("PrivateKey");
            }
      } catch (Exception ex) {
            System.out.println(ex);return "0";
        }
        return null;
    }
    
}
