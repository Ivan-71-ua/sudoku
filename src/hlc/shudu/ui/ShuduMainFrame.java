// src/hlc/shudu/ui/ShuduMainFrame.java
package hlc.shudu.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ShuduMainFrame extends JFrame {

	public static int pass = 1; // 关卡
	public static JLabel lbPass; // 显示关卡的lable
	public static long usedTime = 0; //
	private ShuduCanvers panelCanvers; // 主游戏区
	public static Timer userTimeAction;

	public ShuduMainFrame() {
		init();
		addComponent();
		addCanvers();
	}

	private void addCanvers() {
		panelCanvers = new ShuduCanvers();
		panelCanvers.setBorder(new TitledBorder("Board"));
		panelCanvers.setBackground(new Color(0xDBC3AD));
		this.add(panelCanvers, BorderLayout.CENTER);
	}

	private void addComponent() {
		JPanel panelComponent = new JPanel();
		panelComponent.setBackground(new Color(0xDBC3AD));
		addPanelMsg(panelComponent);
		addPanelTime(panelComponent);
		this.add(panelComponent, BorderLayout.NORTH);
	}

	private void addPanelTime(JPanel panelComponent) {
		JPanel panelTime = new JPanel();
		panelTime.setBackground(new Color(0xDBC3AD));
		panelTime.setBorder(new TitledBorder("Time"));
		panelTime.setLayout(new GridLayout(2, 1));

		final JLabel lbSysTime = new JLabel();
		final JLabel lbUserTime = new JLabel();

		panelTime.add(lbSysTime, BorderLayout.NORTH);
		panelTime.add(lbUserTime, BorderLayout.SOUTH);

		Timer sysTimeAction = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long timeMillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				lbSysTime.setText("    System time:  " + df.format(timeMillis));
			}
		});
		sysTimeAction.start();

		userTimeAction = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbUserTime.setText("    You wasted your time:  " + (++usedTime) + " sec.");
			}
		});
		userTimeAction.start();

		panelComponent.add(panelTime, BorderLayout.EAST);
	}

	private void addPanelMsg(JPanel panelComponent) {
		panelComponent.setLayout(new GridLayout(1, 3));
		Font font14 = new Font("Montserrat Alternates", Font.PLAIN, 14);
		Font font28 = new Font("Montserrat Alternates", Font.BOLD, 28);
		Font font18 = new Font("Montserrat Alternates", Font.BOLD, 18);


		JPanel panelMsg = new JPanel();
		panelMsg.setBorder(new TitledBorder("Menu"));
		panelMsg.setBackground(new Color(0xDBC3AD));


		JLabel lbPass1 = new JLabel("Level: ");
		lbPass1.setFont(font18);
		panelMsg.add(lbPass1);

		lbPass = new JLabel("" + pass);
		lbPass.setForeground(new Color(0x000000));
		lbPass.setFont(font18);
		panelMsg.add(lbPass);

		JLabel lbPass2 = new JLabel(" / 10 levels");
		lbPass2.setFont(font18);
		panelMsg.add(lbPass2);

		panelComponent.add(panelMsg, BorderLayout.CENTER);
	}

	private void init() {
		ImageIcon image = new ImageIcon("icon/icon.png");
		this.setIconImage(image.getImage());
		this.setSize(515, 600);
		this.setLocation(500, 50);
		this.setTitle("Sudoku");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0xDBC3AD));

		UIManager.put("OptionPane.background", new Color(0xDBC3AD));
		UIManager.put("Panel.background", new Color(0xDBC3AD));
	}
}