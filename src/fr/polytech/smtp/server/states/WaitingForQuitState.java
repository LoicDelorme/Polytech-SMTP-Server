package fr.polytech.smtp.server.states;

import fr.polytech.smtp.server.states.results.StateResult;

/**
 * This class represents a waiting for quit state.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class WaitingForQuitState extends State {

	/**
	 * Create a waiting for quit state.
	 */
	public WaitingForQuitState() {
		super();
	}

	@Override
	protected StateResult executeCommand(String command, String[] parameters) {
		String message = null;
		State nextState = null;

		switch (command) {
			case "":
				// final CommandResult commandResult = COMMANDS.get(command).execute(null, parameters);
				message = "";
				nextState = this;
				break;
			default:
				message = "";
				nextState = this;
				break;
		}

		return new StateResult(message, nextState);
	}
}