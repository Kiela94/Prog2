package Uebung4;

public class Hashfunktionen implements IHashfunktionen{

	public int hashing(Object key,int iLength) {
		if (key instanceof Integer) {
			Integer i = (Integer)key;
			
			if (i.intValue() < 0){
				return -i.intValue() % iLength;
			}else{
				return i.intValue() % iLength;
			}
			
		} else if (key instanceof Character) {
			Character c = (Character)key;
			return c.charValue() % iLength;
		}else if (key instanceof String){
			String str = (String)key;
			int res = 0;
			for(int i = 0; i < str.length(); ++i)
				res = ((res << 6) + str.charAt(i)) % iLength;
			return res;
		}else{
			return 0;
		}
	}
}
