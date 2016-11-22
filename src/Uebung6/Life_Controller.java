package Uebung6;

public class Life_Controller {

	public static void main(String[] args)
	{
		

		Life_Programm model = new Life_Programm();

		model.initialisierung( 16, 6);
		model.ausgabe( );
		
		

		int maleNeuBerechnen = 8;
		model.array2 = model.array;
		for(int y = 1; y< maleNeuBerechnen; y++)
		{
			model.berechneNeuesArray( );
		}
		model.ausgabe();
		
		
		Life_View myView = new Life_View( model );
		
		
		
		while(true){
			model.berechneNeuesArray();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			myView.repaint();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
