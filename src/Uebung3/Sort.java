package Uebung3;

import Uebung2.List;
import Uebung2.SimpleCollection;
import Uebung2.MyVektorT;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyVektorT<Integer> object = new MyVektorT<Integer>(15,5);

//		List<Integer> object = new List<Integer>();	

		for(int i = 0; i < 5; i++){
			int x = (int) (Math.random()*100);
			object.push_back(x);
		}

		System.out.println("\n");
//		int x = object.size();
//		System.out.println("size vor erster ausgabe: " + x);
		for(int i = 0; i < object.size(); i++){
			System.out.print(object.get(i) + " ");
		}
		System.out.println("");
//		System.out.println("size: " + object.size());
		
		heapsort(object);
		
		System.out.println("Sortiert");
		for(int i = 0; i < object.size(); i++)
		{
			System.out.print(object.get(i) + " ");
		}
	}
	
	public static <T extends Comparable<T>> void shellsort(SimpleCollection<T> col){
		int iDist = 1;
		for( ; iDist <= col.size()/ 3; iDist = 3 * iDist + 1) {
		}
		
		for( ; iDist > 0; iDist /= 3) {
			for( int i = iDist; i < col.size(); i++){
				final T IVAL = col.get(i);
				int i2 = i;
				while( i2 >= iDist && col.get(i2-iDist).compareTo(IVAL) > 0)
				{
					col.set(i2, col.get(i2-iDist));
					i2 = i2 - iDist;
				}		
				col.set(i2, IVAL);
				
			}
		}
	}
	
	public static <T extends Comparable<T>> void quicksort(SimpleCollection<T> col){
		quickSortHelp(col,0, col.size()-1);
	}
	
	public static <T extends Comparable<T>> void mergesort(SimpleCollection<T> col){
		mergeSortHelp(col, 0, col.size()-1);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void heapsort(SimpleCollection<T> col){
		// hier muss bei size nicht -1 gemacht werden, da nicht auf dieses zugegriffen wird sondern ein array angelegt wird.
		Heap<Integer> a = new Heap<Integer>(col.size());
		for(int i = 0; i < col.size(); ++i)
			a.insert((int)col.get(i));
		
//		System.out.println("nodes: " + a.count_nodes());
//		System.out.println("Element found on index: " + a.search(2));
		
		for(int i = 0; i < col.size(); ++i)
			col.set(col.size()-i-1, (T) a.remove());
		
		
	}
	
	private static <T extends Comparable<T>> void quickSortHelp(SimpleCollection<T> col, int iLeft, int iRight){
		final T MID = col.get((iLeft + iRight) / 2);
		int l = iLeft;
		int r = iRight;
		while(l < r) {
			while(col.get(l).compareTo(MID) < 0) { ++l; }
			while(col.get(r).compareTo(MID) > 0) { --r; }
			if(l <= r)
			{
				T tmp = col.get(l);
				col.set(l, col.get(r));
				col.set(r, tmp);
				l++;
				r--;
			}
		}
		if (iLeft < r)
			quickSortHelp(col, iLeft, r );
		if (iRight > l)
			quickSortHelp(col, l, iRight);
	}

	private static <T extends Comparable<T>> void mergeSortHelp(SimpleCollection<T> col, int iLeft, int iRight){
		if (iLeft < iRight) {
			final int MIDDLE = (iLeft + iRight) / 2;
			
			mergeSortHelp(col, iLeft, MIDDLE);
			mergeSortHelp(col, MIDDLE + 1, iRight);
			
			SimpleCollection<T> tmp = new List<T>();
			for(int z = 0; z <= iRight - iLeft; z++){ tmp.push_back(null);}
			//K[] tmp = (K[]) new Comparable[iRight - iLeft + 1];
			
			for(int i = iLeft; i <= MIDDLE; ++i)
				tmp.set(i - iLeft,  col.get(i));
			for(int i = MIDDLE+1; i <= iRight; ++i)
				tmp.set(tmp.size()-i+MIDDLE, col.get(i));
			int iL = 0;
			int iR = tmp.size()-1;
			for(int i = iLeft; i <= iRight; ++i) {
				if(tmp.get(iL).compareTo(tmp.get(iR)) <= 0){
					col.set(i, tmp.get(iL++));
				} else {
					col.set(i, tmp.get(iR--));
				}
			}
		}
	}
}
