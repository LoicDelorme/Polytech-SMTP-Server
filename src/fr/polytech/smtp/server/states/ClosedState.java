package fr.polytech.smtp.server.states;

import fr.polytech.smtp.server.commands.results.SmtpServiceReadyCommandResult;
import fr.polytech.smtp.server.states.results.StateResult;

/**
 * This class represents a closed state.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class ClosedState extends State {

	/**
	 * Create a closed state.
	 */
	public ClosedState() {
		super();
	}

	@Override
	protected StateResult executeCommand(String command, String[] parameters) {
		return new StateResult(new SmtpServiceReadyCommandResult().toString(), new WaitingForAuthentificationState());
	}
}