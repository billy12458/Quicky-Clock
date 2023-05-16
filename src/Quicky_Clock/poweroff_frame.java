package Quicky_Clock;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;/** @author 86136*/
class poweroff_frame {
	private JFrame frame;
	public static JTextField textField,textField_1,textField_2;/*** Launch the application.*/
	public static JButton btnNewButton;
	public static Font font1;
	public static void initialize_frame(){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{new poweroff_frame();
				}catch(Exception e){e.printStackTrace();}
			}
		});
	}public poweroff_frame() {
		initialize();
	}private void initialize() {
		frame = new JFrame();
		font1=new Font("Arial",Font.BOLD,18);
		frame.setBounds(700, 300, 450, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBounds(27, 74, 66, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener((shutdownevent)->{shutdown.set_shutdown();});
		btnNewButton.setFont(new Font("等线", Font.BOLD, 20));
		btnNewButton.setBounds(155, 125, 140, 36);
		frame.getContentPane().add(btnNewButton);
		JLabel lblNewLabel = new JLabel("     \u8BF7\u8F93\u5165\u5B9A\u65F6\u5173\u673A\u7684\u5C0F\u65F6\u3001\u5206\u949F\u548C\u79D2");
		lblNewLabel.setFont(new Font("等线", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 10, 436, 47);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel(" \u5C0F\u65F6");
		lblNewLabel_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_1.setBounds(104, 74, 52, 27);
		frame.getContentPane().add(lblNewLabel_1);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(166, 74, 66, 27);
		textField.setFont(font1);
		textField_1.setFont(font1);
		frame.getContentPane().add(textField_1);
		JLabel lblNewLabel_1_1 = new JLabel(" \u5206\u949F");
		lblNewLabel_1_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(240, 74, 52, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(300, 74, 66, 27);
		textField_2.setFont(font1);
		frame.getContentPane().add(textField_2);
		JLabel lblNewLabel_1_1_1 = new JLabel("  \u79D2");
		lblNewLabel_1_1_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(374, 74, 52, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		JLabel lblNewLabel_2 = new JLabel("\u63D0\u793A:\u6BCF\u6B21\u5F00\u673A\u540E\u53EA\u80FD\u8BBE\u7F6E\u4E00\u6B21\uFF0C\u91CD\u590D\u8BBE\u7F6E\u65E0\u6548\uFF01");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(0, 184, 436, 27);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
	}
}@SuppressWarnings("all")class shutdown{
	public static final JButton BUTTON1=poweroff_frame.btnNewButton;
	public static final JTextField TEXT_FIELD1=poweroff_frame.textField;
	public static final JTextField TEXT_FIELD2=poweroff_frame.textField_1;
	public static final JTextField TEXT_FIELD3=poweroff_frame.textField_2;
	public static final boolean LOG=properties_1.uselog;
	public static final String PATTER_STRING="[^0-9]";
	public static final void set_shutdown(){
		try{int total=Integer.parseInt(TEXT_FIELD1.getText().trim())*3600+Integer.parseInt(TEXT_FIELD2.getText().trim())*60+Integer.parseInt(TEXT_FIELD3.getText().trim());
			Runtime.getRuntime().exec("shutdown -s -t "+String.valueOf(total));
			JOptionPane.showMessageDialog(null,"成功设置定时关机，时间："+total+"s");
			Logging.dolog("成功设置定时关机，时间："+total+"s","INFO", LOG);
		}catch(NumberFormatException shutdownException){
			Logging.dolog("Number Error:用户输入的数字有误,请重新输入！"+shutdownException.toString(),"INFO", LOG);
		}catch(IOException ioException1){
			Logging.dolog("系统命令执行失败！"+ioException1.toString(),"INFO", LOG);
		}finally{Runtime.getRuntime().runFinalization();}
	}
}