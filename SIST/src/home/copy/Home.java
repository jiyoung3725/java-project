package home.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.MembersDAO;
import oracle.net.aso.c;


public class Home extends JPanel {
	public Home() {
		// ���� ����
		MainPage.jlb_title=new JLabel(new MembersDAO().getTitle(LogInPage.ID));
		MainPage.jlb_title.setBackground(Color.white);
		MainPage.jlb_title.setOpaque(true);
		MainPage.jlb_title.setFont(new Font("Dovemayo_gothic", Font.PLAIN, 15));
		
		// ȭ�� ����
		setLayout(new BorderLayout());
		add(MainPage.jlb_title, BorderLayout.NORTH);
		add(new Miniroom(), BorderLayout.CENTER);
		setBackground(new Color(206,212,192));
		
		
	}


}

// �ƹ�Ÿ action ������ ���� Home Panel �ȿ� Miniroom Panel ����
class Miniroom extends JPanel {
	Image homeimage;
	MyAvatar avatar;
	
	public Miniroom() {
		// �����̸� ���� ĳ����, �����̸� ���� ĳ���� ����
//		String gender = new MembersDAO().getGender(LogInPage.ID).trim();
//		if(gender.equals("��")) {gender="girl.png";} 
//		else if(gender.equals("��")){gender="boy.png";}
//		avatar = new MyAvatar(gender);
		avatar = new MyAvatar("girl.png");
		
		// avatar�� �������� ���� avatar Ŭ������ ���콺������ ����
		addMouseMotionListener(avatar);

		
		// avatar�� �������� ���� ������ ����
		class MyThread extends Thread{
			public void run() {
				while(true) {
					avatar.update();
					repaint();
					try { Thread.sleep(50);} 
					catch (InterruptedException e) {}
				}
			}
		}
		new MyThread().start();
		
		// ȭ�� ����
		setSize(750,450);
		setBackground(new Color(206,212,192));
		homeimage = new ImageIcon("image.gif").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	} 

	// image�� �׷��ִ� paint �޼��� 
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(homeimage, 0, 0, null);
		avatar.draw(g);
	}
}

// avatar�� �������� ���� ������ Ŭ���� �ۼ�
class MyAvatar implements MouseMotionListener{
	Image img = null;
	int x = 300, y=150;	// DB�� ����� ��ġ�� �ʱ� ��ġ �����ϱ�
	
	public MyAvatar(String name) {
		try {
			img = new ImageIcon(name).getImage();
		} catch (Exception e) {System.out.println(" MyAvatar ���ܹ߻� : "+e.getMessage());}
	}
	// ���콺�� �ƹ�Ÿ�� �巡���ϸ� �� ��ġ�� �̵�
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	public void mouseMoved(MouseEvent e) {}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, 50,90, null);
	}
	public void update() {}
	
}