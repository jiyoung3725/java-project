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

// �α��� ȭ��
public class LogInPage extends JFrame {
	JTextField input_id;
	JTextField input_pwd;
	JButton btn_login;
	JButton btn_signup;
	static String ID;
	public LogInPage() {
		// �α��� �ǳ� ����
		JPanel pan_login = new JPanel();
		input_id = new JTextField(10);
		input_pwd = new JTextField(10);
 		pan_login.add(new JLabel("ID"));
		pan_login.add(input_id);
		pan_login.add(new JLabel("PWD"));
		pan_login.add(input_pwd);
		
		// ��ư �ǳ� ����
		JPanel pan_btn = new JPanel();
		btn_login = new JButton("�α���");
		btn_signup = new JButton("ȸ������");
		pan_btn.add(btn_login);
		pan_btn.add(btn_signup);
		
		
		// ��ü ������ ȭ�� ����
		JLabel jlb_title = new JLabel("�α��� ȭ��");
		jlb_title.setFont(new Font("����", Font.BOLD, 20));
		add(jlb_title);
		add(pan_login);
		add(pan_btn);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		
		// �α��� ��ư actionlistener
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ID = input_id.getText();
				// id, pwd �ؽ�Ʈ �ʵ尡 ������ ��
				if(ID.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.");
					return;
				} else if(input_pwd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.");
					return;
				}
				
				// id, pwd �α��� ��ȿ�� �˻�
				String PWD = new MembersDAO().getPWD(input_id.getText());
				if(input_pwd.getText().equals(PWD)) {
					new MainPage();
					setVisible(false); // �α��� �����ϸ� First ������ invisible
				} else if(PWD.equals("")){JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
				} else {JOptionPane.showMessageDialog(null, "��й�ȣ�� �߸��Ǿ����ϴ�.");}
			}
		});
		
		// ȸ������ ��ư ������ �� ȸ������ frame ȣ��
		btn_signup.addActionListener(e->new Signup());
	}
	
	// main �޼���
	public static void main(String[] args) {
		new LogInPage();
	}

}
