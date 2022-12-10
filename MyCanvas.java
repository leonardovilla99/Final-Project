package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MyCanvas extends FinalProject {
	  public void paint(Graphics g) {  
    	  
	        Toolkit t=Toolkit.getDefaultToolkit();  
	        Image i=t.getImage("cardealer.jpg");  
	        g.drawImage(i, 120,100,this);  
	        
	        MyCanvas m=new MyCanvas();  
	        JFrame f=new JFrame();  
	        f.add(m);  
	        f.setSize(10,10);  
	        f.setVisible(true);  
	          
	    }  
}
