package vorbKlausurProg2;


public class myVektor <T> implements SimpleCollection <T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		testClass c = new testClass();
		if(!c.test_construktor1())
			System.out.println("constr1");
		if(!c.test_construktor2())
			System.out.println("constr2");
		if(!c.test_construktor3())
			System.out.println("constr3");
		if(!c.test_pushBack())
			System.out.println("pushBack");
		if(!c.test_pushFront())
			System.out.println("pushFront");
		if(!c.test_delete())
			System.out.println("delete");
		if(!c.test_get())
			System.out.println("get");
		if(!c.test_set())
			System.out.println("set");
		System.out.println("Ende");
	}
	
	
	
//	public static myVektor myVector_merge(myVektor a, myVektor b){
//		
//		myVektor tmp = new myVektor();
//		int sizeA = a.size();
//		int sizeB = b.size();
//		
//		while(sizeA >= 0 && sizeB >=0)
//			tmp.push_back(a.get(sizeA))> b.get(sizeB)? a.get(sizeA--) : a.get(sizeB--));
//			
//		if(sizeA != 0)
//			while(sizeA != 0)
//				tmp.push_back(a.get(sizeA--));
//		else
//			while(sizeB != 0)
//				tmp.push_back(b.get(sizeB--));
//		
//		return tmp;
//	}
	
	int mInitCap;
	int mNextFree;
	int mFirstElem;
	int mIncValue;
	T[] mObjects;
	
	
	myVektor(int initialValue, int incrementValue)
	{
		mIncValue = incrementValue;
		mInitCap = initialValue;
		mObjects = (T[]) new Object[initialValue];
		mNextFree = 0;
		mFirstElem = 0;
	}
	
	myVektor(int initialValue){
		this(initialValue, 0); 
	}
	
	myVektor(){
		this(1,0);
	}
	

	private void rezise(){
		T[] tmp = mObjects;
		if(mIncValue == 0){
			mObjects = (T[]) new Object[tmp.length*2];
		}else{
			mObjects = (T[]) new Object[tmp.length+mIncValue];
		}
		
		for(int i = 0; i < tmp.length; ++i){
			mObjects[i] = tmp[i];
		}
		
	}
	
	public void Ausgabe(){
		for( int i = 0; i < mObjects.length; ++i){
			System.out.println(mObjects[i].toString());
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0; i < mNextFree; ++i){
			if(mObjects[i] != null){
				++count;
			}
		}
		return count;
	}

	@Override
	public void push_back(T arg) {
		// TODO Auto-generated method stub
		if( mNextFree < mObjects.length){
			mObjects[mNextFree++] = arg;
		}else{
			this.rezise();
			mObjects[mNextFree++] = arg;
		}
	}

	@Override
	public void push_front(T arg) {
		// TODO Auto-generated method stub
		if( mFirstElem == 0){
			if( mNextFree == 0){
				this.push_back(arg);
			}else{
				for(int i = mNextFree; i > 0; --i){
					mObjects[i] = mObjects[i-1];
				}
				mObjects[0] = arg;
			}
		}else{
			mObjects[--mFirstElem-1] = arg;
			
		}
	}

	@Override
	public T get(int i) throws outOfBoundsException{
		// TODO Auto-generated method stub
		if(i < mNextFree && i>= 0)
		{
			return mObjects[i];
		}else{
			throw new outOfBoundsException();
		}

	}

	@Override
	public void set(int i, T arg) throws outOfBoundsException{
		// TODO Auto-generated method stub
		if( i < size() && i>=0){
			mObjects[i] = arg;
		}else{
			throw new outOfBoundsException();
		}
	}

	@Override
	public void delete(int i) {
		// TODO Auto-generated method stub
		//pürfen ob Objekt im Rahmen des möglichen liegt
		if( i >= 0 && i < size()){
			mObjects[i] = null;
			// ist Element ersten Obj dann mFirstElem neu setzen
			if(i == mFirstElem){
				for(int j = i; j < size(); ++j){
					if(mObjects[j] != null){
						mFirstElem =j;
					}
				}
				// ist Element letztes Element mNextFree neu setzen
			}else if(i == mNextFree-1){
				--mNextFree;
				//ist es im Bereich, Element löschen, ELemente nach vorne schieben und mNextFree verändern
			}else{
				for(int k = i; k < size(); ++k){
					mObjects[k] = mObjects[k+1];
				}
				mObjects[--mNextFree] = null;
				
			}
		}
		
	}
}

