package vorbKlausurProg2;

public class zeitNehmen {
	public static void main(String[] args){
		//Mit diesen Aufr�fen wird die Zeit genommen.
		long iStart = System.currentTimeMillis();
		for( long i = 0; i < 5000000L; i++)
		{
			
		}
		long iEnd = System.currentTimeMillis();
		System.out.println("Zeit in Millisek: " + (iEnd - iStart));
	}
}
