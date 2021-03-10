package txt;

import java.io.File;
import java.io.IOException;

public class MyFile {

    File file;

    public MyFile(File file) {
        this.file = file;
    }

    public boolean isExist() {
        return file.exists();
    }

    public boolean isFile() {
        return file.isFile();
    }

    public String getName() {
        return file.getName();
    }

    public boolean createNewFile() throws IOException {
        return file.createNewFile();
    }

    public boolean renameTo(File file) {
        return this.file.renameTo(file);
    }

    public File getFile() {
        return file;
    }

    public boolean delete() {
        return file.delete();
    }
}
