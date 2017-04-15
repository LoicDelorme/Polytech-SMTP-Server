package fr.polytech.smtp.server.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.OkCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a RSET SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class RSET extends Command {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(RSET.class.getName());

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "RSET";

	/**
	 * Create a RSET SMTP command.
	 */
	public RSET() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String receivedCommand) {
		LOGGER.log(Level.INFO, "[SERVER] Mail drop request reset");
		return new OkCommandResult();
	}
}