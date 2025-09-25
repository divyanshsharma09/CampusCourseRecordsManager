package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class BackupService {

    private Path backupFolder;

    public BackupService(Path backupFolder) {
        this.backupFolder = backupFolder;
    }

    // Copies all files recursively from source folder to backup folder
    public void backupFolder(Path sourceFolder) throws IOException {
        if (!Files.exists(backupFolder)) {
            Files.createDirectories(backupFolder);
        }
        Files.walkFileTree(sourceFolder, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetFile = backupFolder.resolve(sourceFolder.relativize(file));
                if (!Files.exists(targetFile.getParent())) {
                    Files.createDirectories(targetFile.getParent());
                }
                Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    // Calculates the size of a folder recursively
    public long folderSize(Path folder) throws IOException {
        final long[] size = {0};
        Files.walkFileTree(folder, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                size[0] += attrs.size();
                return FileVisitResult.CONTINUE;
            }
        });
        return size[0];
    }
}
