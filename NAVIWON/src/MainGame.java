import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import java.applet.Applet;

public class MainGame extends GameFoundation

{
	
	private Bullets b;
	private Bullets a;
	
	SoldierWinner sWinner = new SoldierWinner("SoldierWinner.png");
	SoldierWinner robotLoser = new SoldierWinner("RobotLoser.png");
	
	RobotWinner rWinner  = new RobotWinner("RobotW.png");
	RobotWinner soldierLoser = new RobotWinner("SoldierL.png");
	
	Tips tips = new Tips("wasd.jpg");
	Tips tips2 =  new Tips("arrows.jpg");
	Tips tips3 = new Tips("spacebar.png");
	Tips tips4 = new Tips("ctrl.png");
	
	
	int mx = 0;
	int my = 0;
	
	boolean locked = false;
	boolean locked2 = false;
	boolean locked3 = false;
	boolean locked4 = false;
	
	// Variable declartions for FPS (Frames Per Second)
	long lastTime = System.nanoTime();
    final double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    int updates = 0;
    int frames = 0;
    long timer = System.currentTimeMillis();
	
	
    
	 Menu menu = new Menu("S1.png");
	 Menu r1 = new Menu("R1.png");
	
	 
	Rect[] platform = new Rect[4];
	
	
	
	
	Soldier soldier = new Soldier(60, 800, 20, 100);
	Robot robot = new Robot (1800, 770, 20, 120);
	Line line1 = new Line(0, 0, 0, 1080);
	Line line2 = new Line(0, 900, 1920, 900);
	Line line3 = new Line(1920,0,0,0);
	Line line4 = new Line(1920,1080,1920,0);
	
	int soldierHp = soldier.getHp();
	int robotHp = robot.getHp();
	
	
	Background background = new Background("1v1jpg.jpg");
	Background fighting = new Background("castle.jpg");
	Background war = new Background("warb.png");
	Background future = new Background("robotw.jpg");
	Background black = new Background("black.jpg");
	
	public static enum STATE
	{
		MENU,
		TIPS,
		GAME,
		WINNER,
		WINNER2,
		QUIT
	};
	
	public static STATE State = STATE.MENU;
	
	public void initialize()
	{
		
		
		
		
		new Sound(this);
		
		Sound.music.play();
	
		platform[0] = new Rect(0, 900, 1920, 20);
		platform[1] = new Rect(200, 750, 420, 10);
		platform[2] = new Rect(820, 730, 390, 10 );
		platform[3] = new Rect(1300, 780, 390, 10);

	}
	
				

		public void inGameLoop()
		{
			for(int i = 0; i < platform.length; i++) {
				if(soldier.overlaps(platform[i])   ) {
					soldier.pushUpFrom(platform[i] );
				}
				if(robot.overlaps(platform[i])) {
					robot.pushUpFrom(platform[i]);
				}
			}
			
			
			
			if(pressing[_A]) {soldier.moveLeft(7);}
			if(pressing[_D]) {soldier.moveRight(7); }
			if(pressing[_W] && !locked3) {
				locked3 = true; 
				soldier.jump();
				Sound.jump.play();
				
			}if(!pressing[_W]) locked3 =false;
			if(pressing[UP] && !locked4)
			{ 
				locked4 = true;
				robot.jump(); 
				Sound.jump.play();
			}if(!pressing[UP]) locked4 = false;
			if(pressing[RT]) {  robot.moveRight(7);}
			if(pressing[LT]) { robot.moveLeft(7);}
			
			if(pressing[CTRL] && !locked2)  
			{
				locked2 = true;
				
				robot.shooty();
				Sound.rshoot.play();
				
			}
			if(!pressing[CTRL])  locked2 = false;  
			if(pressing[SPACE] && !locked)  
			{
				locked = true;
				
				soldier.shooty();
				Sound.sshoot.play();
			}
			if(!pressing[SPACE])  locked = false;  
			
			soldier.move();
			robot.move();
			
			ArrayList bullets = soldier.getBullets();
			for(int i = 0; i< bullets.size(); i++) {
				 b = (Bullets) bullets.get(i);
				if(b.isVisible() == true ) {
					b.update();

					if(b.overlaps1(robot.getX(), robot.getY(), robot.getW(), robot.getH())) {
						robotHp = robotHp - 10;
						if(robotHp ==0) {
							MainGame.State = MainGame.STATE.WINNER;
						}
						
					}
				}
				else {
					bullets.remove(i);
				}
				
			}
			
			ArrayList bullets2 = robot.getBullets();
			for(int i = 0; i< bullets2.size(); i++) {
				 a = (Bullets) bullets2.get(i);
				if(a.isVisible() == true ) {
					a.LtBullets();
//					
					if(a.overlaps1(soldier.getX(), soldier.getY(), soldier.getW(), soldier.getH())) {
						Sound.shot.play();
						soldierHp = soldierHp - 10;
						if(soldierHp == 0) {
						MainGame.State = MainGame.STATE.WINNER2;
						}
					}
				}
				else {
					bullets2.remove(i);
				}
				
			}
			
			
			

		 
		
			if(soldier.overlapsLt(line1)) soldier.pushedBackByLt(line1);
			if(soldier.overlapsRt(line4)) soldier.pushedBackByRt(line4);
			

						
			if(robot.overlapsLt(line1)) robot.pushedBackByLt(line1);
			if(robot.overlapsRt(line4)) robot.pushedBackByRt(line4);
			

					
	
			
		}
		long nextSecond = System.currentTimeMillis() + 1000;
	    int frameInLastSecond = 0;
	    int framesInCurrentSecond = 0;
		
	

