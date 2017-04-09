package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a no such user command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class NoSuchUserCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "550 No such user here";

	/**
	 * Create a no such user command result.
	 */
	public NoSuchUserCommandResult() {
		super(CommandResultStatus.ERROR, MESSAGE);
	}

	/**
	 * Create a no such user command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public NoSuchUserCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.ERROR, MESSAGE, mailDropRequest);
	}
}