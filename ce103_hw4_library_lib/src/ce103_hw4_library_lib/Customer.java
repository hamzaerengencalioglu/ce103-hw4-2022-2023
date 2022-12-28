package ce103_hw4_library_lib;


import java.util.List;

public class Customer {
	public static final int CUSTOMER_ID_LENGTH = 4;
	public static final int CUSTOMER_CONTACTNO_LENGTH = 13;
	public static final int CUSTOMER_EMAIL_MAX_LENGTH = 80 ;
	public static final int CUSTOMER_CITY_MAX_LENGTH = 20;
	public static final int CUSTOMER_NAME_MAX_LENGTH = 40;
	public static final int CUSTOMER_DATA_BLOCK_SIZE = CUSTOMER_ID_LENGTH + CUSTOMER_CONTACTNO_LENGTH + CUSTOMER_EMAIL_MAX_LENGTH + CUSTOMER_CITY_MAX_LENGTH + CUSTOMER_NAME_MAX_LENGTH;



	private int _customerid;
	private String _customercontactNo;
	private String _customeremail;
	private List <String> _customercity;
	private List <String> _customername;



	public int getId() {return _customerid;}
	public void setId(int customerid) {this._customerid = customerid;}

	public String getContactNo() { return _customercontactNo;}
	public void setContactNo(String customercontactno) {this._customercontactNo = customercontactno;}

	public String getEmail() {return _customeremail;}
	public void setEmail(String customeremail) {this._customeremail = customeremail;}

	public List <String> getCity() {return _customercity;}
	public void setCity(List <String> customercity) {this._customercity = customercity;}

	public List <String> getName() {return _customername;}
	public void setName(List <String> customername) {this._customername = customername;}

	public static byte[] CustomerToByteArrayBlock(Customer Customer)
	{
	int index = 0;	
	byte[] dataBuffer = new byte[CUSTOMER_DATA_BLOCK_SIZE];

	//copy Customer id
	byte[] idBytes = ConversionUtility.intToByteArray(Customer.getId());
	   System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
	   index += Customer.CUSTOMER_ID_LENGTH;
 
	byte[] contactnoBytes = ConversionUtility.stringToByteArray(Customer.getContactNo());
	System.arraycopy(contactnoBytes, 0, dataBuffer, index, contactnoBytes.length);
	index += Customer.CUSTOMER_CONTACTNO_LENGTH;

	byte[] emailBytes = ConversionUtility.stringToByteArray(Customer.getEmail());
	System.arraycopy(emailBytes, 0, dataBuffer, index, emailBytes.length);
	index += Customer.CUSTOMER_EMAIL_MAX_LENGTH;


	byte[] cityBytes = ConversionUtility.stringListToByteArray(Customer.getCity(), Customer.CUSTOMER_CITY_MAX_LENGTH);
	System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
	index += cityBytes.length;


	byte[] nameBytes = ConversionUtility.stringListToByteArray(Customer.getName(), Customer.CUSTOMER_NAME_MAX_LENGTH);
	System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
	index += nameBytes.length;

	if(index != dataBuffer.length)
	{
	throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

	}
	return dataBuffer;

	}
	public static Customer byteArrayBlockToCustomer(byte[] byteArray) {
		Customer Customer = new Customer();

	    if (byteArray.length != CUSTOMER_DATA_BLOCK_SIZE) {
	        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	    }

	    int index = 0;

	    // copy Customer id
	    byte[] idBytes = new byte[Customer.CUSTOMER_ID_LENGTH];
	    System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
	    Customer.setId(ConversionUtility.byteArrayToInteger(idBytes));
	    index += Customer.CUSTOMER_ID_LENGTH;

	    // copy Customer Contact No
	    byte[] contactnoBytes = new byte[Customer.CUSTOMER_CONTACTNO_LENGTH];
	    System.arraycopy(byteArray, index, contactnoBytes, 0, contactnoBytes.length);
	    Customer.setContactNo(ConversionUtility.byteArrayToString(contactnoBytes));
	    index += Customer.CUSTOMER_CONTACTNO_LENGTH;

	    // copy Customer Email
	    byte[] emailBytes = new byte[Customer.CUSTOMER_EMAIL_MAX_LENGTH];
	    System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
	    Customer.setEmail(ConversionUtility.byteArrayToString(emailBytes));
	    index += Customer.CUSTOMER_EMAIL_MAX_LENGTH;

	    // copy Customer City
	    byte[] cityBytes = new byte[Customer.CUSTOMER_CITY_MAX_LENGTH];
	    System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
	    Customer.setCity(ConversionUtility.byteArrayToStringList(cityBytes, Customer.CUSTOMER_CITY_MAX_LENGTH));
	    index += cityBytes.length;

	    // copy Customer name
	    byte[] nameBytes = new byte[Customer.CUSTOMER_NAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
	    Customer.setName(ConversionUtility.byteArrayToStringList(nameBytes, Customer.CUSTOMER_NAME_MAX_LENGTH));
	    index += nameBytes.length;

	    if (index != byteArray.length) {
	        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	    }

	    if (Customer.getId() == 0) {
	        return null;
	    } else {
	        return Customer;
	    }
	}

}