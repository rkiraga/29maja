
public class Gun extends Actor {
	protected static final int BULLET_SPEED = 5;
	public static final int MAX_BULLETS = 5;	// moga teraz byc max 3 pociski
	public static int CURRENT_BULLETS = 0;
	public int czyj;

	public Gun(Stage stage)	{
		super(stage);
		setSpriteNames(new String[] {"bullet.jpg"});
		//setFrameSpeed(3);
			CURRENT_BULLETS++;

	}

	public void act() {
		super.act();
		y-=BULLET_SPEED;
			if( y < 0)	//jesli pocisk wypadl poza mape:
			{
				remove();
				CURRENT_BULLETS--;
			}
	}
}
