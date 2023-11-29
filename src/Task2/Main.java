package Task2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        var save1 = new GameProgress(100, 10, 1, 0.0);
        var save2 = new GameProgress(150, 20, 3, 20.3);
        var save3 = new GameProgress(250, 30, 8, 45.7);

        String saveName1 = "C://IdeaProjects/Games/savegames/save1.dat";
        String saveName2 = "C://IdeaProjects/Games/savegames/save2.dat";
        String saveName3 = "C://IdeaProjects/Games/savegames/save3.dat";
        String zipFile = "C://IdeaProjects/Games/savegames/saves.zip";

        saveGame(saveName1, save1);
        saveGame(saveName2, save2);
        saveGame(saveName3, save3);

        String[] files = {saveName1, saveName2, saveName3};
        zipFiles(zipFile, files);
        deleteFiles(zipFile, "C://IdeaProjects/Games/savegames");
    }

    public static void saveGame(String path, GameProgress game) throws IOException {
        var f = new File(path);
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(game);
        oos.close();
    }

    public static void zipFiles(String archive, String[] files) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archive))) {
            byte[] buffer = new byte[1024];
            for (int i=0; i < files.length; i++) {
                File srcFile = new File(files[i]);
                FileInputStream fis = new FileInputStream(srcFile);
                zout.putNextEntry(new ZipEntry(srcFile.getName()));
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }
                zout.closeEntry();
                fis.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteFiles(String archive, String folder) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(archive))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                File srcFile = new File(folder, name);
                srcFile.delete();
                zin.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
