package Uebung6;

public class polygon_model {
	int m_maxx;
	int m_maxy;
	int[] m_xkoor;
	int[] m_ykoor;
	int m_nline;
	
	polygon_model(int maxx, int maxy){
		m_maxx = maxx;
		m_maxy = maxy;
		if(m_nline < 4){
			addLine();
		}
		addLine();
	}
	
	void addLine(){
		if(m_nline == 0){
			m_xkoor = new int [2];
			m_ykoor = new int [2];
			for(int i = 0; i < m_xkoor.length; ++i){
				m_xkoor[i] = (int) (Math.random() * m_maxx);
				m_ykoor[i] = (int) (Math.random() * m_maxy);
				++m_nline;
			}		
		}
		
		int [] newx = new int[m_nline+1];
		int [] newy = new int[m_nline+1];
		
		//alten Array übertragen:
		for(int i = 0; i < m_xkoor.length; ++i){
			newx[i] = m_xkoor[i];
			newy[i] = m_ykoor[i];
		}
		
		//neue Koordinate berechnen:
		newx[newx.length-1] = (int) (Math.random() * m_maxx);
		newy[newy.length-1] = (int) (Math.random() * m_maxy);
		
		//x/y koor erneuern
		m_xkoor = newx;
		m_ykoor = newy;
		++m_nline;
	}

}
