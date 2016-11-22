package Uebung6;

import java.awt.Color;

public class polygon_controller {
	private polygon_model m_Mod;
	private polygon_view m_View;
	int counter = 0;
	
	
	polygon_controller(Color background, Color polygon){

		m_Mod = new polygon_model(500,300);
		m_View = new polygon_view(m_Mod, background, polygon);
	}
	
	void simulate(){
		while(true){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
			m_Mod.addLine();
			m_View.repaint();
			
			if(counter == 10){
				m_View.printTestPage();
				counter++;
			}else{
				counter++;
			}
				
		}
	}
}
