/** 
* Klasa odpowiedzialna za strza�y bossa.  
*/
public class BossGun extends Actor {
	/** 
	 * Pr�dko�� pocisk�w bossa - d�ugo�� wektora, o jaki przesuwaj� si� w jednostce czasu. 
	 */
	protected static final int BULLET_SPEED = 10;
	/** 
	 * Pr�dko�� bomb bossa - wektor o jaki przesuwaj� si� w jednostce czasu. 
	 */
	protected static final int Bomb_Speed = 4;
	/** 
	 * Pr�dko�� pozioma bossa - wektor o jaki przesuwa si� w jednostce czasu.
	 */
	protected int vx;
	/** 
	 * Pr�dko�� pionowa bossa - wektor o jaki przesuwa si� w jednostce czasu.
	 */
	protected int vy;
	
	private double u;//trzeba zmienic nazwe
	//??????????????????????????????????????????????
	//????????????????????
	//????????
	//????????
	//????????????????????
	//????????
	//????????
	//????????????????????
	//????????
	//????????
	public static final int Up_Left = 0;
	public static final int Up = 1;
	public static final int Up_Right= 2;
	public static final int Right = 3;
	public static final int Down_Right = 4;
	public static final int Down = 5;
	public static final int Down_Left = 6;
	public static final int Left = 7;
	
	/** 
	 * Konstruktor, kt�ry tworzy wybrany losowo wystrza�.
	 * �aduje odpowiednie obrazy. Korzysta z metody act() z klasy Actor.
	 */
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
	/** 
	 *OPISZCZCIE LADNIE NIE CHCE MI SIE WCZYTYWAC
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */
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
	
	/** 
	 * Metoda korzysta z metody act() klasy nadrz�dnej.
	 * "Usuwa" strza� je�li wypad� poza map�.
	 */
	@Override
	public void act() {
		super.act();
		y+=vy;
		x+=vx;
		y+=BULLET_SPEED;
			if( y > Stage.WYSOKOSC || x < 0 || x > Stage.SZEROKOSC)
			{
				remove();
			}
	}

}


