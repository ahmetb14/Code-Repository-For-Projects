package kodlamaio.hrms.core.utilites;

import java.util.Random;

public class GenerateRandomCode {

	public String Create(Integer id) {

		String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "İ", "I", "J", "K", "L", "M", "N", "O", "Ö", "P",
				"R", "S", "Ş", "T", "U", "Ü", "V", "Y", "Z" };

		String dogrulamaKodu = "";

		for (int k = 0; k < alphabet.length; k++) {

			Random r = new Random();
			int randomNumber = r.nextInt(alphabet.length);
			int randomNumber2 = r.nextInt(alphabet.length);

			int random = (int) Math.floor(Math.random() * 9999);
			dogrulamaKodu = alphabet[randomNumber] + "" + id + "" + alphabet[randomNumber2] + "" + random;

		}

		return dogrulamaKodu;

	}

}
