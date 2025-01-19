package eu.mithril.javaio;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WritingFiles {
    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string č ć ž"); // UTF 8
        System.out.println("utfFile = " + utfFile);

        Path iso88591File = Files.createTempFile("some", ".txt");
        Files.writeString(iso88591File, "this is my string č ć ž", Charset.forName("windows-1250")); // otherwise == utf8
        System.out.println("iso88591File = " + iso88591File);

        Path anotherIso88591File = Files.createTempFile("some", ".txt");
        Files.write(anotherIso88591File, "this is my string č ć ž".getBytes(Charset.forName("windows-1250")));
        System.out.println("anotherIso88591File = " + anotherIso88591File);

        Path anotherUtf8File = Files.createTempFile("some", ".txt");
        Files.writeString(anotherUtf8File, "this is my string č ć ž", StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("anotherUtf8File = " + anotherUtf8File);

        Path oneMoreUtf8File = Files.createTempFile("some", ".txt");
        Files.write(oneMoreUtf8File, "this is my string č ć ž".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("oneMoreUtf8File = " + oneMoreUtf8File);


        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(utfFile)) {
            // handle reader
        }

        try (OutputStream os = Files.newOutputStream(utfFile)) {
            // handle outputstream
        }
    }
}
