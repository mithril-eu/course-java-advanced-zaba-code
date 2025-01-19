package eu.mithril.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFiles {

    public static void main(String[] args) throws IOException {
        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string č ć ž"); // UTF 8

        String s = Files.readString(utfFile);// UTF 8
        System.out.println("s = " + s);

        s = Files.readString(utfFile, Charset.forName("windows-1250")); // otherwise == utf8
        System.out.println("s = " + s);

        s = new String(Files.readAllBytes(utfFile), StandardCharsets.UTF_8);
        System.out.println("s = " + s);

        System.out.println("s = " + Files.readString(utfFile));


        try (BufferedReader bufferedReader = Files.newBufferedReader(utfFile)) {
            // handle reader
        }

        try (InputStream is = Files.newInputStream(utfFile)) {
            // handle inputstream
        }
    }
}
