package fr.polytech.smtp.server.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.InvalidParametersCommandResult;
import fr.polytech.smtp.server.commands.results.OkCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a MAIL FROM SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MAILFROM extends Command {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(MAILFROM.class.getName());

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "MAIL FROM";

	/**
	 * The command pattern.
	 */
	public static final Pattern COMMAND_PATTERN = Pattern.compile("MAIL FROM <(.*)>");

	/**
	 * Create a MAIL FROM SMTP command.
	 */
	public MAILFROM() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String receivedCommand) {
		final Matcher matcher = COMMAND_PATTERN.matcher(receivedCommand);
		if (!matcher.find()) {
			return new InvalidParametersCommandResult();
		}

		final String emitterEmailAddress = matcher.group(1);
		if (emitterEmailAddress.isEmpty()) {
			return new InvalidParametersCommandResult();
		}

		mailDropRequest.setEmitterEmailAddress(emitterEmailAddress);
		LOGGER.log(Level.INFO, "[SERVER] Emitter email address: " + emitterEmailAddress);

		return new OkCommandResult(mailDropRequest);
	}
}