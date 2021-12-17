import java.awt.*;

public class RobotWinner {
	
	Image image;
	
	
	 public Rectangle quitButton = new Rectangle(MainGame.WIDTH/2 + 1700, 70, 100, 50); 
	 
	 public RobotWinner(String filename) {
		 image = Toolkit.getDefaultToolkit().getImage(filename);
	 }
	 public void draw(Graphics pen)
		{
			pen.drawImage(image, 150, 100 , null);
		}
		public void drawLoser(Graphics pen)
		{
			pen.drawImage(image, 800, 150, null);
		}
	 
	 public void render(Graphics pen) {
	        Graphics2D g2d = (Graphics2D) pen;

	        Font fnt0 = new Font("arial", Font.BOLD, 100);
	        pen.setFont(fnt0);
	        pen.setColor(Color.GREEN);
	        pen.drawString("ROBOT WINS", MainGame.WIDTH/2 + 120, 100);
	        pen.setColor(Color.RED);
	        pen.drawString("SOLDIER LOSES", MainGame.WIDTH/2 + 850, 100);
	        
	        


	        Font fnt1 = new Font("arial", Font.BOLD, 30);
	        pen.setFont(fnt1);
	        pen.setColor(Color.BLUE);
	     
	        pen.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
	        g2d.draw(quitButton);
	    }
	 
}
