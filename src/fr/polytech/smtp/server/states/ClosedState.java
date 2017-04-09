package fr.polytech.smtp.server.states;

import java.io.BufferedReader;

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
	public StateResult executeCommand(String receivedCommand, BufferedReader inputStream) {
		return new StateResult(new SmtpServiceReadyCommandResult().toString(), new WaitingForAuthentificationState());
	}
}