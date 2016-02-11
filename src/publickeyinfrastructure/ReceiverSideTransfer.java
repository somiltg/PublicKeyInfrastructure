
package publickeyinfrastructure;
import java.io.File;
import java.net.*;
import java.text.*;
import java.util.Observable;

/**
 *
 * @author somil
 */
class ReceiverSideTransfer extends Observable implements Runnable 
{
	/* Attributes */
	private long BytesTransferred;   //Bytes Transferred
        private long TotalSize;
        private String FilePath;
        private String User;
        private String IP;
        private int status;
        private String message;
        private long StartTime;
        private String AlgoType;
        
  // These are the status codes.
  public static final int TRANSFERRING = 0;
  public static final int COMPLETE = 1;
  public static final int CANCELLED = 2;
  public static final int ERROR = 3;
  public static final int REQUESTING = 4;
  
          
        
	public ReceiverSideTransfer(Socket Controlclient){  
                BytesTransferred=0;
                message=null;
                this.IP=IP;
                Controlclient.
                User=user;
                FilePath=PathName;
                status=REQUESTING;
                TotalSize=new File(PathName).length();		
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
      
	public void StartTransfer(){ 
			getReceiverCertification();
                        ServerSocket MyService;
    try {
       MyService = new ServerSocket(PortNumber);
        }
        catch (IOException e) {
           System.out.println(e);
        }
    Socket clientSocket = null;
    try {
       serviceSocket = MyService.accept();
        }
    catch (IOException e) {
       System.out.println(e);
    }
                        InetAddress.getByName(currentSettings.ProxyAddress).getHostAddress();	
                        Socket socket
			}
		
        @Override
	public void run(){
                        StartTransfer();
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
