package Uebung3;

public class Heap<K extends Comparable<K>> {

	private int m_iNext;
	private K[] m_Keys;
	
	@SuppressWarnings("unchecked")
	public Heap( int size){
		m_iNext = 0;
		m_Keys = (K[])new Comparable[size];
	}
	
	/**
	 * Bringt das Element an Stelle Index nach oben vom Baum, sofern es größer ist.
	 * @param iIndex
	 */
	private void upheap(int iIndex) {
		K k = m_Keys[iIndex];
		while (iIndex != 0 && m_Keys[(iIndex-1) / 2].compareTo(k) < 0) {
			m_Keys[iIndex] = m_Keys[(iIndex-1) / 2];
		iIndex = (iIndex - 1) / 2;
		}
		m_Keys[iIndex] = k;
	}
	
	public void insert(K key) {
		m_Keys[m_iNext] = key;
		upheap(m_iNext);
		++m_iNext;
		}
	
	private void downheap(int iIndex) {
		K k = m_Keys[iIndex];
		while (iIndex < m_iNext / 2) {
			int iSon = 2 * iIndex + 1;
			if (iSon < m_iNext-1 && m_Keys[iSon].compareTo(m_Keys[iSon + 1]) < 0)
				++iSon;
			if (k.compareTo(m_Keys[iSon]) >= 0) break;
				m_Keys[iIndex] = m_Keys[iSon];
			iIndex = iSon;
		}
		m_Keys[iIndex] = k;
		}
	
	public K remove() {
		K res = m_Keys[0];
		m_Keys[0] = m_Keys[--m_iNext];
		downheap(0);
		return res;
		}
	
	
	public int search( K element){
		return search_help( element, 0);	
	}
	
	private int search_help(K element, int currentIndex){
		if(currentIndex < m_Keys.length){
			
			int links = -1;
			int rechts = -1;
			
			if(m_Keys[currentIndex].compareTo(element) == 0){
				return currentIndex;
			}
			
			if( m_Keys.length > currentIndex*2+1){
				links = search_help(element, currentIndex*2+1);
			}
			
			if( m_Keys.length > currentIndex*2+2){
				rechts = search_help(element, currentIndex*2+2);
			}
			
			if( links > rechts){
				return links;
			}else{
				return rechts;
			}
		}else{
			return -1;
		}
	}

	public int count_nodes(){
		return count_nodes_help(0);
	}
	
	private int count_nodes_help(int index){
		
		if( m_Keys.length != 0 ){
			int links = 0;
			int rechts = 0;
			
			if( m_Keys.length > index*2+1){
				links = count_nodes_help(index*2+1);
			}
			
			if( m_Keys.length > index*2+2){
				rechts = count_nodes_help(index*2+2);
			}
			
			return 1 + links + rechts;
		}
		else{
			return 0;
		}
		
	}
	
}
