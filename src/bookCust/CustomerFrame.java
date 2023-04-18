package bookCust;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import bookCust.CustomerDAO;
import bookCust.CustomerVO;

public class CustomerFrame extends JFrame {
	JTextField jtf_custid;
	JTextField jtf_name;
	JTextField jtf_address;
	JTextField jtf_phone;
	
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public CustomerFrame() {
		colNames = new Vector<String>();
		colNames.add("고객번호");
		colNames.add("이름");
		colNames.add("주소");
		colNames.add("전화");
		
		rowData = new Vector<Vector<String>>();
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);		
		
		JPanel p = new JPanel();
		
		jtf_custid = new JTextField(10);
		jtf_name = new JTextField(10);
		jtf_address = new JTextField(10);
		jtf_phone = new JTextField(10);
				
		p.add(new JLabel("고객번호"));
		p.add(jtf_custid);
		p.add(new JLabel("이름"));
		p.add(jtf_name);
		p.add(new JLabel("주소"));
		p.add(jtf_address);
		p.add(new JLabel("전화"));
		p.add(jtf_phone);
		
		JButton btn_add = new JButton("등록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		p.add(btn_add);
		p.add(btn_update);
		p.add(btn_delete);
		
		add(p, BorderLayout .NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(1000, 600);
		//setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadCustomer();
		
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
				//테이블에서 선택한 행 인덱스를 갖고 옵니다.
				int row = table.getSelectedRow();
				
				//벡터에서 row번째에 있는 데이터를 갖고 옵니다.
				Vector<String> v = rowData.get(row);
				
				//갖고온 데이터를 각각의 텍스트필드에 출력합니다.
				jtf_custid.setText(v.get(0));
				jtf_name.setText(v.get(1));
				jtf_address.setText(v.get(2));
				jtf_phone.setText(v.get(3));
				
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if( JOptionPane.showConfirmDialog(null, "정말로 삭제할까요?") !=0 ) {
					return;
				}
				
				int custid = Integer.parseInt(jtf_custid.getText());
				CustomerDAO dao = new CustomerDAO();
				int re =dao.deleteCustomer(custid);
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "삭제하였습니다.");
					loadCustomer();
				}else {
					JOptionPane.showMessageDialog(null, "삭제에 실패하였습니다.");
				}
			}
		});
		
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int custid = Integer.parseInt(jtf_custid.getText());
				String name = jtf_name.getText();
				String address = jtf_address.getText();
				String phone = jtf_phone.getText();
				
				//위의 4가지 속성을 갖고 CustomerVO객체를 생성해 봅니다.
				CustomerVO c = 
						new CustomerVO(custid, name, address, phone);
				
				//나머지 코드를 완성해 봅니다.
				CustomerDAO dao = new CustomerDAO();
				int re =dao.updateCustomer(c);
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "회원의 정보를 수정하였습니다.");
					loadCustomer();
				}else {
					JOptionPane.showMessageDialog(null, "수정실패");
				}
			}
		});	
		
		
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int custid = Integer.parseInt(jtf_custid.getText());
				String name = jtf_name.getText();
				String address = jtf_address.getText();
				String phone = jtf_phone.getText();
				
				//위의 4가지 속성을 갖고 CustomerVO객체를 생성해 봅니다.
				CustomerVO c = 
						new CustomerVO(custid, name, address, phone);
				
				//나머지 코드를 완성해 봅니다.
				CustomerDAO dao = new CustomerDAO();
				int re =dao.insertCustomer(c);
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "회원의 정보를 등록하였습니다.");
					loadCustomer();
				}else {
					JOptionPane.showMessageDialog(null, "등록실패");
				}
				
			}
		});
	}
	
	public void loadCustomer() {
		rowData.clear();
		CustomerDAO dao = new CustomerDAO();
		ArrayList<CustomerVO> list = dao.listCustomer();
		for(CustomerVO c :list) {
			Vector<String> v = new Vector<String>();
			v.add(c.getCustid()+"");
			v.add(c.getName());
			v.add(c.getAddress());
			v.add(c.getPhone());
			rowData.add(v);
		}
		table.updateUI();		
		
		/*for(int i=0;i<list.size();i++) {
			CustomerVO c = list.get(i);
			
		}*/
		
	}
	

}











