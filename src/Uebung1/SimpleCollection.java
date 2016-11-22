package Uebung1;

@SuppressWarnings("hiding")
public interface SimpleCollection<Object>{

	/**
	 * Liefert die Anzahl der gespeicherten Elemente.
	 * @return
	 */
	int size(); 
	
	/**
	 * F�gt das �bergebene Objekt am Ende ein.
	 * @param arg
	 */
	void push_back(Object arg);
	
	/**
	 * F�gt das �bergebene Objekt am Anfang ein.
	 * @param arg
	 */
	void push_front(Object arg);
	
	/**
	 * Gibt das Element an der i-ten Stelle zur�ck.
	 * @param i
	 * @return
	 */
	Object get( int i );
	
	/**
	 * Setzt das �bergebene Objekt an der i-ten Stelle.
	 * @param i
	 * @param arg
	 */
	void set(int i, Object arg); 
	
	/**
	 * L�scht das Element an der i-ten Stelle.
	 * @param i
	 */
	void delete(int i); //l�scht das i-te Element
	
	
}
