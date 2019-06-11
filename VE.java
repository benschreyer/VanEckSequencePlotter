import java.awt.*;
import java.awt.event.*;
public class VE extends Frame
{
	public VE()
	{
		super("Van-Eck sequence");
		setSize(1000,1000);
	      addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      }); 
	}
	   @Override
	public void paint(Graphics g) 
	{
		   Graphics2D g2 = (Graphics2D)g;
	       int[] vanEck = new int[1000];
	       vanEck[0] = 0;
	       for(int i = 1;i < 1000;i++)
	       {
	    	   boolean found = false;
	    	   for(int j = i - 2;j >= 0;j--)
	    	   {
	    		   if(vanEck[j] == vanEck[i - 1])
	    		   {
	    			   vanEck[i] = i - j - 1;
	    			   found = true;
	    			   break;
				   }
	    	   }
			   if(!found)
				   vanEck[i] = 0;
		   }
	       for(int i = 0; i < 1000;i++)
	       {
	    	   System.out.println(vanEck[i]);
	       }
	       g2.setColor(Color.BLACK);
	       for(int i = 0;i < 1000;i++)
	       {
	    	   g2.fill(new Rectangle(i,1000 - vanEck[i], 5, 5));
	       }
	}
	public static void main(String[] args)
	{
		VE window = new VE();
		window.setVisible(true);
	}
}
