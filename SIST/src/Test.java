import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends JFrame {

	public Test() {
		ImageIcon icon = new ImageIcon("girl.png");
		add(new CustomJLabel(icon));
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
class CustomJLabel extends JLabel {
    private ImageIcon image;
    private int charX, charY;

    public CustomJLabel(ImageIcon imageIcon) {
        super();
        image = imageIcon;
        charX = 0;
        charY = 0;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                charX = point.x;
                charY = point.y;
                repaint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = e.getPoint();
                charX = point.x;
                charY = point.y;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, 0, null);
        g.drawRect(charX, charY, 20, 20);
    }
}

