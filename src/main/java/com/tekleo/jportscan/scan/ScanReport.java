package com.tekleo.jportscan.scan;

import com.tekleo.jportscan.core.Ip;
import com.tekleo.jportscan.core.Port;

import java.io.Serializable;
import java.util.Objects;

/**
 * Report of the scan will be held in this object
 *
 * It contains ip, port and boolean flag that indicates whether this port on this ip was open
 *
 * This object is immutable, hash-code is calculated in constructor
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:29
 */
public class ScanReport implements Serializable {
    private Ip ip;
    private Port port;
    private boolean open;
    private int hashCode;

    /**
     * Full arguments constructor
     * @param ip
     * @param port
     * @param open
     */
    public ScanReport(Ip ip, Port port, boolean open) {
        this.ip = ip;
        this.port = port;
        this.open = open;
        this.hashCode = Objects.hash(ip, port, open);
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
    public boolean isOpen() {
        return open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScanReport that = (ScanReport) o;
        return open == that.open && Objects.equals(ip, that.ip) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return "ScanReport{ip='" + ip + "', port='" + port + "', open=" + open + "}";
    }
}