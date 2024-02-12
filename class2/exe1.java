import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueFileCreator {

    public static void main(String[] args) {
        String fileName = ""+ System.currentTimeMillis();
        File file = new File(fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("New file created: " + file.getName());
            } else {
                System.out.println("The file already exists: " + file.getName());
            }

            Path absolutePath = file.toPath().toAbsolutePath();
            Path relativePath = file.toPath().toRealPath();

            System.out.println("Absolute path: " + absolutePath);
            System.out.println("Relative path: " + relativePath);

            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            System.out.println("Is read-only: " + !attrs.isOther());
            System.out.println("Is hidden: " + Files.isHidden(file.toPath()));

            File parentFolder = file.getParentFile();
            if (parentFolder != null) {
                String parentFolderName = parentFolder.getName();
                System.out.println("Parent folder name: " + parentFolderName);
            } else {
                System.out.println("The file does not have a parent folder.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
