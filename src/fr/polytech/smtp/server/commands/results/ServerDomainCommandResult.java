package fr.polytech.smtp.server.commands.results;

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
	private static final String MESSAGE = "250 polytech.fr";

	/**
	 * Create a server domain command result.
	 */
	public ServerDomainCommandResult() {
		super(CommandResultStatus.SUCCESS);
	}

	/**
	 * Create a server domain command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public ServerDomainCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.SUCCESS, mailDropRequest);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}