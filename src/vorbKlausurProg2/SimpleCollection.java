package vorbKlausurProg2;

@SuppressWarnings("hiding")
public interface SimpleCollection <T>{

	int size();
	void push_back(T arg);
	void push_front(T arg);
	T get(int i) throws outOfBoundsException;
	void set(int i, T arg) throws outOfBoundsException;
	void delete(int i);
}

@SuppressWarnings("serial")
class outOfBoundsException extends Exception{
	outOfBoundsException(){
		myException();
	}
	
	void myException(){
		System.out.println("junge du bist zu weit gegangen");
	}
}