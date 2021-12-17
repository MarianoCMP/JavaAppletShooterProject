public class Soldier extends Sprite
{
	static String[] pose = {"_up_", "_dn_","_lt_","_rt_"};
	
	
	
	
	public Soldier(int x, int y, int w, int h)
	{
		super(x, y, w, h, "S", pose, 11, "png", 4, 700);
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	


}