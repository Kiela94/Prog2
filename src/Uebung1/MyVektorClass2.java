package Uebung1;

public class MyVektorClass2 implements SimpleCollection<Object>{

	public static void main(String[] args) {
		MyVektorClass2 blubb = new MyVektorClass2( 5, 5);
		blubb.push_front(2);
		blubb.push_front(7);
		blubb.push_front(25);
		blubb.push_front(4);
		blubb.push_front(17);

		blubb.sort();
		
		blubb.print();

	}
	
	private final int mIncValue;
	private int mNextValue;
	private int mPrevValue;
	private Object[] mObjects;
	
	
	
	public MyVektorClass2(int initialValue, int incrementValue) {
		mIncValue = incrementValue;
		mNextValue = 0;
		mPrevValue = 0;
		mObjects = new Object[initialValue];		
	}
	
	public MyVektorClass2(int intialValue) {
		this( intialValue, 0);
	}
	
	public MyVektorClass2() {
		this(1,0);
	}
	
	//liefert die Anzahl der Elemente zurück
	public int size() {
		
		int size = 0;
		for(int i = mPrevValue-1; i < mNextValue; i++ ){
			++size;
		}
		
		return size; 
	}

	// fügt ein neues Element am Ende ein
	//###########################################################################
	//Mehtode könnte erweitert werden. Wenn mPrevNext ungleich 0, dann 
	//alle Elemente ein weiter nach vorn schieben und das letzte Element einfügen
	//###########################################################################
	public void push_back(Object arg) { 
		if( mNextValue >= mObjects.length ) {
			resize();
		}
		mObjects[mNextValue++] = arg;
	}

	// fügt ein neues Element am Anfang ein
	public void push_front(Object arg) {
		// Zeiger ist 0 und alle Elemente werden um eine Stelle nach hinten geschoben. An 0-ter Stelle wird ein Element eingefügt. mNext wird erhöht
		if( mNextValue >= mObjects.length && mPrevValue == 0 ) {
			resize();
			for( int i = mNextValue; i > 0; i-- ) {
				mObjects[i] = mObjects[i-1];
			} 
			mObjects[mPrevValue] = arg;
			mNextValue++;
		}
		// an 0-ter Stelle ein Element setzten und den Zeiger nicht veringern.
		else if ( mNextValue < mObjects.length && mPrevValue == 0 ) {
			// ist mNext == 0 ist der "Vektor" Leer nur der Zeiger wird erhöht, da ein Element eingefügt wird.
			if( mNextValue == 0 ) {
				mNextValue++;
			}
			//ist mNext > 0 ist der "Vektor" nciht leer aber der Zeiger ist auf 0. Alle Elemente werden einen weiter geschoben.
			else if ( mNextValue > 0) {
				for( int i = mNextValue; i > 0; i-- ) {
					mObjects[i] = mObjects[i-1];
				} 
				mNextValue++;
			}
			mObjects[mPrevValue] = arg;
		}
		// Einfügen eines Elementes an erster Stelle mit veringern des Zeigers.
		else 
		{
			mObjects[mPrevValue--] = arg;
		}

	}

	// liefert das i-te element
	public Object get(int i) {
		
		return mObjects[i];
	}

	//setzt das i-te Element auf arg
	public void set(int i, Object arg) {
		mObjects[i] = arg;
	}
	
	//löscht das i-te Element
	public void delete(int i) {
		// prüfen wo weniger Verschiebungen nötig sind. Verschiebung durchführen
		if( i - mPrevValue < mNextValue - i){
			for( int counter = i; i > mPrevValue; i--) {
				mObjects[counter] = mObjects[counter-1];
			}
			mPrevValue++;
		}
		else {
			for( int counter = i; i < mNextValue; i++) {
				mObjects[counter] = mObjects[counter+1];
			}
			// Element vom aktuellen Zeiger auf 0 setzten und Zeiger veringern
			mObjects[mNextValue--] = null;

		}
	}
	
	public void resize(){
		final int newSize; 
				if( mIncValue == 0 ){
					newSize = mObjects.length * 2;
				}
				else{
					newSize = mObjects.length + mIncValue;
				}

				Object[] newObjects = new Object[newSize];
				for(int i = 0;i < mObjects.length;++i) {
				newObjects[i] = mObjects[i];
				}
				mObjects = newObjects;
	}	
	
	public void print(){
		for(int i = 0; i < this.mObjects.length; i++){
			System.out.print(mObjects[i] + " ");
		}
	}
	
	public void sort(){
		distributionCounting(this.mObjects);
	}
	
	private void distributionCounting(Object[] array) {	
		int tmp_low = (int)array[0];
		int tmp_high = (int)array[0];
		
		//Wertebereich finden (kleinstes und größtes Element
		for( int counter = 0; counter < array.length; counter++){
			if(tmp_low > (int)array[counter]){
				tmp_low = (int)array[counter];
			}else if( tmp_high < (int)array[counter]){
				tmp_high = (int)array[counter];
			}
		}
		
		int m;
		if( tmp_low < 0) 
			m = tmp_high - tmp_low +1; 
		else 
			m = tmp_high+1; // gesamte größe +1, da das 0-te Elemente nicht dargestellt wird
		
		int[] count = new int[m];

		for(int i = 0; i < array.length; ++i) {
			
			//ist tmp_low -5 muss i um 5 erhöht werden, damit es an 0.Stelle im array steht
			if( tmp_low < 0 ){
				++count[(int)array[i] - tmp_low];
			}
				
			else
				++count[(int)array[i]];
		}
		for(int i1 = 0, i2 = 0; i1 < count.length; ++i1) {
			for(int i3 = 0; i3 < count[i1]; ++i3) {
				if(tmp_low < 0)
					array[i2++] = i1+tmp_low;
				else
					array[i2++] = i1;
			}
		}
	}
}
