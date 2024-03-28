package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class acctionButton extends JButton{
	
	private boolean mousePress;
	
	public acctionButton() {
		setContentAreaFilled(false);
		setBorder(new EmptyBorder(2, 2, 2, 2));
		setFocusPainted(false);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				mousePress = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				mousePress = true;
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
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int heigth = getHeight();
		int size = Math.min(width, heigth);
		int x = (width - size) / 2 ;
		int y = (heigth - size) / 2 ;
		
		if(mousePress) {
			g2.setColor(new Color(158,158,158));
		} else {
			g2.setColor(new Color(199,199,199));
		}
		
		g2.fill(new Ellipse2D.Double(x,y,size,size));
		
		g2.dispose();
		super.paintComponent(g);
	}
}
