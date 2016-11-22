package Uebung7;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Life_View extends Frame{

	private Life_Programm p_model;
	public Insets insets;
	final public Dimension dim;
	startWindow start;
	LifeControl lC;
	public FontMetrics fMetric;
	
	Life_View( Life_Programm model){
		super("Mein erstes Fenster");
		setSize(400,300);
		setMenue();
		setMyListener();
		dim = getSize();
		fMetric = getGraphics().getFontMetrics();
		p_model = model;
		Dimension dim2 = getToolkit().getScreenSize();
		
		setLocation(dim2.width/2-this.getWidth()/2-200, dim2.height/2-this.getHeight()/2);
		
		//Window Listener setzen
		setListener();
		
		//LifeControl erzeugung (Sichbarschalten kommt nach dem Startscreen
		lC = new LifeControl(this, "Life Control");
		
		// Start Fenster, wo der Sting von links nach rechts läuft
		start = new startWindow(this, "Dies ist der laufende Text");
		start.setSize(300,150);
		start.setLocation(dim2.width/2-start.getWidth()/2, dim2.height/2-start.getHeight()/2);
		start.setVisible(true);
		start.slideString();
		
		setVisible(true);
		lC.setVisible(true);
		
		insets = this.getInsets();
		repaint();
		System.out.println(insets.top + " " + insets.right + " " + insets.left + " " + insets.bottom);
		
	}
	
	public void setListener(){
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				lC.dispose();
				dispose();
			}
		});
	}
	
	public void paint(Graphics g){
		
			for( int i = 0; i < p_model.getNoOfColumn(); ++i){
				g.drawString(p_model.getString(i), insets.left,insets.top+fMetric.getHeight()+i*12);
			
			}
	}
	
	public void nextCalculation(){
		p_model.berechneNeuesArray();
		repaint();
	}
	
	public void setMenue(){
		MenuBar myMenuBar = new MenuBar();
		Menu fileMenu = new Menu("Datei");
		MenuItem beenden = new MenuItem("Beenden");
		MenuItem weiter = new MenuItem("Weiter");
		MenuItem iconofizieren = new MenuItem("iconofizieren");
		MenuItem zentrieren = new MenuItem("zentrieren");
		MenuItem maximieren = new MenuItem("maximieren");
		Menu sub_neuInitialisieren = new Menu("neuInitialisieren");
		MenuItem groesse1 = new MenuItem("x");
		MenuItem groesse2 = new MenuItem("y");
		MenuItem groesse3 = new MenuItem("z");
		
		sub_neuInitialisieren.add(groesse1);
		sub_neuInitialisieren.add(groesse2);
		sub_neuInitialisieren.add(groesse3);
		
		fileMenu.add(beenden);
		fileMenu.add(weiter);
		fileMenu.add(iconofizieren);
		fileMenu.add(zentrieren);
		fileMenu.add(maximieren);
		fileMenu.add(sub_neuInitialisieren);
		
		Menu about = new Menu("about");
		about.add(new MenuItem("nothing"));
		
		
		myMenuBar.add(fileMenu);
		myMenuBar.add(about);
		
		weiter.setShortcut(new MenuShortcut(KeyEvent.VK_W));
		
		
		beenden.addActionListener(e->{
			lC.dispose();
			dispose();
		});
		
		weiter.addActionListener(e->{
			nextCalculation();
		});
		
		
		this.setMenuBar(myMenuBar);
	}
	
	public void setMyListener(){
		addComponentListener( new ComponentAdapter(){
			@Override
			public void componentResized(ComponentEvent e) {
			System.out.println("Resize: " + e);
			}
		});
	}
	
	public void doNothing(){
		
	}
	
	
}

// Klasse für den start ... Text läuft von links nacht rechts
@SuppressWarnings("serial")
class startWindow extends Window{
	String m_text;
	int pos_x;
	int pos_y;
	boolean text_direction_left = false;
	boolean workDone = false;
	Dimension dim;

	startWindow(Frame parent, String text) throws HeadlessException {
		super(parent);
		// TODO Auto-generated constructor stub
		m_text = text;
		this.setBackground(Color.orange);
		dim = this.getSize();
		
		
		
	}
	
	public void slideString(){
		pos_x = 0;
		pos_y = this.getHeight()/2;
		int stringlength = this.getGraphics().getFontMetrics().stringWidth(m_text);
		
		
		while(!workDone){
			
			if(text_direction_left == false){
				 
				pos_x +=1;
				if(pos_x >= this.getWidth()- stringlength){
					text_direction_left = true;
				}
				
			}else{
				pos_x -=1;
				if(pos_x <= 0){
					workDone = true;
					dispose();
				}
			}
			repaint(); 
			try{
				Thread.sleep(10);
			}catch(Exception e){
				System.out.println("d");
			}
		
		}
	}
	
	public void paint(Graphics g){
		g.drawString(m_text, pos_x, pos_y);
	}
	
}

@SuppressWarnings("serial")
class LifeControl extends Frame {
	
	
	Dimension dim;
	Life_View m_parent;
	
	LifeControl(Life_View parent, String title){
		this.setTitle(title);
		setListener();
		setSize(200,200);
		m_parent = parent;
		dim = getToolkit().getScreenSize();
		setLocation(dim.width/2-this.getWidth()/2+200, dim.height/2-this.getHeight()/2);
		
		Button weiterButton = new Button("Weiter");
		weiterButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				m_parent.nextCalculation();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		BorderLayout borderLayout = new BorderLayout();
		
		this.setLayout(borderLayout);
		this.add(BorderLayout.CENTER, weiterButton);
		pack();	
	}
	
	
	public void setListener(){
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
	}
}