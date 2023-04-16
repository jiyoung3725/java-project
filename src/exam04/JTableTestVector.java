package exam04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class JTableTestVector extends JFrame {

	JTable table;
	Vector<String>colName;
	Vector<Vector<String>> rowData;
	public JTableTestVector() {
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colName.add("이름");
		colName.add("국어");
		colName.add("수학");
		colName.add("영어");
		
		Vector<String> v1 = new Vector<String>();
		v1.add("손지민");
		v1.add("65");
		v1.add("78");
		v1.add("50");
		
		Vector<String> v2 = new Vector<String>();
		v2.add("이아현");
		v2.add("60");
		v2.add("90");
		v2.add("95");
		
		rowData.add(v1);
		rowData.add(v2);
		
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp,BorderLayout.CENTER);
		
		JButton btn = new JButton("추가");
		add(btn, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> row = new Vector<String>(); //벡터의 데이터를 스트링으로 받음.
				row.add("홍길동");
				row.add("100");
				row.add("100");
				row.add("100");
				
				rowData.add(row);
				table.updateUI(); //변경된 내용 테이블에 반영
			}
		});
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new JTableTestVector();
	}

}
