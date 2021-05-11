package consoleUI;

import concretes.CampaingManager;
import concretes.GameManager;
import concretes.PlayerManager;
import concretes.ValidationManager;
import entities.Campaing;
import entities.Game;
import entities.Player;

public class Main {

	public static void main(String[] args) {

		PlayerManager playerManager = new PlayerManager(new ValidationManager());
		Player player1 = new Player(1, "=> Ahmet Berkay", "Y�lmaz", 19, "78945674189", "20.12.2002");

		CampaingManager campaingManager = new CampaingManager();
		Campaing campaing1 = new Campaing(4, "=> Yeni Y�l Kampanyas�", 200);

		GameManager gameManager = new GameManager();
		Game game1 = new Game(7, "=> Forza Horizon 4", 400);
		Game game2 = new Game(8, "=> Call of Duty: WWII", 300);

		System.out.println("************************************************************************");
		System.out.println("              -> Oyun Ma�azas�na Ho� Geldiniz <-");
		System.out.println("************************************************************************");
		System.out.println("------------------------------------------------------------------------");

		System.out.println();
		campaingManager.add(campaing1);
		System.out.println();
		playerManager.register(player1);
		System.out.println();
		playerManager.login(player1);
		System.out.println();
		playerManager.buyGame(player1, game1);
		System.out.println();
		gameManager.add(game1);
		System.out.println();
		gameManager.update(game2);
		System.out.println();
		campaingManager.use(campaing1, game1);
		System.out.println();

		System.out.println("------------------------------------------------------------------------");
		System.out.println("************************************************************************");
		System.out.println("               !All R�ghts Reserved 2020-2021! ");
		System.out.println("************************************************************************");

	}

}
