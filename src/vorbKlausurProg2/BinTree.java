package vorbKlausurProg2;

public class BinTree <K extends Comparable<K>, D>{
	
	Node mRoot;
	
	class Node{
		K mKey;
		D mData;
		Node mLeft;
		Node mRight;
		
		Node(K key, D data){
			mKey = key;
			mData = data;
			mLeft = null;
			mRight = null;
		}
		
	}
	
	BinTree(){
		mRoot = null;
	}
	
	void insert(K key, D data){
		Node tmp = mRoot;
		Node father = null;
		
		while(tmp != null){
			father = tmp;
			tmp = tmp.mKey.compareTo(key)<0 ? tmp.mRight: tmp.mLeft;
		}
		
		tmp = new Node( key, data);
		
		if( father == null){
			mRoot = tmp;
		}else if(father.mKey.compareTo(tmp.mKey)>0){
			father.mLeft = tmp;
		}else{
			father.mRight = tmp;
		}
		
	}
	
	Node search( K key){
		Node tmp = mRoot;
		
		while(tmp != null){
			
			int result = tmp.mKey.compareTo(key);
			if( result == 0)
				return tmp;
			else if(result >0){
				tmp = tmp.mLeft;
			}else{
				tmp = tmp.mRight;
			}
		}
		
		return null;
	}
	
	
}







