package kodlamaio.hrms.core.utilites;

import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.mernisSimulation.MernisSimulation;

public class IdentityValidation {

	public static Result isRealPerson(String tcno) {

		if (MernisSimulation.Validation(tcno) == true) {

			return new SuccessResult();

		}

		return new ErrorResult(" -> Türkiye Cumhuriyeti Kimliği Olmak Zorundadır!");

	}

}
