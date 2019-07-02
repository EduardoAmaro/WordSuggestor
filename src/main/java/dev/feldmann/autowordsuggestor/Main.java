package dev.feldmann.autowordsuggestor;

import java.io.File;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        Tri tri = new Tri();
        tri.loadFromFile(getFileFromResources("brazilian.txt"));
        MainScreen.main(tri);
        System.out.println("Teste");
    }

    private static File getFileFromResources(String fileName) {

        ClassLoader classLoader = Main.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
