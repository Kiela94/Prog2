package Uebung5;

public class Funktion_Berechnung implements Funktion_IFunktionen{

	private float g_d_B = 0.01F; // Genauigkeit der Berechung
	
	
	@Override
	public float[][] x_hochZwei(float x_min, float x_max) {
		
		int tmp = numberOfCalculations(x_min, x_max);
		float[][] calculations = new float[tmp][2];
		
		for( int i = 0; i < tmp; ++i){
			calculations[i][0] = x_min;
			calculations[i][1] = x_min*x_min;
			x_min = x_min + g_d_B;
			if(x_min >= x_max)
				break;
		}
		
		return calculations;
	}

	@Override
	public float[][] x_hochDrei(float x_min, float x_max) {
		int tmp = numberOfCalculations(x_min, x_max);
		float[][] calculations = new float[tmp][2];
		
		for( int i = 0; i < tmp; ++i){
			calculations[i][0] = x_min;
			calculations[i][1] = x_min*x_min*x_min;
			x_min = x_min + g_d_B;
			if(x_min >= x_max)
				break;
		}
		
		return calculations;
	}
	
	public int numberOfCalculations(float x_min, float x_max){
		
//		float a =  0.1F;
//		float b = -0.1F;
		int anz = 0;
		
		for(float i = x_min; i <= x_max; i = i +g_d_B){
			++anz;
		}
		System.out.println(anz);
		
		return anz;
	}


}
