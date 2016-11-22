package Uebung5;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Funktion_View extends Frame {

	float x1_Bereich;
	float x2_Bereich;
	Funktion_IFunktionen m_obj;
	Insets ins;
	float skale =5F;
	
	Funktion_View(Funktion_IFunktionen obj, float bereich_beginn, float bereich_ende ){
		
		x1_Bereich = bereich_beginn;
		x2_Bereich = bereich_ende;
		m_obj = obj;
		setSize(1000,600);
		setVisible(true);
		ins = getInsets();
		
	}
	
	public void zeichneFunktion(Graphics g, int width, int height){
		
		g.drawString("Skale: " + skale, ins.right+5, ins.top+15);
		
		int anzahl_werte = m_obj.numberOfCalculations(x1_Bereich, x2_Bereich);
		int point_range = anzahl_werte/width;
//		if(point_range == 0)
//			point_range = 1;
		
		paintCoordSystem(g);
		
		float[][] data = m_obj.x_hochDrei(x1_Bereich, x2_Bereich);
		
		for( int i = 0; i < width; ++i){
		
			
			if(i != 0){
				g.drawLine(i-1, height/2-(int)(data[(i-1)*point_range][1]*skale), i, height/2-(int)(data[i*point_range][1]*skale));
			}else{
				g.drawLine(0, height/2-(int)(data[i][1]*skale) ,0, height/2-(int)(data[i][1]*skale));
			
			}
				
		}
	}
	
	
	public void paintCoordSystem(Graphics g){
		g.drawLine(getSize().width/2, 0, getSize().width/2, getSize().height);
		g.drawLine(0, getSize().height/2, getSize().width, getSize().height/2);
//		g.drawString("-10", getSize().width/2+5, (int) (getSize().height/2 - 10*skale));
//		g.drawString("-20", getSize().width/2+5, (int) (getSize().height/2 - 20*skale));
//		g.drawString("-30", getSize().width/2+5, (int) (getSize().height/2 - 30*skale));
//		g.drawString("-40", getSize().width/2+5, (int) (getSize().height/2 - 40*skale));
//		g.drawString("-50", getSize().width/2+5, (int) (getSize().height/2 - 50*skale));
//		
//		
//		g.drawString("-10", getSize().width/2+5, (int) (getSize().height/2 + 10*skale));
//		g.drawString("-20", getSize().width/2+5, (int) (getSize().height/2 + 20*skale));
//		g.drawString("-30", getSize().width/2+5, (int) (getSize().height/2 + 30*skale));
//		g.drawString("-40", getSize().width/2+5, (int) (getSize().height/2 + 40*skale));
//		g.drawString("-50", getSize().width/2+5, (int) (getSize().height/2 + 50*skale));
		
		
//		int wertebereichsZahl_min = (int) (getSize().width/2 - getSize().width/4/skale);
//		int wertebereichsZahl_max = (int) (getSize().width/2 + getSize().width/4/skale);
//		
//		g.drawLine(wertebereichsZahl_min, getSize().height/2, wertebereichsZahl_min, getSize().height/2+3);
//		g.drawString(String.valueOf(x1_Bereich/2), wertebereichsZahl_min-8, getSize().height/2 + 15 );
//
//		g.drawLine(wertebereichsZahl_max, getSize().height/2, wertebereichsZahl_max, getSize().height/2+3);
//		g.drawString(String.valueOf(x2_Bereich/2), wertebereichsZahl_max-8, getSize().height/2 + 15 );

	}
	
	public void paint(Graphics g){
		
		zeichneFunktion(g, getSize().width, getSize().height);
	}
	
}
