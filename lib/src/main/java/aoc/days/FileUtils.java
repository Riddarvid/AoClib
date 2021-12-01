package aoc.days;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

class FileUtils {
    static List<String> getLines(File f) {
        try {
            return Files.readAllLines(f.toPath());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getLines(InputStream is) {
        return new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.toList());
    }
}