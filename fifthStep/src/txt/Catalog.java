package txt;

import java.io.File;
import java.io.IOException;

public class Catalog {

    File catalog;

    public Catalog(File catalog) {
        this.catalog = catalog;
    }

    public boolean isCatalog() {
        return catalog.isDirectory();
    }

    public String getAbsPath() {
        return catalog.getAbsolutePath();
    }
}
