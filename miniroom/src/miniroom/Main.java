package miniroom;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener{
	
	JLabel lblCom, lblUser, lblVS, lblResult, lblScore, lblresult;
	JButton btnmook, btnjji, btnbba;
	int win=0;
	int draw=0;
	int lose=0;
	
	
	ImageIcon Icon[] = {
			new ImageIcon("./img/mook.png"),
			new ImageIcon("./img/jji.png"),
			new ImageIcon("./img/bba.png")
	};
	
	ImageIcon smallIcon[] = {
			new ImageIcon("./img/small_mook.png"),
			new ImageIcon("./img/small_jji.png"),
			new ImageIcon("./img/small_bba.png")	
	};
	
	public Main(){
		setBounds(0, 0, 820, 820);
		setTitle("���� ���� �� ����");
		setLayout(null);
		
		Container ct = getContentPane();
		ct.setBackground(Color.white);

		lblScore = new JLabel("0�� 0�� 0��");
		lblScore.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
		lblScore.setBounds(300, 0, 500, 50);
		
		lblCom = new JLabel(new ImageIcon("./img/first.png"));
		lblCom.setBounds(50, 50, 300, 300);
		
		lblVS = new JLabel("VS");
		lblVS.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
		lblVS.setBounds(375, 50, 50, 300);
		
		lblresult = new JLabel();
		lblresult.setFont(new Font("����ǹ��� ����", Font.BOLD, 70));
		lblresult.setBounds(300, 0, 480, 1300);
		
		
		lblUser = new JLabel(new ImageIcon("./img/first.png"));
		lblUser.setBounds(450, 50, 300, 300);
		
		lblResult = new JLabel();
		lblResult.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
		lblResult.setBounds(350, 180, 200, 300);
		
		btnmook = new JButton(smallIcon[0]);
		btnmook.setBounds(50, 400, 150, 150);
		btnjji = new JButton(smallIcon[1]);
		btnjji.setBounds(325, 400, 150, 150);
		btnbba = new JButton(smallIcon[2]);
		btnbba.setBounds(600, 400, 150, 150);
	
		btnmook.addActionListener(this);
		btnjji.addActionListener(this);
		btnbba.addActionListener(this);
		
		ct.add(lblCom);
		ct.add(lblUser);
		ct.add(lblVS);
		ct.add(btnmook);
		ct.add(btnjji);
		ct.add(btnbba);
		ct.add(lblResult);
		ct.add(lblScore);
		ct.add(lblresult);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	public class get {
		static public final int point = 100;
		int win;
		int lose;
	}

	public void chkResult(int user){
		int com = (int)((Math.random()*1000)%3)+1;
		lblCom.setIcon(Icon[com-1]);
		
		
		
		//1:�� 2:�� 3:��
		if(com==user){
			draw++;
			lblResult.setText("�� �� ��!!");
		}else if((com==1 && user==3) || (com==2 && user==1) || (com==3 && user==2)){
			win++;
			lblResult.setText("�� �� ��!!");
		}else if((com==1 && user==2) || (com==2 && user==3) || (com==3 && user==1)){
			lose++;
			lblResult.setText("�����Ⱦ�!!");
		}else{
			lblResult.setText("����");
		}
		lblScore.setText(win + "�� " + draw + "�� " + lose + "�� ");
		
		if(win > 3 && draw < 3 && lose < 3) {
			int win = get.point + 300;
			lblresult.setText(win + "��");
//			lblScore.setText("����Ʈ ����~!");
		}
		else {
			int lose = get.point;
			lblresult.setText(lose + "��");
		}
		if(draw > 3 && lose >3) {
			lblresult.setText("�������");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if(ob == btnmook){
			lblUser.setIcon(Icon[0]);
			chkResult(1);
		}else if(ob == btnjji){
			lblUser.setIcon(Icon[1]);
			chkResult(2);
		}else if(ob == btnbba){
			lblUser.setIcon(Icon[2]);
			chkResult(3);
		}
	}
}