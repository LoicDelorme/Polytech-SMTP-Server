package fr.polytech.smtp.server.commands;

import java.io.File;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.InvalidParametersCommandResult;
import fr.polytech.smtp.server.commands.results.NoSuchUserCommandResult;
import fr.polytech.smtp.server.commands.results.OkCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a RCPT TO SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class RCPTTO extends Command {

	/**
	 * The inboxes path.
	 */
	private static final String INBOXES_PATH = "inboxes" + File.separator;

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "RCPT TO:";

	/**
	 * Create a RCPT TO SMTP command.
	 */
	public RCPTTO() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String[] parameters) {
		if (parameters.length != 1) {
			return new InvalidParametersCommandResult();
		}

		final String recipientUsername = parameters[0].split("@")[0];
		if (userExists(recipientUsername)) {
			mailDropRequest.addRecipientEmailAdress(recipientUsername);
			return new OkCommandResult(mailDropRequest);
		}

		return new NoSuchUserCommandResult(mailDropRequest);
	}

	/**
	 * Check if a user exists locally.
	 * 
	 * @param recipientUsername
	 *            The recipient username.
	 * @return True if the user exists, else False.
	 */
	private boolean userExists(String recipientUsername) {
		final File inbox = new File(INBOXES_PATH + recipientUsername);
		return inbox.exists();
	}
}