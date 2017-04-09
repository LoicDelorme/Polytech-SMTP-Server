package fr.polytech.smtp.server.states;

import java.io.BufferedReader;

import fr.polytech.smtp.server.commands.MAILFROM;
import fr.polytech.smtp.server.commands.RSET;
import fr.polytech.smtp.server.commands.results.CommandResult;
import fr.polytech.smtp.server.commands.results.InvalidCommandCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;
import fr.polytech.smtp.server.states.results.StateResult;

/**
 * This class represents a waiting for emitter identification state.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class WaitingForEmitterIdentificationState extends State {

	/**
	 * Create a waiting for emitter identification state.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public WaitingForEmitterIdentificationState(MailDropRequest mailDropRequest) {
		super(mailDropRequest);
	}

	@Override
	public StateResult executeCommand(String receivedCommand, BufferedReader inputStream) {
		String message = null;
		State nextState = null;

		CommandResult commandResult = null;
		if (receivedCommand.startsWith(MAILFROM.COMMAND_NAME)) {
			commandResult = COMMANDS.get(MAILFROM.COMMAND_NAME).execute(this.mailDropRequest, receivedCommand);

			message = commandResult.toString();
			nextState = commandResult.wasWellExecuted() ? new WaitingForRecipientState(commandResult.getMailDropRequest()) : this;
		} else if (receivedCommand.startsWith(RSET.COMMAND_NAME)) {
			commandResult = COMMANDS.get(RSET.COMMAND_NAME).execute(this.mailDropRequest, receivedCommand);

			message = commandResult.toString();
			nextState = commandResult.wasWellExecuted() ? new WaitingForQuitState() : this;
		} else {
			message = new InvalidCommandCommandResult().toString();
			nextState = this;
		}

		return new StateResult(message, nextState);
	}
}