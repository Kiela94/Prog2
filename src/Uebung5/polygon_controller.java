package Uebung5;

public class polygon_controller {
	private polygon_model m_Mod;
	private polygon_view m_View;
	int counter = 0;
	
	
	polygon_controller(){

		m_Mod = new polygon_model(500,300);
		m_View = new polygon_view(m_Mod);
	}
	
	void simulate(){
		while(true){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
			m_Mod.addLine();
			m_View.repaint();
				
		}
	}
}
