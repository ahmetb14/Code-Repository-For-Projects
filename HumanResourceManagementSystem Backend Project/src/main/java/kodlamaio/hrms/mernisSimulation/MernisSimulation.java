package kodlamaio.hrms.mernisSimulation;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MernisSimulation {

	public boolean Validation(String tcNo) {

		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(tcNo);

		if (tcNo.length() > 11) {

			return false;

		} else if (matcher.matches() && !tcNo.startsWith("0")) {

			return true;

		} else {

			return false;

		}
	}

}
//Replace if you get the error: public "static" boolean change!