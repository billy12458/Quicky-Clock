package Quicky_Clock;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
@SuppressWarnings("all")class TimeZone1 {
	public static final JButton CONFIRM_BUTTON=MainFrame.btnNewButton_2;
	public static final JComboBox COMBO_BOX=MainFrame.comboBox;
	public static final JLabel LABEL1=MainFrame.lblNewLabel;
	public static final JLabel label2=MainFrame.lblNewLabel_2;
	public static final boolean LOG1=properties_1.uselog;/**show the time of the timezone that the user choosed*/
	public static void showTimeZone(JButton CONFIRM_BUTTON,JComboBox COMBO_BOX,JLabel LABEL1){
		try{SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			LocalDateTime localDateTime=LocalDateTime.now(ZoneId.of((String) COMBO_BOX.getSelectedItem()));
			Timer time1=new Timer(1000,(timezoneevent)->{
				LABEL1.setText(localDateTime.toString().replaceAll("T"," "));
				Runtime.getRuntime().runFinalization();
			});time1.start();
			Logging.dolog("用户选择了："+(String) COMBO_BOX.getSelectedItem()+"时区","INFO",LOG1);
		}catch(Exception timeException1){timeException1.printStackTrace();}
	}public static void showcurrenttime(String zoneidString,String hourString,JLabel label_of_setted){
		try{SimpleDateFormat format1=new SimpleDateFormat(hourString);
			LocalDateTime localDateTime=LocalDateTime.now(ZoneId.of(zoneidString));
			Timer time2=new Timer(1000,(currenttimevent)->{
				label_of_setted.setText(localDateTime.toString().replaceAll("T"," "));
				Runtime.getRuntime().runFinalization();
			});time2.start();
		}catch(Exception currenttimeException){currenttimeException.printStackTrace();}
	}
}