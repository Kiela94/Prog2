package vorbKlausurProg2;

public class list<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	listElem m_Head;
	listElem m_Tail;
	boolean m_isStack;
	
	public list(boolean is_stack){
		m_Head = null;
		m_Tail = null;
		m_isStack = is_stack;
	}
	
	public void add(T obj){
		if(m_Head == null && m_Tail == null){
			m_Head = new listElem(obj, null, null);
			m_Tail = m_Head;
		}else{
			m_Tail = new listElem(obj, null, m_Tail);
			
		}
	}
	
	public void delte(T obj){
		if( obj != null){
			if(m_Head.getElem() == obj){
				m_Head = m_Head.getNext();
				m_Head.setPrev(null);
			}else{
				for(listElem  tmp = m_Head; tmp != null; tmp = tmp.getNext()){
					if(tmp.getElem() == obj){
						tmp.getNext().setPrev(tmp.getPrev());
						tmp.getPrev().setNext(tmp.getNext());
						return;
					}
				}
			}
		}
		
	}
	
	
	class listElem{
		
		private T m_Elem;
		private listElem m_next;
		private listElem m_prev;
		
		
		public listElem(T obj, listElem next, listElem prev){
				m_next = next;
				if(m_next != null)
					m_next.setPrev(this);
				m_prev = prev;
				if(m_prev != null)
					m_prev.setNext(this);
		}
		
		public T getElem(){
			return m_Elem;
		}
		
		public listElem getNext(){
			return m_next;
		}
		
		public listElem getPrev(){
			return m_prev;
		}
		
		public void setNext(listElem obj){
			m_next = obj;
		}
		
		public void setPrev(listElem obj){
			m_prev = obj;
		}
		
		
		
		
	}// Ende Klasse ListElem
}
