import java.awt.Graphics;
import java.util.ArrayList;


public class Sprite extends Rect 
{
	// Position P
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	
	double x;
	double y;
	
	
	// Velocity V
	double vx = 0;
	double vy = 0;
	
	// Accerleration a
	double ax = 0;
	double ay = gravity;
	
	
	int hp;
	
	int w;
	int h;
	
	
	final static double gravity = 0.3; 
	
	
	Animation[] animation;
	
	boolean moving = false;
	
	final int UP = 0;
	final int DN = 1;
	static final int LT = 2;
	final int RT = 3;
	
	
	 static int action2;
	 int action = DN;
	
	public Sprite(int x, int y, int w, int h, String name, String[] pose, int count, String filetype, int delay, int hp) 
	{
		
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.hp = hp;
		
		animation = new Animation[pose.length];
		
		for(int i = 0; i < animation.length; i++)
			
			animation[i] = new Animation(name + pose[i], count, filetype, delay);
		
		
	}
	

	
	
	public void draw(Graphics pen)
	{
   	   if(moving)
	
		   pen.drawImage(animation[action].currentImage(), (int)x, (int)y, null);
		   
	   else

		   pen.drawImage(animation[action].stillImage(), (int)x, (int)y, null);
	   
	   moving = false;
	}
	
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	public void setAccelleration(double ax, double ay)
	{
		this.ax = ax;
		this.ay = ay;
	}
	
	public void jump()
	{
		vy = -8;
	}
	
	public void move()
	{
		// Moved based on current velocity
		x += vx;  
		y += vy;
		
		// Adjust Velocity based on current acceleration
		vx += ax;
		vy += ay;
	}
	
	
	public void moveUp(int dy)
	{
		y -= dy;
		
		moving = true;
		
		action = UP;
	}

	public void moveDown(int dy)
	{
		y += dy;
		
		moving = true;
		
		action = DN;
	}

	public void moveLeft(int dx)
	{
		x -= dx;
		
		moving = true;
		
		action = LT;
		
	}

	public void moveRight(int dx)
	{
		x += dx;
		
		moving = true;
		
		action = RT;
	}

	public void goLeft(int dx)
	{
		vx = -dx;
		
		moving = true;
		
		action = LT;
	}

	public void goRight(int dx)
	{
		vx = +dx;
		
		moving = true;
		
		action = RT;
	}

	public boolean overlaps(Rect r)
	{
		return (getX() + getW() >= r.x      ) &&
			   (getX()     <= r.x + r.w) &&
			   (getY() + getH() >= r.y      ) &&
			   (getY()    <= r.y + r.h);
	}
	
	
	public void pushUpFrom(Rect platform)
	{
		y -= y + h  - platform.y;
		
		vx = 0;
		vy = 0;
	}
	public boolean overlapsLt(Line L)
	{
		return L.distanceFrom(x, y) - 0 < 0;   			
	}
	
	public void pushedBackByLt(Line L)
	{
		double d = L.distanceFrom(x, y);
		
		x += (0 - d) * L.Nx;
		y += (0 - d) * L.Ny;
	}
	public boolean overlapsRt(Line L)
	{
		return L.distanceFrom(x, y) - 80 < 0;   			
	}
	
	public void pushedBackByRt(Line L)
	{
		double d = L.distanceFrom(x, y);
		
		x += (80 - d) * L.Nx;
		y += (80  - d) * L.Ny;
	}
	
	public boolean contains(int mx, int my)
	{
		return ( mx > x   ) &&   
			   ( mx < x+w ) && 
			   ( my > y   ) && 
			   ( my < y+h );
	}
	public void shooty() {
		
		Bullets b = new Bullets((int)x, (int)y + 50, 20, 20, 7);
		bullets.add(b);


	}
	
	
	public ArrayList getBullets() {
		return bullets;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}public double getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}public double getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}

	
	
	
	
}