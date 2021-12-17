import java.awt.*;

public class SoldierWinner {
	
	Image image;
	
	 public Rectangle quitButton = new Rectangle(MainGame.WIDTH/2 + 1700, 70, 100, 50);;
	 
	 public SoldierWinner(String filename) {
		 image = Toolkit.getDefaultToolkit().getImage(filename);
	 }
	 
		public void draw(Graphics pen)
		{
			pen.drawImage(image, 200, 250 , null);
		}
		public void drawLoser(Graphics pen)
		{
			pen.drawImage(image, 960, 150, null);
		}
	 
	 public void render(Graphics pen) {
	        Graphics2D g2d = (Graphics2D) pen;

	        Font fnt0 = new Font("arial", Font.BOLD, 100);
	        pen.setFont(fnt0);
	        pen.setColor(Color.GREEN);
	        pen.drawString("SOLDIER WINS", MainGame.WIDTH/2 + 100, 100);
	        pen.setColor(Color.RED);
	        pen.drawString("ROBOT LOSES", MainGame.WIDTH/2 + 900, 100);
	        
	        
	        


	        Font fnt1 = new Font("arial", Font.BOLD, 30);
	        pen.setFont(fnt1);
	        pen.setColor(Color.BLUE);
	        
	        pen.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
	        g2d.draw(quitButton);
	    }
	 
	 
	 
}
