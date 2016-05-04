package auxCommand;

import game.InfoRound;
import player.PlayersList;

public class EliminatePlayers implements AuxCommand {
	private PlayersList playersList;
	private InfoRound infoRound;
	
	public EliminatePlayers(PlayersList playersList,InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}
	
	@Override
	public void execute() {
		this.playersList.eliminatePlayers();;
	}
	
}
