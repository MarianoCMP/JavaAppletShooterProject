

public class Robot extends Sprite
{
	static String[] pose = {"_up_", "_dn_", "_lt_", "_rt_"};
	
	
	
	
	public Robot(int x, int y, int w, int h)
	{
		super(x, y, w, h, "B", pose, 9, "png", 3, 700);
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	


}