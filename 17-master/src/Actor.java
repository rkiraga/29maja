import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Actor {
	
	protected int x,y;
	protected int width, height;
	protected String spriteName;
	protected Stage stage;
	protected SpriteCache spriteCache;
	protected boolean TrashObject;

	protected int currentFrame;
	protected String[] spriteNames;
	
	protected int frameSpeed;
	protected int t;
	
		
	public Actor (Stage stage) {
		this.stage = stage;
		spriteCache = stage.getSpriteCache();
		currentFrame = 0;
		frameSpeed = 1;
		t = 0;
	}
	
	public int  getFrameSpeed() { return frameSpeed; }
	public void setFrameSpeed(int i) { frameSpeed = i; }
	
	
	public void paint(Graphics2D g){
		//currentFrame = 0;
		g.drawImage( spriteCache.getSprite(spriteNames[currentFrame]), x, y, stage);

	}
	
	public int getX() { return x;}
	public void setX(int i){x = i;}
	public int getY() {return y;}
	public void setY(int i) {y = i;}
	
	public void remove() {
		TrashObject = true;
	}
	public boolean isTrashObject() {
		return TrashObject;
	}
	
	public String getSpriteName() {return spriteName;}
	
	public void setSpriteNames(String[] names) {
		spriteNames = names;
		height = 0;
		width = 0;
		
		for(int i =0 ; i < names.length; i++) {
			BufferedImage image = spriteCache.getSprite(spriteNames[i]);
			height = Math.max(height, image.getHeight());
			width = Math.max(width, image.getWidth());		
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x, y, width, height);
	}
	public void collision(Actor a) { }
	
	public int  getHeight()    	 {return height; }
	public int  getWidth()  	 {return width;}
	public void setHeight(int i) {height = i;}
	public void setWidth(int i)  {width = i;}
	
	public void act(){
		t++;
		if(t % frameSpeed == 0){
			t = 0;
			currentFrame = (currentFrame + 1) % spriteNames.length;
		}
	}
	
	
}
