package fr.polytech.smtp.server.commands;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.InvalidParametersCommandResult;
import fr.polytech.smtp.server.commands.results.OkCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a DATA SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class DATA extends Command {

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
	public CommandResult execute(MailDropRequest mailDropRequest, String[] parameters) {
		if (parameters.length != 1) {
			return new InvalidParametersCommandResult();
		}

		mailDropRequest.appendEmailContent(parameters[0]);

		return new OkCommandResult();
	}
}