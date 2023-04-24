package home.copy;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemoPopUp extends JFrame {
	static JLabel sender;
	public MemoPopUp() {
		JButton btn_delete = new JButton("삭제");
		JButton btn_reply = new JButton("답장");
		sender = new JLabel("철수");
		setLayout(new FlowLayout());
		add(new JLabel("보낸 사람"));
		add(sender);
		add(btn_delete);
		add(btn_reply);
		setVisible(true);
		setSize(150,300);
		
		btn_reply.addActionListener(e->new MemoReply());
	}
}

class MemoReply extends JFrame{
	JTextArea jtf_content;
	MemoReply(){
		jtf_content = new JTextArea();
		JScrollPane jsp = new JScrollPane(jtf_content);
		add(new JLabel("보낼 사람"));
		add(new JLabel(MemoPopUp.sender.getText()));
		add(new JLabel("내용"));
		add(jsp);
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(300,200);
	}
}