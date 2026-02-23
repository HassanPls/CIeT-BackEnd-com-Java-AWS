package exceptions_io_dependecies.io.Aula1e2e3.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2FilePersistence extends FilePersistence {

    public NIO2FilePersistence(String fileName) throws IOException {
        super(fileName, "/managedFiles/NIO/");
        Path path = Paths.get(currentDir + storedDir);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        } 
        clearFile();
    }

    @Override
    public String write(String data) {
        Path path = Paths.get(currentDir + storedDir + fileName);
        try (Stream<String> lines = Files.lines(path)) {
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
            Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String findAll() {
        Path path = Paths.get(currentDir + storedDir + fileName);
        String content = "";
        try (Stream<String> lines = Files.lines(path)) {
            content = lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String findBy(String sentence) {
        String content = findAll();
        return Stream.of(content.split(System.lineSeparator())).filter(c -> c.contains(sentence)).findFirst().orElse("");
    }
    
}
