package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an OK command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class OkCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "250 OK";

	/**
	 * Create an OK command result.
	 */
	public OkCommandResult() {
		super(CommandResultStatus.SUCCESS);
	}

	/**
	 * Create an OK command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public OkCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.SUCCESS, mailDropRequest);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}