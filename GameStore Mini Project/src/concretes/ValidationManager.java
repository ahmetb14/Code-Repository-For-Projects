package concretes;

import abstracts.ValidationService;
import entities.Player;

public class ValidationManager implements ValidationService {

	@Override
	public String confirm(Player player) {

		if (player.getTcNo().length() < 1) {

			return "TC Kimlik Numras� Alan� Bo� B�rak�lamaz!";

		} else {

			return "";

		}

	}

}
