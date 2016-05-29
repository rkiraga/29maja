		/** 
		 * Klasa odpowiada za strza�y przeciwnik�w - potwor�w.  
		 * Rozszerza klas� Actor.
		 */
public class MonsterGun extends Actor {
		/** 
		 * Pr�dko�� pocisk�w - wektor o jaki przemieszczaj� si� w jednostce czasu.
		 */
	protected static final int BULLET_SPEED = 10;
		/** 
		 * Konstruktor. Wczytuje obrazy do animacji.  
		 */
	public MonsterGun(Stage stage)	{
		super(stage);
		setSpriteNames(new String[] {"monsterbullet.jpg", "monsterbullet1.jpg", "monsterbullet2.jpg","monsterbullet3.jpg"});
		setFrameSpeed(10);
	}
		/** 
		 * Metoda korzysta z metody act() klasy nadrzednej. Sprawdza czy pocisk nie "wylecia�" poza map�.  
		 */
	@Override
	public void act() {
		super.act();
		y+=BULLET_SPEED;
			if( y > Stage.WYSOKOSC )
			{
				remove();
			}
		
	}

}