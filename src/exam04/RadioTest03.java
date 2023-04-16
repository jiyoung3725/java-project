package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RadioTest03 extends JFrame {

	JLabel jlb;
	String []key = {"사과","바나나","포도","복숭아","감"};
	String []value = {"apple.png","banana.jpg","grape.png","peach.png","persimmon.jpeg"};
	HashMap<String, ImageIcon> map;
	JRadioButton []jrb = new JRadioButton[key.length];
	
	public RadioTest03() {
		jlb = new JLabel();
		map = new HashMap<String, ImageIcon>();
		setLayout(new FlowLayout());
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i<key.length; i++) {
			jrb[i] = new JRadioButton(key[i]);
			map.put(key[i],new ImageIcon(value[i]));
			bg.add(jrb[i]);
			add(jrb[i]);
			jrb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String key = ((JRadioButton)e.getSource()).getText(); //이벤트가 발생된 객체를 가져오는데 오브젝트로 반환하기때문에 타임캐스팅필요
					ImageIcon icon = map.get(key);
					jlb.setIcon(icon);
					
				
					
					
					
				}
			});
		}
		add(jlb);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new RadioTest03();
	}

}
