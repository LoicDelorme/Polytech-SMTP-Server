package fr.polytech.smtp.server.states;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

import fr.polytech.smtp.server.commands.results.OkCommandResult;
import fr.polytech.smtp.server.requests.MailDropRequest;
import fr.polytech.smtp.server.states.results.StateResult;

/**
 * This class represents a waiting for data state.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class WaitingForDataState extends State {

	/**
	 * The inboxes path.
	 */
	private static final String INBOXES_PATH = "inboxes" + File.separator;

	/**
	 * The email end character.
	 */
	private static final String EMAIL_END_CHARACTER = "..";

	/**
	 * Create a waiting for data state.
	 * 
	 * @param mailDropRequest
	 *            The mail drop request.
	 */
	public WaitingForDataState(MailDropRequest mailDropRequest) {
		super(mailDropRequest);
	}

	@Override
	public StateResult executeCommand(String receivedCommand, BufferedReader inputStream) {
		String message = null;
		State nextState = null;

		try {
			this.mailDropRequest.appendEmailContent(receivedCommand);
			this.mailDropRequest.appendEmailContent("\r\n");

			String readLine = inputStream.readLine();
			while (!EMAIL_END_CHARACTER.equals(readLine)) {
				this.mailDropRequest.appendEmailContent(readLine);
				this.mailDropRequest.appendEmailContent("\r\n");
				readLine = inputStream.readLine();
			}

			writeEmails();

			message = new OkCommandResult().toString();
			nextState = new WaitingForQuitState();
		} catch (IOException e) {
			message = "";
			nextState = new WaitingForQuitState();
		}

		return new StateResult(message, nextState);
	}

	/**
	 * Write emails into recipients mailboxes.
	 * 
	 * @throws IOException
	 *             If an error occurs.
	 */
	private void writeEmails() throws IOException {
		final String content = this.mailDropRequest.getEmailContent();

		File email = null;
		for (String recipient : this.mailDropRequest.getRecipientsEmailAdresses()) {
			email = new File(INBOXES_PATH + recipient + File.separator + UUID.randomUUID().toString());
			Files.write(email.toPath(), content.getBytes(), StandardOpenOption.CREATE_NEW);
		}
	}
}