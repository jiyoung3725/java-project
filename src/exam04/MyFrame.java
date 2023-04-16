package exam04;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MyFrame extends JFrame {
	Tab_Blood tab01;
	Tab_gender tab02;
	JTabbedPane pane;
	
	public MyFrame() {
		tab01 = new Tab_Blood();
		tab02 = new Tab_gender();
		pane = new JTabbedPane();
		pane.addTab("혈액형", tab01);
		pane.addTab("성별", tab02);
		
		add(pane);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}
