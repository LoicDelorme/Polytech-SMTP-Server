package fr.polytech.smtp.server.commands.results;

/**
 * This class represents an SMTP service ready command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpServiceReadyCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "220 polytech.fr Simple Mail Transfer Service Ready";

	/**
	 * Create an SMTP service ready command result.
	 */
	public SmtpServiceReadyCommandResult() {
		super(CommandResultStatus.SUCCESS);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}