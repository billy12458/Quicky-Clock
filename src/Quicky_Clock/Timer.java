package Quicky_Clock;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; /*** ��ʱ�� */  
class Timer extends JFrame {  
	private static final long serialVersionUID = 1L;
	private static final String INITIAL_LABEL_TEXT = "00:00:00 000";  
    private CountingThread thread = new CountingThread();  // �����߳�  
    private long programStart = System.currentTimeMillis();  // ��¼����ʼʱ��
    private long pauseStart = programStart;// ����һ��ʼ������ͣ��  
    private long pauseCount = 0;  // ������ͣ����ʱ�� 
    private JLabel label = new JLabel(INITIAL_LABEL_TEXT);  
    private JButton startPauseButton = new JButton("��ʼ");  
    private JButton resetButton = new JButton("����");
    public static final boolean LOG2=properties_1.uselog;
    private ActionListener startPauseButtonListener = new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  
            if (thread.stopped) {  
                pauseCount += (System.currentTimeMillis() - pauseStart);  
                thread.stopped = false;  
                startPauseButton.setText("��ͣ");  
            }else{pauseStart = System.currentTimeMillis();  
                thread.stopped = true;  
                startPauseButton.setText("����");  
            }  
        }  
    };private ActionListener resetButtonListener = new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  
            pauseStart = programStart;  
            pauseCount = 0;  
            thread.stopped = true;  
            label.setText(INITIAL_LABEL_TEXT);  
            startPauseButton.setText("��ʼ");  
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
        thread.start(); // �����߳�һֱ��������  
    }private void setupBorder(){// Ϊ���������ӱ߿�   
       JPanel contentPane = new JPanel(new BorderLayout());  
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  
        this.setContentPane(contentPane);  
    }private void setupButtonsPanel(){// ���ð�ť  
        JPanel panel = new JPanel(new FlowLayout());  
        panel.add(startPauseButton);  
        panel.add(resetButton);  
        add(panel, BorderLayout.SOUTH);  
    }private void setupLabel(){// ���ñ�ǩ  
        label.setHorizontalAlignment(SwingConstants.CENTER);  
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 40));  
        this.add(label, BorderLayout.CENTER);  
    }public void showtimer(){// �������  
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        }catch (Exception e) {  
            e.printStackTrace();  
        }Timer frame = new Timer("��ʱ��");  
        frame.pack();  
        frame.setVisible(true);  
        new Logging().dolog("�û�ʹ����һ�μ�ʱ����","INFO", LOG2);
    }private class CountingThread extends Thread {  
        public boolean stopped = true;  
        private CountingThread(){  
            setDaemon(true);}  
       @Override public void run(){  
            while(true){  
                if(!stopped){  
                    long elapsed = System.currentTimeMillis() - programStart - pauseCount;  
                    label.setText(format(elapsed));  
                }try{sleep(1);  // 1�������һ����ʾ
                }catch (InterruptedException e) {  
                    e.printStackTrace();  
                    System.exit(1);  
                }  
            }  
        }private String format(long elapsed){// ����������ʽ��  
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