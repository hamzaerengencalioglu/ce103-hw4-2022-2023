package ce103_hw4_library_cmd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ce103_hw4_library_lib.ConversionUtility;

class ConversionUtilityTest {

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
	void testToByte() {

		    // Test case 1
		    String hexString1 = "48656c6c6f20776f726c64";
		    byte[] expected1 = new byte[] { 72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100 };
		    assertArrayEquals(expected1, ConversionUtility.toByte(hexString1));

		    // Test case 2
		    String hexString2 = "010203";
		    byte[] expected2 = new byte[] { 1, 2, 3 };
		    assertArrayEquals(expected2, ConversionUtility.toByte(hexString2));

		    // Test case 3
		    String hexString3 = "deadbeef";
		    byte[] expected3 = new byte[] { -34, -83, -66, -17 };
		    assertArrayEquals(expected3, ConversionUtility.toByte(hexString3));
		

	}

	@Test
	void testToHex() {

		

		    // Test case 1
		    byte[] arr1 = new byte[] { 72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100 };
		    String expected1 = "48656c6c6f20776f726c64";
		    assertEquals(expected1, ConversionUtility.toHex(arr1));

		    // Test case 2
		    byte[] arr2 = new byte[] { 1, 2, 3 };
		    String expected2 = "010203";
		    assertEquals(expected2,  ConversionUtility.toHex(arr2));

		    // Test case 3
		    byte[] arr3 = new byte[] { -34, -83, -66, -17 };
		    String expected3 = "deadbeef";
		    assertEquals(expected3,  ConversionUtility.toHex(arr3));
		}

		

	

	@Test
	void testIsHex() {

		    // Test case 1
		    String str1 = "48656c6c6f20776f726c64";
		    boolean expected1 = true;
		    assertEquals(expected1, ConversionUtility.isHex(str1));

		    // Test case 2
		    String str2 = "010203";
		    boolean expected2 = true;
		    assertEquals(expected2,  ConversionUtility.isHex(str2));

		    // Test case 3
		    String str3 = "deadbeef";
		    boolean expected3 = true;
		    assertEquals(expected3,  ConversionUtility.isHex(str3));

		    // Test case 4
		    String str4 = "g01f";
		    boolean expected4 = false;
		    assertEquals(expected4,  ConversionUtility.isHex(str4));

		    // Test case 5
		    String str5 = "";
		    boolean expected5 = false;
		    assertEquals(expected5,  ConversionUtility.isHex(str5));
		}

	

