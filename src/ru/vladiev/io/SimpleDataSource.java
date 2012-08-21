package ru.vladiev.io;

import java.io.Reader;
import java.util.Scanner;

/**
 * Author: Aleksey Vladiev (Avladiev2@gmail.com)
 */
public class SimpleDataSource implements DataSource {
    private final int n;
    private final int b;
    private final int[] sizes;

    public SimpleDataSource(final Reader reader) {
        final Scanner scanner = new Scanner(reader);
        if (!scanner.hasNextInt() || (n = scanner.nextInt()) <= 0) {
            throw new RuntimeException(" invalid input data ");
        }
        final int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt() || (data[i] = scanner.nextInt()) <= 0) {
                throw new RuntimeException(" invalid input data ");
            }
        }

        if (!scanner.hasNext() || (b = scanner.nextInt()) < 0) {
            throw new RuntimeException(" invalid input data ");
        }
        sizes = data;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int[] getSizes() {
        return sizes;
    }
}
