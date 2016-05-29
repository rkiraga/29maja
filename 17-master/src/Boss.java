
public class Boss extends Actor {

	protected int vx;
	protected int vy;
	static final int SHIP_SPEED = 1; 
	public static final int MAX_HEALTH = 200;
	private static int HP;

	public Boss (Stage stage) {
		super(stage);
		setSpriteNames(new String[] {"bos.png"});   //,"boss2.png", "boss3.png", "boss4.png"} ); //wczytanie statku
		setFrameSpeed(10);
		HP = MAX_HEALTH;
	}
public void fireBoss() {
		
		BossGun shoot = new BossGun(stage);
		shoot.setX(x + 10);
		shoot.setY(y + shoot.getHeight());
		stage.addActor(shoot);
		stage.getSoundCache().playSound("strzalpotwor.wav");
	}

public void fireBossCluster() {
	
	stage.addActor(new BossGun(stage, BossGun.Up_Left, x, y));
	stage.addActor(new BossGun(stage, BossGun.Up, x, y));
	stage.addActor(new BossGun(stage, BossGun.Up_Right, x, y));
	stage.addActor(new BossGun(stage, BossGun.Left, x, y));
	stage.addActor(new BossGun(stage, BossGun.Right, x, y));
	stage.addActor(new BossGun(stage, BossGun.Down_Left, x, y));
	stage.addActor(new BossGun(stage, BossGun.Down, x, y));
	stage.addActor(new BossGun(stage, BossGun.Down_Right, x, y));
	
}

	public void setVx(int i) { vx = i; }
	public void setVy(int i) { vy = i; }
	
	public void act() {
		super.act();
		x+=vx;
		y+=vy;
		if(x < 0 || x > Stage.SZEROKOSC - 100) {
			vx = -vx;
		}
		if(y < 0 || y > Stage.WYSOKOSC - 500) {
			vy = -vy;
		}
		if((int)(Math.random() * 30) == 1){
			fireBoss();
		}
		if((int)(Math.random() * 400) == 1){
			fireBossCluster();
		}
	}
	
	public static int  getHp() { return HP;}

	public void collision(Actor a) {
		
		if(a instanceof Gun ) {
	
			HP-=5; // zwykla bron zabiera 5 HP BOSSA
			if(HP < 1) {
				remove();
				setSpriteNames(new String[] {"bum2.png"});
				setFrameSpeed(10);
				currentFrame = 0;
				stage.gameWon();
			}
			
			a.remove();	//usuwanie strzalu
			stage.getSoundCache().playSound("boom.wav");		//jakis iny dzwiek
			if(((Gun)a).czyj == 1) {
				stage.getPlayer().addPoints(20);
			}
			if(((Gun)a).czyj == 2) {
				stage.getPlayer2().addPoints(20);
			}
		
			if(Gun.CURRENT_BULLETS>0) {
				Gun.CURRENT_BULLETS--;
			}
			currentFrame = 0;
		}
	if(a instanceof Bomb) {
		
		HP-=10; //bomba zabiera 10 HP
		if(HP < 1){
			remove(); // jesli HP BOSSA < 1 usun go 
			setSpriteNames(new String[]  {"wybuch.png"});
			setFrameSpeed(10);
			currentFrame = 0;
			stage.gameWon();
		}
		a.remove(); // usuwanie bomby po strzale
		if(((Bomb)a).czyj == 1) {
			stage.getPlayer().addPoints(50);
			stage.getPlayer().getClusterBombs();
			
		}
		if(((Bomb)a).czyj == 2) {
			stage.getPlayer2().addPoints(50);
			stage.getPlayer2().getClusterBombs();
	}
		currentFrame = 0;
}
		
	if(a instanceof Player ){
		
			HP -= 20;
			if(HP < 1) {
				remove();
				setSpriteNames(new String[] {"wybuch.png"});
				setFrameSpeed(10);
				currentFrame = 0;
			}
			stage.getSoundCache().playSound("boom.wav");
			stage.getPlayer().addPoints(50);
			//stage.gameOver();
			stage.gameWon();
		}
	if(a instanceof Player2 ){
		
			HP -= 20;
			if(HP < 1) {
				remove();
				setSpriteNames(new String[] {"wybuch.png"}); 
				setFrameSpeed(10);
				currentFrame = 0;
				stage.gameWon();
				
			}
			stage.getSoundCache().playSound("boom.wav");
			stage.getPlayer2().addPoints(50);
			//stage.gameOver();
			}
		}	
}


	
