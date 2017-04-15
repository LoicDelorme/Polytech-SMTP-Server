package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.SmtpServer;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an SMTP service ready command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpServiceReadyCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = String.format("220 %s Simple Mail Transfer Service Ready", SmtpServer.SERVER_DOMAIN);

	/**
	 * Create an SMTP service ready command result.
	 */
	public SmtpServiceReadyCommandResult() {
		super(CommandResultStatus.SUCCESS, MESSAGE);
	}

	/**
	 * Create an SMTP service ready command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public SmtpServiceReadyCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.SUCCESS, MESSAGE, mailDropRequest);
	}
}