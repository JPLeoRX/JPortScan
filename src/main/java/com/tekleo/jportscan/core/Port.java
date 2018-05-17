package com.tekleo.jportscan.core;

/**
 * Port contains only one integer, so it's just a number
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:21
 */
public class Port extends Number {
    /**
     * Constructor
     * @param asInt
     */
    public Port(int asInt) {
        super(asInt);
    }

    /**
     * Constructor
     * @param asString
     */
    public Port(String asString) {
        super(asString);
    }
}