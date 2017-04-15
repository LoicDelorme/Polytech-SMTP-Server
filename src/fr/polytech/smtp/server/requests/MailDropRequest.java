package fr.polytech.smtp.server.requests;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an SMTP mail drop request.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MailDropRequest {

	/**
	 * The emitter email address.
	 */
	private String emitterEmailAddress;

	/**
	 * The recipients email addresses.
	 */
	private final List<String> recipientsEmailAdresses;

	/**
	 * The email content.
	 */
	private final StringBuilder emailContent;

	/**
	 * Create an SMTP mail drop request.
	 */
	public MailDropRequest() {
		this.emitterEmailAddress = null;
		this.recipientsEmailAdresses = new ArrayList<String>();
		this.emailContent = new StringBuilder();
	}

	/**
	 * Get the emitter email address.
	 * 
	 * @return The emitter email address.
	 */
	public String getEmitterEmailAddress() {
		return this.emitterEmailAddress;
	}

	/**
	 * Set the emitter email address.
	 * 
	 * @param emitterEmailAddress
	 *            The emitter email address.
	 */
	public void setEmitterEmailAddress(String emitterEmailAddress) {
		this.emitterEmailAddress = emitterEmailAddress;
	}

	/**
	 * Get the recipients email addresses.
	 * 
	 * @return The recipients email addresses.
	 */
	public List<String> getRecipientsEmailAdresses() {
		return this.recipientsEmailAdresses;
	}

	/**
	 * Add a recipient email address.
	 * 
	 * @param recipientEmailAdress
	 *            The recipient email address.
	 */
	public void addRecipientEmailAdress(String recipientEmailAdress) {
		this.recipientsEmailAdresses.add(recipientEmailAdress);
	}

	/**
	 * Get the email content.
	 * 
	 * @return The email content.
	 */
	public String getEmailContent() {
		return this.emailContent.toString();
	}

	/**
	 * Append some contents to the global email content.
	 * 
	 * @param content
	 *            The content to append.
	 */
	public void appendEmailContent(String content) {
		this.emailContent.append(content);
	}
}