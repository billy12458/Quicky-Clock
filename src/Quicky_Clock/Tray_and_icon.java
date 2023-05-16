package Quicky_Clock;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
@SuppressWarnings("all")
class Tray_and_icon{
	static SystemTray systemTray;
	static TrayIcon icon1;
	static final JFrame FRAME1=MainFrame.frmQuickyTimer;
	static MenuItem menuItem1;
	static PopupMenu pop1;
	static{systemTray=SystemTray.getSystemTray();
		try{menuItem1=new MenuItem("ÍË³ö");
			menuItem1.setFont(new Font("Arial",Font.PLAIN,17));
			menuItem1.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});pop1=new PopupMenu();
			pop1.add(menuItem1);
			icon1=new TrayIcon(ImageIO.read(new FileInputStream(System.getProperty("user.dir")+"\\clock2.png")),"Quicky-Clock version 0.5.0",pop1);
			icon1.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent mouseEvent1){
					if(mouseEvent1.getClickCount()==2){
						systemTray.remove(icon1);
						FRAME1.setExtendedState(JFrame.NORMAL);
						FRAME1.setVisible(true);
						FRAME1.setBounds(700, 300, 530, 450);
					}
				}
			});
		}catch (IOException e){
		}
	}public static final void toTray(){
		try{systemTray.add(icon1);
		}catch(Exception allException){
			allException.printStackTrace();
		}
	}
}