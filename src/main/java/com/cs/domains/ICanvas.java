package com.cs.domains;

import java.util.function.Supplier;

/**
 * This interface provides a method to get the current state of
 * underlying Canvas object on which command is executed.
 *
 * @author anuja
 */
public interface ICanvas extends Supplier<Canvas> {

}
