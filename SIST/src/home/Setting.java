package home;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Setting extends JPanel {
	JTextField jtf_title;
	public Setting() {
		jtf_title = new JTextField(10);
		JButton btn_change = new JButton("수정");
		add(new JLabel("수정할 제목"));
		add(jtf_title);
		add(btn_change);
		btn_change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = jtf_title.getText();
				MainPage.jlb_title.setText(s);
			}
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
				
	}
	
}
