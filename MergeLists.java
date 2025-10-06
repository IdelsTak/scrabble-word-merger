import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

void main() throws IOException {
    var files = List.of(Path.of("CSW21.txt"), Path.of("NSWL2023.txt"));
    var pattern = Pattern.compile("^[A-Z]+");
    var merged = new TreeSet<String>(); // sorted + unique

    for (var file : files) {
        try (Stream<String> lines = Files.lines(file)) {
            lines.map(String::strip)
                 .filter(line -> !line.isEmpty() && !line.startsWith("#"))
                 // extract only the first uppercase word at the start of the line
                 .map(line -> {
                     var m = pattern.matcher(line);
                     return m.find() ? m.group() : null;
                 })
                 .filter(Objects::nonNull)
                 .forEach(merged::add);
        }
    }

    Files.writeString(Path.of("merged.txt"), String.join(System.lineSeparator(), merged));
    System.out.println("merged.txt written (" + merged.size() + " unique words)");
}
