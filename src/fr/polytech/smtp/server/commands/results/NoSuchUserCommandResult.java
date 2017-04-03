package fr.polytech.smtp.server.commands.results;

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
		super(CommandResultStatus.ERROR);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}