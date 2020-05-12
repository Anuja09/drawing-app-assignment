package com.cs.config;

/**
 * The class holds list of configurable properties
 *
 * @author anuja
 */
public enum Property {
    OUTPUT("OUTPUT");
//,INPUT("INPUT");

    private String value;

    Property(String value) {
        this.value = value;
    }
}

