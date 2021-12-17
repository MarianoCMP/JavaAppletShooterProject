import java.util.ArrayList;

public class Bullets extends Rect{
	
	
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	

	
	
	private int speedX;
	private int negativeSpeed;
	private boolean visible;
	
	
	public Bullets(int x, int y, int w, int h, int speedX) {
		super(x,y,w,h);
	this.speedX = speedX;
	visible = true;
	
		
		
	}
	


	public void update() {
		x += speedX;
		if(this.x > 1920) {
			visible = false;
			
		}
		
//			x -= speedX;
//			if(this.speedX <0) {
//				visible = false;
//			}
//		
		
	}

	
	public void LtBullets() {
		x -= speedX;
		if(this.x < 0 ) {
			visible = false;
		}
	}
	
	public boolean isVisible() {
	return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	public int getSpeedX() {
		return speedX;
	}
	
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public boolean overlaps1(double x, double y, double w, double h) {
		return 	   (x + w >= this.x      ) &&
				   (x     <= this.x + this.w) &&
				   (y + h >= this.y      ) &&
				   (y    <= this.y + this.h);
	}
	

	
	

}
