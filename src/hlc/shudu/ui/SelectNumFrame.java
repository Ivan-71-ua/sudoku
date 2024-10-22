package hlc.shudu.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectNumFrame extends JDialog implements MouseListener {
	private ShuduCell cell;

	public void setCell(ShuduCell cell) {
		this.cell = cell;
	}
	/*public SelectNumFrame() {
		this.setSize(200, 200);
		this.setBackground(new Color( 0x8e223d)); // Set background color to black
		this.getContentPane().setBackground(new Color( 0x8e223d)); // Ensure content pane is also black
		this.setLayout(new GridLayout(3, 3));

		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.setBackground(new Color( 0x8e223d)); // Set button background color to black
			button.setForeground(Color.WHITE); // Set button text color to white for contrast
			this.add(button);
		}
	}*/
	public SelectNumFrame(){
		//隐藏界面上面的工具栏
		this.setUndecorated(true);
		this.setSize(150, 150);
		this.setBackground(new Color( 0x8e223d));
		this.setLayout(null);
		addNum();
	}
	//添加数字1~9
	private void addNum() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton();
				btn.setBackground(new Color( 0xce3c6b));
				btn.setForeground(new Color(255, 255, 255));
				btn.setSize(50, 50);
				btn.setLocation(i*50,j*50);
				btn.setText(""+(j*3+i+1));
				btn.addMouseListener(this);
				this.add(btn);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int modes = e.getModifiers();
		if ((modes & InputEvent.BUTTON1_MASK) != 0) {
			JButton btn = (JButton) e.getSource();
			cell.setText(btn.getText());
		}
		this.dispose();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
