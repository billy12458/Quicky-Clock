package Quicky_Clock;
import java.awt.*;
import java.util.concurrent.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URI;
@SuppressWarnings("all")class MainFrame implements ActionListener{
	public static JFrame frmQuickyTimer;
	public static JButton btnNewButton_2;
	public static JComboBox comboBox;
	public static JLabel lblNewLabel,lblNewLabel_2,lblNewLabel_3,lblNewLabel_2_1;
	public static int x_location;
	public static final ToolTipManager MANAGER;
	public static JButton[] allbutton=new JButton[5];
	public String[] pictureStrings=new String[]{"秒表","倒计时","定时关机","设置","网络时钟"};
	public String[] nameStrings=new String[]{"/Timer.jpg","/countdown.jpg","/power.jpg","/setting.jpg","/webtime.jpg"};
	public static ExecutorService big_poolService;
	static{
		x_location=8;
		MANAGER=ToolTipManager.sharedInstance();
		big_poolService=Executors.newCachedThreadPool();
	}/*** Launch the application.*/
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{new MainFrame();
				}catch(Exception e){
				}
			}
		});
	}public MainFrame(){
		initialize();
	}private void initialize(){
		frmQuickyTimer = new JFrame();
		frmQuickyTimer.setFont(new Font("Dialog", Font.BOLD, 18));
		frmQuickyTimer.setTitle("Quicky Clock 0.5");
		frmQuickyTimer.setIconImage(frmQuickyTimer.getToolkit().getImage(System.getProperty("user.dir")+"\\clock1.png"));
		frmQuickyTimer.setResizable(false);
		frmQuickyTimer.setBounds(700, 300, 530, 450);
		frmQuickyTimer.addWindowListener(new WindowAdapter(){
			@Override public void windowIconified(WindowEvent event1){
				Tray_and_icon.toTray();
				frmQuickyTimer.dispose();
			}
		});frmQuickyTimer.getContentPane().setLayout(null);
		frmQuickyTimer.setVisible(false);
		for(int i=0;i<5;i++){
			allbutton[i]=new JButton(pictureStrings[i],new ImageIcon(MainFrame.class.getResource(nameStrings[i])));
			allbutton[i].setFont(new Font("Arial",Font.PLAIN,1));
			allbutton[i].setBounds(x_location, 305, 100, 100);
			allbutton[i].setToolTipText(pictureStrings[i]);
			MANAGER.setInitialDelay(100);
			allbutton[i].addActionListener(this);
			frmQuickyTimer.getContentPane().add(allbutton[i]);
			x_location+=100;
		}lblNewLabel = new JLabel("你尚未选择时区！");
		lblNewLabel.setBackground(SystemColor.control);
		lblNewLabel.setFont(new Font("等线 Light", Font.BOLD, 30));
		lblNewLabel.setBounds(195, 126, 331, 42);
		lblNewLabel.setOpaque(true);
		frmQuickyTimer.getContentPane().add(lblNewLabel);
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("等线 Light", Font.BOLD, 30));
		lblNewLabel_2.setBackground(SystemColor.control);
		lblNewLabel_2.setBounds(195, 188, 331, 42);
		frmQuickyTimer.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setFont(new Font("等线 Light", Font.BOLD, 30));
		lblNewLabel_2_1.setBackground(SystemColor.menu);
		lblNewLabel_2_1.setBounds(195, 250, 331, 42);
		frmQuickyTimer.getContentPane().add(lblNewLabel_2_1);
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u65F6\r\n\u533A\u65F6\u95F4:");
		lblNewLabel_1.setFont(new Font("等线", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 126, 190, 42);
		frmQuickyTimer.getContentPane().add(lblNewLabel_1);
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}SwingUtilities.updateComponentTreeUI(frmQuickyTimer.getContentPane());
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(583, 237, 100, 100);
		frmQuickyTimer.getContentPane().add(btnNewButton_1);
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Europe/London", "Europe/Brussels","Europe/Moscow", "Africa/Casablanca", "Africa/Brazzaville", "Africa/Windhoek", "Asia/Tehran", "Asia/Baghdad", "Asia/Kabul", "Asia/Kuwait", "Asia/Bangkok", "Asia/Shanghai", "Asia/Hong_Kong","Asia/Tokyo", "Asia/Vladivostok", "Pacific/Honolulu", "America/Anchorage", "America/Los_Angeles","America/Denver", "America/Chicago", "America/New_York", "America/Sao_Paulo", "America/Manaus", "America/Barbados", "Atlantic/Azores", "Atlantic/Cape_Verde"}));
		comboBox.setBounds(153, 38, 230, 30);
		frmQuickyTimer.getContentPane().add(comboBox);
		JLabel lblNewLabel_1_1 = new JLabel("\u9009\u62E9\u4F60\u7684\u65F6\u533A:");
		lblNewLabel_1_1.setFont(new Font("等线 Light", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(0, 32, 155, 42);
		frmQuickyTimer.getContentPane().add(lblNewLabel_1_1);
		btnNewButton_2 = new JButton("Start");
		btnNewButton_2.setFont(new Font("等线", Font.BOLD, 18));
		btnNewButton_2.setBounds(404, 36, 100, 35);
		btnNewButton_2.addActionListener(this);
		frmQuickyTimer.getContentPane().add(btnNewButton_2);
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(SystemColor.window);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(0, 82, 526, 36);
		frmQuickyTimer.getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_1_2 = new JLabel("\u5317\u4EAC\u65F6\r\n\u533A\u65F6\u95F4:");
		lblNewLabel_1_2.setFont(new Font("等线", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(0, 188, 190, 42);
		frmQuickyTimer.getContentPane().add(lblNewLabel_1_2);
		JLabel lblNewLabel_1_2_1 = new JLabel("\u4F26\u6566\u65F6\r\n\u533A\u65F6\u95F4:");
		lblNewLabel_1_2_1.setFont(new Font("等线", Font.BOLD, 30));
		lblNewLabel_1_2_1.setBounds(0, 250, 190, 42);
		frmQuickyTimer.getContentPane().add(lblNewLabel_1_2_1);
		JButton btnNewButton = new JButton("\u4F7F\u7528\u65E5\u5FD7");
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 17));
		btnNewButton.setBounds(105, 0, 105, 30);
		btnNewButton.addActionListener(this);
		frmQuickyTimer.getContentPane().add(btnNewButton);
		JButton btnNewButton_3 = new JButton("\u6E05\u7406\u5185\u5B58");
		btnNewButton_3.setFont(new Font("等线", Font.PLAIN, 17));
		btnNewButton_3.setBounds(0, 0, 105, 30);
		btnNewButton_3.addActionListener(this);
		frmQuickyTimer.getContentPane().add(btnNewButton_3);
		big_poolService.submit(new baidu_news());
		big_poolService.submit(new GarbageCollect());
		properties_1.setting();
		frmQuickyTimer.validate();
		frmQuickyTimer.setVisible(true);
	}@Override
	public void actionPerformed(ActionEvent e1) {
		choose.choose1(e1);
	}
}class choose{/**conduct the choice of button*/
	public static final boolean LOG1=properties_1.uselog;
	public static final void choose1(ActionEvent chooseEvent){
		try{switch(chooseEvent.getActionCommand()){
			case "清理内存":
				JOptionPane.showMessageDialog(null, "成功清理jvm内存！");
				Runtime.getRuntime().runFinalization();
				conduct_log("用户清理了jvm的内存","INFO", LOG1);
				break;
			case "秒表":new Timer("计时器").showtimer();break;
			case "倒计时":
				JOptionPane.showMessageDialog(null, "此功能尚在开发中！");
				conduct_log("Selection Error：用户尝试打开未开发的功能","INFO", LOG1);
				break;
			case "定时关机":poweroff_frame.initialize_frame();break;
			case "设置":setting_frame.initialize_setting();break;
			case "Start":showzonetime();break;
			case "使用日志":
				log2.openlog();
				conduct_log("用户查看了使用日志","INFO", LOG1);
				break;
			case "网络时钟":
				Desktop.getDesktop().browse(new URI("https://naozhong.net.cn/shijian/"));
				conduct_log("用户打开了网络时钟","INFO", LOG1);
				break;
			}
		}catch(Exception switchException){switchException.printStackTrace();}
	}public static final void showzonetime(){
		TimeZone1.showTimeZone(MainFrame.btnNewButton_2, MainFrame.comboBox, MainFrame.lblNewLabel);
	}public static final void conduct_log(String contentString,String infoString,boolean enabled){
		Logging.dolog(contentString,infoString,enabled);
	}
}