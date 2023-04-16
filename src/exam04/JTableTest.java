package exam04;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest extends JFrame {
	JTable table;
	public JTableTest() {
		String [] colName = {"이름","국어","영어","수학"};
		String [][]rowData = {{"손지민","65","78","50"},
				{"이아현","60","90","95"},{"정소희","50","95","40"},
				{"우현아","70","70","85"}};
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTableTest();
	}

}
