package home.copy;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.MembersDAO;

// 로그인 화면
public class LogInPage extends JFrame {
	JTextField input_id;
	JTextField input_pwd;
	JButton btn_login;
	JButton btn_signup;
	static String ID;
	public LogInPage() {
		// 로그인 판넬 구성
		JPanel pan_login = new JPanel();
		input_id = new JTextField(10);
		input_pwd = new JTextField(10);
 		pan_login.add(new JLabel("ID"));
		pan_login.add(input_id);
		pan_login.add(new JLabel("PWD"));
		pan_login.add(input_pwd);
		
		// 버튼 판넬 구성
		JPanel pan_btn = new JPanel();
		btn_login = new JButton("로그인");
		btn_signup = new JButton("회원가입");
		pan_btn.add(btn_login);
		pan_btn.add(btn_signup);
		
		
		// 전체 프레임 화면 구성
		JLabel jlb_title = new JLabel("로그인 화면");
		jlb_title.setFont(new Font("굴림", Font.BOLD, 20));
		add(jlb_title);
		add(pan_login);
		add(pan_btn);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		
		// 로그인 버튼 actionlistener
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ID = input_id.getText();
				// id, pwd 텍스트 필드가 공란일 때
				if(ID.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					return;
				} else if(input_pwd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
					return;
				}
				
				// id, pwd 로그인 유효성 검사
				String PWD = new MembersDAO().getPWD(input_id.getText());
				if(input_pwd.getText().equals(PWD)) {
					new MainPage();
					setVisible(false); // 로그인 성공하면 First 프레임 invisible
				} else if(PWD.equals("")){JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
				} else {JOptionPane.showMessageDialog(null, "비밀번호가 잘못되었습니다.");}
			}
		});
		
		// 회원가입 버튼 눌렀을 때 회원가입 frame 호출
		btn_signup.addActionListener(e->new Signup());
	}
	
	// main 메서드
	public static void main(String[] args) {
		new LogInPage();
	}

}
