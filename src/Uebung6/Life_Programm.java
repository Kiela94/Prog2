package Uebung6;

public class Life_Programm {

	stone array[][];
	stone array2[][]; //neu berechnetes array
	
	
	
	public int[][] koordMitXNachbarn( int x)
	{
		int arraySize = 0;
		for( int i = 0; i < array.length; i++)
		{
			for( int j = 0; j < array[i].length; j++ )
			{
				if( zaehleNachbarn( i, j) == x)
					arraySize += 1;
			}
		}
		int[][] koords = new int[arraySize][2];
		int arrayPos = 0;
		
		for( int i = 0; i < array.length; i++)
		{
			for( int j = 0; j < array[i].length; j++ )
			{
				if( zaehleNachbarn( i, j) == x)
				{
					koords[arrayPos][0] = i;
					koords[arrayPos][1] = j;
					arrayPos += 1;
				}
			}
		}
		return koords;
	}
	
	public int[][] koordMitXNachbarnRek(int x, int zeile, int spalte, int arraySize)
	{
		int koords[][];
		if( zeile < array.length )
		{
			if( spalte < array[zeile].length )
			{
				//alle spalten durchlaufen und nachbarn prüfen
				boolean genug = false;
				if( zaehleNachbarn( zeile, spalte) == x)
				{
					arraySize += 1;
					genug = true;
				}
				//aufruf mit neuer spalte
				koords = koordMitXNachbarnRek( x, zeile, spalte+1, arraySize);
				if( genug )
				{
					for(int i = 0; i < koords.length; i++ )
					{
						if( koords[i][0] == -1)
						{
							koords[i][0] = zeile;
							koords[i][1] = spalte;
							break;
						}
					}
					
				}
			}
			else
			{
				//aufruf mit neuer spalte
				koords = koordMitXNachbarnRek(x, zeile+1, 0, arraySize );
			}
		}
		else
		{
			//letzte zeile ist durchlaufen erstelle Array mit arraySize
			koords = new int[arraySize][2];
			for(int i = 0; i < koords.length; i++)
			{
				koords[i][0] = -1;
				koords[i][1] = -1;
			}
		}
		
		return koords;
	}
	
	public void ausgabeKoords(int koords[][])
	{
		for( int i = 0; i < koords.length; i++)
		{
			System.out.println( koords[i][0] + " | " + koords[i][1]);
		}
		System.out.println("\n");
	}
	
