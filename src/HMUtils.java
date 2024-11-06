import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class HMUtils {
    public String[] listFilesForFolder(final File folder) {
        ArrayList<String> files = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                continue;
            }
            files.add(fileEntry.getName());
        }
        return files.stream().map(name -> name).toArray(String[]::new);
    }
}
