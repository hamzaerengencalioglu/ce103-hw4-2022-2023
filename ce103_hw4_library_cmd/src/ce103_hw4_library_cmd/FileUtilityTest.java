package ce103_hw4_library_cmd;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ce103_hw4_library_lib.FileUtility;

class FileUtilityTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDeleteFile() throws IOException {

		        String path = "test.txt";
		        // create a new file
		        File file = new File(path);
		        file.createNewFile();
		        // verify that the file exists
		        assertTrue(file.exists());
		        // delete the file
		        boolean result = FileUtility.deleteFile(path);
		        // verify that the file was deleted
		        assertTrue(result);
		        assertFalse(file.exists());
		    }
		

	

	@Test
	void testReadBlock() throws IOException {

		        String path = "test.txt";
		        int count = 2;
		        int blocksize = 3;
		        byte[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		        // create a new file with the given data
		        Files.write(new File(path).toPath(), data);
		        // read the second block of 3 bytes
		        byte[] expected = {'d', 'e', 'f'};
		        byte[] result = FileUtility.readBlock(count, blocksize, path);
		        assertArrayEquals(expected, result);
		    }
		

	

	@Test
	void testAppendBlock() {

		        int count = 1;
		        int blocksize = 1024;
		        String path = "test.txt";
		        byte[] data = "This is a test".getBytes();

		        boolean result = FileUtility.appendBlock(count, blocksize, path, data);
		        assertTrue(result);

		        // Verify that the data was written to the correct location in the file
		        // You can do this by reading the file and comparing the contents to the expected data
		    }
		

	

	@Test
	void testUpdateBlock() throws IOException {

		        int blocksize = 1024;
		        String path = "test.txt";
		        byte[] data = "This is a test".getBytes();

		        boolean result = FileUtility.updateBlock(data, blocksize, path);
		        assertTrue(result);

		        // Verify that the data was written to the file correctly
		        // You can do this by reading the file and comparing the contents to the expected data
		    }
		

	@Test
	void testDeleteBlock() throws IOException {

		        int count = 1;
		        int blocksize = 1024;
		        String path = "test.txt";

		        boolean result = FileUtility.deleteBlock(count, blocksize, path);
		        assertTrue(result);

		        // Verify that the block was deleted from the file correctly
		        // You can do this by reading the file and ensuring that the data at the expected location is empty or zero-filled
		    }
	

	

	@Test
	void testReadAllBytes() throws IOException {

		        String filePath = "test.txt";
		        byte[] expected = "This is a test".getBytes();

		        byte[] result = FileUtility.readAllBytes(filePath);
		        assertArrayEquals(expected, result);
		    }
		

	

}