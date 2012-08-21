package ru.vladiev.io;

import java.io.PrintStream;

/**
 * Author: Aleksey Vladiev (Avladiev2@gmail.com)
 */
public class SimpleDataDestination implements DataDestination {
    final PrintStream printStream;

    public SimpleDataDestination(final PrintStream printStream) {
        this.printStream = printStream;

    }

    @Override
    public void put(final String s) {
        printStream.println(s);
    }


}
