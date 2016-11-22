package Uebung2;

public class List<T> implements SimpleCollection<T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fülle Liste");
		List<Integer> myList = new List<Integer>();
		myList.push_back(new Integer(5));
		myList.push_back(new Integer(8));
		myList.push_back(new Integer(13));
		myList.push_back(new Integer(1));
		myList.push_back(new Integer(3));
		System.out.println("Fertig -- Ausgabe");
		System.out.println( "Size:" + myList.size() );
		for(int i = 0; i < myList.size(); i++)
		{
			System.out.println(myList.get(i));
		}
		
	}
	
	class ListElem{
		
		private ListElem m_Next;
		private ListElem m_Prev;
		private T m_Obj;
		

		ListElem(T obj, ListElem prev, ListElem next){
			m_Next = next;
			m_Prev = prev;
			m_Obj = obj;
			
			if(m_Next != null){
				m_Next.setPrev(this);
			}
			
			if(m_Prev != null){
				m_Prev.setNext(this); 
			}
			
		}
		
		T getElement(){
			return m_Obj;
		}
		
		ListElem getNext(){
			return m_Next;
		}
		
		ListElem getPrev(){
			return m_Prev;
		}
		
		void setNext(ListElem next){
			m_Next = next;
		}
		
		void setPrev(ListElem prev){
			m_Prev = prev;
		}
	}

	//Diese Elemente waren laut Vorlesung Private
	private ListElem m_Head;
	private ListElem m_Foot;
	
	public List(){
		m_Head = null;
		m_Foot = null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		
		if(m_Head == null && m_Foot == null){
			return size;
		}	
		else{
			ListElem count= m_Head;
			
			while(count != m_Foot){
				count = count.getPrev();
				size++;
			}
			return ++size;
		}
		
		
	}

	@Override
	public void push_back(T arg) {
		// TODO Auto-generated method stub
		m_Head = new ListElem(arg, m_Head, null);
		if(m_Foot == null){
			m_Foot = m_Head;
		}
	}

	@Override
	public void push_front(T arg) {
		// TODO Auto-generated method stub
		m_Foot = new ListElem(arg, null, m_Foot);
		if(m_Head == null){
			m_Head = m_Foot;
		}
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		ListElem obj = m_Head;
		int count = 0;
		while(count != i){
			obj = obj.getPrev();
			++count;
		}
		return obj.getElement();
	}

	@Override
	public void set(int i, T arg) {
		// TODO Auto-generated method stub
		if(i >= size()) return;
		ListElem obj = m_Head;
		int count = 0;
		while(count != i){
			obj = obj.getPrev();
			count++;
		}
		
		obj.m_Obj = (T) arg;
//		new ListElem(arg, obj.getPrev(), obj.getNext());
//		obj = null;
	
	}

	@Override
	public void delete(int i) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ListElem obj = m_Head;
		int count = 0;
		while(count != i){
			obj = obj.getNext();
			i++;
		}
		
		obj.getNext().setPrev(obj.getPrev());
		obj.getPrev().setNext(obj.getNext());
		obj = null;	
	}	
}
