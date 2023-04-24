package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Home extends JPanel {
	public Home() {
		// 제목 설정
		MainPage.jlb_title=new JLabel("기본 홈페이지입니다.");
		MainPage.jlb_title.setBackground(Color.white);
		MainPage.jlb_title.setOpaque(true);
		MainPage.jlb_title.setFont(new Font("굴림", Font.BOLD, 15));
		
		// 화면 설정
		setLayout(new BorderLayout());
		add(MainPage.jlb_title, BorderLayout.NORTH);
		add(new Miniroom(), BorderLayout.CENTER);
		setBackground(new Color(206,212,192));
	}

}

class Miniroom extends JPanel {
	Image homeimage;
	Image characterIcon;
	MyAvatar avatar;
	public Miniroom() {
		avatar = new MyAvatar("girl.png");
		setSize(750,450);
		homeimage = new ImageIcon("image.gif").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		characterIcon = new ImageIcon("girl.png").getImage();
		setBackground(new Color(206,212,192));
		addMouseMotionListener(avatar);
		
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
	} 

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(homeimage, 0, 0, null);
		avatar.draw(g);
	}
}

class MyAvatar implements MouseMotionListener{
	Image img = null;
	int x = 300, y=150;	// DB에 저장된 위치로 초기 위치 설정하기
	public MyAvatar(String name) {
		try {
			img = new ImageIcon(name).getImage();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, 50,90, null);
	}
	public void update() {
		}
	
}