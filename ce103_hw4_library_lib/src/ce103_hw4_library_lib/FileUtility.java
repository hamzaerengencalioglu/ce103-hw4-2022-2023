package ce103_hw4_library_lib;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;


public class FileUtility {
	public static boolean deleteFile(String path) 
	{
		 File file = new File(path);
		 if (file.exists()) 
		 { return file.delete();}
			return true;
	}	
			
			
		public static byte[] readBlock(int count, int blocksize, String path) throws
		IOException 
		{
			
		   byte[] buffer = new byte[blocksize];
		   try (FileInputStream fileStream = new FileInputStream(path)) 
		   {
		     fileStream.skip((count - 1) * blocksize); 
		     fileStream.read(buffer, 0, buffer.length);
		   }
		   return buffer;
		}	
	

		public static boolean appendBlock(int count, int blocksize, String path, byte[] data) {
		    try {
		        RandomAccessFile file = new RandomAccessFile(path, "rw");
		        file.seek((count - 1) * blocksize);
		        file.write(data);
		        file.close();
		        return true;
		    } catch (IOException e) {
		        // handle the exception here
		        e.printStackTrace();
		        return false;
		    }
		}


		
		public static boolean updateBlock(byte[] data, int blocksize, String path) throws IOException {
		    try (RandomAccessFile fileStream = new RandomAccessFile(path, "rw")) {
		        fileStream.write(data);
		    }
		    return true;
		}

		
		public static boolean deleteBlock(int count, int blocksize, String path) throws IOException {

		    try (RandomAccessFile fileStream = new RandomAccessFile(path, "rw")) {

		        fileStream.seek((count - 1) * blocksize);

		        byte[] buffer = new byte[blocksize];

		        int read = fileStream.read(buffer);

		        if (read == -1) {
		            return false;
		        }

		        fileStream.seek((count - 1) * blocksize);

		        fileStream.write(new byte[blocksize]);
		    }
		    return true;
		}

		
		public static byte[] readAllBytes(String filePath) throws IOException {
		    try (InputStream in = new FileInputStream(filePath)) {
		        return in.readAllBytes();
		    }
		}

}