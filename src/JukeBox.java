import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//lets get jazzy

public class JukeBox {

	static Clip Audio;
	
	JukeBox() {}
	
	static void PLAY (File SelectedAudio) {
		try {
			Audio = AudioSystem.getClip();
			Audio.open(AudioSystem.getAudioInputStream(SelectedAudio));
			Audio.start();
			
			//Thread.sleep(Audio.getMicrosecondLength()/1000);
		}
		catch (Exception e) {}
	}
	
	static void STOP () {
		Audio.stop();
		Audio.close();
		Audio.drain();
	}
	
	public static void main (String [] args) {
		File TestAudio = new File("assets/bgm/TestAudio.wav");
		PLAY(TestAudio);
	}
	
}
