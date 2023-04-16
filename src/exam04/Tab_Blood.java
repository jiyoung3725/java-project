package exam04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tab_Blood extends JPanel {
	String []data = {"A형","B형","AB형","O형"};
	JCheckBox []jcb = new JCheckBox[data.length];
	JTextField jtf;
	
	public Tab_Blood() {
		jtf = new JTextField(20);
		for(int i = 0 ; i<jcb.length; i++) {
			jcb[i] = new JCheckBox(data[i]);
			add(jcb[i]);
			jcb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = "";
					for(int i = 0 ; i<jcb.length;i++) {
						if(jcb[i].isSelected()) {
							str += jcb[i].getText()+",";
						}
					}
					if(str.equals("")) {
						jtf.setText("선택해 주세요!");
					}else {
					str = str.substring(0, str.length()-1);
					jtf.setText("우리 가족의 혈액형은 " + str + "입니다.");
					}
					
				}
			});
		}
		add(jtf);
	}
}
