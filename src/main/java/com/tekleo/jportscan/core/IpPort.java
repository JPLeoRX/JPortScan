package com.tekleo.jportscan.core;

import java.util.Objects;

/**
 * Combination of ip and port
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:23
 */
public class IpPort {
    private Ip ip;
    private Port port;

    /**
     * Constructor
     * @param ip
     * @param port
     */
    public IpPort(Ip ip, Port port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * Constructor
     * @param ip
     * @param port
     */
    public IpPort(String ip, String port) {
        this(new Ip(ip), new Port(port));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpPort ipPort = (IpPort) o;
        return Objects.equals(ip, ipPort.ip) && Objects.equals(port, ipPort.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    @Override
    public String toString() {
        return ip.toString() + ":" + port.toString();
    }

    @Override
    protected IpPort clone() {
        return new IpPort(ip, port);
    }
}