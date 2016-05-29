public class MonsterGun extends Actor {
	protected static final int BULLET_SPEED = 10;
	
	public MonsterGun(Stage stage)	{
		super(stage);
		setSpriteNames(new String[] {"monsterbullet.jpg", "monsterbullet1.jpg", "monsterbullet2.jpg","monsterbullet3.jpg"});
		setFrameSpeed(10);
	}
	public void act() {
		super.act();
		y+=BULLET_SPEED;
			if( y > Stage.WYSOKOSC ) //jesli pocisk wypadl poza mape:
			{
				remove();
			}
		
	}

}
