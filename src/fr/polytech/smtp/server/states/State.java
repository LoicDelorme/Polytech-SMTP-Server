package fr.polytech.smtp.server.states;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import fr.polytech.smtp.server.commands.Command;
import fr.polytech.smtp.server.commands.DATA;
import fr.polytech.smtp.server.commands.EHLO;
import fr.polytech.smtp.server.commands.MAILFROM;
import fr.polytech.smtp.server.commands.QUIT;
import fr.polytech.smtp.server.commands.RCPTTO;
import fr.polytech.smtp.server.commands.RSET;
import fr.polytech.smtp.server.requests.MailDropRequest;
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
		COMMANDS.put(DATA.COMMAND_NAME, new DATA());
		COMMANDS.put(EHLO.COMMAND_NAME, new EHLO());
		COMMANDS.put(MAILFROM.COMMAND_NAME, new MAILFROM());
		COMMANDS.put(QUIT.COMMAND_NAME, new QUIT());
		COMMANDS.put(RCPTTO.COMMAND_NAME, new RCPTTO());
		COMMANDS.put(RSET.COMMAND_NAME, new RSET());
	}

	/**
	 * The mail drop request.
	 */
	protected final MailDropRequest mailDropRequest;

	/**
	 * Create a state.
	 */
	public State() {
		this(null);
	}

	/**
	 * Create a state.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public State(MailDropRequest mailDropRequest) {
		this.mailDropRequest = mailDropRequest;
	}

	/**
	 * Execute the command with its parameters.
	 * 
	 * @param receivedCommand
	 *            The received command.
	 * @param inputStream
	 *            The input stream.
	 * @return The state result.
	 */
	public abstract StateResult executeCommand(String receivedCommand, BufferedReader inputStream);
}