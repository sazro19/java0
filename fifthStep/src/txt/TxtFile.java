package txt;

import java.io.*;

public class TxtFile {

    private MyFile file;

    private Catalog catalog;

    public TxtFile(Catalog catalog, MyFile file) {
        if (file.isFile() && catalog.isCatalog()) {
            this.file = file;
            this.catalog = catalog;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public TxtFile(String catalogPath, String fileName) {
        file = new MyFile(new File(catalogPath + "\\" + fileName));
        catalog = new Catalog(new File(catalogPath));
    }

    public boolean create() throws IOException {
        return file.createNewFile();
    }

    public boolean rename(String newName) {
        return file.renameTo(new File(catalog.getAbsPath() + "\\" + newName));
    }

    public void printTxtFile() {
        try (FileReader fileReader = new FileReader(file.getFile())) {
            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(String add) {
        try (FileWriter fileWriter = new FileWriter(file.getFile(), true)) {
            fileWriter.write(add);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean delete() {
        return file.delete();
    }

    public static void main(String[] args) throws IOException {
        TxtFile txtFile = new TxtFile("C:\\Users\\Sasha\\Desktop", "ttt.txt");
        txtFile.printTxtFile();
    }
}

