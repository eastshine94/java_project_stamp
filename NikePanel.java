package Project;
import java.awt.*;

public class NikePanel extends Panel {
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
	    g2d.setColor(Color.WHITE);
	    g2d.translate(75, 60);
		g2d.rotate(Math.toRadians(-30));
	    g2d.translate(-70, -70);
		g2d.fillRoundRect(18,85,110,15, 50, 30);
		g2d.translate(70, 70);
		g2d.rotate(Math.toRadians(-40));
		g2d.translate(-70, -70);
		g2d.fillRoundRect(15,40,60,25, 50, 30);
		
		g2d.setColor(c);
		g2d.translate(70, 70);
		g2d.rotate(Math.toRadians(-10));
		g2d.translate(-70, -70);
		g2d.fillRoundRect(35,35,60,30, 50, 30);
		g2d.translate(70, 70);
		g2d.rotate(Math.toRadians(60));
		g2d.translate(-70, -70);
		g2d.fillRoundRect(30,73,102,20, 50, 30);


		Font font = new Font("impact", Font.ITALIC, 35);
		g2d.getFontMetrics(font);
	    g2d.setFont(font);
		g2d.setColor(Color.WHITE);
		g2d.translate(70, 70);
		g2d.rotate(Math.toRadians(20));
	    g2d.translate(-70, -70);
		g2d.drawString("N",40,83);
		g2d.drawString("I",59,83);
		g2d.drawString("K",69,83);
		g2d.drawString("E",89,83);

	}

}
