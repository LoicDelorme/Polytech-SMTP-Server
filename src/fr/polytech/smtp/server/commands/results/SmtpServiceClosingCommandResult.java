package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.SmtpServer;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an SMTP service closing command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpServiceClosingCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = String.format("221 %s Service Closing Transmission Channel", SmtpServer.SERVER_DOMAIN);

	/**
	 * Create an SMTP service closing command result.
	 */
	public SmtpServiceClosingCommandResult() {
		super(CommandResultStatus.SUCCESS, MESSAGE);
	}

	/**
	 * Create an SMTP service closing command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public SmtpServiceClosingCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.SUCCESS, MESSAGE, mailDropRequest);
	}
}