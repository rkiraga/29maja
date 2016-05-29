import java.awt.image.ImageObserver;
	/** 
	 * Interfejs porz�dkuj�cy obiekty na planszy.
	 */
public interface Stage extends ImageObserver {
		/** 
		 * Szeroko�� okna.
		 */
	public static final int SZEROKOSC = 1024;
		/** 
		 * Wysoko�� okna.
		 */
	public static final int WYSOKOSC = 768;
		/** 
		 * Pr�dko�� rozgrywki.
		 */
	public static final int SZYBKOSC = 15;
		/** 
		 * Wysoko��, na jak� mo�e maksymalnie wylecie� statek gracza.
		 */
	public static final int WYSOKOSC_GRY = 550;
	public SpriteCache getSpriteCache();
	public void addActor(Actor a);
	public Player getPlayer();
	public Player2 getPlayer2();
	public SoundCache getSoundCache();
	public void gameOver();
	public void gameWon();


}
