package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an invalid parameter(s) command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class InvalidParametersCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "501 Invalid parameter(s) for the current command";

	/**
	 * Create an invalid parameter(s) command result.
	 */
	public InvalidParametersCommandResult() {
		super(CommandResultStatus.ERROR, MESSAGE);
	}

	/**
	 * Create an invalid parameter(s) command result.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public InvalidParametersCommandResult(MailDropRequest mailDropRequest) {
		super(CommandResultStatus.ERROR, MESSAGE, mailDropRequest);
	}
}