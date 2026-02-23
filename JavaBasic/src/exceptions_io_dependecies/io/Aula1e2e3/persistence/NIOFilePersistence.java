package exceptions_io_dependecies.io.Aula1e2e3.persistence;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFilePersistence extends FilePersistence {

    public NIOFilePersistence(String fileName) throws IOException {
        super(fileName, "/managedFiles/NIO2/");
        var file = new File(currentDir + storedDir);

        if (!file.exists() && !file.mkdirs())
            throw new IOException("Erro ao criar arquivo");

        clearFile();
    }

    @Override
    public String write(String data) {
        try (RandomAccessFile file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "rw")) {
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String findAll() {
        StringBuilder content = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "r"); FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            int bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        StringBuilder content = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "r"); FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            int bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    while (!content.toString().endsWith(System.lineSeparator())) {
                        content.append((char) buffer.get());
                    }
                    if (content.toString().contains(sentence)) {
                        break;
                    } else {
                        content.setLength(0);
                    }

                    if (!content.isEmpty()) {
                        break;
                    }
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
