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

// 로그인 화면
public class First extends JFrame {
	JTextField input_id;
	JTextField input_pwd;
	JButton btn_login;
	JButton btn_signup;
	
	public First() {
		// 1. 로그인 판넬 구성
		JPanel pan_login = new JPanel();
		input_id = new JTextField(10);
		input_pwd = new JTextField(10);
 		pan_login.add(new JLabel("ID"));
		pan_login.add(input_id);
		pan_login.add(new JLabel("PWD"));
		pan_login.add(input_pwd);
		
		// 2. 버튼 판넬 구성
		JPanel pan_btn = new JPanel();
		btn_login = new JButton("로그인");
		btn_signup = new JButton("회원가입");
		pan_btn.add(btn_login);
		pan_btn.add(btn_signup);
		
		
		// 3. 전체 프레임 화면 구성
		JLabel jlb_title = new JLabel("로그인 화면");
		jlb_title.setFont(new Font("굴림", Font.BOLD, 20));
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
				// if 로그인 성공하면 Home 프레임 호출
				// 코드 구현 예정
				new MainPage();
				setVisible(false); // 로그인 성공하면 First 프레임 invisible
			}
		});
		// 회원가입 버튼 눌렀을 때 회원가입 frame 호출
		btn_signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Signup();
			}
		});
	}
	
	// main 메서드
	public static void main(String[] args) {
		new First();
	}

}
