package com.company.filemanagement.common;

import com.company.filemanagement.FileManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class FileManagerUtils {
    private final FileManager fileManager;

    public FileManagerUtils() {
        this.fileManager = null;
    }

    public FileManagerUtils(final FileManager fileManager) {
        this.fileManager = fileManager;
    }

    /*
    Creates directory if it is not found.
    Uses file from fileManager.
    Returns if the directory was created.
     */
    public boolean createDirectory() {
        return createDirectorIfNotFound(fileManager.getFilePath());
    }

    /*
    Creates directory if it is not found.
    Uses file parameters for directory path.
    Returns if the directory was created.
     */
    public boolean createDirectory(final File file) {
        return createDirectorIfNotFound(file);
    }

    public boolean deleteDirectory() {
        return deleteDirectoryIfExists(fileManager.getFilePath());
    }

    public boolean deleteDirectory(final File file) {
        return deleteDirectoryIfExists(file);
    }

    public boolean createFile() throws IOException {
        return createFileIfNotFound(fileManager.getFile());
    }

    public boolean createFile(final File file) throws IOException {
        return createFileIfNotFound(file);
    }

    /*
    Clears the file.
    Uses fileManager file.
     */
    public boolean clearFile() throws IOException {
        if (!fileManager.getFile().exists()) {
            return false;
        }

        try (PrintWriter pw = new PrintWriter(fileManager.getFile())) {
            pw.print("");
            return true;
        }
    }

    /*
    Clears the file.
    Uses the parameter file.
     */
    public boolean clearFile(final File file) throws IOException {
        if (!file.exists()) {
            return false;
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print("");
            return true;
        }
    }

    public String readFile() throws IOException {
        final byte[] encoded = Files.readAllBytes(fileManager.getFile().toPath());
        return new String(encoded, fileManager.getEncoding());
    }

    public String readFile(final File file, final Charset encoding) throws IOException {
        final byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public void writeToFile(final String output) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileManager.getFile())) {
            pw.println(output);
        }
    }

    public void writeToFile(final File file, final String output) throws IOException {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(output);
        }
    }

    /*
    Checks if the directory exists. If it does not, it will create it.
    Returns if the directory was created.
     */
    private boolean createDirectorIfNotFound(final File file) {
        if (!file.exists()) {
            file.mkdir();
            return true;
        }
        return false;
    }

    private boolean deleteDirectoryIfExists(final File file) {
        if (file.exists()) {
            for (final String fileName : file.list()) {
                final File deleteFile = new File(file.getPath(), fileName);
                deleteFile.delete();
            }
            file.delete();
            return true;
        }
        return false;
    }

    private boolean createFileIfNotFound(final File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            return true;
        }
        return false;
    }
}