	public int zaehleNachbarn( int i, int j)
	{
		int anzTrueBarn = 0;
		
		// berechne Nachbarn
		// obenlinks
		if( i-1 < 0 && j-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 < 0 && j-1 >= 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][j-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[i-1][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j-1 >= 0 )
		{
			if(array[i-1][j-1].state > 0)
				anzTrueBarn +=1;
		}
		//oben
		if( i-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][j].state > 0)
				anzTrueBarn +=1;
		}
		if( i-1 >= 0 )
		{
			if(array[i-1][j].state > 0)
				anzTrueBarn +=1;
		}
		//obenrechts
		if( i-1 <0 && j+1 >= array[i].length )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][0].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 < 0 && j+1 < array[i].length )
		{
			if(array[array.length-1][j+1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j+1 < array[i].length )
		{
			if(array[i-1][j+1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j+1 >= array[i].length )
		{
			if(array[i-1][0].state > 0)
				anzTrueBarn +=1;
		}
		//links
		if( j-1 < 0)
		{
			//auf die andere Seite des arrays Springen
			if(array[i][array[i].length-1].state > 0)
				anzTrueBarn +=1;

		}
		if( j-1 >= 0)
		{
			if(array[i][j-1].state > 0)
				anzTrueBarn +=1;

		}
		//rechts
		if( j+1 >=array[i].length )
		{
			//auf andere Seite des Arrays Springen
			if(array[i][0].state > 0)
				anzTrueBarn +=1;
		}
		if( j+1 < array[i].length )
		{
			if(array[i][j+1].state > 0)
				anzTrueBarn +=1;
		}
		//untenlinks
		if( i+1 >= array.length && j-1 < 0)
		{
			//auf andere Seite des Arrays Springen
			if(array[0][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j-1 >= 0)
		{
			if(array[i+1][j-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 >= array.length && j-1 >= 0)
		{
			if(array[0][j-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j-1 < 0)
		{
			if(array[i+1][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		//unten
		if( i+1 >= array.length )
		{
			//auf andere Seite des Arrays springen
			if(array[0][j].state > 0)
				anzTrueBarn +=1;
		}
		if( i+1 < array.length )
		{
			if(array[i+1][j].state > 0)
				anzTrueBarn +=1;
		}
		//untenrechts
		if( i+1 >= array.length && j+1 >= array[i].length )
		{
			if(array[0][0].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j+1 < array[i].length )
		{
			if(array[i+1][j+1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j+1 >= array[i].length )
		{
			if(array[i+1][0].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 >= array.length && j+1 < array[i].length )
		{
			if(array[0][j+1].state > 0)
				anzTrueBarn +=1;
		}
//		if(anzTrueBarn == 3)
//		System.out.println("Anzahl nachbarn "  + anzTrueBarn);
		return anzTrueBarn;
	}
	
	public void initialisierung(int width, int height)
	{
//		int width = 17;
//		int height = 5;
		array = new stone[height][width];
		
		for(int i = 2; i <= height+1; i++ )
		{
			for(int j = 0; j < width; j++ )
			{
					if( java.lang.Math.random() < 0.5 )
						array[i-2][j] = new stone(0,i,j); 
					else
						array[i-2][j] = new stone(1,i,j); 
			}
		}
	}
	
	public void ausgabe( )
	{
		// ausgabe
		for(int i = 0; i< array.length; i++ )
		{
			for( int j = 0; j<array[i].length; j++ )
			{
				if( array[i][j].state == 0 )
					System.out.print(" ");
				else if(array[i][j].state == 1)
					System.out.print("a");
				else if(array[i][j].state == 2)
					System.out.print("f");
				else if(array[i][j].state == 3)
					System.out.print("r");
				else if(array[i][j].state > 3)
					System.out.print("6");
			}
			System.out.println("");
			
		}
		System.out.println("\n");
	}
	
	public void berechneNeuesArray()
	{
		int anzTrueBarn = 0;
		
		for(int i = 0; i< array2.length; i++ )
		{
			for( int j = 0; j < array2[i].length; j++ )
			{
				
				anzTrueBarn = zaehleNachbarn(i, j);
				
				if( array2[i][j].state > 0 && (anzTrueBarn ==2 || anzTrueBarn ==3) )
				{
					array2[i][j].state = array2[i][j].state+1;
				}
				else if(array2[i][j].state == 0 && anzTrueBarn == 3 )
				{
					array2[i][j].state = 1;
				}
				else 
					array2[i][j].state = 0;
				anzTrueBarn = 0;
			}
			
		}
	}
	

	/**
	 * Liefert die angebene Zeile als String zurück.
	 * @param zeile
	 * @return
	 */
	public String getString( int zeile ){
		String tmp = "";
		
		for( int i = 0; i < array[zeile].length; i++){
			if( array[zeile][i].state == 0 )
				tmp += " ";
			else if(array[zeile][i].state == 1)
				tmp += "a";
			else if(array[zeile][i].state == 2)
				tmp += "f";
			else if(array[zeile][i].state == 3)
				tmp += "r";
			else if(array[zeile][i].state > 3)
				tmp += "6";
		}
		
		return tmp;
	}
	
	public int getNoOfColumn(){
		return array.length;
	}
}

class stone
{
	
	int state;
	int zeile;
	int spalte;
	
	stone(int state, int zeile, int spalte)
	{
		this.state = state;
		this.zeile = zeile;
		this.spalte = spalte;
	}
	
	void print( stone array[][])
	{
		
		// berechne Nachbarn
		// obenlinks
		if( this.zeile-1 < 0 && this.spalte-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			printState(array[array.length-1][array[this.zeile].length-1].state);
		}
		else if( this.zeile-1 < 0 && this.spalte-1 >= 0 )
		{
			//auf die andere Seite des arrays Springen
			printState(array[array.length-1][this.spalte-1].state);
		}
		else if( this.zeile-1 >= 0 && this.spalte-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			printState(array[this.zeile-1][array[this.zeile].length-1].state);
		}
		else if( this.zeile-1 >= 0 && this.spalte-1 >= 0 )
		{
			printState(array[this.zeile-1][this.spalte-1].state);
		}
		//oben
		if( this.zeile-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			printState(array[array.length-1][this.spalte].state);
		}
		if( this.zeile-1 >= 0 )
		{
			printState(array[this.zeile-1][this.spalte].state);
		}
		//obenrechts
		if( this.zeile-1 <0 && this.spalte+1 >= array[this.zeile].length )
		{
			//auf die andere Seite des arrays Springen
			printState(array[array.length-1][0].state);
		}
		else if( this.zeile-1 < 0 && this.spalte+1 < array[this.zeile].length )
		{
			printState(array[array.length-1][this.spalte+1].state);
		}
		else if( this.zeile-1 >= 0 && this.spalte+1 < array[this.zeile].length )
		{
			printState(array[this.zeile-1][this.spalte+1].state);
		}
		else if( this.zeile-1 >= 0 && this.spalte+1 >= array[this.zeile].length )
		{
			printState(array[this.zeile-1][0].state);
		}
		//links
		if( this.spalte-1 < 0)
		{
			//auf die andere Seite des arrays Springen
			printState(array[this.zeile][array[this.zeile].length-1].state);
		}
		if( this.spalte-1 >= 0)
		{
			printState(array[this.zeile][this.spalte-1].state);
		}
		//rechts
		if( this.spalte+1 >=array[this.zeile].length )
		{
			//auf andere Seite des Arrays Springen
			printState(array[this.zeile][0].state);
		}
		if( this.spalte+1 < array[this.zeile].length )
		{
			printState(array[this.zeile][this.spalte+1].state);
		}
		//untenlinks
		if( this.zeile+1 >= array.length && this.spalte-1 < 0)
		{
			//auf andere Seite des Arrays Springen
			printState(array[0][array[this.zeile].length-1].state);
		}
		else if( this.zeile+1 < array.length && this.spalte-1 >= 0)
		{
			printState(array[this.zeile+1][this.spalte-1].state);
		}
		else if( this.zeile+1 >= array.length && this.spalte-1 >= 0)
		{
			printState(array[0][this.spalte-1].state);
		}
		else if( this.zeile+1 < array.length && this.spalte-1 < 0)
		{
			printState(array[this.zeile+1][array[this.zeile].length-1].state);
		}
		//unten
		if( this.zeile+1 >= array.length )
		{
			//auf andere Seite des Arrays springen
			printState(array[0][this.spalte].state);
		}
		if( this.zeile+1 < array.length )
		{
			printState(array[this.zeile+1][this.spalte].state);
		}
		//untenrechts
		if( this.zeile+1 >= array.length && this.spalte+1 >= array[this.zeile].length )
		{
			printState(array[0][0].state);
		}
		else if( this.zeile+1 < array.length && this.spalte+1 < array[this.zeile].length )
		{
			printState(array[this.zeile+1][this.spalte+1].state);
		}
		else if( this.zeile+1 < array.length && this.spalte+1 >= array[this.zeile].length )
		{
			printState(array[this.zeile+1][0].state);
		}
		else if( this.zeile+1 >= array.length && this.spalte+1 < array[this.zeile].length )
		{
			printState(array[0][this.spalte+1].state);
		}
	}

	void printState(int state)
	{
		if( state == 0 )
			System.out.print(" ");
		else if(state == 1)
			System.out.print("a");
		else if(state == 2)
			System.out.print("f");
		else if(state == 3)
			System.out.print("r");
		else if(state > 3)
			System.out.print("6");
	}
	
	int countNeighbour(stone array[][])
	{
		int anzTrueBarn = 0;
		int i = this.zeile;
		int j = this.spalte;
		
		// berechne Nachbarn
		// obenlinks
		if( i-1 < 0 && j-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 < 0 && j-1 >= 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][j-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[i-1][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j-1 >= 0 )
		{
			if(array[i-1][j-1].state > 0)
				anzTrueBarn +=1;
		}
		//oben
		if( i-1 < 0 )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][j].state > 0)
				anzTrueBarn +=1;
		}
		if( i-1 >= 0 )
		{
			if(array[i-1][j].state > 0)
				anzTrueBarn +=1;
		}
		//obenrechts
		if( i-1 <0 && j+1 >= array[i].length )
		{
			//auf die andere Seite des arrays Springen
			if(array[array.length-1][0].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 < 0 && j+1 < array[i].length )
		{
			if(array[array.length-1][j+1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j+1 < array[i].length )
		{
			if(array[i-1][j+1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i-1 >= 0 && j+1 >= array[i].length )
		{
			if(array[i-1][0].state > 0)
				anzTrueBarn +=1;
		}
		//links
		if( j-1 < 0)
		{
			//auf die andere Seite des arrays Springen
			if(array[i][array[i].length-1].state > 0)
				anzTrueBarn +=1;

		}
		if( j-1 >= 0)
		{
			if(array[i][j-1].state > 0)
				anzTrueBarn +=1;

		}
		//rechts
		if( j+1 >=array[i].length )
		{
			//auf andere Seite des Arrays Springen
			if(array[i][0].state > 0)
				anzTrueBarn +=1;
		}
		if( j+1 < array[i].length )
		{
			if(array[i][j+1].state > 0)
				anzTrueBarn +=1;
		}
		//untenlinks
		if( i+1 >= array.length && j-1 < 0)
		{
			//auf andere Seite des Arrays Springen
			if(array[0][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j-1 >= 0)
		{
			if(array[i+1][j-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 >= array.length && j-1 >= 0)
		{
			if(array[0][j-1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j-1 < 0)
		{
			if(array[i+1][array[i].length-1].state > 0)
				anzTrueBarn +=1;
		}
		//unten
		if( i+1 >= array.length )
		{
			//auf andere Seite des Arrays springen
			if(array[0][j].state > 0)
				anzTrueBarn +=1;
		}
		if( i+1 < array.length )
		{
			if(array[i+1][j].state > 0)
				anzTrueBarn +=1;
		}
		//untenrechts
		if( i+1 >= array.length && j+1 >= array[i].length )
		{
			if(array[0][0].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j+1 < array[i].length )
		{
			if(array[i+1][j+1].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 < array.length && j+1 >= array[i].length )
		{
			if(array[i+1][0].state > 0)
				anzTrueBarn +=1;
		}
		else if( i+1 >= array.length && j+1 < array[i].length )
		{
			if(array[0][j+1].state > 0)
				anzTrueBarn +=1;
		}
//		if(anzTrueBarn == 3)
//		System.out.println("Anzahl nachbarn "  + anzTrueBarn);
		return anzTrueBarn;
	}
	
	//ist die Zelle besetzt ?
	boolean isAlive()
	{
		if( this.state > 0 )
			return true;
		else 
			return false;
				
	}
	
	boolean computeNext(stone array[][], int anzNeighbours)
	{
		if( countNeighbour( array ) == anzNeighbours)
			return true;
		else
			return false;
	}
}
