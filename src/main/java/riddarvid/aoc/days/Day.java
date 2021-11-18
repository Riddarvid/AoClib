package riddarvid.aoc.days;

import java.io.File;
import java.net.URL;
import java.util.List;

public abstract class Day {
    protected List<String> lines;
    private static final String fileName = "input";

    public Day() {
        URL url = getClass().getResource(fileName);
        if (url == null || url.getPath() == null) {
            System.out.println("No such file found: " + fileName);
        } else {
            File f = new File(url.getPath());
            lines = FileUtils.getLines(f);
        }
    }

    public void run() {
        setup();
        part1();
        part2();
    }

    public void runAndPrint() {
        setup();
        System.out.println(part1());
        System.out.println(part2());
    }

    public abstract long part1();

    public abstract long part2();

    public abstract void setup();
}
