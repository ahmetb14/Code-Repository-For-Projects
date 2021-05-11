package abstracts;

import entities.Game;
import entities.Player;

public interface PlayerService {

	void login(Player player);

	void register(Player player);

	void logout(Player player);

	void buyGame(Player player, Game game);

}
