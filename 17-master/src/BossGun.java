
public class BossGun extends Actor {
	protected static final int BULLET_SPEED = 10;
	protected static final int Bomb_Speed = 4;
	protected int vx;
	protected int vy;
	private double u;
	public static final int Up_Left = 0;
	public static final int Up = 1;
	public static final int Up_Right= 2;
	public static final int Right = 3;
	public static final int Down_Right = 4;
	public static final int Down = 5;
	public static final int Down_Left = 6;
	public static final int Left = 7;
	
	
	public BossGun(Stage stage)	{ //wybiera z jakiej broni strzelic
		super(stage);
		u = Math.random();
		if(u < 0.4){
		setSpriteNames(new String[] {"BossBullet.png", "BossBullet1.png"});
		setFrameSpeed(10);
		currentFrame = 0;
		}
		if(u >= 0.4) {
			setSpriteNames(new String[] {"monsterbullet.jpg", "monsterbullet1.jpg", "monsterbullet2.jpg","monsterbullet3.jpg"});
			setFrameSpeed(10);
			currentFrame = 0;
		}
		
	}
	
	public BossGun(Stage stage, int heading, int x, int y){ // strzela tez bombami, w Boss.java funkcja fireBossCluster i potem randomowa szybkosc
		super(stage);
		
		this.x = x;
		this.y = y;
		
		switch(heading) {
		case Up_Left: 	 vx = -Bomb_Speed; 	vy = -Bomb_Speed; 	setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Up: 		 vx = 0; 			vy = -Bomb_Speed; 	setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Up_Right: 	 vx = Bomb_Speed; 	vy = -Bomb_Speed; 	setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Right: 	 vx = Bomb_Speed; 	vy = 0; 			setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Down_Right: vx = Bomb_Speed; 	vy = Bomb_Speed; 	setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Down: 		 vx = 0; 			vy = Bomb_Speed; 	setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Down_Left:  vx = -Bomb_Speed; 	vy = Bomb_Speed;	setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
		case Left: 		 vx = -Bomb_Speed; 	vy = 0; 			setSpriteNames(new String[] {"specialBoss.png", "specialBoss1.png"}); break;
	}
	}
	public void act() {
		super.act();
		y+=vy;
		x+=vx;
		y+=BULLET_SPEED;
			if( y > Stage.WYSOKOSC || x < 0 || x > Stage.SZEROKOSC) //jesli pocisk wypadl poza mape:
			{
				remove();
			}
	}

}


