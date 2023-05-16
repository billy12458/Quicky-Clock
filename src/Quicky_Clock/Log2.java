package Quicky_Clock;
import java.awt.*;
import java.io.*;
import javax.swing.*;
@SuppressWarnings("all")
class log2{
	public static final String NOTEPAD_STRING="notepad ";
	public static final String LOG_STRING=System.getProperty("user.dir")+"\\information.log";
	public static final void openlog(){
		try{Runtime.getRuntime().exec(NOTEPAD_STRING+LOG_STRING);
		}catch(IOException ioException1){
			ioException1.printStackTrace();
		}finally{
			Runtime.getRuntime().runFinalization();
		}
	}
}