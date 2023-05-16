package Quicky_Clock;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
class Logging{
	private static final String classname=Logging.class.getName();
	private static final String INFO_STRING=System.getProperty("user.dir")+"\\information.log";
	private static final String NULL_STRING=" ",MAOHAO_STRING=":",PATTERN_STRING="yyyy-MM-dd HH:mm:ss";
	static Logger LOGGER1=null;
	static FileHandler fileHandler1;
	static{
		try{LOGGER1=Logger.getLogger(classname);
			LOGGER1.setUseParentHandlers(false);
			fileHandler1=new FileHandler(INFO_STRING, true);
			fileHandler1.setLevel(Level.INFO);
			Formatter infoformatter=new Formatter(){
				public String format(LogRecord record){
					return new SimpleDateFormat(PATTERN_STRING).format(new Date())+NULL_STRING+record.getLevel()+MAOHAO_STRING+record.getMessage()+"\n\n";
				}
			};fileHandler1.setFormatter(infoformatter);
		}catch(IOException|SecurityException somException){
			somException.printStackTrace();
		}
	}public static void dolog(String contentString,String typeString,boolean enabled){
		Log(contentString,typeString,enabled);
	}private static final void Log(String contentString1,String typeString1,boolean enabled){
		if(enabled==true){
			switch(typeString1){
			case "INFO":
				LOGGER1.addHandler(fileHandler1);
				LOGGER1.info(contentString1);
				fileHandler1.close();
				break;
			}
		}else{}
	}
}