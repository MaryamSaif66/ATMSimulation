import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileUtil {

    public static List<String> readAll(String filename) {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return lines;               // empty list first run

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) lines.add(s);
        } catch (IOException e) { e.printStackTrace(); }
        return lines;
    }

    public static void writeAll(String filename, List<String> lines) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (String l : lines) pw.println(l);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void append(String filename, String line) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(line);
        } catch (IOException e) { e.printStackTrace(); }
    }
}

