package home;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// �α��� ȭ��
public class First extends JFrame {
	JTextField input_id;
	JTextField input_pwd;
	JButton btn_login;
	JButton btn_signup;
	
	public First() {
		// 1. �α��� �ǳ� ����
		JPanel pan_login = new JPanel();
		input_id = new JTextField(10);
		input_pwd = new JTextField(10);
 		pan_login.add(new JLabel("ID"));
		pan_login.add(input_id);
		pan_login.add(new JLabel("PWD"));
		pan_login.add(input_pwd);
		
		// 2. ��ư �ǳ� ����
		JPanel pan_btn = new JPanel();
		btn_login = new JButton("�α���");
		btn_signup = new JButton("ȸ������");
		pan_btn.add(btn_login);
		pan_btn.add(btn_signup);
		
		
		// 3. ��ü ������ ȭ�� ����
		JLabel jlb_title = new JLabel("�α��� ȭ��");
		jlb_title.setFont(new Font("����", Font.BOLD, 20));
		add(jlb_title);
		add(pan_login);
		add(pan_btn);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// if �α��� �����ϸ� Home ������ ȣ��
				// �ڵ� ���� ����
				new MainPage();
				setVisible(false); // �α��� �����ϸ� First ������ invisible
			}
		});
		// ȸ������ ��ư ������ �� ȸ������ frame ȣ��
		btn_signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Signup();
			}
		});
	}
	
	// main �޼���
	public static void main(String[] args) {
		new First();
	}

}
