package fr.polytech.smtp.server.commands.results;

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
		super(CommandResultStatus.ERROR);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}