/** 
 * Klasa odpowiedzialna za dzia�anie przeciwnik�w graczy - potwor�w.
 * Rozszerza klas� Actor. Potwory poruszaj� si� w poziomie i atakuj� strza�ami gracza.
 */
public class Monster extends Actor {
		/** 
		 * Pr�dko�� pozioma - wektor o jaki przesuwa si� stw�r w jednostce czasu.
		 */
	protected int vx;
		/** 
	 	* Liczba �ywych potwor�w na mapie.
	 	*/
	public static int LICZBA_POTWOROW = 0;
		/** 
		 * Punkty �ycia potwora.
		 */
	private int HP = 0;
		/** 
		 * Maksymalne punkty �ycia potwora.
		 */
	public static final int MAX_HP = 1;
		/** 
		 * Licznik zabitych potwor�w (przez gracza).
		 */
	public static int deathCounter = 0;
		/** 
		 * Konstruktor. W zale�no�ci od ilo�ci zabitych potwor�w,
		 * pojawiaj� si� istoty z wi�ksz� ilo�ci� punk�w �ycia.
		 * Po zabiciu 100 potwor�w nie pojawiaj� si� kolejne - rozgrywka z bossem.
		 */
	public Monster(Stage stage) {
		super(stage);

			if(deathCounter < 20 ){
				HP = MAX_HP ;
				setSpriteNames(new String[] {"evil.png", "evil1.png"});
				setFrameSpeed(10);
				currentFrame = 0;
			}
			if(deathCounter >= 20 && deathCounter < 40) {
				HP = (MAX_HP + 1);
				setSpriteNames(new String[] {"evil2.png", "evil3.png"});
				setFrameSpeed(10);
				currentFrame = 0;
			}								
			if(deathCounter >= 40 && deathCounter < 60){
				HP = (MAX_HP + 2); // 
				setSpriteNames(new String[] {"evil4.png", "evil5.png"});
				setFrameSpeed(10);
				currentFrame = 0;
			}
			if(deathCounter >= 60 && deathCounter < 80){
				HP = (MAX_HP + 3); // 
				setSpriteNames(new String[] {"evil10.png", "evil11.png"});
				setFrameSpeed(10);
				currentFrame = 0;
			}
			if(deathCounter >= 80 && deathCounter < 100){
				HP = (MAX_HP + 4); // 
				setSpriteNames(new String[] {"devil.png", "devil1.png"});
				setFrameSpeed(10);
				currentFrame = 0;
			}
			currentFrame = 0;
		}
		/** 
		 * Metoda u�ywa metody act() klasy nadrz�dnej.
		 * Okre�la spos�b poruszania oraz cz�stotliwo�� strza��w potwora.
		 */	
	public void act() { // sposob poruszania i zachowanie potwora
		super.act();
		x+=vx;
		if(x < 0 || x > Stage.SZEROKOSC - 60) {
			vx = -vx;
		}
		if((int)(Math.random() * 800) == 1) {
			fireMonster();
		}	
	}
		/** 
		 * Metoda pozwala na pojawianie si� nowych potwor�w.
		 * Nadaje im r�wnie� pr�dko�� i pozycje pocz�tkow�.
		 */	
	public void spawn() {
		
		if(LICZBA_POTWOROW < 20) {
			if(deathCounter < 99){
				Monster m = new Monster(stage);
				LICZBA_POTWOROW++;
				m.setX (  ((int)Math.random() * 1000 ));
				m.setY (  ((int)(Math.random() * 100) * 45 ) % 540);				
				m.setVx(   (int)(Math.random() * 7 ) + 2);
				stage.addActor(m);
				currentFrame=0;
				}
		}
	}
	/** 
	 * Metoda odpowiedzialna za tworzenie pocisk�w potwora.
	 */	
	public void fireMonster() { //strzelanie potwora zwyklego
		
		MonsterGun shoot = new MonsterGun(stage);
		shoot.setX(x + 10);
		shoot.setY(y + shoot.getHeight());
		stage.addActor(shoot);
		stage.getSoundCache().playSound("strzalpotwor.wav");	
	}
	
	public int  getVx()      {return vx; }
	public void setVx(int i) { vx = i;}
	/** 
	 * Metoda sprawdza, czy nast�pi�a kolizja potwora z innymi obiektami na mapie.  
	 */
	public void collision(Actor a) {
	
		if(a instanceof Gun) { //jesli kolizja potwora z instancja Gun
			
			HP -= 1;
			if(HP < 1){
				deathCounter++; //licznik zabojstw 
			remove();	//usuwanie potwora 
	
			if(deathCounter<80){
			spawn(); 
			}
			setSpriteNames(new String[]  {"bum2.png"});
			setFrameSpeed(10);
			LICZBA_POTWOROW--;
			}
			
			a.remove();//usuwanie strzalu
			stage.getSoundCache().playSound("boom.wav");
		
			if(((Gun)a).czyj == 1) {
				stage.getPlayer().addPoints(10);
			}
			if(((Gun)a).czyj == 2) {
				stage.getPlayer2().addPoints(10);
			}
			
			
			if(Gun.CURRENT_BULLETS>0) {
				Gun.CURRENT_BULLETS--;
			}
			currentFrame = 0;
		}
	
		
	if(a instanceof Bomb) { //jesli kolizja potwora z bomba
			
			HP -= 3; // bomba zbiera wiecej HP
			if(HP < 1) {
			remove(); // usuwanie potwora
			deathCounter++;
			setSpriteNames(new String[]  {"bum2.png"});
			setFrameSpeed(10);
			currentFrame=0;
			
			if(deathCounter < 80){
			spawn();
			
			LICZBA_POTWOROW--;
			}
			a.remove();		//usuwanie strzalu
			stage.getSoundCache().playSound("boom.wav");
			
			if(((Bomb)a).czyj == 1) { //czy bomba gracza 1 
				stage.getPlayer().addPoints(50);
				stage.getPlayer().getClusterBombs();
				
			}
			if(((Bomb)a).czyj == 2) { //czy bomba gracza 2
				stage.getPlayer2().addPoints(50);
				stage.getPlayer2().getClusterBombs();
				
			}	
			currentFrame = 0;
		}		
	}
		if(a instanceof Player ) { //zderzenie z graczem1
			
			deathCounter++;
		
			if(LICZBA_POTWOROW < 20) { if(deathCounter < 80) spawn();}
			setSpriteNames(new String[]  {"bum2.png"});
			setFrameSpeed(10);
			currentFrame = 0;
			}
		
			if(a instanceof Player2 ) { //zderzenie z graczem2
			
			deathCounter++;
			//stage.getSoundCache().playSound("boom.wav"); // niepotrzebne bo w Player te� nawala w tym momencie
		
			if(LICZBA_POTWOROW < 20) { if(deathCounter<80) spawn();} //liczba potworow na ekranie<20 i licznik zabojstw<80 to spawn()
			
			setSpriteNames(new String[]  {"bum2.png"});
			setFrameSpeed(10);
			currentFrame = 0;
			}
			
	}
}
