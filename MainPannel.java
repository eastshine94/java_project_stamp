package Project;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.ArrayList;


public class MainPannel extends JFrame implements ActionListener {
	JPanel section, nav, nav1, nav2;
	Panel nP = new NikePanel();
	Panel aP = new AdidasPanel();
	JPanel colorP = new JPanel();
	Button nB = new Button("NIKE");
	Button aB = new Button("ADIDAS");
	Button colorButton = new Button("COLOR");
	Button deleteButton = new Button("DELETE");
	Button allDeleteButton = new Button("ALL DELETE");
	Button exitButton = new Button("EXIT");

	ArrayList<Panel> temp1 = new ArrayList<Panel>(); int n = 0;
	MouseHandler handler = new  MouseHandler();
	
	String figue = null;
	Color color = Color.BLACK;
	

	public MainPannel() {
		//Base Panel
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nike & Adidas Stamp Application");
		setSize(1300,800);
		setLayout(new BorderLayout(10,0));
		
		//Nav Panel
		nav = new JPanel();
		nav.setBorder(new EmptyBorder(10, 10, 5, 0));
		nav.setLayout(new GridLayout(2,1,0,10));
		
		nav1 = new JPanel();
		nav1.setLayout(new GridLayout(2,1,0,10));
		nB.setLayout(new GridBagLayout());    nB.setBackground(Color.WHITE);
		aB.setLayout(new GridBagLayout());	  aB.setBackground(Color.WHITE);
		nB.add(nP);    nav1.add(nB);
		aB.add(aP);	   nav1.add(aB);
		nB.addActionListener(this);    aB.addActionListener(this);
		nav.add(nav1);
		
		nav2 = new JPanel();
		nav2.setLayout(new GridLayout(5,1,0,10));
		colorP.setLayout(new GridBagLayout());		colorP.setBackground(color);      nav2.add(colorP);
		colorButton.addActionListener(this);        nav2.add(colorButton);        
		deleteButton.addActionListener(this);       nav2.add(deleteButton);
		allDeleteButton.addActionListener(this);    nav2.add(allDeleteButton);
		exitButton.addActionListener(this);         nav2.add(exitButton);
		nav.add(nav2);
		
		add(nav, BorderLayout.WEST);
		
		//Section Panel
		section = new JPanel();
		section.setLayout(null);
		section.setBackground(Color.WHITE);
		section.addMouseListener(handler);    section.addMouseMotionListener(handler);
		add(section, BorderLayout.CENTER);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			String actionCommand = e.getActionCommand();
			if (actionCommand.equals("NIKE")){ 
				figue="nike";
				aB.setBackground(Color.WHITE);
				nB.setBackground(Color.LIGHT_GRAY);
			}
			else if(actionCommand.equals("ADIDAS")){ 
				figue="adidas";
				nB.setBackground(Color.WHITE);
				aB.setBackground(Color.LIGHT_GRAY);
			}
			else if(actionCommand.equals("COLOR")){ 
				color = JColorChooser.showDialog(this, "Choose Color", color);
				colorP.setBackground(color); 	
			}
			else if(actionCommand.equals("DELETE")){ figue="delete"; }
			else if(actionCommand.equals("EXIT")){ dispose(); }
			else if(actionCommand.equals("ALL DELETE")) {
				section.removeAll();
				section.revalidate();
				section.repaint();
				temp1.clear();
				figue=null; n=0;
			} 
		} catch(Exception error){
			System.err.println("1");
		}
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				if(figue.equals("delete")){
					if(e.getComponent() instanceof NikePanel || e.getComponent() instanceof AdidasPanel) {
						if(inCycle(e)){
							section.remove(e.getComponent());
					        section.revalidate();
					        section.repaint();
					        temp1.remove(temp1.indexOf(e.getComponent()));
					        n--;
						}
					}
				} else {
					if(figue.equals("nike")){ temp1.add(new NikePanel()); }
					else if(figue.equals("adidas")){ temp1.add(new AdidasPanel()); }
					

					int sX = (int) section.getMousePosition().getX();
					int sY = (int) section.getMousePosition().getY();
					Panel panel = temp1.get(n);
					Dimension size = panel.getPreferredSize();
					
					section.add(panel);
					panel.addMouseListener(handler);
					panel.addMouseMotionListener(handler);
					panel.c = color;
					panel.setBounds(sX-70, sY-70, size.width, size.height);
					n++;
				}
			} catch(Exception error) {
				System.err.println("2");
			}
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			try {
				if(inCycle(e)){
					int sX = (int) section.getMousePosition().getX();
					int sY = (int) section.getMousePosition().getY();

					if(e.getComponent() instanceof NikePanel || e.getComponent() instanceof AdidasPanel) {
						e.getComponent().setLocation(sX-70, sY-70);
					}
				}
			} catch(Exception error){
				System.err.println("3");
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseMoved(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}

	}
	
	public boolean inCycle(MouseEvent e){
		
		double x = 70.0;
		double y = 70.0;
		double x1 = e.getX();
		double y1 = e.getY();

		if(Math.pow((x-x1),2) + Math.pow((y-y1),2) <= Math.pow(70,2)){ return true; }
		else { return false; }
	}
}
