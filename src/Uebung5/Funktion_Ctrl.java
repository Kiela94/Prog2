package Uebung5;

public class Funktion_Ctrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Funktion_Berechnung a = new Funktion_Berechnung();
		Funktion_View view = new Funktion_View(a, -10.0F, 10.0F);
		view.repaint();
	}
	
	 

}
