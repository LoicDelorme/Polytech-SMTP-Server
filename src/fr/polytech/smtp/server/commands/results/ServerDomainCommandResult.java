package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.SmtpServer;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a server domain command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class ServerDomainCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = String.format("250 %s", SmtpServer.SERVER_DOMAIN);

	/**
	 * Create a server domain command result.
	 */
	public ServerDomainCommandResult() {
		super(CommandResultStatus.SUCCESS, MESSAGE);
	}

	/**
	 * Create a server domain command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public ServerDomainCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.SUCCESS, MESSAGE, mailDropRequest);
	}
}