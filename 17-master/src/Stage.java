import java.awt.image.ImageObserver;

public interface Stage extends ImageObserver {
	public static final int SZEROKOSC = 1024;
	public static final int WYSOKOSC = 768;
	public static final int SZYBKOSC = 15;
	public static final int WYSOKOSC_GRY = 550;
	public SpriteCache getSpriteCache();
	public void addActor(Actor a);
	public Player getPlayer();
	public Player2 getPlayer2();
	public SoundCache getSoundCache();
	public void gameOver();
	public void gameWon();


}
