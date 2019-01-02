package Project;
import java.awt.*;

public class AdidasPanel extends Panel {
	
	public void paint(Graphics g){
		super.paint(g);
	    Graphics2D g2d = (Graphics2D)g;
	    
	    g2d.setColor(Color.WHITE);
	    g2d.rotate(Math.toRadians(57));
	    g2d.fillRect(68, -5, 35, 25);
	    g2d.fillRect(63, -35, 50, 25);
	    g2d.fillRect(56, -65, 80, 25);
	    
	    g2d.setColor(c);
	    g2d.rotate(Math.toRadians(-57));
	    g2d.fillRect(12, 75, 117, 28);
	    
		Font font = new Font("Berlin Sans FB", Font.PLAIN, 40);
		g2d.getFontMetrics(font);
	    g2d.setFont(font);
		g2d.setColor(Color.WHITE);
		g2d.drawString("a",15,105);
		g2d.drawString("d",38,105);
		g2d.drawString("i",60,105);
		g2d.drawString("d",68,105);
		g2d.drawString("a",90,105);
		g2d.drawString("s",113,105);
	}
}
