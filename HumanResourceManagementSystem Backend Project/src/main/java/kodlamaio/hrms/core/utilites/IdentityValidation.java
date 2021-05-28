package kodlamaio.hrms.core.utilites;

import kodlamaio.hrms.mernisSimulation.MernisSimulation;

public class IdentityValidation {

	public static boolean isRealPerson(String tcno) {

		MernisSimulation mernisSimulation = new MernisSimulation();

		return mernisSimulation.Validation(tcno);

	}

}
