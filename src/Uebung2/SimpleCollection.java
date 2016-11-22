package Uebung2;

public interface SimpleCollection<T> {

	/**
	 * Liefert die Anzahl der gespeicherten Elemente.
	 * @return
	 */
	int size(); 
	
	/**
	 * Fügt das übergebene Objekt am Ende ein.
	 * @param arg
	 */
	void push_back(T arg);
	
	/**
	 * Fügt das übergebene Objekt am Anfang ein.
	 * @param arg
	 */
	void push_front(T arg);
	
	/**
	 * Gibt das Element an der i-ten Stelle zurück.
	 * @param i
	 * @return
	 */
	T get(int i);
	
	/**
	 * Setzt das übergebene Objekt an der i-ten Stelle.
	 * @param i
	 * @param arg
	 */
	void set(int i, T arg); 
	
	/**
	 * Löscht das Element an der i-ten Stelle.
	 * @param i
	 */
	void delete(int i); //löscht das i-te Element
	
	
}
