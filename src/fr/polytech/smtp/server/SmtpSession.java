package fr.polytech.smtp.server;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.polytech.smtp.server.states.ClosedState;
import fr.polytech.smtp.server.states.State;
import fr.polytech.smtp.server.states.results.StateResult;

/**
 * This class represents an SMTP session.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpSession implements Runnable {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(SmtpSession.class.getName());

	/**
	 * The client socket.
	 */
	private final Socket socket;

	/**
	 * Create an SMTP session.
	 * 
	 * @param socket
	 *            The client socket.
	 */
	public SmtpSession(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			final BufferedReader inputStream = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			final DataOutput outputStream = new DataOutputStream(this.socket.getOutputStream());

			String commandInput = "";
			String commandOutput = "";
			State currentState = new ClosedState();
			StateResult stateResult = null;
			while (true) {
				stateResult = currentState.executeCommand(commandInput.trim(), inputStream);

				currentState = stateResult.getNextState();
				commandOutput = stateResult.getMessage();

				outputStream.writeBytes(commandOutput + "\r\n");
				// outputStream.writeBytes("\r\n");
				LOGGER.log(Level.INFO, "[SERVER_THREAD] commandOutput:" + commandOutput);

				if (currentState == null) {
					break;
				}

				commandInput = inputStream.readLine();
				LOGGER.log(Level.INFO, "[SERVER_THREAD] commandInput:" + commandInput);
			}

			this.socket.close();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "[SERVER_THREAD] An unexpected exception occured", e);
		}
	}
}