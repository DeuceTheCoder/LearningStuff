package com.biblio.nuevo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class LibraryConsole {
    private BufferedReader inputStream;
    private PrintStream printStream;

    public LibraryConsole(BufferedReader reader, PrintStream mockStream) {
        inputStream = reader;
        printStream = mockStream;
    }

    public void print(String s) {
        printStream.println(s);
    }

    public String read() throws IOException {
        return inputStream.readLine();
    }
}
