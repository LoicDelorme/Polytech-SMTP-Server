package fr.polytech.smtp.server.commands.results;

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
	 * Create a command result.
	 * 
	 * @param status
	 *            The command result status.
	 */
	public CommandResult(CommandResultStatus status) {
		this.status = status;
	}

	/**
	 * Check if the command was well executed.
	 * 
	 * @return True if it was well executed, else False.
	 */
	public boolean wasWellExecuted() {
		return CommandResultStatus.SUCCESS == this.status;
	}

	@Override
	public abstract String toString();
}