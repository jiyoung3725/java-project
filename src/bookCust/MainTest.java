package bookCust;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainTest extends JFrame{
	
	BookFrame bf;
	CustomerFrame cf;
	
	public MainTest() {
		bf = new BookFrame();
		cf = new CustomerFrame();
		JButton btn_customer = new JButton("회원관리");
		JButton btn_book = new JButton("도서관리");
		
		setLayout(null);
		btn_customer.setBounds(100, 110, 100, 50);
		btn_book.setBounds(230, 110, 100, 50);
		add(btn_customer);
		add(btn_book);
		
		setSize(450,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cf.setVisible(false);
				bf.setVisible(true);
			}
		});
		
		btn_customer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bf.setVisible(false);
				cf.setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		new MainTest();
	}
}







