package abstracts;

import entities.Campaing;
import entities.Game;

public interface CampaingService {

	void add(Campaing campaing);

	void update(Campaing campaing);

	void delete(Campaing campaing);

	void use(Campaing campaing, Game game);

}
