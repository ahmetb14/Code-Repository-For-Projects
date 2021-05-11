package abstracts;

import entities.Game;

public interface GameService {

	void add(Game game);

	void update(Game game);

	void delete(Game game);

	void play(Game game);

}
