package lld.atlassian_file_manager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileManagerTest {

    FileManager subject;
    @Before
    public void setUp() throws Exception {
        subject = new FileManager();
    }

    @Test
    public void totalFileSize() {
        assertEquals(0, subject.totalFileSize());
        // setup
        subject.addFiles(new File(0, "file1.txt", 100), "");
        subject.addFiles(new File(1, "file2.txt", 100), "collection1");
        subject.addFiles(new File(2, "file3.txt", 200), "collection1");

        assertEquals(400, subject.totalFileSize());

        subject.addFiles(new File(3, "file4.txt", 200), "collection1");
        assertEquals(600, subject.totalFileSize());
    }

    @Test
    public void getTopNCollections() {
        assertEquals(0, subject.getTopNCollections(1).size());
        // setup
        subject.addFiles(new File(0, "file1.txt", 100), "");
        subject.addFiles(new File(1, "file2.txt", 100), "collection1");
        subject.addFiles(new File(2, "file3.txt", 200), "collection1");
        subject.addFiles(new File(3, "file4.txt", 500), "collection2");
        subject.addFiles(new File(4, "file5.txt", 200), "collection2");

        assertEquals(2, subject.getTopNCollections(10).size());
        Collection c = subject.getTopNCollections(1).get(0);
        assertEquals("collection2", c.collectionName);
    }

    @Test
    public void addFiles() {
        assertEquals(0, subject.allFiles.size());
        assertEquals(0, subject.allCollections.size());
        // setup
        subject.addFiles(new File(0, "file1.txt", 100), "");
        subject.addFiles(new File(1, "file2.txt", 100), "collection1");
        subject.addFiles(new File(2, "file3.txt", 200), "collection1");

        assertEquals(3, subject.allFiles.size());
        assertEquals(1, subject.allCollections.size());

        subject.addFiles(new File(2, "file3.txt", 200), "collection2");

        assertEquals(3, subject.allFiles.size());
        assertEquals(2, subject.allCollections.size());
    }
}