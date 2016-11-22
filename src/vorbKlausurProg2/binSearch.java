package vorbKlausurProg2;

public class binSearch <K extends Comparable<K>,D>{
	
	Node mRoot;
	
	class Node{
		K mKey;
		D mData;
		Node left;
		Node right;
		
		Node(K key, D data){
			mKey = key;
			mData = data;
			Node left = null;
			Node right = null;
		}
	}
	
	
	void insert(K key, D data){
		Node tmp = mRoot;
		Node father = null;
		
		while(tmp != null){
			tmp = father;
			tmp = (key.compareTo(tmp.mKey)<0)? tmp.left : tmp.right;
		}
		
		tmp = new Node( key, data);
		
		if(father == null)
			mRoot = tmp;
		else if(father.mKey.compareTo(tmp.mKey)>0){
			father.left = tmp;
		}
		else
			father.right = tmp;
		
		
		
	}

}
