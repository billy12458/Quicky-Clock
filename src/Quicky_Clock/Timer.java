package Quicky_Clock;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; /*** 计时器 */  
class Timer extends JFrame {  
	private static final long serialVersionUID = 1L;
	private static final String INITIAL_LABEL_TEXT = "00:00:00 000";  
    private CountingThread thread = new CountingThread();  // 计数线程  
    private long programStart = System.currentTimeMillis();  // 记录程序开始时间
    private long pauseStart = programStart;// 程序一开始就是暂停的  
    private long pauseCount = 0;  // 程序暂停的总时间 
    private JLabel label = new JLabel(INITIAL_LABEL_TEXT);  
    private JButton startPauseButton = new JButton("开始");  
    private JButton resetButton = new JButton("清零");
    public static final boolean LOG2=properties_1.uselog;
    private ActionListener startPauseButtonListener = new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  
            if (thread.stopped) {  
                pauseCount += (System.currentTimeMillis() - pauseStart);  
                thread.stopped = false;  
                startPauseButton.setText("暂停");  
            }else{pauseStart = System.currentTimeMillis();  
                thread.stopped = true;  
                startPauseButton.setText("继续");  
            }  
        }  
    };private ActionListener resetButtonListener = new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  
            pauseStart = programStart;  
            pauseCount = 0;  
            thread.stopped = true;  
            label.setText(INITIAL_LABEL_TEXT);  
            startPauseButton.setText("开始");  
        }  
    };public Timer(String title) throws HeadlessException {  
        super(title);  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        setBounds(800, 450, 450, 300); 
        setResizable(false);  
        setupBorder();  
        setupLabel();  
        setupButtonsPanel();  
        startPauseButton.addActionListener(startPauseButtonListener);  
        resetButton.addActionListener(resetButtonListener);  
        thread.start(); // 计数线程一直就运行着  
    }private void setupBorder(){// 为窗体面板添加边框   
       JPanel contentPane = new JPanel(new BorderLayout());  
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  
        this.setContentPane(contentPane);  
    }private void setupButtonsPanel(){// 配置按钮  
        JPanel panel = new JPanel(new FlowLayout());  
        panel.add(startPauseButton);  
        panel.add(resetButton);  
        add(panel, BorderLayout.SOUTH);  
    }private void setupLabel(){// 配置标签  
        label.setHorizontalAlignment(SwingConstants.CENTER);  
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 40));  
        this.add(label, BorderLayout.CENTER);  
    }public void showtimer(){// 程序入口  
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        }catch (Exception e) {  
            e.printStackTrace();  
        }Timer frame = new Timer("计时器");  
        frame.pack();  
        frame.setVisible(true);  
        new Logging().dolog("用户使用了一次计时器！","INFO", LOG2);
    }private class CountingThread extends Thread {  
        public boolean stopped = true;  
        private CountingThread(){  
            setDaemon(true);}  
       @Override public void run(){  
            while(true){  
                if(!stopped){  
                    long elapsed = System.currentTimeMillis() - programStart - pauseCount;  
                    label.setText(format(elapsed));  
                }try{sleep(1);  // 1毫秒更新一次显示
                }catch (InterruptedException e) {  
                    e.printStackTrace();  
                    System.exit(1);  
                }  
            }  
        }private String format(long elapsed){// 将毫秒数格式化  
            int hour, minute, second, milli;  
            milli = (int) (elapsed % 1000);  
            elapsed = elapsed / 1000;  
            second = (int) (elapsed % 60);  
            elapsed = elapsed / 60;  
            minute = (int) (elapsed % 60);  
            elapsed = elapsed / 60;  
            hour = (int) (elapsed % 60);  
            return String.format("%02d:%02d:%02d %03d", hour, minute, second, milli);  
        }  
    }  
}