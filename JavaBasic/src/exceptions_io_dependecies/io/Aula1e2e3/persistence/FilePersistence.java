package exceptions_io_dependecies.io.Aula1e2e3.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class FilePersistence {
    protected final String currentDir = System.getProperty("user.dir");
    protected final String storedDir;
    protected final String fileName;

    public FilePersistence(String fileName, final String storedDir) {
        this.fileName = fileName;
        this.storedDir = storedDir;
    }

    public abstract String write(final String data);

    public boolean remove(String sentence) {
        ArrayList<String> contentList = toArrayList();

        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false;

        clearFile();
        contentList.stream().filter(c -> !c.contains(sentence)).forEach(this::write);
        return true;
    }

    public String replace(String oldContent, String newContent) {
        
        ArrayList<String> contentList = toArrayList();
        
        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return "";

        clearFile();
        contentList.stream().map(c -> c.contains(oldContent) ? newContent : c).forEach(this::write);;

        return newContent;
    }

    public abstract String findAll();
    public abstract String findBy(final String sentence);

    protected void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<String> toArrayList() {
        String content = findAll();
        ArrayList<String> contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        return contentList;
    }
}