	@Test
	void testGetInt() {

		    // Test case 1
		    byte[] data1 = new byte[] { 0, 0, 0, 1 };
		    int offset1 = 0;
		    int length1 = 4;
		    int expected1 = 1;
		    assertEquals(expected1, ConversionUtility.getInt(data1, offset1, length1));

		    // Test case 2
		    byte[] data2 = new byte[] { 0, 0, 1, 0 };
		    int offset2 = 0;
		    int length2 = 4;
		    int expected2 = 256;
		    assertEquals(expected2, ConversionUtility.getInt(data2, offset2, length2));

		    // Test case 3
		    byte[] data3 = new byte[] { 0, 1, 0, 0 };
		    int offset3 = 0;
		    int length3 = 4;
		    int expected3 = 65536;
		    assertEquals(expected3, ConversionUtility.getInt(data3, offset3, length3));

		    // Test case 4
		    byte[] data4 = new byte[] { 1, 0, 0, 0 };
		    int offset4 = 0;
		    int length4 = 4;
		    int expected4 = 16777216;
		    assertEquals(expected4, ConversionUtility.getInt(data4, offset4, length4));

		    // Test case 5
		    byte[] data5 = new byte[] { 1, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		    int offset5 = 4;
		    int length5 = 4;
		    int expected5 = 16909060;
		    assertEquals(expected5, ConversionUtility.getInt(data5, offset5, length5));
		}

	

	@Test
	void testToAscii() {

		    // Test case 1
		    String hexString1 = "48656c6c6f20776f726c64";
		    String expected1 = "Hello world";
		    assertEquals(expected1, ConversionUtility.toAscii(hexString1));

		    // Test case 2
		    String hexString2 = "4865206c6c6f20776f726c64";
		    String expected2 = "He lloworld";
		    assertEquals(expected2, ConversionUtility.toAscii(hexString2));

		    // Test case 3
		    String hexString3 = "4865206c6c6f20776f726c6421";
		    String expected3 = "He lloworld!";
		    assertEquals(expected3, ConversionUtility.toAscii(hexString3));

		    // Test case 4
		    String hexString4 = "4865206c6c6f207";
		    String expected4 = "He llow ";
		    assertEquals(expected4, ConversionUtility.toAscii(hexString4));

		    // Test case 5
		    String hexString5 = "";
		    String expected5 = "";
		    assertEquals(expected5, ConversionUtility.toAscii(hexString5));
		}

	

	@Test
	void testByteArrayToInt() {

		    // Test case 1
		    byte[] bytes1 = new byte[] { 0, 0, 0, 1 };
		    int expected1 = 1;
		    assertEquals(expected1, ConversionUtility.byteArrayToInt(bytes1));

		    // Test case 2
		    byte[] bytes2 = new byte[] { 0, 0, 0, -1 };
		    int expected2 = 255;
		    assertEquals(expected2, ConversionUtility.byteArrayToInt(bytes2));

		    // Test case 3
		    byte[] bytes3 = new byte[] { 0, 0, -1, -1 };
		    int expected3 = 65535;
		    assertEquals(expected3, ConversionUtility.byteArrayToInt(bytes3));

		    // Test case 4
		    byte[] bytes4 = new byte[] { 0, -1, -1, -1 };
		    int expected4 = 16777215;
		    assertEquals(expected4, ConversionUtility.byteArrayToInt(bytes4));

		    // Test case 5
		    byte[] bytes5 = new byte[] { -1, -1, -1, -1 };
		    int expected5 = -1;
		    assertEquals(expected5, ConversionUtility.byteArrayToInt(bytes5));
		}

	

	@Test
	void testByteArrayToInteger() {

		        byte[] byteArray = {0, 0, 0, 1};
		        int expected = 1;
		        int result = ConversionUtility.byteArrayToInteger(byteArray);
		        assertEquals(expected, result);
		    }
		

	

	@Test
	void testIntegerToByteArray() {


		        int value = 1;
		        byte[] expected = {0, 0, 0, 1};
		        byte[] result = ConversionUtility.integerToByteArray(value);
		        assertArrayEquals(expected, result);
		    }
		

	

	@Test
	void testIntToByteArray() {

		        int value = 1;
		        byte[] expected = {0, 0, 0, 1};
		        byte[] result = ConversionUtility.intToByteArray(value);
		        assertArrayEquals(expected, result);
		    }
		
	@Test
	void testStringListToByteArray() {

		        List<String> stringList = Arrays.asList("a", "b", "c");
		        int itemMaxLength = 2;
		        byte[] expected = {'a', 0, 'b', 0, 'c', 0};
		        byte[] result = ConversionUtility.stringListToByteArray(stringList, itemMaxLength);
		        assertArrayEquals(expected, result);
		    }


	@Test
	void testByteArrayToStringList() {


		        byte[] byteArray = {'a', 0, 'b', 0, 'c', 0};
		        int itemMaxLength = 2;
		        List<String> expected = Arrays.asList("a", "b", "c");
		        List<String> result = ConversionUtility.byteArrayToStringList(byteArray, itemMaxLength);
		        assertEquals(expected, result);
		    }


	@Test
	void testStringToByteArray() {

		        String data = "abc";
		        byte[] expected = {'a', 'b', 'c'};
		        byte[] result = ConversionUtility.stringToByteArray(data);
		        assertArrayEquals(expected, result);
		    }
			

	@Test
	void testByteArrayToString() {

		        byte[] byteArray = {'a', 'b', 'c'};
		        String expected = "abc";
		        String result = ConversionUtility.byteArrayToString(byteArray);
		        assertEquals(expected, result);
		    }
		
	

}