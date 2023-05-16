package Quicky_Clock;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("all")
class setting_frame{
	private JFrame frame;
	public static JComboBox comboBox,comboBox_1,comboBox_1_1;
	public static JCheckBox chckbxNewCheckBox,chckbxNewCheckBox_1_1;/*** Launch the application.*/
	public static void initialize_setting(){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{setting_frame window = new setting_frame();
					window.frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();}
			}
		});
	}public setting_frame() {
		initialize();
	}private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.setTitle("\u8BBE\u7F6E");
		frame.setResizable(false);
		frame.setBounds(670, 300, 650, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("           \u754C\u9762\u8BBE\u7F6E");
		lblNewLabel.setFont(new Font("等线", Font.BOLD, 32));
		lblNewLabel.setBounds(0, 0, 319, 51);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("           \u5176\u4ED6\u8BBE\u7F6E");
		lblNewLabel_1.setFont(new Font("等线", Font.BOLD, 32));
		lblNewLabel_1.setBounds(317, 0, 319, 51);
		frame.getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("        \u6240\u6709\u7684\u8BBE\u7F6E\u5C06\u4FDD\u5B58\u5728\u914D\u7F6E\u6587\u4EF6\u4E2D,\u91CD\u542F\u7A0B\u5E8F\u540E\u624D\u80FD\u751F\u6548");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 336, 636, 25);
		frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("\u6253\u5F00\u65B0\u95FB\u63A8\u9001:");
		lblNewLabel_3.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_3.setBounds(368, 61, 135, 25);
		frame.getContentPane().add(lblNewLabel_3);
		chckbxNewCheckBox = new JCheckBox("\u662F");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setFont(new Font("等线", Font.BOLD, 22));
		chckbxNewCheckBox.setBounds(514, 58, 109, 30);
		frame.getContentPane().add(chckbxNewCheckBox);
		JLabel lblNewLabel_3_1 = new JLabel("\u4E3B\u754C\u9762\u6309\u94AE\u5B57\u4F53\u5927\u5C0F");
		lblNewLabel_3_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(10, 61, 192, 30);
		frame.getContentPane().add(lblNewLabel_3_1);
		comboBox = new JComboBox();
		comboBox.setFont(new Font("等线", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		comboBox.setSelectedItem("19");
		comboBox.setBounds(202, 61, 100, 30);
		frame.getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setFont(new Font("等线", Font.BOLD, 22));
		btnNewButton.setBounds(250, 290, 150, 36);
		frame.getContentPane().add(btnNewButton);
		JLabel lblNewLabel_3_1_1 = new JLabel("\u65B0\u95FB\u5B57\u4F53\u5927\u5C0F:");
		lblNewLabel_3_1_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(368, 101, 135, 30);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40"}));
		comboBox_1.setSelectedItem("24");
		comboBox_1.setFont(new Font("等线", Font.BOLD, 20));
		comboBox_1.setBounds(502, 101, 100, 30);
		frame.getContentPane().add(comboBox_1);
		chckbxNewCheckBox_1_1 = new JCheckBox("\u662F");
		chckbxNewCheckBox_1_1.setSelected(true);
		chckbxNewCheckBox_1_1.setFont(new Font("等线", Font.BOLD, 22));
		chckbxNewCheckBox_1_1.setBounds(514, 224, 109, 30);
		frame.getContentPane().add(chckbxNewCheckBox_1_1);
		tool1.load_setting();
		JLabel lblNewLabel_3_1_1_1 = new JLabel("\u5F00\u542F\u590F\u4EE4\u65F6:");
		lblNewLabel_3_1_1_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_3_1_1_1.setBounds(368, 142, 135, 30);
		frame.getContentPane().add(lblNewLabel_3_1_1_1);
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u662F");
		chckbxNewCheckBox_1.setFont(new Font("等线", Font.BOLD, 22));
		chckbxNewCheckBox_1.setBounds(514, 142, 109, 30);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("12/24\u5C0F\u65F6\uFF1A");
		lblNewLabel_3_1_1_1_1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_3_1_1_1_1.setBounds(368, 183, 135, 30);
		lblNewLabel_3_1_1_1_1.setVisible(false);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1);
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"HH:mm:ss(24)", "hh:mm:ss(12)"}));
		comboBox_1_1.setFont(new Font("等线", Font.BOLD, 20));
		comboBox_1_1.setBounds(482, 182, 154, 30);
		comboBox_1_1.setVisible(false);
		frame.getContentPane().add(comboBox_1_1);
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("\u542F\u7528\u65E5\u5FD7:");
		lblNewLabel_3_1_1_1_2.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel_3_1_1_1_2.setBounds(368, 224, 135, 30);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_2);
		btnNewButton.addActionListener((settingchangeevent1)->{tool1.change_setting();});
	}
}class tool1{
	public static final void change_setting(){properties_1.setting1();}
	public static final void load_setting(){properties_1.change2();}
}