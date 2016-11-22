package Uebung5;

import java.awt.*;

@SuppressWarnings("serial")
public class polygon_view extends Frame{
	
	
	private polygon_model m_Mod;
	
	polygon_view(polygon_model mod){
		super("Zufälliges Polynom :D");
		m_Mod = mod;
		setSize(m_Mod.m_maxx, m_Mod.m_maxy);
		setVisible(true);

	}
	
	
	
	public void paint(Graphics g){
		final Insets ins = getInsets();
		final Dimension dim = getSize();

		
		for(int i = 0; i < m_Mod.m_xkoor.length; ++i){
			if(m_Mod.m_xkoor[i] < ins.left)					{	m_Mod.m_xkoor[i] += ins.left;	}
			if(m_Mod.m_xkoor[i] > dim.width - ins.right)	{	m_Mod.m_xkoor[i] -= ins.right;	}
			if(m_Mod.m_ykoor[i] < ins.top)					{		m_Mod.m_ykoor[i] += ins.top;}
			if(m_Mod.m_ykoor[i] > dim.height - ins.bottom)	{	m_Mod.m_ykoor[i] -= ins.bottom;	}
		}
		
		g.setColor( Color.red);
		g.fillPolygon(m_Mod.m_xkoor, m_Mod.m_ykoor, m_Mod.m_nline);
	
		
	}
	
	
}