class testClass{
	
	public boolean test_construktor1(){
		boolean state = true;
		try{
			myVektor v = new myVektor(5,1);
			if(v.mInitCap != 5)
				state = false;
			if(v.mIncValue != 1)
				state = false;
		}catch(Exception e){
			state = false;
		}
		
		return state;
	}
	
	public boolean test_construktor2(){
		boolean state = true;
		try{
			myVektor v = new myVektor(5);
			if(v.mInitCap != 5)
				state = false;
			if(v.mIncValue != 0)
				state = false;
		}catch(Exception e){
			state = false;
		}
		return state;
	}
	
	public boolean test_construktor3(){
		boolean state = true;
		try{
			myVektor v = new myVektor();
			if(v.mInitCap != 1)
				state = false;
			if(v.mIncValue != 0)
				state = false;
		}catch(Exception e){
			state = false;
		}
		return state;
	}
	
	public boolean test_pushBack(){
		boolean aState = true;
		try{
			myVektor v = new myVektor(5,0);
			v.push_back(5);
			v.push_back(3);
			v.push_back(4);
			v.push_back(2);
			v.push_back(1);
			if(v.size()!= 5)
				aState = false;
		}catch(Exception e){
			aState = false;
		}
		return aState;
	}
	
	public boolean test_get(){
		boolean aState = true;
		try{
			myVektor v = new myVektor(5,0);
			v.push_back(5);
			v.push_back(3);
			v.push_back(4);
			v.push_back(2);
			v.push_back(1);
			
			if((int)v.get(2) != 4)
				aState = false;
		
		}catch(Exception e){
			aState = false;
		}
		
		return aState;
	}
		
		
	public boolean test_pushFront(){
		boolean aState = true;
		try{
			myVektor v = new myVektor(5,0);
			v.push_back(5);
			v.push_back(3);
			v.push_back(4);
			v.push_front(17);
			if((int)v.get(0)!= 17)
				aState = false;
			v.push_front(18);
			if((int)v.get(0)!= 18)
				aState = false;
		
		}catch(Exception e){
			aState = false;
		}
		return aState;
	}
	
	public boolean test_delete(){
		boolean aState = true;
		
		try{
			myVektor v = new myVektor(5,0);
			v.push_back(5);
			v.push_back(3);
			v.push_back(4);
			v.push_back(17);
			v.push_back(18);

			v.delete(3);
			if((int)v.get(3)==17)
				aState = false;
			if(v.get(3) == null)
				System.out.println("function delete only set null");
		
		}catch(Exception e){
			System.out.println("exception delete");
			aState = false;
		}
		return aState;
	}
	

	
	public boolean test_set(){
		boolean aState = true;
		
		try{
			myVektor v = new myVektor(5,0);
			v.push_back(5);
			v.push_back(3);
			v.push_back(4);
			v.push_back(17);
			v.push_back(18);

			v.set(3, 23);
			
			if((int)v.get(3)!= 23)
				aState = false;
		
		}catch(Exception e){
			aState = false;
		}
		return aState;
	}
	
	public boolean test_resize(){
		boolean aState = false;
		
		try{
			myVektor v = new myVektor(3,0);
			v.push_back(3);
			v.push_back(2);
			v.push_back(1);
			v.push_back(5);
		}catch(Exception e){
			aState = false;
		}
		return false;
	}
	
	public boolean test_kombination(){
		return false;
	}
}


