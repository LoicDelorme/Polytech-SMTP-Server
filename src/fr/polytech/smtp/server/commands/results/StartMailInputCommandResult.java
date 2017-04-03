package fr.polytech.smtp.server.commands.results;

/**
 * This class represents a start mail input command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class StartMailInputCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "354 Start Mail input; end with \r\n.\r\n";

	/**
	 * Create a start mail input command result.
	 */
	public StartMailInputCommandResult() {
		super(CommandResultStatus.SUCCESS);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}