package Uebung2;


public class MyVektorT<T> implements SimpleCollection<T>{

	private final int mIncValue;
	private int mNextValue;
	private int mPrevValue;
	private T[] mObjects;
	
	@SuppressWarnings("unchecked")
	public MyVektorT(int initialValue, int incrementValue){
		mIncValue = incrementValue;
		mNextValue = 0;
		mPrevValue = 0;
		mObjects =  (T[]) new Object[initialValue];
	}
	
	public MyVektorT(int intialValue) {
		this( intialValue, 0);
	}
	
	public MyVektorT() {
		this(1,0);
	}
	
	
	//liefert die Anzahl der Elemente zurück
	@Override
	public int size() {
		int size = 0;
		int tmp = 0;
		if( mPrevValue == 0){
			tmp = mPrevValue;
		}else{
			tmp = mPrevValue-1;
		}
		for(int i = tmp; i < mNextValue; i++ ){
			++size;
		}
		return size; 
	}

	public void push_back(T arg) { 
		if( mNextValue >= mObjects.length ) {
			resize();
		}
		mObjects[mNextValue] = arg;
		++mNextValue;
	}

	// fügt ein neues Element am Anfang ein
		public void push_front(T arg) {
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
	public T get(int i) {
		
		return mObjects[i];
	}

	//setzt das i-te Element auf arg
	public void set(int i, T arg) {
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

				
				@SuppressWarnings("unchecked")
				T[] newObjects = (T[]) new Object[newSize];
				for(int i = 0;i < mObjects.length;++i) {
				newObjects[i] = mObjects[i];
				}
				mObjects = newObjects;
	}	

}
