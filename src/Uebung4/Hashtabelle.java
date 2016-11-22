package Uebung4;

public class Hashtabelle<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//hashtabelle wird mit 20 elemenenten initialisiert
		// 40% = 8 Elemente
		// 50% = 10 Elemente
		// 60% = 12 Elemente
		// 70% = 14 Elemente
		Hashfunktionen hashF = new Hashfunktionen();

		Hashtabelle<Integer> myTable = new Hashtabelle(hashF);
		myTable.insert("Hallo", 5);
		myTable.insert("Halli", 17);
		myTable.insert("Hallöle", 724);
		myTable.insert("Moin", 456);
		myTable.insert("Tach", 51);
		myTable.insert("Was geht", 251);
		myTable.insert("Grüß Gott", 452);
		myTable.insert("Haudi", 4);
		myTable.insert("Hi", 45);
		myTable.insert("Tschüss", 9);
		myTable.insert("auf wiedersehen", 3);
		myTable.insert("Guten Tag", 8);	
		myTable.insert("Bye", 12);
		myTable.insert("Adijö", 25);
		
		System.out.println("Alle Suchen: ");
		System.out.println(myTable.search("Hallo"));
		System.out.println(myTable.search("Halli"));
		System.out.println(myTable.search("Hallöle"));
		System.out.println(myTable.search("Moin"));
		System.out.println(myTable.search("Tach"));
		System.out.println(myTable.search("Was geht"));
		System.out.println(myTable.search("Grüß Gott"));
		System.out.println(myTable.search("Haudi"));
		System.out.println(myTable.search("Hi"));
		System.out.println(myTable.search("Tschüss"));
		System.out.println(myTable.search("auf wiedersehen"));
		System.out.println(myTable.search("Guten Tag"));
		System.out.println(myTable.search("Bye"));
		System.out.println(myTable.search("Adijö"));
		
//		myTable.remove("Tach");
//		
//		System.out.println("");
//		System.out.println("Eins gelöscht und alle suchen");
//		
//		System.out.println(myTable.search("Hallo"));
//		System.out.println(myTable.search("Halli"));
//		System.out.println(myTable.search("Hallöle"));
//		System.out.println(myTable.search("Moin"));
//		System.out.println(myTable.search("Tach"));
//		System.out.println(myTable.search("Was geht"));
//		System.out.println(myTable.search("Grüß Gott"));
//		System.out.println(myTable.search("Haudi"));
//		System.out.println(myTable.search("Hi"));
//		System.out.println(myTable.search("Tschüss"));
//		System.out.println(myTable.search("Guten Tag"));
//		System.out.println(myTable.search("auf wiedersehen"));
//		System.out.println(myTable.search("Bye"));
//		System.out.println(myTable.search("Adijö"));
		
		myTable.printKollision();
		//40% = 2
		//50% = 6
		//60% = 8
		//70% = 16
	}
	
	
	@SuppressWarnings("hiding")
	class Node<T>{
		
		private Object m_Key;
		private T m_Data;
		private boolean m_deleted;
		
		public Node(Object key, T data){
			m_Key = key;
			m_Data = data;
			m_deleted = false;
		}
		
	}
	
	private Node<T>[] m_Entries;
	private int m_iNrOfEntries;
	private int m_Kollision;
	private Hashfunktionen p_hashF;
	
	@SuppressWarnings("unchecked")
	public Hashtabelle( Hashfunktionen hashF ){
		p_hashF = hashF;
		m_Entries = new Node[20];//1023
		m_iNrOfEntries = 0;
		m_Kollision = 0;
	}
	
	// Suche das Element. Ist es nicht an der Indexstelle, dann wird es mittels der Sequenziellen suche ermittelt
	public T search(Object key) {
		int iIndex = p_hashF.hashing(key, m_Entries.length);
		
		for(int i = 0; m_Entries[iIndex] != null && i < m_Entries.length; ++i) {
				if (m_Entries[iIndex].m_Key==key && m_Entries[iIndex].m_deleted == false){
					return m_Entries[iIndex].m_Data;
				}
				iIndex = (iIndex + 1) % m_Entries.length;
		}
		return null;
	}
	
	public void insert(Object key, T data) {
		int iIndex = p_hashF.hashing(key, m_Entries.length);
		for(int i = 0; i < m_Entries.length; ++i) {
			if (m_Entries[iIndex] == null) {
				m_Entries[iIndex] = new Node<T>(key,data);
				++m_iNrOfEntries;
				if (m_iNrOfEntries > m_Entries.length *8/10)
					resize();
				return;
			}
			iIndex = (iIndex + 1) % m_Entries.length;
			++m_Kollision;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		final int OLDCAPACITY = m_Entries.length;
		Node<T>[] oldEntries = m_Entries;
		final int iNewCap = (m_Entries.length + 1) * 2 - 1;
		m_Entries = new Node[iNewCap];
		m_iNrOfEntries = 0;
		m_Kollision = 0;
		
		for(int i = 0;i < OLDCAPACITY;++i) {
			if (oldEntries[i] != null) {
				if(oldEntries[i].m_deleted == false){
					insert(oldEntries[i].m_Key, oldEntries[i].m_Data);
				}
			}
		}
	}
	

	
	
	public void remove( Object key ){
		int iIndex = p_hashF.hashing(key, m_Entries.length);
		
		for(int i = 0; m_Entries[iIndex] != null && i < m_Entries.length; ++i) {
				if (m_Entries[iIndex].m_Key==key){
					m_Entries[iIndex].m_deleted = true;
				}
				iIndex = (iIndex + 1) % m_Entries.length;
		}
		
	}
	
	
//	unsigned hashKey(unsigned ui , unsigned uiLength) {
//		return ui % uiLength;
//	}
//	
//	unsigned hashKey(int i , unsigned uiLength) {
//		return (unsigned)i % uiLength;
//	}
	
	public void printKollision(){
		System.out.println("Anzahl Kollisionen: " + m_Kollision);
	}
	
}
