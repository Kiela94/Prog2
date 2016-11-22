package testproj;

import java.awt.*;
import java.awt.event.*;

public class mainWindow extends Frame{

	Point p1;
	Point p2;
	Point p3;
	Point p4;
	boolean firstClick;
	boolean thirdClick;
	int[] x ;
	int[] y;
	boolean set = false;
	
	
	mainWindow(String title ){
		System.out.println("Erstelle Fenster");
		Point p1 = null;
		Point p2 = null;
		Point p3 = null;
		Point p4 = null;
		firstClick = true;
		thirdClick = false;
		x= new int[4];
		y = new int[4];
		this.setTitle(title);
		
		this.setLocation(100, 100);
		
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
		this.setMenues();
		BorderLayout mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
		this.setColorCheckBoxes();
		this.setBorderTitle("Dies ist die Nodseite des Layouts");
		this.setButtons();
		this.setTextFields();
		this.setMiddle();
		
		
		this.setSize(800,500);
		this.setVisible(true);
		
		
		
	
	}
	
	void setMenues(){
		MenuBar menubar = new MenuBar();
		Menu datei = new Menu("Datei");
		Menu save = new Menu("Speichern");
		MenuItem saveAs = new MenuItem("Speichern als...");
		save.add(saveAs);
		MenuItem saveIt = new MenuItem("Speichern");
		save.add(saveIt);
		datei.add(save);
		MenuItem end = new MenuItem("Beenden");
		datei.add(end);
		menubar.add(datei);
		Menu shutTheFuckUp = new Menu("Nervig");
		MenuItem about = new MenuItem("About");
		shutTheFuckUp.add(about);
		MenuItem help = new MenuItem("?");
		shutTheFuckUp.add(help);
		menubar.add(shutTheFuckUp);
		
		//add Listener
		end.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		saveAs.addActionListener(e->{
			System.out.println("Speichern als...");
			}
		);
		
		saveIt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Speichern");
				
			}
			
		});
		
		about.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("about");
			}
		});
		
		
		help.addActionListener(e->{
			System.out.println("help");
		});
		
		this.setMenuBar(menubar);
		
	
	}
	
	void setColorCheckBoxes(){
		Panel p = new Panel();
		GridLayout checkBoxLayout = new GridLayout(3,1);
		p.setLayout(checkBoxLayout);
		CheckboxGroup grp = new CheckboxGroup();
		p.add(new Checkbox("red", grp, false));
		p.add(new Checkbox("green",grp, false));
		p.add(new Checkbox("blue", grp, false));
		p.setBackground(Color.GREEN);
		
		this.add(BorderLayout.WEST, p);
		pack();
	}
	
	void setBorderTitle(String text){
		Label label = new Label(text);
		Panel p = new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.add(label);
		p.setBackground(Color.BLUE);
		add(BorderLayout.NORTH, p);
		
	}
	
	void setButtons(){
		Panel p = new Panel();
		p.setLayout(new GridLayout(2,1));
		Button oben = new Button("Speichern...");
		RButton unten = new RButton("Löschen");

		p.add(oben);
		p.add(unten);
		p.setBackground(Color.red);

		add(BorderLayout.EAST, p);
	}

	void setTextFields(){
		
		
		TextArea tA = new TextArea();
		//tA.setSize(this.getSize().width, 100);
		Panel p = new Panel();
		//p.setSize(this.getSize().width, 10);
		p.setLayout(new GridLayout(1,1));
		p.add(tA);
		p.setBackground(Color.YELLOW);
		add(BorderLayout.SOUTH, p);
	}

	void setMiddle(){
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				
				if(firstClick == true && thirdClick == false){
					p1 = e.getPoint();
					firstClick = false;
					System.out.println("Erster Klick");
				}
				else if( firstClick == false && thirdClick == false){
					p2 = e.getPoint();
					firstClick = true;
					thirdClick = true;
					System.out.println("Zweiter Klick");
					repaint();
				}else if(firstClick == true && thirdClick == true){
					firstClick = false;
					p3 = e.getPoint();
					System.out.println("dritter Klick");
				}else if(firstClick == false && thirdClick == true){
					firstClick = true;
					thirdClick = false;
					p4 = e.getPoint();
					set();
					set = true;
					repaint();
					System.out.println("vierter Klick");
				}
				
			}
		});
	}

	public void paint(Graphics g){
		g.setColor(Color.red);
		System.out.println("jawoll");

		if(set){
			
			g.drawPolygon(x,y,4);
			
			System.out.println("jawoll2");
		}
	}
	
	void set(){
		x[0] = p1.x;
		x[1] = p2.x;
		x[2] = p3.x;
		x[3] = p4.x;
		
		y[0] = p1.y;
		y[1] = p2.y;
		y[2] = p3.y;
		y[3] = p4.y;
	}
}

class RButton extends Component{
	String mLabel;
	Image img = this.getToolkit().getImage("C:/Users/Lars/Desktop/grey.png");
	Image img1 = this.getToolkit().getImage("C:/Users/Lars/Desktop/green1.gif");
	Image img2 = this.getToolkit().getImage("C:/Users/Lars/Desktop/red1.gif");
	Image img3 = this.getToolkit().getImage("C:/Users/Lars/Desktop/grey.png");
	boolean mPressed =false;
	
	RButton(String label){
		mLabel = label;
		this.setSize(105, 105);
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				if((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0)
				pressed();
			}
			
			@Override 
			public void mouseReleased(MouseEvent e){
				if((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0)
				released();
			}
		});
		
		addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				img = img2;
				repaint();
			}

			@Override
			public void focusLost(FocusEvent e) {
				img = img3;
				repaint();
			}
			
		});
	}
	
	@Override 
	public Dimension getPreferredSize(){
		return new Dimension(img.getWidth(this), img.getHeight(this));
	}
	
	@Override
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	
	@Override
	public void paint(Graphics g){
		Dimension d = getSize();
		if(mPressed){
			g.drawImage(img1, 0,0,100, 100, this);
		}else{
			g.drawImage(img, 0,0,100, 100, this);
		}
		
	}
	
	private void pressed(){
		mPressed = true;
		System.out.print("pressed");
		requestFocus();
		repaint();
	}
	
	private void released(){
		mPressed = false;
		System.out.println("Released");
		repaint();
	}
	
	@Override
	public boolean isFocusable(){
		return true;
	}
	

}
