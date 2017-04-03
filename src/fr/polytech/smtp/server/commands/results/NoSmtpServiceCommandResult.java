package fr.polytech.smtp.server.commands.results;

/**
 * This class represents a no SMTP service command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class NoSmtpServiceCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "554 No Simple Mail Transfer Service";

	/**
	 * Create a no SMTP service command result.
	 */
	public NoSmtpServiceCommandResult() {
		super(CommandResultStatus.ERROR);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}