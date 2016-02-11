
package publickeyinfrastructure;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.text.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author somil
 */
class SenderSideTransfer extends Observable implements Runnable 
{
	/* Attributes */
	private long BytesTransferred;   //Bytes Transferred
	private int BufferSize;
        private long TotalSize;
        private String FilePath;
        private String User;
        private String IP;
        private int status;
        private String message;
        private boolean Hostname;
        private long StartTime;
        private String AlgoType;
        
  // These are the status codes.
  public static final int TRANSFERRING = 0;
  public static final int COMPLETE = 1;
  public static final int CANCELLED = 2;
  public static final int ERROR = 3;
  public static final int REQUESTING = 4;
  
          
        
	public SenderSideTransfer(String user,String PathName,String IP,boolean Hostname){  
                BytesTransferred=0;
                message=null;
                this.Hostname=Hostname;
                this.IP=IP;
                User=user;
                FilePath=PathName;
                status=REQUESTING;
                TotalSize=new File(PathName).length();		
                StartTime=0;
                AlgoType=EndUser.getAlgoType();
        }
       public SenderSideTransfer(boolean Hostname,String user,String msg,String IP){  
                BytesTransferred=0;
                message=msg;
                this.Hostname=Hostname;
                this.IP=IP;
                User=user;
                FilePath=null;
                status=REQUESTING;
                TotalSize=message.length();
                StartTime=0;
                AlgoType=EndUser.getAlgoType();
		}
       		public static String millisecondsToString(long time){
		int milliseconds = (int)(time % 1000);
		int seconds = (int)((time/1000) % 60);
		int minutes = (int)((time/60000) % 60);
		int hours = (int)((time/3600000) % 24);

		String millisecondsStr = (milliseconds<10 ? "00" : (milliseconds<100 ? "0" : ""))+milliseconds;
		String secondsStr = (seconds<10 ? "0" : "")+seconds;
		String minutesStr = (minutes<10 ? "0" : "")+minutes;
		String hoursStr = (hours<10 ? "0" : "")+hours;
		
		return new String(hoursStr+":"+minutesStr+":"+secondsStr);
	}
	public String getTimeForTransfer(){
            
                if(status>0)
                    return "N/A";
		long time_elapsed,required_time;
		time_elapsed = System.currentTimeMillis() - StartTime;
		if (BytesTransferred > 0)
		required_time = (long)(((TotalSize) * time_elapsed)/BytesTransferred) - time_elapsed;
		else
		required_time =0;
		
		return " " + millisecondsToString(required_time) + " ";
	
	}
        public String getMessage()
        {
            return message;
        }
	public String getTransferSpeed(){ 
	
		float current_speed;NumberFormat formatter ;
                if(status>0)
                    return "N/A";
                long currBytesDown=BytesTransferred;
		if (currBytesDown > 0 )
		current_speed = ((float) (currBytesDown*1000) / (System.currentTimeMillis() - StartTime));
		else
		current_speed = 0;
            formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(2);
                if(current_speed<1024)return " " + formatter.format(current_speed) + " Bytes/sec ";
                current_speed/=1024;
                if(current_speed<1024)return " " + formatter.format(current_speed) + " KB/sec ";
                return " " + formatter.format(current_speed) + " MB/sec ";
	
	}
	
        public String getFilePath()
        {
            return FilePath;
        }
       public static String BytestoString(long bytes){
		if(bytes<1024)return bytes+ "Bytes";
                bytes/=1024;
                if(bytes<1024)return bytes+ "KB";
                bytes/=1024;
                if(bytes<1024)return bytes+ "MB";
                bytes/=1024;
		if(bytes<1024)return bytes+ "GB";
                bytes/=1024;
                return bytes+ "TB";
	}
        public String getBytesTransferred()
        {
            return BytestoString(BytesTransferred);
        }

       public String getSize()
       {   
           
           return BytestoString(TotalSize);
       }
       public float getProgress(){ 
		
			if ( BytesTransferred > 0 && TotalSize > 0 )
			return ((float)( BytesTransferred * 100 ) / TotalSize) ;
                        else return 0.0f;
		}
      public String getIP()
      {
          return IP;
      }
      public String getUserName()
      {
          return User;
      }
        
