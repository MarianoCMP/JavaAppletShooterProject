import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Menu {
	
	Image image;
	
	Color color = Color.BLACK;

    public Rectangle playButton = new Rectangle(MainGame.WIDTH/2 + 900, 150, 100, 50); 
    public Rectangle helpButton = new Rectangle(MainGame.WIDTH/2 + 900, 250, 100, 50); 
    public Rectangle quitButton = new Rectangle(MainGame.WIDTH/2 + 900, 350, 100, 50); 

    public Menu(String filename) {
		 image = Toolkit.getDefaultToolkit().getImage(filename);
	 }
	 
		public void drawS(Graphics pen)
		{
			pen.drawImage(image, 400, 250 , null);
		}
		public void drawR(Graphics pen)
		{
			pen.drawImage(image, 1000, 150, null);
		}
    
    public void render(Graphics pen) {
        Graphics2D g2d = (Graphics2D) pen;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        pen.setFont(fnt0);
        pen.setColor(Color.BLUE);
        pen.drawString("GUN", MainGame.WIDTH/2 + 830, 100);
        pen.setColor(Color.RED);
        pen.drawString("FIGHT", MainGame.WIDTH/2 + 940, 100);


        Font fnt1 = new Font("arial", Font.BOLD, 30);
        pen.setFont(fnt1);
        pen.setColor(Color.BLUE);
        pen.drawString("Play", playButton.x + 19, playButton.y + 30);
        g2d.draw(playButton);
        pen.setColor(Color.RED);
        pen.drawString("Help", helpButton.x + 19, helpButton.y + 30);
        g2d.draw(helpButton);
        pen.setColor(Color.ORANGE);
        pen.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
        g2d.draw(quitButton);
    }
    
    public void setColor(Color color)
	{
		this.color = color;
	}

}