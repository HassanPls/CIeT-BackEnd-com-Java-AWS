package exceptions_io_dependecies.io.Aula1e2e3.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOFilePersistence extends FilePersistence {


    public IOFilePersistence(final String fileName) throws IOException {
        super(fileName, "/managedFiles/IO/");
        var file = new File(currentDir + storedDir);

        if (!file.exists() && !file.mkdirs())
            throw new IOException("Erro ao criar arquivo");

        clearFile();
    }

    @Override
    public String write(final String data) {
        try (
            FileWriter fileWriter = new FileWriter(currentDir + storedDir + fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter)
        ) {
            printWriter.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String findAll() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line;
            do {
                line = reader.readLine();
                if (line != null) content.append(line).append(System.lineSeparator());
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        String found = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line = reader.readLine();
            do {
                if (line.contains(sentence)) found = line;
                line = reader.readLine();
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }
}
