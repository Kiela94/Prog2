package Uebung1;

@SuppressWarnings("hiding")
public interface SimpleCollection<Object>{

	/**
	 * Liefert die Anzahl der gespeicherten Elemente.
	 * @return
	 */
	int size(); 
	
	/**
	 * Fügt das übergebene Objekt am Ende ein.
	 * @param arg
	 */
	void push_back(Object arg);
	
	/**
	 * Fügt das übergebene Objekt am Anfang ein.
	 * @param arg
	 */
	void push_front(Object arg);
	
	/**
	 * Gibt das Element an der i-ten Stelle zurück.
	 * @param i
	 * @return
	 */
	Object get( int i );
	
	/**
	 * Setzt das übergebene Objekt an der i-ten Stelle.
	 * @param i
	 * @param arg
	 */
	void set(int i, Object arg); 
	
	/**
	 * Löscht das Element an der i-ten Stelle.
	 * @param i
	 */
	void delete(int i); //löscht das i-te Element
	
	
}
