package fr.polytech.smtp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents an SMTP server.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpServer implements Runnable {

	/**
	 * The server domain.
	 */
	public static final String SERVER_DOMAIN = "polytech.fr";

	/**
	 * The server email end character.
	 */
	public static final String SERVER_EMAIL_END_CHARACTER = "..";

	/**
	 * The server port.
	 */
	private static final int SERVER_PORT = 2018;

	/**
	 * The server queue length.
	 */
	private static final int SERVER_QUEUE_LENGHT = 10;

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(SmtpServer.class.getName());

	@Override
	public void run() {
		try (final ServerSocket serverSocket = new ServerSocket(SERVER_PORT, SERVER_QUEUE_LENGHT)) {
			Socket client = null;
			while (true) {
				client = serverSocket.accept();

				final Thread clientThread = new Thread(new SmtpSession(client));
				clientThread.start();

				LOGGER.log(Level.INFO, String.format("[SERVER] New client (address: %s ; port: %s)", client.getInetAddress().getHostName(), client.getPort()));
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "[SERVER] Unabled to create SMTP server socket on port: " + SERVER_PORT, e);
		}
	}

	/**
	 * The entry of the application.
	 * 
	 * @param args
	 *            Some arguments.
	 */
	public static void main(String[] args) {
		final Thread serverThread = new Thread(new SmtpServer());
		serverThread.start();
	}
}