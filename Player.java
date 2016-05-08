
public class Player implements Character{

	private int xpos;
	private int ypos;
	private int xvel;
	private int yvel;
	
	public Player(int x, int y, int xvel, int yvel){
		xpos = x;
		ypos = y;
		this.xvel = xvel;
		this.yvel = yvel;
	}
	
	@Override
	public void moveLeft() {
		xpos -= xvel;
		
	}

	@Override
	public void moveRight() {
		xpos += xvel;
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}
	
	public int getX(){
		return xpos;
	}
	
	public int getY(){
		return ypos;
	}
	
	public int getXvel(){
		return xvel;
	}
	
	public int getYvel(){
		return yvel;
	}

}
