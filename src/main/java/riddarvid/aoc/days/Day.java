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

    protected abstract long part1();

    protected abstract long part2();

    protected abstract void setup();
}
