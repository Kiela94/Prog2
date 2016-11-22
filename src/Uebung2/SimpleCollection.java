package Uebung2;

public interface SimpleCollection<T> {

	/**
	 * Liefert die Anzahl der gespeicherten Elemente.
	 * @return
	 */
	int size(); 
	
	/**
	 * F�gt das �bergebene Objekt am Ende ein.
	 * @param arg
	 */
	void push_back(T arg);
	
	/**
	 * F�gt das �bergebene Objekt am Anfang ein.
	 * @param arg
	 */
	void push_front(T arg);
	
	/**
	 * Gibt das Element an der i-ten Stelle zur�ck.
	 * @param i
	 * @return
	 */
	T get(int i);
	
	/**
	 * Setzt das �bergebene Objekt an der i-ten Stelle.
	 * @param i
	 * @param arg
	 */
	void set(int i, T arg); 
	
	/**
	 * L�scht das Element an der i-ten Stelle.
	 * @param i
	 */
	void delete(int i); //l�scht das i-te Element
	
	
}
