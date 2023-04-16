package exam04;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JTableTestVectorInput extends JFrame {

	int row;
	JTable table;
	Vector<String>colName;
	Vector<Vector<String>> rowData;
	JLabel name;
	JLabel kor;
	JLabel eng;
	JLabel math;
	JLabel sum;
	JLabel avg;
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	JTextField jtf4;
	
	public JTableTestVectorInput() {
		name = new JLabel("이름");
		kor = new JLabel("국어");
		eng = new JLabel("영어");
		math = new JLabel("수학");
		sum = new JLabel("총점");
		avg = new JLabel("평균");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		p.add(name);
		p.add(jtf1);
		p.add(kor);
		p.add(jtf2);
		p.add(eng);
		p.add(jtf3);
		p.add(math);
		p.add(jtf4);
		
		add(p, BorderLayout.CENTER); //south
		
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colName.add("이름");
		colName.add("국어");
		colName.add("영어");
		colName.add("수학");
		colName.add("총점");
		colName.add("평균");
		
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp,BorderLayout.NORTH); //center
		
		JPanel p1 = new JPanel();  //플로우 레이아웃으로 담는게 더 편할것같음.
		JButton btn = new JButton("등록");
		JButton btn2 = new JButton("수정");
		JButton btn3 = new JButton("삭제");
		p1.setLayout(new GridLayout(1,3));
		p1.add(btn);
		p1.add(btn2);
		p1.add(btn3);
		add(p1, BorderLayout.SOUTH); //south
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				Vector<String> v = rowData.get(row);
				jtf1.setText(v.get(0));
				jtf2.setText(v.get(1));
				jtf3.setText(v.get(2));
				jtf4.setText(v.get(3));
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String>v = new Vector<String>();
				v.add(jtf1.getText());
				v.add(jtf2.getText());
				v.add(jtf3.getText());
				v.add(jtf4.getText());
				int k = Integer.parseInt(jtf2.getText());
				int en = Integer.parseInt(jtf3.getText());
				int m = Integer.parseInt(jtf4.getText());
				int sum = k+en+m;
				int avg = (k+en+m)/3;
				v.add(sum+"");
				v.add(avg+"");
				rowData.set(row, v);
				table.updateUI();
				
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int re = JOptionPane.showConfirmDialog(null, "정말로 삭제할까요?");
				if(re ==0) {
				rowData.remove(row);
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				table.updateUI();
				}
			}
		});
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = new Vector<String>(); //벡터의 데이터를 스트링으로 받음.
				v.add(jtf1.getText());
				v.add(jtf2.getText());
				v.add(jtf3.getText());
				v.add(jtf4.getText());
				int k = Integer.parseInt(jtf2.getText());
				int en = Integer.parseInt(jtf3.getText());
				int m = Integer.parseInt(jtf4.getText());
				int sum = k+en+m;
				int avg = (k+en+m)/3;
				v.add(sum+"");
				v.add(avg+"");
				
				rowData.add(v);
				table.updateUI(); //변경된 내용 테이블에 반영
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
			}
		});
		
		setSize(500,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new JTableTestVectorInput();
	}

}