	public int getStatus()
        {
            return status;
        }
        public Socket getSocket(int port)
        {
            Socket socket = null;
            if(!Hostname){try {
                            socket=new Socket(InetAddress.getByName(IP),port);
            } catch (IOException ex) {
                EndUser.DisplayMessage("Error in forming socket", "Socket Error", 0);
                Logger.getLogger(SenderSideTransfer.class.getName()).log(Level.SEVERE, null, ex);
            }
                        }else try {
                            socket=new Socket(IP,port);
            } catch (IOException ex) {
                 EndUser.DisplayMessage("Error in forming socket or Resolving Named Host", "Socket Error", 0);
                Logger.getLogger(SenderSideTransfer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return socket;
        }
      
	public int StartTransfer(){ 
            Socket socket,sendsocket;
             status= 5;
             stateChanged();
			Public Key ClientPublicKey=getReceiverCertification();	
                   status= 6;
             stateChanged();
                    socket=getSocket(10000);
                    if(socket==null){error();return 0;}
                    try{
                        
                    BufferedReader ControlInstream=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter ControlOutstream=new PrintWriter(socket.getOutputStream());
                    PrintWriter DataOutStream=new PrintWriter(sendsocket.getOutputStream());
                    //Handshake
                    status=4;stateChanged();
                    String HandshakeData="Username:"+EndUser.getMyName()+"\nAlgoType:"+AlgoType+"\nTotalSize:"+TotalSize+"\nmessage:"+(message.isEmpty()?"y\n":"n\n")+"certiLength:"+EndUser.certificate.toString().length()+"\n";
                    
                    ControlOutstream.write(HandshakeData,0,HandshakeData.length());
                    if(ControlInstream.readLine().equals("Rejected"))
                    {
                        EndUser.DisplayMessage("Receiver rejected the request", "Request refused", 1);
                        status=10; stateChanged(); socket.close(); sendsocket.close(); return 0;
                    }
                    status=7;stateChanged();
                    ControlOutstream.write(EndUser.certificate.toString(),0,EndUser.certificate.toString().length());
                     if(ControlInstream.readLine().equals("Invalid"))
                    {
                        EndUser.DisplayMessage("Receiver found certificate invalid", "Erred certificate", 0);
                        status=3; stateChanged(); socket.close(); sendsocket.close(); return 0;
                    }   
                     status=8; stateChanged();
                     EncryptionStandards encrypt;
          
                         if(message.isEmpty())encrypt=new EncryptionStandards(FilePath,TotalSize,AlgoType);
                         else encrypt=new EncryptionStandards(AlgoType,message);
            
                        byte[] encryptedKey=EndUser.RSAEncrypt(EndUser.RSAEncrypt(ClientPublicKey,encrypt.getKey()), EndUser.getPrivateKey());
                String Hash = EndUser.HashCreate(new String(encrypt.getKey().getEncoded()),"MD5");
                     ControlOutstream.write(new String(encryptedKey)+"\n",0,(new String(encryptedKey)+"\n").length());
                     ControlOutstream.write(Hash+"\n",0,(Hash+"\n").length());
                      if(ControlInstream.readLine().equals("HashMismatch"))
                    {
                        System.err.println("HashMismatch");
                        status=3; stateChanged(); socket.close(); sendsocket.close(); return 0;
                    }   
                      status=9; stateChanged();
                      sendsocket=getSocket(10001);
                      encrypt.encrypt();
                      status=0; stateChanged();
                      DataOutStream.write(encrypt.getDecryptedMessage());
                       if(ControlInstream.readLine().equals("DataReceived"))
                    {
                        status=1;
                         stateChanged();
                         socket.close(); sendsocket.close(); return 0;
                    }   
                       else System.err.println("Error in sending message");
                    }catch(IOException e)
                        {
                            System.out.println(e);
                            EndUser.DisplayMessage("Error in Socket Input Output", "Error", 0);
                            error();
                        }
                    return 0;
        }
		
        @Override
	public void run(){
                        //StartTransfer();
		}
       
         void stateChanged() {
        setChanged();
        notifyObservers();
    }
	
                   public void cancel()
                   {
                                       this.status=CANCELLED;
                              stateChanged();
                   }
         
    // Mark this download as having an error.
    void error() {
        status = ERROR;
        System.out.println("error");
        stateChanged();
    }
    
    private void TransferCompleted() {
     status=COMPLETE;
       stateChanged();
    }
	
}
