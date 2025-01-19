package eu.mithril.javaio;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.stream.Stream;

public class DeleteMoveFiles {
    public static void main(String[] args) throws IOException {

        Path moveTarget = Path.of(System.getProperty("user.home"), "my_new_folder");
        if (!Files.exists(moveTarget)) {
            Files.createDirectory(moveTarget);
            System.out.println("folder created at: " + moveTarget.toString());
        }

        Path utfFile = Files.createTempFile("some", ".txt");

        try {
            Files.move(utfFile, moveTarget);  // this is wrong!
        } catch (FileAlreadyExistsException e) {
            // that didn't work!
        }

        Files.move(utfFile, moveTarget.resolve(utfFile.getFileName().toString()));


        Path utfFile2 = Files.createTempFile("some", ".txt");
        Files.move(utfFile2, moveTarget.resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

        Path utfFile3 = Files.createTempFile("some", ".txt");
        Files.move(utfFile3, moveTarget.resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);


        try {
            Files.delete(moveTarget);
        } catch (DirectoryNotEmptyException e) {
            e.printStackTrace();
        }

        try (Stream<Path> walk = Files.walk(moveTarget)) {
            walk.sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            // something could not be deleted..
                            throw new RuntimeException(e);
                        }
                    });
        }
    }

    //sort the list in reverse order, so the directory itself comes after the including subdirectories and files
}
