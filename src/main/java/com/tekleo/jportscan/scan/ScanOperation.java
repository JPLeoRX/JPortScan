package com.tekleo.jportscan.scan;

import com.tekleo.jportscan.core.Ip;
import com.tekleo.jportscan.core.Port;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * This class is the main scan operation, we will check if the port is open here
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:28
 */
public class ScanOperation {
    public static final int DEFAULT_TIMEOUT = 200;

    private Ip ip;
    private Port port;
    private int timeout;

    private boolean executed;
    private boolean open;

    /**
     * Full arguments constructor
     * @param ip ip address
     * @param port port to check
     * @param timeout timeout (in ms)
     */
    public ScanOperation(Ip ip, Port port, int timeout) {
        this.ip = ip;
        this.port = port;
        this.timeout = timeout;
    }

    /**
     * Shortened constructor, with default timeout value
     * @param ip ip address
     * @param port port to check
     */
    public ScanOperation(Ip ip, Port port) {
        this(ip, port, DEFAULT_TIMEOUT);
    }

    /**
     * Checking the port happens here
     */
    private void execute() {
        // If not executed already
        if (!executed) {
            // Try to connect
            try {
                // Create new socket, try to connect, close the socket
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip.toString(), port.getAsInt()), timeout);
                socket.close();

                // If succeeded - the port is open
                open = true;
            }

            // If connection failed
            catch (IOException e) {
                // The port is probably closed
                open = false;
            }

            // If something else went wrong
            catch (Exception e) {
                // Rethrow this exception
                throw new ScanOperationException("Couldn't check " + ip + ":" + port + " due to", e);
            }

            // After we tested the connection
            finally {
                // Mark this executed
                executed = true;
            }
        }
    }

    /**
     * Getter
     * @return
     */
    public Ip getIp() {
        return ip;
    }

    /**
     * Getter
     * @return
     */
    public Port getPort() {
        return port;
    }

    /**
     * Getter
     * @return
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Getter
     * @return
     */
    public boolean isExecuted() {
        return executed;
    }

    /**
     * Getter
     * @return
     */
    public boolean isOpen() {
        // If it was executed already - return the result directly
        if (executed) {
            return open;
        }

        // If it wasn't executed yet
        else {
            // Run the check
            this.execute();

            // Return the result
            return open;
        }
    }

    /**
     * Getter
     * @return
     */
    public ScanReport getScanReport() {
        return new ScanReport(this.getIp(), this.getPort(), this.isOpen());
    }
}