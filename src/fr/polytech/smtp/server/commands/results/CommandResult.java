package fr.polytech.smtp.server.commands.results;

import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents a command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class CommandResult {

	/**
	 * The command result status.
	 */
	private final CommandResultStatus status;

	/**
	 * The mail drop request.
	 */
	private final MailDropRequest mailDropRequest;

	/**
	 * Create a command result.
	 * 
	 * @param status
	 *            The command result status.
	 */
	public CommandResult(CommandResultStatus status) {
		this(status, null);
	}

	/**
	 * Create a command result.
	 * 
	 * @param status
	 *            The command result status.
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public CommandResult(CommandResultStatus status, MailDropRequest mailDropRequest) {
		this.status = status;
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
	public abstract String toString();
}