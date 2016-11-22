package vorbKlausurProg2;

public class sortier {

	public static void main(String args[])
	{
		
	}
	<K extends Comparable<K>>void swap(K[] field, int pos1, int pos2){
		K tmp = field[pos1];
		field[pos1] = field[pos2];
		field[pos2] = tmp;
	}
	
	// mergesort, shellsort, quicksort, distribution counting, heap sort
	
	<K extends Comparable<K>> void mergesort(K[] field){
		mergesort_help(field, 0, field.length);
	}

	<K extends Comparable<K>> void mergesort_help(K[] field, int iLeft, int iRight){
		if(iLeft < iRight){
			final int middle = (iLeft+iRight)/2;
			mergesort_help(field, iLeft, middle);
			mergesort_help(field, middle+1, iRight);
			
			K[] tmp = (K[]) new Comparable[iRight-iLeft+1];
			
			for(int i = iLeft; i <= middle; i++){
				tmp[i-iLeft] = field[i];
			}
			
			for(int i = middle+1; i<= iRight; i++){
				tmp[field.length-i+ middle] = field[i];
			}
			
			int iL = 0;
			int iR = tmp.length-1;
			for(int i = iLeft; i<= iRight; i++){
				field[i] = (tmp[iL].compareTo(tmp[iR]))<= 0? tmp[iL++]: tmp[iR--];
			}
		}
	}
	
	<K extends Comparable<K>> void quicksort(K[] field){
		quicksort_help(field, 0, field.length-1);
	}
	
	<K extends Comparable<K>> void quicksort_help(K[] field, int iLeft, int iRight){
		final K middle = field[(iLeft+iRight)/2];
		int l = iLeft;
		int r = iRight;
		
		while(l<r){
			while(field[l].compareTo(middle)<0){l++;}
			while(field[r].compareTo(middle)>0){r--;}
			if(l<=r){
				swap(field, l++, r--);
			}
		}
		
		if(iLeft < r)
			quicksort_help(field, iLeft, r);
		if(iRight > l)
			quicksort_help(field, l, iRight);
	}
	
	
	void distribution_counting(int[] field, int m){
		int[] count = new int[m];
		
		for(int i = 0; i< field.length; i++){
			++count[field[i]];
		}
		
		for(int i = 0,i2 = 0; i< count.length; i++){
			for(int i3 = 0; i3 < count[i]; i3++){
				field[i2++] = i;
			}
		}
	}
	
	<K extends Comparable<K>> void shellsort(K[] field){
		int iDist = 1;
		for(; iDist < field.length/9; iDist = iDist*3+1){}
		
		for(; iDist > 0; iDist/=3){
			for( int i = iDist; i< field.length; i++){
				final K IVAL = field[i];
				int i2 = i;
				while(i2 >= iDist && field[i2-iDist].compareTo(IVAL)>0){
					field[i2] = field[i2-iDist];
					i2 = i2 -iDist;
				}
				field[i2] = IVAL;
			}
		}
		
	}
	
	
	// shellsort, heap sort; mergesort, distribuition counting, quicksort
	

	<K extends Comparable<K>> void ss(K[] field){
		int iDist = 1;
		for(; iDist < field.length/9; iDist = iDist*3+1){}
		
		for(; iDist > 0; iDist/=3){
			for(int i = iDist; i < field.length; i++){
				final K IVAL = field[i];
				int i2 = i;
				
				while(i2 >= iDist && field[i2-iDist].compareTo(IVAL)>0){
					field[i2] = field[i2-iDist];
					i2 = i2 -iDist;
				}
				
				field[i2] = IVAL;
			}
		}
		
	}
	
	<K extends Comparable <K>> void ms(K[] field){
		msh(field, 0, field.length-1);
	}
	
	<K extends Comparable<K>>void msh(K[] field, int iLeft, int iRight){
		if(iLeft < iRight){
			final int middle = (iLeft+iRight)/2;
			msh(field, iLeft, middle);
			msh(field, middle+1, iRight);
			
			K[] tmp = (K[]) new Comparable[iRight-iLeft+1];
			
			for(int i = iLeft; i <= middle; i++){
				tmp[i-iLeft] = field[i];
			}
			
			for(int i = middle+1; i <= iRight;i++){
				tmp[tmp.length-i+middle] = field[i];
			}
			
			int iL = 0;
			int iR = tmp.length-1;
			
			for(int i = iLeft; i <= iRight; i++){
				field[i] = tmp[iL].compareTo(tmp[iR]) <= 0? tmp[iL++] : tmp[iR--];
			}
		}
	}
	
	<K extends Comparable<K>> void qs(K[] field){
		qsh(field, 0, field.length-1);
	}
	<K extends Comparable<K>> void qsh(K[] field, int iLeft, int iRight){
		final K middle = field[(iLeft+iRight)/2];
		int l = iLeft;
		int r = iRight;
		
		while(l<r){
			while(field[l].compareTo(middle) < 0){l++;}
			while(field[r].compareTo(middle)> 0){r--;}
			
			if(l <= r)
				swap(field, l++, r--);
		}
		

	}
}


class heap <K extends Comparable<K>>{
	int next;
	K[] keys;
	
	heap(int size){
		next = 0;
		keys = (K[]) new Comparable[size];
	}
	
	void insert(K obj){
		keys[next] = obj;
		upheap(next);
		next++;
	}
	
	void upheap(int index){
		K tmp = keys[index];
		
		while(index != 0 && keys[(index-1)/2].compareTo(tmp)<0){		
			keys[index] = keys[(index-1)/2];
			index = (index-1)/2;
		}
		
		keys[index] = tmp;
	}
	
	K remove(){
		K tmp = keys[0];
		keys[0] = keys[--next];
		downheap(0);
		return tmp;
	}
	
	void downheap(int index){
		K tmp = keys[index];
		
		while(index < next/2){
			int index_son = index*2+1;
			if(index_son < next-1 && keys[index_son].compareTo(keys[index_son+1])< 0){
				index_son++;
			}
			
			if(tmp.compareTo(keys[index_son])>= 0) break;
			
			keys[index] = keys[index_son];
			index = index_son;
		}
		
		keys[index] = tmp;
	}
	
	
}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	








class heap_b <K extends Comparable<K>>{
	
	int next;
	K[] keys;
	
	heap_b(int size){
		next = 0;
		keys = (K[]) new Comparable[size];
	}
	
	void insert(K obj){
		keys[next] = obj;
		upheap(next);
		++next;
	}
	
	void upheap(int index){
		K tmp = keys[index];
		
		while(index != 0 && keys[(index-1)/2].compareTo(tmp)<0){
			keys[index] = keys[(index-1)/2];
			index = (index-1)/2;
			
		}
		
		keys[index] = tmp;
	}
	
	K remove(){
		K tmp = keys[0];
		keys[0] = keys[--next];
		downheap(0);
		return tmp;
	}
	
	void downheap(int index){
		K tmp = keys[index];
		
		while(index < next/2){
			int index_son = 2*index+1;
			if(index_son < next-1 && keys[index_son].compareTo(keys[index_son+1])<0){
				++index_son;
			}
			
			if(tmp.compareTo(keys[index_son])>=0)break;
			
			keys[index] = keys[index_son];
			index = index_son;
		}
		
		keys[index]= tmp;
	}
}






















