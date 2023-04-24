package home.copy;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Community extends JFrame {
	JTextField jtf_search;
	JComboBox<String> jcb_option;	//�����ؿ�, �츮���� ����
	String []interest = {"�ǰ�/�","����/�丮","��ȭ/����/����","�̼�/����","�뷡/����","����ũ","��Ÿ"};
	JCheckBox []jcb = new JCheckBox[interest.length];
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
		
	public Community() {
		JPanel p_main = new JPanel();	//�Խ��� ���� ȭ��
		p_main.setLayout(new BorderLayout());
		JPanel p_search1 = new JPanel();	//�˻�â ��ü �г�
		JPanel p_search2 = new JPanel();	//�˻�â ���
		JPanel p_search3 = new JPanel();	//�˻�â �ϴ�
		JPanel p_interest = new JPanel();	//���ɻ� �˻� �г�
		p_interest.setLayout(new GridLayout(7,1));
		JPanel p_etc = new JPanel();	//�۾���, ������ �ѱ�
		p_etc.setLayout(new GridLayout(1,3));
		JPanel p_etc1 = new JPanel();
		JPanel p_etc2 = new JPanel();
		JPanel p_etc3 = new JPanel();
		p_etc.add(p_etc1);
		p_etc.add(p_etc2);
		p_etc.add(p_etc3);
		
		p_search1.setLayout(new GridLayout(3,1));
		jcb_option = new JComboBox<String>();
		jcb_option.addItem("�Բ��ؿ�");
		jcb_option.addItem("���׻�Ȱ");
		
		jtf_search = new JTextField(20);
		JButton btn_search = new JButton("�˻�");
		JButton btn_clear = new JButton("�ʱ�ȭ");
		JRadioButton jrb_option1 = new JRadioButton("�α��") ;	//�α�� ����
		JRadioButton jrb_option2 = new JRadioButton("�ֽż�");	//�ֽż� ����
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_option1);
		bg.add(jrb_option2);
		
		p_search2.add(jcb_option);
		p_search2.add(jtf_search);
		p_search2.add(btn_search);
		p_search2.add(btn_clear);
		p_search3.add(jrb_option1);
		p_search3.add(jrb_option2);
		p_search1.add(p_search2);
		p_search1.add(p_search3);
		
		p_main.add(p_search1, BorderLayout.NORTH);
		
		for(int i=0; i<interest.length ; i++) {
			jcb[i] = new JCheckBox(interest[i]);
			p_interest.add(jcb[i]);			
		}
		p_main.add(p_interest, BorderLayout.WEST);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("��ȣ");
		colNames.add("��ġ");
		colNames.add("����");
		colNames.add("�ۼ���");
		colNames.add("�ۼ���¥");
		colNames.add("�Ⱓ");
		colNames.add("��������");
		colNames.add("��");
		colNames.add("��ȸ��");
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		p_main.add(jsp, BorderLayout.CENTER);
		
		JButton btn_pre = new JButton("����");
		JLabel jlb_page = new JLabel("page");	//page ��ȣ�� ���� �ٲ�� ���� ����
		JButton btn_post = new JButton("����");
		p_etc2.add(btn_pre);
		p_etc2.add(jlb_page);
		p_etc2.add(btn_post);
		
		JButton btn_write = new JButton("�Խñ� �ۼ�");
		p_etc3.add(btn_write);
		p_main.add(p_etc, BorderLayout.SOUTH);
		add(p_main);
		
		setSize(800, 600);
		setVisible(true);
	}
	
}
;