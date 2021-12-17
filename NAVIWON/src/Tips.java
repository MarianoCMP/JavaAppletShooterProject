import java.awt.*;

public class Tips {
	
	Image image;
	
	public Rectangle backButton = new Rectangle(MainGame.WIDTH/2 + 50, 900, 130, 50);
	 
	 public Tips(String filename) {
		 image = Toolkit.getDefaultToolkit().getImage(filename);
	 }
	 
		public void draw(Graphics pen)
		{
			pen.drawImage(image, 350, 250 , null);
		}
		public void draw2(Graphics pen)
		{
			pen.drawImage(image, 1000, 250, null);
		}
		
		public void draw3(Graphics pen) {
			pen.drawImage(image, 350, 650, null);
		}
		public void draw4(Graphics pen) {
			pen.drawImage(image, 1000, 650, null);
		}
	 
	 public void render(Graphics pen) {
	        Graphics2D g2d = (Graphics2D) pen;

	        Font fnt0 = new Font("arial", Font.BOLD, 25);
	        pen.setFont(fnt0);
	        pen.setColor(Color.GREEN);
	        pen.drawString("SOLDIER CONTROLS", 375, 100);
	        pen.drawString("W - Jump", 100, 400);
	        pen.drawString("A - Move Left", 100, 450);
	        pen.drawString("D - Move Right", 100, 500);
	        pen.drawString("Spacebar - Shoot", 50, 700);
	        
	        pen.setColor(Color.RED);
	        pen.drawString("ROBOT CONTROLS", 1050, 100);
	        pen.drawString("Up Arrow - Jump", 1370, 400);
	        pen.drawString("Left Arrow - Move Left", 1370, 450);
	        pen.drawString("Right Arrow - Move Right", 1370, 500);
	        pen.drawString("CTRL - Shoot", 1370, 700);


	        Font fnt1 = new Font("arial", Font.BOLD, 40);
	        pen.setFont(fnt1);
	        pen.setColor(Color.BLUE);
	 
	        pen.drawString("Back", backButton.x + 19, backButton.y + 40);
	        g2d.draw(backButton);
	    }
	 
}