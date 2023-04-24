package home.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Memo extends JPanel {
	public Memo() {
		
		setBackground(new Color(206, 212,192));
		
		Vector<String> colName = new Vector<String>();
		colName.add("���� ���");
		colName.add("����");
		colName.add("���� �ð�");
		colName.add("���� ����");
		
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		Vector<String> v = new Vector<String>();
		v.add("����1");
		v.add("�Ȥ���!");
		v.add("2023/04/21");
		v.add("����");
		rowData.add(v);
		
		JPanel pan_memo = new JPanel(new BorderLayout());
		JTable jtb_memo = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(jtb_memo);
		add(new JLabel("������ ����Ʈ"), BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		jtb_memo.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				jtb_memo.getSelectedRow();
				new MemoPopUp();		
				}
		});
	}

}
