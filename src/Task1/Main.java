package Task1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder log = new StringBuilder();
        var test = new File("C://IdeaProjects/Games/src/test");
        var main = new File("C://IdeaProjects/Games/src/main");
        var main_file = new File("C://IdeaProjects/Games/src/main/Main.java");
        var utils_file = new File("C://IdeaProjects/Games/src/main/Utils.java");
        var drawables = new File("C://IdeaProjects/Games/res/drawables");
        var vectors = new File("C://IdeaProjects/Games/res/vectors");
        var icons = new File("C://IdeaProjects/Games/res/icons");
        var savegames = new File("C://IdeaProjects/Games/savegames");
        var temp = new File("C://IdeaProjects/Games/tmp");
        var temp_file = new File("C://IdeaProjects/Games/tmp/temp.txt");

        if (test.mkdirs()) {
            log.append("Каталог Games/src/test создан;\n");
        }
        if (main.mkdirs()) {
            log.append("Каталог Games/src/main создан;\n");
        }
        if (temp.mkdirs()) {
            log.append("Каталог Games/tmp создан;\n");
        }
        if (drawables.mkdirs()) {
            log.append("Каталог Games/res/drawables создан;\n");
        }
        if (vectors.mkdirs()) {
            log.append("Каталог Games/res/vectors создан;\n");
        }
        if (icons.mkdirs()) {
            log.append("Каталог Games/res/icons создан;\n");
        }
        if (savegames.mkdirs()) {
            log.append("Каталог Games/savegames создан;\n");
        }

        try {
            if (main_file.createNewFile())
                log.append("Файл Main.java создан;\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (utils_file.createNewFile())
                log.append("Файл Utils.java создан;\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (temp_file.createNewFile())
                log.append("Файл temp.txt создан;\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileOutputStream out = new FileOutputStream("C://IdeaProjects/Games/tmp/temp.txt")) {
             byte[] bytes = log.toString().getBytes();
             out.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}