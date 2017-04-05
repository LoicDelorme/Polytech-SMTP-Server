package fr.polytech.smtp.server.commands;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.SmtpServiceClosingCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a QUIT SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class QUIT extends Command {

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "QUIT";

	/**
	 * Create a QUIT SMTP command.
	 */
	public QUIT() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String[] parameters) {
		return new SmtpServiceClosingCommandResult();
	}
}