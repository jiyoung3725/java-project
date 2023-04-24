package home.copy;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.MembersDAO;

public class Setting extends JPanel implements ColorChanger{
	JTextField jtf_title;
	static Color homecolor;
	public Setting() {
		jtf_title = new JTextField(10);
		JButton btn_change = new JButton("수정");
		
		JButton btn_color = new JButton("색상선택");
		btn_color.addActionListener(new ActionListener() {
			JColorChooser colorChooser = new JColorChooser();
			@Override
			public void actionPerformed(ActionEvent e) {
				homecolor = colorChooser.showDialog(null, "테마 색상 선택", Color.black);
				if(homecolor!=null) {
					setBackgroundColor();
				}
			}
		});
		
		
		
		
		
		
		
		add(new JLabel("수정할 제목"));
		add(jtf_title);
		add(btn_change);
		add(btn_color);
		btn_change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = jtf_title.getText();
				int re = new MembersDAO().saveTitle(title, LogInPage.ID);
				if(re==1) JOptionPane.showMessageDialog(null, "수정되었습니다.");
				else JOptionPane.showMessageDialog(null, "수정에 실패하였습니다.");
				MainPage.jlb_title.setText(new MembersDAO().getTitle(LogInPage.ID));
			}
			
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
				
	}
	

	@Override
	public void setBackgroundColor() {
		setBackground(homecolor);
		
	}
}
