package fr.polytech.smtp.server.commands.results;

/**
 * This class represents a server domain command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class ServerDomainCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "250 polytech.fr";

	/**
	 * Create a server domain command result.
	 */
	public ServerDomainCommandResult() {
		super(CommandResultStatus.SUCCESS);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}