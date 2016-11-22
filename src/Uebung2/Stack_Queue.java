package Uebung2;

public class Stack_Queue<T> extends List<T>{

	boolean m_isStack;
	
	
	/**
	 * @param aState : Gibt an, ob diese Klasse (Liste) wie eine Queue oder ein Stack behandelt wird. true = Stack, false = Queue
	 */
	Stack_Queue(boolean aState){
		m_isStack = aState;
	}
	
//	??
//	@Override
//	private void push_front(T arg){
//		
//	}
	
	public T getElem(){
		
		if(m_isStack == false){
			return this.get(0);
		}
		else{
			return this.get(this.size());
		}
	}
	
	public void push_front(T arg) {
		
	}
	
	
	//1 2 3 4
}
