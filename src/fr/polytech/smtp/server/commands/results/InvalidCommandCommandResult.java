package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an invalid command command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class InvalidCommandCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "502 Invalid command for the current state";

	/**
	 * Create an invalid command command result.
	 */
	public InvalidCommandCommandResult() {
		super(CommandResultStatus.ERROR, MESSAGE);
	}

	/**
	 * Create an invalid command command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public InvalidCommandCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.ERROR, MESSAGE, mailDropRequest);
	}
}