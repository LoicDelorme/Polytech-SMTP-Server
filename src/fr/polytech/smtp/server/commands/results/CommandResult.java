package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class CommandResult {

	/**
	 * The command result status.
	 */
	private final CommandResultStatus status;

	/**
	 * The message.
	 */
	private final String message;

	/**
	 * The mail drop request.
	 */
	private final MailDropRequest mailDropRequest;

	/**
	 * Create a command result.
	 * 
	 * @param status
	 *            The command result status.
	 * @param message
	 *            The message.
	 */
	public CommandResult(CommandResultStatus status, String message) {
		this(status, message, null);
	}

	/**
	 * Create a command result.
	 * 
	 * @param status
	 *            The command result status.
	 * @param message
	 *            The message.
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public CommandResult(CommandResultStatus status, String message, MailDropRequest mailDropRequest) {
		this.status = status;
		this.message = message;
		this.mailDropRequest = mailDropRequest;
	}

	/**
	 * Check if the command was well executed.
	 * 
	 * @return True if it was well executed, else False.
	 */
	public boolean wasWellExecuted() {
		return CommandResultStatus.SUCCESS == this.status;
	}

	/**
	 * Get the mail drop request.
	 * 
	 * @return The mail drop request.
	 */
	public MailDropRequest getMailDropRequest() {
		return this.mailDropRequest;
	}

	@Override
	public String toString() {
		return this.message;
	}
}