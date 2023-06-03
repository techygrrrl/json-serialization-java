package stream.techygrrrl.jsonserialization;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static String getResourceDirectoryPath() {
        Path resourceDirectory = Paths.get("src", "main", "resources");
        return resourceDirectory.toFile().getAbsolutePath();
    }
}
