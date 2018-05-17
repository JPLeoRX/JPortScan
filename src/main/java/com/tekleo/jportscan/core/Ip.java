package com.tekleo.jportscan.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * IP contains 4 numbers
 *
 * String representation has these numbers separated by "." symbol
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:23
 */
public class Ip implements Serializable, Cloneable {
    private Number n1, n2, n3, n4;

    /**
     * Constructor
     * @param n1
     * @param n2
     * @param n3
     * @param n4
     */
    public Ip(Number n1, Number n2, Number n3, Number n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    /**
     * Constructor
     * @param asString
     */
    public Ip(String asString) {
        String[] a = asString.split("\\.");

        this.n1 = new Number(a[0]);
        this.n2 = new Number(a[1]);
        this.n3 = new Number(a[2]);
        this.n4 = new Number(a[3]);
    }

    /**
     * Getter
     * @return
     */
    public Number getN1() {
        return n1;
    }

    /**
     * Getter
     * @return
     */
    public Number getN2() {
        return n2;
    }

    /**
     * Getter
     * @return
     */
    public Number getN3() {
        return n3;
    }

    /**
     * Getter
     * @return
     */
    public Number getN4() {
        return n4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ip ip = (Ip) o;
        return Objects.equals(n1, ip.n1) && Objects.equals(n2, ip.n2) && Objects.equals(n3, ip.n3) && Objects.equals(n4, ip.n4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2, n3, n4);
    }

    @Override
    public String toString() {
        return n1.getAsString() + "." + n2.getAsString() + "." + n3.getAsString() + "." + n4.getAsString();
    }

    @Override
    public Ip clone() {
        return new Ip(n1, n2, n3, n4);
    }
}