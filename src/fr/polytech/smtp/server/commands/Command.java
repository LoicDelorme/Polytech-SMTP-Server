package fr.polytech.smtp.server.commands;

import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;

/**
 * This class represents an SMTP command.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class Command {

	/**
	 * The command name.
	 */
	protected final String name;

	/**
	 * Create an SMTP command.
	 * 
	 * @param name
	 *            The command name.
	 */
	public Command(String name) {
		this.name = name;
	}

	/**
	 * Get the command name.
	 * 
	 * @return The command name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Execute the SMTP command.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request (optionnal).
	 * @param receivedCommand
	 *            The received command.
	 * @return The command result.
	 */
	public abstract CommandResult execute(MailDropRequest mailDropRequest, String receivedCommand);

	@Override
	public String toString() {
		return "Command [name=" + this.name + "]";
	}
}