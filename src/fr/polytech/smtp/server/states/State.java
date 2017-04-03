package fr.polytech.smtp.server.states;

import java.util.HashMap;
import java.util.Map;

import fr.polytech.smtp.server.commands.Command;
import fr.polytech.smtp.server.states.results.StateResult;

/**
 * This class represents a state.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class State {

	/**
	 * The commands.
	 */
	protected static final Map<String, Command> COMMANDS = new HashMap<String, Command>();

	{
		COMMANDS.put(null, null);
	}

	/**
	 * Create a state.
	 */
	public State() {
	}

	/**
	 * Run the command.
	 * 
	 * @param receivedCommand
	 *            The received command with its potential parameters.
	 * @return The state result.
	 */
	public StateResult runCommand(String receivedCommand) {
		final String[] splittedCommand = receivedCommand.split(" ");

		final String command = splittedCommand[0].toUpperCase();
		final String[] parameters = new String[splittedCommand.length - 1];
		if (splittedCommand.length > 1) {
			System.arraycopy(splittedCommand, 1, parameters, 0, parameters.length);
		}

		return executeCommand(command, parameters);
	}

	/**
	 * Execute the command with its parameters.
	 * 
	 * @param command
	 *            The command.
	 * @param parameters
	 *            The parameters (optionnal).
	 * @return The state result.
	 */
	protected abstract StateResult executeCommand(String command, String[] parameters);
}