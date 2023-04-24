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
		// 제목 설정
		MainPage.jlb_title=new JLabel(new MembersDAO().getTitle(LogInPage.ID));
		MainPage.jlb_title.setBackground(Color.white);
		MainPage.jlb_title.setOpaque(true);
		MainPage.jlb_title.setFont(new Font("Dovemayo_gothic", Font.PLAIN, 15));
		
		// 화면 설정
		setLayout(new BorderLayout());
		add(MainPage.jlb_title, BorderLayout.NORTH);
		add(new Miniroom(), BorderLayout.CENTER);
		setBackground(new Color(206,212,192));
		
		
	}


}

// 아바타 action 삽입을 위해 Home Panel 안에 Miniroom Panel 삽입
class Miniroom extends JPanel {
	Image homeimage;
	MyAvatar avatar;
	
	public Miniroom() {
		// 여성이면 여성 캐릭터, 남성이면 남성 캐릭터 삽입
//		String gender = new MembersDAO().getGender(LogInPage.ID).trim();
//		if(gender.equals("여")) {gender="girl.png";} 
//		else if(gender.equals("남")){gender="boy.png";}
//		avatar = new MyAvatar(gender);
		avatar = new MyAvatar("girl.png");
		
		// avatar의 움직임을 위해 avatar 클래스의 마우스리스너 삽입
		addMouseMotionListener(avatar);

		
		// avatar의 움직임을 위한 쓰레드 구현
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
		
		// 화면 설정
		setSize(750,450);
		setBackground(new Color(206,212,192));
		homeimage = new ImageIcon("image.gif").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	} 

	// image를 그려주는 paint 메서드 
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(homeimage, 0, 0, null);
		avatar.draw(g);
	}
}

// avatar의 움직임을 위해 별도로 클래스 작성
class MyAvatar implements MouseMotionListener{
	Image img = null;
	int x = 300, y=150;	// DB에 저장된 위치로 초기 위치 설정하기
	
	public MyAvatar(String name) {
		try {
			img = new ImageIcon(name).getImage();
		} catch (Exception e) {System.out.println(" MyAvatar 예외발생 : "+e.getMessage());}
	}
	// 마우스로 아바타를 드래그하면 그 위치로 이동
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