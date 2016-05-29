import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.ImageObserver;






public class SpriteCache extends ResourceCache implements ImageObserver
{
	
	public HashMap<String, Object> sprites;
	
	public SpriteCache() {
		
	sprites = new HashMap<String, Object>();
	}
	
	private BufferedImage loadImage(String sciezka) {
		URL url = null;
			try {
				url = getClass().getClassLoader().getResource(sciezka);
				return ImageIO.read(url);
				} 
			catch (Exception e) {
				System.out.println("Przy otwieraniu " + sciezka +" jako " + url);
				System.out.println("Wystapil blad : "+e.getClass().getName()+""+e.getMessage());
				System.exit(0);
				return null;
				}
		}
	
	
	
	
	
	public BufferedImage createCompatible(int width, int height, int transparency) {
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage compatible = gc.createCompatibleImage(width, height, transparency);
		return compatible;
	}
	
	
	
	public BufferedImage getSprite(String sciezka) {
		BufferedImage loaded = (BufferedImage)getResource(sciezka);
		BufferedImage compatible = createCompatible(loaded.getWidth(), loaded.getHeight(), Transparency.BITMASK);
		Graphics g = compatible.getGraphics();
		g.drawImage(loaded,  0, 0, this);
		return compatible;		
	}
	
	
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
		return (infoflags & (ALLBITS|ABORT)) == 0;
	}
	
	/*

	public BufferedImage getSprite(String sciezka) {
		BufferedImage img = (BufferedImage)sprites.get(sciezka);
		if(img == null)
		{
			img = loadImage(sciezka);
			sprites.put(sciezka, img);
		}
		return img;
	}
	*/
	
	protected Object loadResource(URL url) {
			try {
			return ImageIO.read(url);
			} 
			catch (Exception e) {
			System.out.println("Przy otwieraniu " + url);
			System.out.println("Wystapil blad : " + e.getClass().getName()+"" + e.getMessage());
			System.exit(0);
			return null;
			}
		}


}
	

