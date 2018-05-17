package com.tekleo.jportscan.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * This is the core number object that stores an integer and a string representation of a number
 *
 * This object is immutable, hash code is computed in constructor
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:17
 */
public class Number implements Serializable, Cloneable {
    private int asInt;
    private String asString;
    private int hash;

    /**
     * Constructor
     * @param asInt
     * @param asString
     */
    private Number(int asInt, String asString) {
        this.asInt = asInt;
        this.asString = asString;
        this.hash = Objects.hash(asString);
    }

    /**
     * Constructor
     * @param asInt
     */
    public Number(int asInt) {
        this(asInt, String.valueOf(asInt));
    }

    /**
     * Constructor
     * @param asString
     */
    public Number(String asString) {
        this(Integer.valueOf(asString), asString);
    }

    /**
     * Getter
     * @return
     */
    public int getAsInt() {
        return asInt;
    }

    /**
     * Getter
     * @return
     */
    public String getAsString() {
        return asString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(asString, number.asString);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return "Number{asInt=" + asInt + ", asString='" + asString + "'}";
    }

    @Override
    public Number clone() {
        return new Number(asInt, asString);
    }
}