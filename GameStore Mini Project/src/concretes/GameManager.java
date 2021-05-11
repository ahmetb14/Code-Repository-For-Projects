package concretes;

import abstracts.GameService;
import entities.Game;

public class GameManager implements GameService {

	@Override
	public void add(Game game) {

		System.out.println(game.getName() + " Ýsimli Oyun Eklendi!");

	}

	@Override
	public void update(Game game) {

		System.out.println(game.getName() + " Ýsimli Oyun Güncellendi!");

	}

	@Override
	public void delete(Game game) {

		System.out.println(game.getName() + " Ýsimli Oyun Silindi!");

	}

	@Override
	public void play(Game game) {

		System.out.println(game.getName() + " Ýsimli Oyun Oynanýyor!");

	}

}
