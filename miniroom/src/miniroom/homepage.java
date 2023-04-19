package miniroom;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class homepage1 extends JFrame{
    ImageIcon i = new ImageIcon("C:\\Users\\s2017\\Desktop\\main2.png");
    Image im = i.getImage();
    homepage1(){
        this.setTitle("미니홈피");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        MyPanel panel = new MyPanel();
        panel.setLayout(new FlowLayout());
        
        this.add(panel);
        this.setSize(860,860);
        this.setVisible(true);
        
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }
}
public class homepage {
    public static void main(String[] args) {
         new homepage1();
    } 
}
