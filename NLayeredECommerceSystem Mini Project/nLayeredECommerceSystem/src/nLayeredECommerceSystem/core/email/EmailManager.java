package nLayeredECommerceSystem.core.email;

public class EmailManager implements EmailService {

	@Override
	public void transmitting(String message, String email) {

		System.out.println(email + " > Kay�tl� Email Adresine " + message + " G�nderildi!");

	}

}
