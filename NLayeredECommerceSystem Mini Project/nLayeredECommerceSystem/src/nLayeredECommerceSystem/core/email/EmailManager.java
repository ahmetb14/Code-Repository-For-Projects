package nLayeredECommerceSystem.core.email;

public class EmailManager implements EmailService {

	@Override
	public void transmitting(String message, String email) {

		System.out.println(email + " > Kayıtlı Email Adresine " + message + " Gönderildi!");

	}

}
