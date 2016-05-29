import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
public class SoundCache extends ResourceCache{
protected Object loadResource(URL url) {
return Applet.newAudioClip(url);
}
public AudioClip getAudioClip(String name) {
return (AudioClip)getResource("sound/"+name);
}
public void playSound(final String name) {
getAudioClip(name).play();
}
public void stopSound(final String name) {
getAudioClip(name).stop();
}
public void loopSound(final String name) {
getAudioClip(name).loop();
}
}
