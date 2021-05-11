package concretes;

import abstracts.GameService;
import entities.Game;

public class GameManager implements GameService {

	@Override
	public void add(Game game) {

		System.out.println(game.getName() + " �simli Oyun Eklendi!");

	}

	@Override
	public void update(Game game) {

		System.out.println(game.getName() + " �simli Oyun G�ncellendi!");

	}

	@Override
	public void delete(Game game) {

		System.out.println(game.getName() + " �simli Oyun Silindi!");

	}

	@Override
	public void play(Game game) {

		System.out.println(game.getName() + " �simli Oyun Oynan�yor!");

	}

}
