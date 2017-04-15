package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.SmtpServer;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a start mail input command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class StartMailInputCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = String.format("354 Start Mail input; end with \r\n%s", SmtpServer.SERVER_EMAIL_END_CHARACTER);

	/**
	 * Create a start mail input command result.
	 */
	public StartMailInputCommandResult() {
		super(CommandResultStatus.SUCCESS, MESSAGE);
	}

	/**
	 * Create a start mail input command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public StartMailInputCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.SUCCESS, MESSAGE, mailDropRequest);
	}
}