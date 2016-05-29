import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundCache extends ResourceCache{
		/** 
		 * Za�adowanie pliku jako zasobu do appletu.
		 */
	protected Object loadResource(URL url){
			return Applet.newAudioClip(url);
			}
		/** 
		 * Wczytanie pliku d�wi�kowego z katalogu "sound/".  
		 */
	public AudioClip getAudioClip(String name){
			return (AudioClip)getResource("sound/"+name);
			}
		/** 
		 * Odtworzenie pliku.  
		 */
	public void playSound(final String name) {
			getAudioClip(name).play();
			}
		/** 
		 * Zatrzymanie odtwarzania pliku.  
		 */
	public void stopSound(final String name) {
			getAudioClip(name).stop();
			}
		/** 
		 * Zap�tlenie odtwarzania. 
		 */
		public void loopSound(final String name) {
			getAudioClip(name).loop();
			}
}
