package Quicky_Clock;
import java.awt.Font;
import java.io.*;
import java.util.Properties;
import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.NEW;
@SuppressWarnings("all")
class properties_1{
	static Properties prop1,prop2,prop3;
	static boolean uselog;
	public static final JFrame FRAME1=MainFrame.frmQuickyTimer;
	public static final JButton BUTTON1=MainFrame.btnNewButton_2;
	public static final JLabel LABEL_NEWS=MainFrame.lblNewLabel_3;
	public static final JLabel LABEL1=MainFrame.lblNewLabel_2;
	public static final JLabel LABEL2=MainFrame.lblNewLabel_2_1;
	public static final String HOUR_STRING1="yyyy-MM-dd ";
	public static final String REGEX_STRING="\\\\";
	public static final String NULL_STRING="";
	public static final String BUTTONFONT_STRING="buttonfont";
	public static final String NEWS_STRING="news";
	public static final String NEWSFONT_STRING="newsfont";
	public static final String HOUR_STRING="hour";
	public static final String LOG_STRING="uselog";
	static JComboBox COMBO_BOX1, COMBO_BOX2, COMBO_BOX3;
	static JCheckBox CHECK_BOX1,CHECK_BOX2;
	static{
		COMBO_BOX1=new JComboBox();
		COMBO_BOX2=new JComboBox();
		COMBO_BOX3=new JComboBox();
		CHECK_BOX1=new JCheckBox();
		CHECK_BOX2=new JCheckBox();
		prop1=new Properties();
		prop2=new Properties();
		prop3=new Properties();
	}static void setting(){init();}/**initializes the setting of this software by reading the .properties file 
	@author 86136*/
	private static final void init(){
		try{//这里的更新操作先用硬编码，反正也不多
			prop1.load(new FileInputStream(System.getProperty("user.dir")+"\\setting.properties"));
			BUTTON1.setFont(new Font("Arial",Font.BOLD,Integer.parseInt(prop1.getProperty(BUTTONFONT_STRING))));
			LABEL_NEWS.setFont(new Font("幼圆", Font.PLAIN, Integer.parseInt(prop1.getProperty(NEWSFONT_STRING))));
			LABEL_NEWS.setVisible(Boolean.parseBoolean(prop1.getProperty(NEWS_STRING)));
			uselog=Boolean.parseBoolean(prop1.getProperty(LOG_STRING));
			TimeZone1.showcurrenttime("Asia/Shanghai",HOUR_STRING1+prop1.getProperty(HOUR_STRING).replaceAll(REGEX_STRING,NULL_STRING).substring(0, 8),LABEL1);
			TimeZone1.showcurrenttime("Europe/London",HOUR_STRING1+prop1.getProperty(HOUR_STRING).replaceAll(REGEX_STRING,NULL_STRING).substring(0, 8),LABEL2);
		}catch(Exception propertiesException){propertiesException.printStackTrace();}
	}public static void setting1(){change();}/**changes the setting according to the user's choice by saving in the .properties file
	@author 86136*/
	private static final void change(){
		try{prop2.setProperty(BUTTONFONT_STRING,(String)setting_frame.comboBox.getSelectedItem());
			prop2.setProperty(NEWS_STRING,String.valueOf(setting_frame.chckbxNewCheckBox.isSelected()));
			prop2.setProperty(NEWSFONT_STRING,(String)setting_frame.comboBox_1.getSelectedItem());
			prop2.setProperty(HOUR_STRING,setting_frame.comboBox_1_1.getSelectedItem().toString().replaceAll(REGEX_STRING,NULL_STRING));
			prop2.setProperty(LOG_STRING, String.valueOf(setting_frame.chckbxNewCheckBox_1_1.isSelected()));
			prop2.store(new FileOutputStream(System.getProperty("user.dir")+"\\setting.properties"),null);
			JOptionPane.showMessageDialog(null,"成功保存设置！");
			new Logging().dolog("用户成功保存设置！","INFO", true);
		}catch(Exception changException){changException.printStackTrace();}
	}public static void change2(){setting_setting_frame();}
	private static final void setting_setting_frame(){
		COMBO_BOX2=setting_frame.comboBox_1;
		COMBO_BOX1=setting_frame.comboBox;
		CHECK_BOX1=setting_frame.chckbxNewCheckBox;
		CHECK_BOX2=setting_frame.chckbxNewCheckBox_1_1;
		try{prop3.load(new FileInputStream(System.getProperty("user.dir")+"\\setting.properties"));
			COMBO_BOX1.setSelectedItem(prop1.getProperty(BUTTONFONT_STRING));
			COMBO_BOX2.setSelectedItem(prop1.getProperty(NEWSFONT_STRING));
			COMBO_BOX3.setSelectedItem(prop1.getProperty(HOUR_STRING).replaceAll(REGEX_STRING,NULL_STRING));
			CHECK_BOX1.setSelected(Boolean.parseBoolean(prop1.getProperty(NEWS_STRING)));
			CHECK_BOX2.setSelected(Boolean.parseBoolean(prop1.getProperty(LOG_STRING)));
		}catch (IOException iosettingframException){
			iosettingframException.printStackTrace();}
	}
}