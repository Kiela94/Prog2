package vorbKlausurProg2;

import java.awt.*;
import java.awt.event.*;


public class ninerPic extends Frame{

	public static void main(String[] args) {
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		Image[] img = new Image[6];
		img[0] = tool.getImage("C:/Users/Lars/Desktop/grey.png");
		img[1] = tool.getImage("C:/Users/Lars/Desktop/grey1.gif");
		img[2] = tool.getImage("C:/Users/Lars/Desktop/green.png");
		img[3] = tool.getImage("C:/Users/Lars/Desktop/green1.gif");
		img[4] = tool.getImage("C:/Users/Lars/Desktop/red.png");
		img[5] = tool.getImage("C:/Users/Lars/Desktop/red1.gif");
		
		
		// TODO Auto-generated method stub
		ninerPic a = new ninerPic(img);
	}
	
	myPanel p1 = null;
	myPanel p2 = null;
	
	myPanel[] panels;
	boolean random;
	a x;
	
	ninerPic(Image[] tmp){
		GridLayout grid = new GridLayout(3,2);
		
		setLayout(grid);
		panels = new myPanel[6];
		random = false;
		for(int i = 0; i < 6; i++){
			myPanel p = new myPanel(this, tmp[i]);
			panels[i] = p;
			add(p);
		}
		
		MenuBar menubar = new MenuBar();
		Menu action = new Menu("Action");
		MenuItem start_stop = new MenuItem("Start/Stop");
		action.add(start_stop);
		start_stop.addActionListener(e->{
			if(random)
				random = false;
			else
				random = true;
			System.out.println("clicked");
			start_random_selection();
		});
		menubar.add(action);
		setMenuBar(menubar);
		
		setBounds(100,100,800,500);
		setVisible(true);
	}
	
	void setSwapPanel(myPanel p){
		
		if(p1 == null)
			p1 = p;
		else
			p2 = p;
		
		if(p1 != null && p2 != null){
			Image tmp = p1.getImage();
			p1.setImage(p2.getImage());
			p2.setImage(tmp);
			p1.repaint();
			p2.repaint();
			p1 = null;
			p2 = null;
			System.out.println("Swap");
		}
	}
	
	void start_random_selection(){
		
		if(random){
			x = new a(this);
			x.start();
		}	
		else{
			x.running = false;
			x.interrupt();
			System.out.println("end");
		}
			
	}

}

class myPanel extends Panel{
	Image img;
	ninerPic parent;
	myPanel(ninerPic xparent, Image a){
		img = a;
		parent = xparent;
		addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e){
				setSwapPanel();
				System.out.println("clicked");
			}
		});
	}
	
	void setSwapPanel(){
		parent.setSwapPanel(this);
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(img,0, 0, this);
	}
	
	Image swapImage(Image imp){
		Image tmp = this.img;
		this.img = img;
		return tmp;
	}
	
	void setImage(Image img){
		this.img = img;
	}
	
	Image getImage(){
		return this.img;
	}
	
	
	
}

class a extends Thread{
	ninerPic parent;
	public volatile boolean running = true;
	
	a(ninerPic xparent){
		parent = xparent;
	}
	
	public void run(){
		while(running){
			int a = (int)(Math.random()*10)%6;
			System.out.println(a);
			parent.setSwapPanel(parent.panels[a]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				interrupt();
			}
		}
	}
}
