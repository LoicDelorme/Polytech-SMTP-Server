package fr.polytech.smtp.server.commands;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.InvalidParametersCommandResult;
import fr.polytech.smtp.server.commands.results.ServerDomainCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an EHLO SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class EHLO extends Command {

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "EHLO";

	/**
	 * Create an EHLO SMTP command.
	 */
	public EHLO() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String[] parameters) {
		if (parameters.length != 1) {
			return new InvalidParametersCommandResult();
		}

		final MailDropRequest newMailDropRequest = new MailDropRequest();
		newMailDropRequest.setEmitterServerDomain(parameters[0]);

		return new ServerDomainCommandResult(newMailDropRequest);
	}
}