package fr.polytech.smtp.server.commands;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(RCPTTO.class.getName());

	/**
	 * The inboxes path.
	 */
	public static final String INBOXES_PATH = "inboxes" + File.separator;

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "RCPT TO";

	/**
	 * The command pattern.
	 */
	public static final Pattern COMMAND_PATTERN = Pattern.compile("RCPT TO: <(.*)>");

	/**
	 * Create an RCPT TO SMTP command.
	 */
	public RCPTTO() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String receivedCommand) {
		final Matcher matcher = COMMAND_PATTERN.matcher(receivedCommand);
		if (!matcher.find()) {
			return new InvalidParametersCommandResult();
		}

		final String recipientEmailAddress = matcher.group(1);
		if (recipientEmailAddress.isEmpty()) {
			return new InvalidParametersCommandResult();
		}

		final String recipient = recipientEmailAddress.split("@")[0];
		if (recipientExists(recipient)) {
			mailDropRequest.addRecipientEmailAdress(recipient);
			LOGGER.log(Level.INFO, "[SERVER] New recipient email address: " + recipient);

			return new OkCommandResult(mailDropRequest);
		}

		return new NoSuchUserCommandResult(mailDropRequest);
	}

	/**
	 * Check if a recipient exists locally.
	 * 
	 * @param recipient
	 *            The recipient.
	 * @return True if the recipient exists, else False.
	 */
	private boolean recipientExists(String recipient) {
		return new File(INBOXES_PATH + recipient).exists();
	}
}