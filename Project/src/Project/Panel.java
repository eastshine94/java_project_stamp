package Project;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class Panel extends JPanel{
	Color c = Color.BLACK;
	public Panel() {
		setBackground(Color.WHITE);
		setOpaque(false);
		setPreferredSize(new Dimension(140, 140));
	}
	
	public void paint(Graphics g){
		super.paint(g);
		setForeground(c);
		g.fillOval(0,0,140,140);
		
	}
}
