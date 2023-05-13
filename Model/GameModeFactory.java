package Model;

public class GameModeFactory {
	public GameMode getGameMode(String mode) {
		if(mode.equals("s"))
			return new SingleMode();
		if(mode.equals("m"))
			return new MultiMode();
		return null;
		
	}

}
