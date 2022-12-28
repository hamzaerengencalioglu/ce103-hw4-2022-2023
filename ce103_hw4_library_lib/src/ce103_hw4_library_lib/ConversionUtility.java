package ce103_hw4_library_lib;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;


public class ConversionUtility {
	public static byte[] toByte(String hexString) 
	{
	 
		int length = hexString.length();
	    byte[] result = new byte[length / 2];

		for (int i = 0; i < length; i += 2) 
		{
		        int value = Integer.parseInt(hexString.substring(i, i + 2), 16);

		        result[i / 2] = (byte) value;
	    }
		    return result;
	}

	public static String toHex(byte[] arr)
	{
	 StringBuilder sb = new StringBuilder(arr.length * 2);
	 
	 for(byte b : arr)
	 {
		 sb.append(String.format("02X",b));
	 }
	 
	 return sb.toString(); 
	}

	public static boolean isHex(String str)
	{
	boolean returnValue = true;
	try 
	{
	toByte(str);
	}

	catch(Exception e)
	{

	return false;
	}

	return returnValue;
	}

	public static int getInt(byte[] data, int offset, int length)
	{
	int result = 0;
	for(int i =0; i< length; i++)
	{
		result = (result << 8) | data[offset + i];
	}
	return result;
	}



	public static String toAscii(String hexString)
	{
	StringBuilder sb = new 	StringBuilder();
	for(int i = 0; i<= hexString.length() -2; i+=2)
	  {
		sb.append((char) Integer.parseInt(hexString.substring(i, i + 2),
		16));
	  }
	return sb.toString();
		
	  }
	
	public static int byteArrayToInt(byte[] bytes) {
		  int value = 0;
		  for (int i = 0; i < 4; i++) {
		    value |= ((int) bytes[i] & 0xff) << (8 * (3 - i));
		  }
		  return value;
		}

	public static int byteArrayToInteger(byte[] byteArray)
	{
	if(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).put(byteArray).getInt(0)
	== byteArray[0])
	{
	byte[] reversed = new byte[4];

	for(int i = 0; i < 4; i++)
	{
	reversed[i] = byteArray[3 - i];	

	}
	byteArray = reversed; 

	}
	return ByteBuffer.wrap(byteArray).getInt();
	}


	public static byte[] integerToByteArray(int value) {
	byte[] intBytes = ByteBuffer.allocate(4).putInt(value).array(); if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {ArrayUtils.reverse(intBytes);
	}
	return intBytes;
	}
	
	public static byte[] intToByteArray(int value)
	{
		  return new byte[] {
		    (byte)(value >>> 24),
		    (byte)(value >>> 16),
		    (byte)(value >>> 8),
		    (byte)value
		  };
	}


	public static byte[] stringListToByteArray(List<String> array, int itemMaxLength) 
	{
	byte[] outputBytes = new byte[itemMaxLength];
	int index = 0;
	for (String val: array) 
	{
	byte[] valBytes = stringToByteArray(val); 
	System.arraycopy(valBytes, 0, outputBytes, index, valBytes.length);
	index += itemMaxLength;
	}
	return outputBytes;
	}



	public static List<String> byteArrayToStringList(byte[] byteArray, int itemMaxLength) {
	    List<String> list = new ArrayList<>();
	    int index = 0;
	    while (index < byteArray.length) {
	        byte[] itemBytes = new byte[itemMaxLength];
	        System.arraycopy(byteArray, index, itemBytes, 0, itemMaxLength);
	        String val = byteArrayToString(itemBytes);
	        if (val != null && !val.isEmpty()) {
	            list.add(val);
	        }
	        index += itemMaxLength;
	    }
	    return list;
	}





	public static byte[] stringToByteArray(String data) { return data.getBytes (StandardCharsets.UTF_8);
	}
	public static String byteArrayToString(byte[] byteArray) { return new String(byteArray, StandardCharsets.UTF_8).trim();
	}


}