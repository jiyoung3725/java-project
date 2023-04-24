package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Memo extends JPanel {
	public Memo() {
		setBackground(new Color(206, 212,192));
		Vector<String> colName = new Vector<String>();
		colName.add("친구");
		colName.add("내용");
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		Vector<String> v = new Vector<String>();
		v.add("일촌1");
		v.add("안ㄴ녕!");
		rowData.add(v);
		JPanel pan_memo = new JPanel(new BorderLayout());
		JTable jtb_memo = new JTable(rowData, colName);
		add(new JLabel("쪽지함 리스트"), BorderLayout.NORTH);
		add(jtb_memo, BorderLayout.CENTER);
		jtb_memo.addMouseListener(new MouseListener() {
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
				jtb_memo.getSelectedRow();
				new MemoPopUp();		
				}
		});
	}
}
