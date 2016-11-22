package testproj;

public class controller {

	
	public static void main(String[] args){
		System.out.println("Start");
		controller ctrl = new controller();
		ctrl.start();
		
		//nur ein Testkommentar
		//noch ein Kommentar
	}
	
	void start(){
		createView();
	}
	
	void createView(){
		mainWindow view = new mainWindow("Scheiﬂe man ein Fenster");
		
	}
	
}
