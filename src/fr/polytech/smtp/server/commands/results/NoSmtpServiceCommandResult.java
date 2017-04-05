package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a no SMTP service command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class NoSmtpServiceCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "554 No Simple Mail Transfer Service";

	/**
	 * Create a no SMTP service command result.
	 */
	public NoSmtpServiceCommandResult() {
		super(CommandResultStatus.ERROR);
	}

	/**
	 * Create a no SMTP service command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public NoSmtpServiceCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.ERROR, mailDropRequest);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}