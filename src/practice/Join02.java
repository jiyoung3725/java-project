// 수정, 삭제 기능을 추가 해 봅니다.
// > 버튼을 누르면 다음 회원의 정보를, < 버튼을 누르면
// 이전 회원의 정보를 출력하도록 코드를 추가 해 봅니다.
//"저장"버튼을 누르면 "member.dat"파일이름으로 저장하도록 하고 
//"읽어오기"버튼을 누르면 "member.dat"파일을 읽어와서 
//맨첫번째 회원의 정보를 각 입력창에 출력합니다.


package practice;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Join02 extends JFrame {
	int idx=0;
	JTextField jtf_name;
	JTextField jtf_phone;
	JRadioButton jrb_man;
	JRadioButton jrb_woman;
	JTextArea jta_addr;
	JCheckBox jcb_agree;
	JLabel jlb_current;
	
	ArrayList<Member> list ;
	String gender = "";
	String fname = "c:/temp/member.dat";
	
	public Join02() {
		jlb_current = new JLabel("");
		list = new ArrayList<Member>();
		
		JPanel p_btn = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		p1.setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(4, 2));
		jtf_name  = new JTextField();
		jtf_phone = new JTextField();
		ButtonGroup bg = new ButtonGroup();
		
		jrb_man = new JRadioButton("남성");
		jrb_woman = new JRadioButton("여성");
		bg.add(jrb_man);
		bg.add(jrb_woman);
		
		jrb_man.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gender = "남성";
			}
		});
		
		jrb_woman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gender = "여성";
			}
		});
		
		jta_addr = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_addr);
		jcb_agree = new JCheckBox("규칙을 준수하겠습니다.");
		p2.add(new JLabel("이름"));
		p2.add(jtf_name);
		p2.add(new JLabel("전화번호"));
		p2.add(jtf_phone);
		p2.add(new JLabel("성별"));
		JPanel p2_gender = new JPanel();
		p2_gender.add(jrb_man);
		p2_gender.add(jrb_woman);
		p2.add(p2_gender);
		p2.add(new JLabel("주소"));
		p2.add(jsp);
		
		JLabel jlb_title = new JLabel("         입회원서");
		Font font = new Font("굴림", Font.BOLD, 30);
		jlb_title.setFont(font);
		
		
		p1.add(jlb_title, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.CENTER);
		p1.add(jcb_agree, BorderLayout.SOUTH);
		
		JButton btn_first = new JButton("<<");
		JButton btn_prev = new JButton("<");
		JButton btn_submit = new JButton("제출");
		JButton btn_reset = new JButton("초기화");
		JButton btn_save = new JButton("저장");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		JButton btn_read = new JButton("읽어오기");
		JButton btn_next = new JButton(">");
		JButton btn_last = new JButton(">>");
		p_btn.add(btn_first);
		p_btn.add(btn_prev);
		p_btn.add(btn_submit);
		p_btn.add(btn_reset);
		p_btn.add(btn_read);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		p_btn.add(btn_save);
		p_btn.add(btn_next);
		p_btn.add(btn_last);
		p_btn.add(jlb_current);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p_btn,BorderLayout.SOUTH);
		
		setSize(800, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jtf_name.getText();
				String phone = jtf_phone.getText();
				String addr = jta_addr.getText();
				boolean agree = jcb_agree.isSelected();
				
				Member m = new Member
						(name, phone, gender, 
										addr, agree);
				
				list.set(idx, m);
				viewData();
				JOptionPane.showMessageDialog(null, "수정하였습니다.");
			}
		});
		//    
		//0
		//
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				list.remove(idx);
//				if(idx >=  list.size()) {
//					idx = list.size()-1;
//				}
				viewData();
				JOptionPane.showMessageDialog(null, "삭제하였습니다.");
			}
		});
		
		
		btn_first.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idx=0;
				viewData();
			}
		});
		
		
		btn_last.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idx = list.size()-1;
				viewData();
			}
		});
		
		btn_prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idx == 0) {
					JOptionPane.showMessageDialog(null, "맨 처음 데이터입니다.");					
				}else {
					idx--;
					viewData();
				}
			}
		});
		
		btn_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("index:"+idx);
				System.out.println("데이터 수:"+list.size());
				System.out.println("------------------------------");
				
				if(idx ==  list.size() - 1) {
					JOptionPane.showMessageDialog(null, "맨 마지막 데이터입니다.");					
				}else {
					idx++;
					viewData();
				}
			}
		});
		
		
		btn_read.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadFile();
			}
		});
		
		btn_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					ObjectOutputStream oos 
					= new ObjectOutputStream(new FileOutputStream(fname));
					oos.writeObject(list);
					oos.close();
					JOptionPane.showMessageDialog(null, "파일로 저장하였습니다.");
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}
		});
		
		
		btn_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jtf_name.getText();
				String phone = jtf_phone.getText();
				String addr = jta_addr.getText();
				boolean agree = jcb_agree.isSelected();
				
				Member m = new Member
						(name, phone, gender, 
										addr, agree);
				list.add(m);
				idx = list.size()-1;
				viewData();
			}
		});
		
		btn_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_reset();
			}
		});
		
		//loadFile();
		
	}//생성자 끝
	
	public void loadFile() {
		try {
			ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream(fname));
			
			list =(ArrayList<Member>) ois.readObject();
			idx = 0;
			viewData();
			ois.close();
			
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
	}
	
	public void view_reset() {
		jtf_name.setText("");
		jtf_phone.setText("");
		jta_addr.setText("");
		jrb_man.setSelected(true);
		jrb_woman.setSelected(false);				
		jcb_agree.setSelected(false);
	}
	
	public void viewData() {
		
		if(list.size() != 0) {
			Member m = list.get(idx);
			jtf_name.setText(m.getName());
			jtf_phone.setText(m.getPhone());
			jta_addr.setText(m.getAddr());
			jrb_man.setSelected(true);
			if(m.getGender().equals("여성")) {
				jrb_woman.setSelected(true);
			}
			
			if(m.isAgree()) {
				jcb_agree.setSelected(true);
			}
			
			int total = list.size();
			jlb_current.setText((idx+1) +"/" + total);
		}else {
			view_reset();
			jlb_current.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		new Join02();

	}

}
