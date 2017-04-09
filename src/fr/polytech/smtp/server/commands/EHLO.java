package fr.polytech.smtp.server.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.InvalidParametersCommandResult;
import fr.polytech.smtp.server.commands.results.ServerDomainCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an EHLO SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class EHLO extends Command {

	/**
	 * The command name.
	 */
	public static final String COMMAND_NAME = "EHLO";

	/**
	 * The command pattern.
	 */
	public static final Pattern COMMAND_PATTERN = Pattern.compile("EHLO (.*)");

	/**
	 * Create an EHLO SMTP command.
	 */
	public EHLO() {
		super(COMMAND_NAME);
	}

	@Override
	public CommandResult execute(MailDropRequest mailDropRequest, String receivedCommand) {
		final Matcher matcher = COMMAND_PATTERN.matcher(receivedCommand);
		if (!matcher.find()) {
			return new InvalidParametersCommandResult();
		}

		final String serverDomain = matcher.group(1);
		if (serverDomain.isEmpty()) {
			return new InvalidParametersCommandResult();
		}

		final MailDropRequest newMailDropRequest = new MailDropRequest();
		newMailDropRequest.setEmitterServerDomain(serverDomain);

		return new ServerDomainCommandResult(newMailDropRequest);
	}
}