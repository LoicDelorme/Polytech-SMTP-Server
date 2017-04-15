package fr.polytech.smtp.server.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.StartMailInputCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a DATA SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class DATA extends Command {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(DATA.class.getName());

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "DATA";

	/**
	 * Create a DATA SMTP command.
	 */
	public DATA() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String receivedCommand) {
		LOGGER.log(Level.INFO, "[SERVER] Data will be transmitted");
		return new StartMailInputCommandResult(mailDropRequest);
	}
}