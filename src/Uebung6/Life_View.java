package Uebung6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Window;



@SuppressWarnings("serial")
public class Life_View extends Frame{

	private Life_Programm p_model;
	final public Insets insets;
	final public Dimension dim;
	startWindow start;
	
	Life_View( Life_Programm model){
		super("Mein erstes Fenster");
		setSize(400,300);
		insets = getInsets();
		dim = getSize();
		p_model = model;
		
		Dimension dim2 = getToolkit().getScreenSize();
		
		start = new startWindow(this, "Dies ist der laufende Text");
		start.setSize(300,150);
		start.setLocation(dim2.width/2-start.getWidth()/2, dim2.height/2-start.getHeight()/2);
		start.setVisible(true);
		start.slideString();
		
		setVisible(true);
		
		
	}
	
	
	
	public void paint(Graphics g){
		
			for( int i = 0; i < p_model.getNoOfColumn(); ++i){
				g.drawString(p_model.getString(i), 50,50+i*12);
			
			}
			
			
	
	}
	
	public void doNothing(){
		
	}
}

@SuppressWarnings("serial")
class startWindow extends Window{
	String m_text;
	int pos_x;
	int pos_y;
	boolean text_direction_left = false;
	boolean workDone = false;
	Dimension dim;

	
	
	startWindow(Frame parent, String text) throws HeadlessException {
		super(parent);
		// TODO Auto-generated constructor stub
		m_text = text;
		this.setBackground(Color.WHITE);
		dim = this.getSize();
		
		
		
	}
	
	public void slideString(){
		pos_x = 0;
		pos_y = this.getHeight()/2;
		int stringlength = this.getGraphics().getFontMetrics().stringWidth(m_text);
		
		
		while(!workDone){
			
			if(text_direction_left == false){
				 
				pos_x +=1;
				if(pos_x >= this.getWidth()- stringlength){
					text_direction_left = true;
				}
				
			}else{
				pos_x -=1;
				if(pos_x <= 0){
					workDone = true;
					dispose();
				}
			}
			repaint(); 
			try{
				Thread.sleep(10);
			}catch(Exception e){
				System.out.println("d");
			}
		
		}
	}
	
	

	public void paint(Graphics g){
		g.drawString(m_text, pos_x, pos_y);
	}
	
}
