/*Chase by Alexander Nakarada | https://www.serpentsoundstudios.com
Music promoted by https://www.chosic.com/free-music/all/
Attribution 4.0 International (CC BY 4.0)
https://creativecommons.org/licenses/by/4.0/
*/

import java.applet.AudioClip;
import java.net.URL;
public class Sound {

	URL url;
	static MainGame sp;
	static AudioClip music, shot, sshoot, rshoot, jump;
	
	
	public Sound(MainGame sp) {
		
		try {
			url = sp.getDocumentBase();
		}catch(Exception e) {
			
		}
		music = sp.getAudioClip(url, "music/menumusic.au");
		shot = sp.getAudioClip(url, "music/shot.au");
		sshoot = sp.getAudioClip(url, "music/sshoot.au");
		rshoot = sp.getAudioClip(url, "music/rshoot.au");
		jump = sp.getAudioClip(url, "music/robotjump.au");
	}
}