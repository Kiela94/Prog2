package Uebung1;

public class MyVektorClass implements SimpleCollection<Object>{

	private final int mIncValue;
	private int mNextValue;
	private Object[] mObjects;
	
	
	MyVektorClass(int initialValue, int incrementValue)
	{
		mIncValue = incrementValue;
		mNextValue = 0;
		mObjects = new Object[initialValue];		
	}
	
	MyVektorClass(int intialValue)
	{
		this( intialValue, 0);
	}
	
	MyVektorClass()
	{
		this(1,0);
	}
	
	//liefert die Anzahl der Elemente zurück
	public int size() {
		
		return this.mObjects.length; //???????????????????????????????????
	}

	// fügt ein neues Element am Ende ein
	public void push_back(Object arg) {
		if( mNextValue < size() )
		{
			mObjects[mNextValue++] = arg;
		}
		else 
		{
			resize();
			mObjects[mNextValue++] = arg;
		}
	}

	// fügt ein neues Element am Anfang ein
	public void push_front(Object arg) {
		if( mNextValue < size() )
		{
			for( int i = mNextValue; i > 0; i-- )
			{
				mObjects[i] = mObjects[i-1];
			} 
			mObjects[0] = arg;
			mNextValue++;
		}
		else 
		{
			resize();
			for( int i = mNextValue; i > 0; i-- )
			{
				mObjects[i] = mObjects[i-1];
			} 
			mObjects[0] = arg;
			mNextValue++;
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
		mObjects[i] = 0;
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
	

}
