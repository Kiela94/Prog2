package Uebung5;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;


@SuppressWarnings("serial")
public class Life_View extends Frame{

	private Life_Programm p_model;
	final public Insets insets;
	final public Dimension dim;
	
	Life_View( Life_Programm model){
		super("Mein erstes Fenster");
		setSize(400,300);
		setVisible(true);
		insets = getInsets();
		dim = getSize();
		p_model = model;
	}
	
	
	
	public void paint(Graphics g){
		for( int i = 0; i < p_model.getNoOfColumn(); ++i){
			g.drawString(p_model.getString(i), 50,50+i*12);
		}
		
	}
	
	public void doNothing(){
		
	}
}
