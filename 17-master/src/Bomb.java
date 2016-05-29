
public class Bomb extends Actor{

	public static final int Up_Left = 0;
	public static final int Up = 1;
	public static final int Up_Right= 2;
	public static final int Right = 3;
	public static final int Down_Right = 4;
	public static final int Down = 5;
	public static final int Down_Left = 6;
	public static final int Left = 7;
	
	public int czyj;
	
	protected static final int Bomb_Speed = 5;
	protected int vx;
	protected int vy;
	
	public Bomb(Stage stage, int heading, int x, int y, int czyj) {
		super(stage);
		
		this.x = x + 20;
		this.y = y + 20;
		this.czyj = czyj;
		
		
		switch(heading) {
			case Up_Left: 	 vx = -Bomb_Speed; 	vy = -Bomb_Speed; 	setSpriteNames(new String[] {"r8.png"}); break;
			case Up: 		 vx = 0; 			vy = -Bomb_Speed; 	setSpriteNames(new String[] {"r1.png"}); break;
			case Up_Right: 	 vx = Bomb_Speed; 	vy = -Bomb_Speed; 	setSpriteNames(new String[] {"r5.png"}); break;
			case Right: 	 vx = Bomb_Speed; 	vy = 0; 			setSpriteNames(new String[] {"r2.png"}); break;
			case Down_Right: vx = Bomb_Speed; 	vy = Bomb_Speed; 	setSpriteNames(new String[] {"r6.png"}); break;
			case Down: 		 vx = 0; 			vy = Bomb_Speed; 	setSpriteNames(new String[] {"r3.png"}); break;
			case Down_Left:  vx = -Bomb_Speed; 	vy = Bomb_Speed;	setSpriteNames(new String[] {"r7.png"}); break;
			case Left: 		 vx = -Bomb_Speed; 	vy = 0; 			setSpriteNames(new String[] {"r4.png"}); break;
		}
	}
	
	public void act() {
		super.act();
		y+=vy;
		x+=vx;
		if(y < 0 || y > Stage.WYSOKOSC || x < 0 || x > Stage.SZEROKOSC) remove();
	}
}
