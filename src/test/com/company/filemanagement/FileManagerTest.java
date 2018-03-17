package com.company.filemanagement;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class FileManagerTest {
    private final String TEMP_PATH = System.getProperty("java.io.tmpdir") + File.separator + "UasiBookTranslator";
    private final String TEST_FILE = "tmp.txt";
    private final Charset UTF8 = StandardCharsets.UTF_8;

    private FileManager fileManager;

    @Before
    public void Before() {
        fileManager = new FileManager(TEMP_PATH, TEST_FILE, UTF8);
    }

    @Test
    public void getPath() {
        assertEquals(TEMP_PATH, fileManager.getPath());
    }

    @Test
    public void getFileName() {
        assertEquals(TEST_FILE, fileManager.getFileName());
    }

    @Test
    public void getEncoding() {
        assertEquals(UTF8, fileManager.getEncoding());
    }

    @Test
    public void getFile() {
        final File file = new File(TEMP_PATH + File.separator + TEST_FILE);
        assertEquals(file, fileManager.getFile());
    }

    @Test
    public void getFilePath() {
        final File file = new File(TEMP_PATH);
        assertEquals(file, fileManager.getFilePath());
    }
}