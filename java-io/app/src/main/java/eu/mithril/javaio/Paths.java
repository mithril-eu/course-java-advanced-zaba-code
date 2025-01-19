package eu.mithril.javaio;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class Paths {

    public static void main(String[] args) throws URISyntaxException {
        // Java11+  : Path.of()
        Path path = Path.of("c:\\folder\\child-folder\\readme.txt");
        System.out.println(path);

        path = Path.of("c:/folder/child-folder/readme.txt");
        System.out.println(path);

        path = Path.of("c:", "folder", "child-folder", "readme.txt");
        System.out.println(path);

        path = Path.of("c:", "folder", "child-folder").resolve("readme.txt"); // resolve == getChild()
        System.out.println(path);

        path = Path.of(new URI("file:///c:/folder/child-folder/readme.txt"));
        System.out.println(path);

        // Java < 11 equivalent: Paths.get()
        path = java.nio.file.Paths.get("c:/folder/child-folder/readme.txt");
        System.out.println(path);
    }
}
