package fr.polytech.smtp.server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 * This class represents an SMTP server.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SmtpServer implements Runnable {

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
		final SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

		try (final SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT, SERVER_QUEUE_LENGHT)) {
			serverSocket.setEnabledCipherSuites(sslServerSocketFactory.getSupportedCipherSuites());

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