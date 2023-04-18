package bookCust;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.BookDAO;
import vo.BookVO;

public class BookFrame extends JFrame {
	JTextField jtf_bookid;
	JTextField jtf_bookname;
	JTextField jtf_publisher;
	JTextField jtf_price;

	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
		
	public BookFrame() {
		jtf_bookid = new JTextField(10);
		jtf_bookname = new JTextField(10);
		jtf_publisher = new JTextField(10);
		jtf_price = new JTextField(10);
		
		JButton btn_new = new JButton("새로운 도서");
		JButton btn_add = new JButton("추가");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
				
		JPanel p = new JPanel();
		p.add(new JLabel("도서번호"));
		p.add(jtf_bookid);
		p.add(new JLabel("도서명"));
		p.add(jtf_bookname);
		p.add(new JLabel("출판사"));
		p.add(jtf_publisher);
		p.add(new JLabel("가격"));
		p.add(jtf_price);
		p.add(btn_new);
		p.add(btn_add);
		p.add(btn_update);
		p.add(btn_delete);
		
		colNames = new Vector<String>();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("출판사");
		colNames.add("가격");
		
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setTitle("도서관리");
		setSize(1200, 500);
		//setVisible(true);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				Vector<String> v = rowData.get(row);
				jtf_bookid.setText(v.get(0));
				jtf_bookname.setText(v.get(1));
				jtf_publisher.setText(v.get(2));
				jtf_price.setText(v.get(3));
			}
		});
		
		
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bookid = Integer.parseInt(jtf_bookid.getText());
				BookDAO dao = new BookDAO();
				if(dao.deleteBook(bookid) > 0) {
					JOptionPane.showMessageDialog(null, "삭제성공");
					loadBook();
				}else {
					JOptionPane.showMessageDialog(null, "삭제실패");
				}
			}
		});
		
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bookid = Integer.parseInt( jtf_bookid.getText() );
				String bookname = jtf_bookname.getText();
				String publisher = jtf_publisher.getText();
				int price = Integer.parseInt(jtf_price.getText());
				
				BookVO b = new BookVO(bookid, bookname, publisher, price);
				BookDAO dao = new BookDAO();
				int re = dao.updateBook(b);
				if( re == 1) {
					JOptionPane.showMessageDialog(null, "도서를 수정하였습니다.");
					loadBook();
				}else {
					JOptionPane.showMessageDialog(null, "도서수정에 실패하였습니다.");
				}	
			}
		});
		
		
		btn_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDAO dao = new BookDAO();
				int bookid = dao.getNextBookId();
				jtf_bookid.setText(bookid+"");
				jtf_bookname.setText("");
				jtf_publisher.setText("");
				jtf_price.setText("");
			}
		});
		
		
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bookid = Integer.parseInt( jtf_bookid.getText() );
				String bookname = jtf_bookname.getText();
				String publisher = jtf_publisher.getText();
				int price = Integer.parseInt(jtf_price.getText());
				
				BookVO b = new BookVO(bookid, bookname, publisher, price);
				BookDAO dao = new BookDAO();
				int re = dao.insertBook(b);
				if( re == 1) {
					JOptionPane.showMessageDialog(null, "도서를 등록하였습니다.");
					loadBook();
				}else {
					JOptionPane.showMessageDialog(null, "도서등록에 실패하였습니다.");
				}				
			}
		});
		
		loadBook();
	}
	
	//모든 도서목록을 읽어와서 테이블에 출력하는 메소드
	public void loadBook() {
		rowData.clear();
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = dao.findAll();
		for(BookVO b  :list  ) {
			Vector<String> v= new Vector<String>();
			v.add(b.getBookid()+"");
			v.add(b.getBookname());
			v.add(b.getPublisher());
			v.add(b.getPrice()+"");
			rowData.add(v);
		}
		table.updateUI();
	}
	
}


