	public void paint(Graphics pen)
	{
		Font fnt0 = new Font("arial", Font.BOLD, 12);
        pen.setFont(fnt0);
        pen.setColor(Color.BLACK);
        
        
		
		if(State == STATE.GAME) {
		
		
		fighting.draw(pen);
		
		
		long currentTime = System.currentTimeMillis();
        if (currentTime > nextSecond) {
            nextSecond += 1000;
            frameInLastSecond = framesInCurrentSecond;
            framesInCurrentSecond = 0;
        }
        framesInCurrentSecond++;
        
		
		pen.setColor(Color.gray);
		pen.fillRect(5, 5, 700, 30);
		pen.setColor(Color.green);
		pen.fillRect(5,5,soldierHp,30);
		pen.setColor(Color.white);
		pen.drawRect(5, 5, 700, 30);
		if(soldierHp <= 350) {
			pen.setColor(Color.red);
			pen.fillRect(5, 5, soldierHp, 30);
		}
		
		pen.setColor(Color.gray);
		pen.fillRect(1215, 5, 700, 30);
		pen.setColor(Color.green);
		pen.fillRect(1215, 5, robotHp , 30);
		pen.setColor(Color.white);
		pen.drawRect(1215, 5, 700, 30);
		if(robotHp <= 350) {
			pen.setColor(Color.red);
			pen.fillRect(1215, 5, robotHp, 30);
		}
		
		
		pen.setColor(Color.BLACK);
		//line2.draw(pen);
		line1.draw(pen);
		line3.draw(pen);
		line4.draw(pen);
		soldier.draw(pen);
		robot.draw(pen);
		
		
		ArrayList bullets = soldier.getBullets();
		for(int i =0; i< bullets.size(); i++) {
			 b =(Bullets) bullets.get(i);
			pen.setColor(Color.BLUE);
			pen.fillRect(b.x, b.y, 30,10 );
			
		}
		
		
		ArrayList bullets2 = robot.getBullets();
		for(int i =0; i< bullets2.size(); i++) {
			 a =(Bullets) bullets2.get(i);
			pen.setColor(Color.RED);
			pen.fillRect(a.x, a.y, 30,10 );
			
			
		}
		
		pen.setColor(Color.BLACK);

		pen.setFont(new Font("arial", Font.BOLD, 30));
		
		 pen.drawString( "FPS: " + frameInLastSecond , 20, 80);
		
		}
		else if(State == STATE.MENU){
			background.draw(pen);
			menu.render(pen);
			menu.drawS(pen);
			r1.drawR(pen);
		}else	 if(State == STATE.QUIT) {
			System.exit(0);
		}
		else  if(State == STATE.WINNER) {
			war.draw(pen);
			sWinner.render(pen);
			sWinner.draw(pen);
			robotLoser.drawLoser(pen);
			
		}
		else if(State == STATE.WINNER2) {
			future.draw(pen);
			rWinner.render(pen);
			rWinner.draw(pen);
			soldierLoser.drawLoser(pen);
		}
		else if(State == STATE.TIPS) {
			black.draw(pen);
			tips.render(pen);
			tips.draw(pen);
			tips2.draw2(pen);
			tips3.draw3(pen);
			tips4.draw4(pen);
		}
	}

	public void mouseMoved(MouseEvent e)
	{
		 mx = e.getX();
		 my = e.getY();		
	}
	
	public void mouseDragged(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		 mx = e.getX();
		 my = e.getY();
		 
//		 public Rectangle playButton = new Rectangle(MainGame.WIDTH/2 + 900, 150, 100, 50); 
//		    public Rectangle helpButton = new Rectangle(MainGame.WIDTH/2 + 900, 250, 100, 50); 
//		    public Rectangle quitButton = new Rectangle(MainGame.WIDTH/2 + 900, 350, 100, 50); 

		
		if(mx >= MainGame.WIDTH/2 + 900 && mx <= MainGame.WIDTH/2 + 1020) {
			if(my >= 150 && my <= 200) {
				MainGame.State = MainGame.STATE.GAME;
				Sound.music.stop();
			}
		}
		
		if(mx >= MainGame.WIDTH/2 + 900 && mx <= MainGame.WIDTH/2 + 1020) {
			if(my >= 350 && my <= 400) {
				MainGame.State = MainGame.STATE.QUIT;
			}
		}
//		public Rectangle tryAgain = new Rectangle(MainGame.WIDTH/2 + 1700, 10, 160, 50);
		if(mx >= MainGame.WIDTH/2 + 900 && mx <= MainGame.WIDTH/2 + 1020) {
			if(my >= 250 && my <= 300) {
				MainGame.State = MainGame.STATE.TIPS;
			}
		}
		
		if(mx >= MainGame.WIDTH/2 + 50 && mx <= MainGame.WIDTH/2 + 170) {
			if(my >= 900 && my <= 950) {
				MainGame.State = MainGame.STATE.MENU;
			}
		}
		if(mx >= MainGame.WIDTH/2 + 1700 && mx <= MainGame.WIDTH/2 + 1820) {
			if(my >= 70 && my <= 120) {
				MainGame.State = MainGame.STATE.QUIT;
			}
		}
		

	}
	
	
	
	public void keyPressed(KeyEvent e)
	{
		
		pressing[e.getKeyCode()] = true;		
	}
	
	public void keyReleased(KeyEvent e)
	{
		pressing[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e)
	{
		
	}
		

}