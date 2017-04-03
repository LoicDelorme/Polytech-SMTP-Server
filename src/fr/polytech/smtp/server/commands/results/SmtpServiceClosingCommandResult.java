package fr.polytech.smtp.server.commands.results;

/**
 * This class represents an SMTP service closing command result.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpServiceClosingCommandResult extends CommandResult {

	/**
	 * The message.
	 */
	private static final String MESSAGE = "221 polytech.fr Service closing transmission channel";

	/**
	 * Create an SMTP service closing command result.
	 */
	public SmtpServiceClosingCommandResult() {
		super(CommandResultStatus.SUCCESS);
	}

	@Override
	public String toString() {
		return MESSAGE;
	}
}