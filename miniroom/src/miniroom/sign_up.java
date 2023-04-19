package miniroom;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sign_up extends Frame{

    public sign_up(String str){
        super(str);
        ImageIcon s_img = new ImageIcon("./image/hello.png"); //�̹��� ������ ����
        JLabel s_bg  = new JLabel(s_img);
        
        //ȸ������ â ������
		
        JButton btn = new JButton(new ImageIcon("./image/okay.png"));
        JButton btn1 = new JButton(new ImageIcon("./image/cancel.png"));
        
        JPanel s_panel = new JPanel();
        JFrame s_frame = new JFrame();
        JLabel s_label = new JLabel("���̵� : ");
        JTextField s_text = new JTextField(6); //���̵�
        JLabel s_label1 = new JLabel("��й�ȣ : ");
        JTextField s_text1 = new JTextField(6); //��й�ȣ
        JLabel s_label2 = new JLabel("ĳ���� �̸� : ");
        JTextField s_text2 = new JTextField(6); //��й�ȣ
        JLabel s_label3 = new JLabel("�̴Ϸ� �̸� : "); //
        JTextField s_text3 = new JTextField(6); //��й�ȣ
        JLabel s_label4 = new JLabel("�̴Ϸ� ���� �Ұ� : ");
        JTextField s_text4 = new JTextField(15); //��й�ȣ
        JLabel s_thisis = new JLabel("ex_) ������� �̴Ϸ�");
        
        s_label.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
        s_label1.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
        s_label2.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
        s_label3.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
        s_label4.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
        s_thisis.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
        
        s_label.setSize(550, 800);
        s_label1.setSize(550, 800);
        s_label2.setSize(550, 800);
        s_label3.setSize(550, 800);
        s_label4.setSize(550, 800);
        s_thisis.setSize(550, 800);
        
        s_panel.add(btn);
        s_panel.add(btn1);
        
        s_panel.add(s_text);
        s_panel.add(s_text1);
        s_panel.add(s_text2);
        s_panel.add(s_text3);
        s_panel.add(s_text4);
        s_panel.add(s_thisis);
        
        Container con = s_frame.getContentPane();
        
        btn.setBorderPainted(false);  //��ư ��� �����ϰ�!
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        
        btn.setLocation(430, 570);
        btn.setSize(200,300); //Ȯ�� ��ư
        con.add(btn);
        
        btn1.setBorderPainted(false);  //��ư ��� �����ϰ�!
        btn1.setFocusPainted(false);
        btn1.setContentAreaFilled(false);
        
        btn1.setLocation(180, 570);
        btn1.setSize(200,300); //Ȯ�� ��ư
        con.add(btn1);
        
        s_text.setSize(120,40);
        s_text.setLocation(400, 150); //�Է�â
        con.add(s_text);
        
	    s_label.setLocation(320, -230); //�۾�
	    con.add(s_label);
	    
	    s_text1.setSize(120,40); 
	    s_text1.setLocation(400, 227); //��й�ȣ �Է�â
	    con.add(s_text1);
	        
		s_label1.setLocation(300, -156); //��й�ȣ �۾�
		con.add(s_label1);
		
	    s_text2.setSize(120,40); 
	    s_text2.setLocation(400, 300); //ĳ���� �̸� �Է�â
	    con.add(s_text2);
	        
		s_label2.setLocation(280, -82); //ĳ���� �۾�
		con.add(s_label2);
		
	    s_text4.setSize(120,40); 
	    s_text4.setLocation(400, 380); //�̴Ϸ� �̸� �Է�â
	    con.add(s_text4);
	        
		s_label4.setLocation(220, 80); //�̴Ϸ� �۾�
		con.add(s_label4);
		
		s_text3.setSize(220,40); 
	    s_text3.setLocation(390, 460); //�̴Ϸ� �Ұ� �Է�â
	    con.add(s_text3);
	        
		s_label3.setLocation(280, -1); //�̴Ϸ� �۾�
		con.add(s_label3);
		
		s_thisis.setLocation(300, 32); //����
		con.add(s_thisis);
		    
        s_frame.add(s_panel);
        s_panel.add(s_bg);
        s_frame.setSize(820,820);
        s_frame.setVisible(true);
    
//////////////////////////////////////////////////////////////////////////////////////////////
		///���⼭���� Ȩ��////
	    ImageIcon img = new ImageIcon("./image/homepage.png"); //�̹��� ������ ����
	    JLabel h_bg  = new JLabel(img);

	    
		JButton store_btn = new JButton(new ImageIcon("./image/store.png"));
        JButton diary_btn = new JButton(new ImageIcon("./image/diary.png"));
        JButton game_btn = new JButton(new ImageIcon("./image/game.png"));
        JButton character = new JButton(new ImageIcon("./image/profile.png"));
        
        JPanel h_panel = new JPanel();
        JFrame h_frame = new JFrame();
        JLabel h_label1 = new JLabel(""); //Ȩ�������̸�
        JLabel h_label2 = new JLabel(""); //���ټҰ�
        
        h_label1.setFont(new Font("����ǹ��� ����", Font.PLAIN, 40));
        h_label2.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
        
	    h_label1.setSize(550, 800);
	    h_label2.setSize(550, 800);
        h_panel.add(store_btn);
        h_panel.add(diary_btn);
        h_panel.add(game_btn);
        h_panel.add(character);
//	    h_panel.add(h_label);
        
        Container c = h_frame.getContentPane();
//        c.setLayout(null);

        store_btn.setBorderPainted(false);  //��ư ��� �����ϰ�!
        store_btn.setFocusPainted(false);
        store_btn.setContentAreaFilled(false);

        diary_btn.setBorderPainted(false);  //��ư ��� �����ϰ�!
        diary_btn.setFocusPainted(false);
        diary_btn.setContentAreaFilled(false);
        
        game_btn.setBorderPainted(false);  //��ư ��� �����ϰ�!
        game_btn.setFocusPainted(false);
        game_btn.setContentAreaFilled(false);
        
        character.setBorderPainted(false);  //��ư ��� �����ϰ�!
        character.setFocusPainted(false);
        character.setContentAreaFilled(false);
        
        store_btn.setLocation(130, -35);
        store_btn.setSize(300,400);
        c.add(store_btn);
        
        diary_btn.setLocation(360, -35);
        diary_btn.setSize(300,400);
        c.add(diary_btn);
        
        game_btn.setLocation(570, -35);
        game_btn.setSize(300,400);
        c.add(game_btn);
        
        character.setLocation(280, 330);
        character.setSize(300,400);
        c.add(character);
        
        h_label1.setLocation(180, -350);
	    c.add(h_label1);
	    
	    h_label2.setLocation(228, -303);
	    c.add(h_label2);
        
//        h_panel.add(h_label);
        h_panel.add(h_bg);
        h_frame.add(h_panel);
        h_frame.setSize(860,860);
//        h_frame.setVisible(true);

  
        /////////ĳ���� ���� �˾�â///////////////
        ImageIcon info = new ImageIcon("./image/info_popup.png"); //�̹��� ������ ���� ��� ��ư �����
	    JLabel c_bg  = new JLabel(info);
	    
//	    JButton checking = new JButton(new ImageIcon("./image/checking.png"));
              
        JPanel c_panel = new JPanel();
        JFrame c_frame = new JFrame();
        
        int Level = 0;
        int point = 10;
        int friend = 0;
        int neigh = 0;
        
        JLabel c_label1 = new JLabel(""); //�̸�
        JLabel c_label2 = new JLabel(String.valueOf(Level)); //����
        JLabel c_label3 = new JLabel(String.valueOf(point)); //����Ʈ
        JLabel c_label4 = new JLabel(String.valueOf(friend)); //ģ��Ȩ��
        JLabel c_label5 = new JLabel(String.valueOf(neigh)); //�̿�Ȩ��
        
        c_label1.setSize(550, 800);
	    c_label1.setLocation(97, -307);
	   
	    c_label2.setSize(550, 800);
	    c_label2.setLocation(97, -261);
	    
	    c_label3.setSize(550, 800);
	    c_label3.setLocation(97, -215);
	    
	    c_label4.setSize(550, 800);
	    c_label4.setLocation(99, -170);
	    
	    c_label5.setSize(550, 800);
	    c_label5.setLocation(99, -118);
        
        c_label1.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
        c_label2.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
        c_label3.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
        c_label4.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
        c_label5.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
        
        Container cc = c_frame.getContentPane();
        
        cc.add(c_label1);
        cc.add(c_label2);
        cc.add(c_label3);
        cc.add(c_label4);
        cc.add(c_label5);
//        cc.add(checking);
        
        c_frame.setUndecorated(false);
        c_panel.add(c_bg);
        c_frame.add(c_panel);
        c_frame.setLocation(470, 280);
        c_frame.setSize(250,350);
        
        
        //����
        ImageIcon originIcon = new ImageIcon("./image/rock.png");  
        Image originImg = originIcon.getImage(); 
        Image changedImg= originImg.getScaledInstance(320, 100, Image.SCALE_SMOOTH );
        ImageIcon Icon = new ImageIcon(changedImg);
        
        ImageIcon originIcon1 = new ImageIcon("./image/random.png");  
        Image originImg1 = originIcon1.getImage(); 
        Image changedImg1= originImg1.getScaledInstance(320, 100, Image.SCALE_SMOOTH );
        ImageIcon Icon1 = new ImageIcon(changedImg1);

        ImageIcon gamebg = new ImageIcon("./image/game_pg.png"); //�̹��� ������ ���� ��� ��ư �����
	    JLabel g_bg  = new JLabel(gamebg);
	    
	    JButton rock = new JButton(new ImageIcon(changedImg));
	    JButton random = new JButton(new ImageIcon(changedImg1));
	    
	    JPanel g_panel = new JPanel();
        JFrame g_frame = new JFrame();
        
        g_panel.add(rock);
        g_panel.add(random);
        
        Container cg = g_frame.getContentPane();
        
        
       rock.setBorderPainted(false);  //��ư ��� �����ϰ�!
       rock.setFocusPainted(false);
       rock.setContentAreaFilled(false);
       
       random.setBorderPainted(false);  //��ư ��� �����ϰ�!
       random.setFocusPainted(false);
       random.setContentAreaFilled(false);
        
       rock.setLocation(200, 45);
       rock.setSize(400,400);
       cg.add(rock);
       
       random.setLocation(200, 285);
       random.setSize(400,400);
       cg.add(random);
      
      g_frame.setUndecorated(false);
      g_panel.add(g_bg);
      g_frame.add(g_panel);
      g_frame.setSize(820,820);
      
      //����
      ImageIcon originIcon2 = new ImageIcon("./image/manager.png");  
      Image originImg2 = originIcon2.getImage(); 
      Image changedImg2= originImg2.getScaledInstance(80, 30, Image.SCALE_SMOOTH );
      ImageIcon Icon2 = new ImageIcon(changedImg2);
      
      ImageIcon storebg = new ImageIcon(changedImg2); //�̹��� ������ ���� ��� ��ư �����
	  JLabel st_bg  = new JLabel(storebg);
	  
	  
	  
	  JPanel st_panel = new JPanel();
      JFrame st_frame = new JFrame();
     
     
     //�����ڸ��
     JPanel ma_panel = new JPanel();
     JFrame ma_frame = new JFrame();
     JButton mana = new JButton();
     
     ma_panel.add(mana);
     
     Container cs = ma_frame.getContentPane();
     
     mana.setBorderPainted(false);  //��ư ��� �����ϰ�!
     mana.setFocusPainted(false);
     mana.setContentAreaFilled(false);
     
     mana.setLocation(600, 585);
     mana.setSize(400,400);
     cs.add(mana);
    
    ma_frame.setUndecorated(false);
    ma_panel.add(st_bg);
    ma_frame.add(st_panel);
    ma_frame.setSize(820,820);
    
    JLabel st_label = new JLabel("��Ϲ�ȣ");
    JTextField st_text = new JTextField(6); //���̵�
    JLabel st_label1 = new JLabel("��ǰ��ȣ");
    JTextField st_text1 = new JTextField(6); //��й�ȣ
    JLabel st_label2 = new JLabel("��ǰ�̸�");
    JTextField st_text2 = new JTextField(6); //��й�ȣ
    JLabel st_label3 = new JLabel("��ǰ����"); //
    JTextField st_text3 = new JTextField(6); //��й�ȣ
    JLabel st_label4 = new JLabel("��ǰ�Ұ�");
    JTextField st_text4 = new JTextField(15); //��й�ȣ
    
    
    st_label.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
    st_label1.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
    st_label2.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
    st_label3.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
    st_label4.setFont(new Font("����ǹ��� ����", Font.PLAIN, 20));
//    st_thisis.setFont(new Font("����ǹ��� ����", Font.PLAIN, 15));
    
    
    st_label.setSize(550, 800);
    st_label1.setSize(550, 800);
    st_label2.setSize(550, 800);
    st_label3.setSize(550, 800);
    st_label4.setSize(550, 800);
//    st_thisis.setSize(550, 800);
    
    
    ma_panel.add(st_text);
    ma_panel.add(st_text1);
    ma_panel.add(st_text2);
    ma_panel.add(st_text3);
    ma_panel.add(st_text4);
//    ma_panel.add(st_thisis);
    
    st_text.setSize(120,40);
    st_text.setLocation(400, 150); //�Է�â
    cs.add(st_text);
    
	    st_label.setLocation(320, -230); //�۾�
	    cs.add(st_label);
	    
	    st_text1.setSize(120,40); 
	    st_text1.setLocation(400, 227); //��й�ȣ �Է�â
	    cs.add(st_text1);
	        
		st_label1.setLocation(300, -156); //��й�ȣ �۾�
		cs.add(st_label1);
		
	    st_text2.setSize(120,40); 
	    st_text2.setLocation(400, 300); //ĳ���� �̸� �Է�â
	    cs.add(st_text2);
	        
		st_label2.setLocation(280, -82); //ĳ���� �۾�
		cs.add(st_label2);
		
	    st_text4.setSize(120,40); 
	    st_text4.setLocation(400, 380); //�̴Ϸ� �̸� �Է�â
	    cs.add(st_text4);
	        
		st_label4.setLocation(220, 80); //�̴Ϸ� �۾�
		cs.add(st_label4);
		
		st_text3.setSize(220,40); 
	    st_text3.setLocation(390, 460); //�̴Ϸ� �Ұ� �Է�â
	    cs.add(st_text3);
	        
		st_label3.setLocation(280, -1); //�̴Ϸ� �۾�
		cs.add(st_label3);
		
    ma_frame.add(ma_panel);
    ma_panel.add(st_bg);
    ma_frame.setSize(820,820);
//    ma_frame.setVisible(true);
     
    btn.addActionListener(new ActionListener() { //��ư �̺�Ʈ
	            public void actionPerformed(ActionEvent e) {
	            	h_label1.setText(s_text2.getText()+"�� �̴Ϸ�");
	            	h_label2.setText(s_text3.getText());
	            	s_frame.setVisible(false);
	                h_frame.setVisible(true);
	            }					
	        });
    btn1.addActionListener(new ActionListener() { //��ư �̺�Ʈ
        public void actionPerformed(ActionEvent e) {
        	s_frame.setVisible(false);
        }					
    });
	     
    store_btn.addActionListener(new ActionListener() { //��ư �̺�Ʈ
        public void actionPerformed(ActionEvent e) {
        	ma_frame.setVisible(true);
            h_frame.setVisible(false);
        	setTitle("��������!!!");
        }					
    });

    diary_btn.addActionListener(new ActionListener() { //��ư �̺�Ʈ
        public void actionPerformed(ActionEvent e) {
        	h_frame.setVisible(true);
        	new MemoJang();
        	
        	setTitle("������ �޸��� ���� =3");
        }					
    });

    game_btn.addActionListener(new ActionListener() { //��ư �̺�Ʈ
        public void actionPerformed(ActionEvent e) {
        	g_frame.setVisible(true);
        	h_frame.setVisible(false);
        	
        }					
    });    
    
    character.addActionListener(new ActionListener() { //��ư �̺�Ʈ
    	public void actionPerformed(ActionEvent e) {
    		c_frame.setVisible(true);
    		System.out.println("����");
    		c_label1.setText(s_text2.getText());
        }					
    });  
    rock.addActionListener(new ActionListener() { //��ư �̺�Ʈ
    	public void actionPerformed(ActionEvent e) {
    		g_frame.setVisible(false);
    		new Main();
        }					
    });
    
    random.addActionListener(new ActionListener() { //��ư �̺�Ʈ
    	public void actionPerformed(ActionEvent e) {
    		c_frame.setVisible(true);
    		c_label1.setText(s_text2.getText());
        }					
    });
    mana.addActionListener(new ActionListener() { //��ư �̺�Ʈ
    	public void actionPerformed(ActionEvent e) {
    		ma_frame.setVisible(true);
    		c_label1.setText(s_text2.getText());
        }					
    });
    
    }
    
    
//    public void paintComponent(Graphics g, Image im){
//        super.paintComponents(g);
//        g.drawImage(im,0,0,getWidth(),getHeight(),this);
//    }
		public static void main(String[] args) {
			new sign_up("");
	}
}
    