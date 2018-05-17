package com.tekleo.jportscan.scan;

import com.tekleo.jportscan.core.Ip;
import com.tekleo.jportscan.core.Port;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * This is the {@link Callable} wrapper around {@link ScanOperation}
 *
 * This class will be heavily used to achieve good multithreading
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:33
 */
public class ScanOperationCallable implements Callable<ScanReport>, Serializable {
    private ScanOperation scanOperation;

    /**
     * Full arguments constructor
     * @param ip ip address
     * @param port port to check
     * @param timeout timeout (in ms)
     */
    public ScanOperationCallable(Ip ip, Port port, int timeout) {
        scanOperation = new ScanOperation(ip, port, timeout);
    }

    /**
     * Shortened constructor, with default timeout value
     * @param ip ip address
     * @param port port to check
     */
    public ScanOperationCallable(Ip ip, Port port) {
        scanOperation = new ScanOperation(ip, port);
    }

    /**
     * The run method
     * @return scan report
     */
    public ScanReport call() {
        return scanOperation.getScanReport();
    }
}