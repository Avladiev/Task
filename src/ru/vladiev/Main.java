package ru.vladiev;

import ru.vladiev.io.DataDestination;
import ru.vladiev.io.DataSource;
import ru.vladiev.io.SimpleDataDestination;
import ru.vladiev.io.SimpleDataSource;
import ru.vladiev.model.Generator;

import java.io.*;

/**
 * Author: Aleksey Vladiev (Avladiev2@gmail.com)
 */
public class Main {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";


    public static void main(final String[] args) {
        final Reader reader = getReader();
        final DataSource dataSource = new SimpleDataSource(reader);
        final PrintStream printStream = getPrintStream();

        final DataDestination dataDestination = new SimpleDataDestination(printStream);
        final Generator generator = new Generator(dataSource, dataDestination);
        generator.generate();

        try {
            reader.close();
        } catch (IOException e) {
            // do nothing
        }
        printStream.close();
    }

    private static Reader getReader() {
        try {
            return new InputStreamReader(new FileInputStream(INPUT_FILE), "utf8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static PrintStream getPrintStream() {
        try {
            return new PrintStream(OUTPUT_FILE, "utf8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
