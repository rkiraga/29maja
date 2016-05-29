		 /** 
		 * Klasa jest odpowiedzialna za strza�y gracza. Dziedziczy po klasie Actor.
		 */
public class Gun extends Actor {
		/** 
		 * Szybko�� pocisk�w - wektor o jaki przesuwaj� si� w jednostce czasu. 
		 */
	protected static final int BULLET_SPEED = 5;
		/** 
		 * Pocz�tkowa maksymalna liczba pocisk�w graczy. 
		 */
	public static final int MAX_BULLETS = 5;
	 	/** 
	 	 * Liczba pocisk�w graczy znajduj�cych si� na mapie. 
	 	 */
	public static int CURRENT_BULLETS = 0;
		/** 
		 * Pole okre�laj�ce kt�ry z graczy wystrzeli� pocisk. 
		 */
	public int czyj;
		/** 
		 * Konstruktor. Wczytuje obraz i zwi�ksza liczb� obecnych pocisk�w.  
		 */
	public Gun(Stage stage)	{
		super(stage);
		setSpriteNames(new String[] {"bullet.jpg"});
		//setFrameSpeed(3);
			CURRENT_BULLETS++;
	}
		/** 
		 * Metoda wykorzystuje metod� act klasy matki oraz sprawdza czy pocisk nie "wylecia�" poza map�.
		 */
	@Override
	public void act() {
		super.act();
		y-=BULLET_SPEED;
			if( y < 0)
			{
				remove();
				CURRENT_BULLETS--;
			}
	}
}