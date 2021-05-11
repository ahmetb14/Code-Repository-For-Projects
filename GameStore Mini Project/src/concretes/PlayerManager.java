package concretes;

import abstracts.PlayerService;
import abstracts.ValidationService;
import entities.Game;
import entities.Player;

public class PlayerManager implements PlayerService {

	ValidationService validationService;

	public PlayerManager(ValidationService validationService) {

		this.validationService = validationService;

	}

	@Override
	public void login(Player player) {

		if (this.validationService.confirm(player).length() < 1) {

			System.out.println(player.getFirstName() + " => Sisteme Giriþ Yaptý!");

		} else {
			System.out.println(this.validationService.confirm(player));
		}

	}

	@Override
	public void register(Player player) {

		System.out.println(player.getFirstName() + " => Sisteme Kayýt Yaptý!");

	}

	@Override
	public void logout(Player player) {

		System.out.println(player.getFirstName() + " => Sistemden Çýkýþ Yapýldý!");

	}

	@Override
	public void buyGame(Player player, Game game) {

		System.out.println(player.getFirstName() + " " + game.getName() + " Ýsimli Oyunu Satýn Aldý!");

	}

}
