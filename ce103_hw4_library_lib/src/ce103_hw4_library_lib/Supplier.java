package ce103_hw4_library_lib;

import java.util.List;

public class Supplier {
	public static final int ID_LENGTH = 4;
	public static final int CONTACTNO_LENGTH = 13;
	public static final int EMAIL_MAX_LENGTH = 80 ;
	public static final int CITY_MAX_LENGTH = 20;
	public static final int NAME_MAX_LENGTH = 40;
	public static final int SUPPLIER_DATA_BLOCK_SIZE = ID_LENGTH + CONTACTNO_LENGTH + EMAIL_MAX_LENGTH + CITY_MAX_LENGTH + NAME_MAX_LENGTH;



	private int _id;
	private String _contactNo;
	private String _email;
	private List <String> _city;
	private List <String> _name;



	public int getId() {return _id;}
	public void setId(int id) {this._id = id;}

	public String getContactNo() { return _contactNo;}
	public void setContactNo(String contactno) {this._contactNo = contactno;}

	public String getEmail() {return _email;}
	public void setEmail(String email) {this._email = email;}

	public List <String> getCity() {return _city;}
	public void setCity(List <String> city) {this._city = city;}

	public List <String> getName() {return _name;}
	public void setName(List <String> name) {this._name = name;}

	public static byte[] supplierToByteArrayBlock(Supplier supplier)
	{
	int index = 0;	
	byte[] dataBuffer = new byte[SUPPLIER_DATA_BLOCK_SIZE];

	//copy supplier id
	byte[] idBytes = ConversionUtility.intToByteArray(supplier.getId());
	System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
	index += Supplier.ID_LENGTH;
 
	byte[] contactnoBytes = ConversionUtility.stringToByteArray(supplier.getContactNo());
	System.arraycopy(contactnoBytes, 0, dataBuffer, index, contactnoBytes.length);
	index += Supplier.CONTACTNO_LENGTH;

	byte[] emailBytes = ConversionUtility.stringToByteArray(supplier.getEmail());
	System.arraycopy(emailBytes, 0, dataBuffer, index, emailBytes.length);
	index += Supplier.EMAIL_MAX_LENGTH;


	byte[] cityBytes = ConversionUtility.stringListToByteArray(supplier.getCity(), Supplier.CITY_MAX_LENGTH);
	System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
	index += cityBytes.length;


	byte[] nameBytes = ConversionUtility.stringListToByteArray(supplier.getName(), Supplier.NAME_MAX_LENGTH);
	System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
	index += nameBytes.length;

	if(index != dataBuffer.length)
	{
	throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

	}
	return dataBuffer;

	}
	public static Supplier byteArrayBlockToSupplier(byte[] byteArray) {
		Supplier supplier = new Supplier();

	    if (byteArray.length != SUPPLIER_DATA_BLOCK_SIZE) {
	        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	    }

	    int index = 0;

	    // copy Supplier id
	    byte[] idBytes = new byte[Supplier.ID_LENGTH];
	    System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
	    supplier.setId(ConversionUtility.byteArrayToInteger(idBytes));
	    index += Supplier.ID_LENGTH;

	    // copy Supplier Contact No
	    byte[] contactnoBytes = new byte[Supplier.CONTACTNO_LENGTH];
	    System.arraycopy(byteArray, index, contactnoBytes, 0, contactnoBytes.length);
	    supplier.setContactNo(ConversionUtility.byteArrayToString(contactnoBytes));
	    index += Supplier.CONTACTNO_LENGTH;

	    // copy Supplier Email
	    byte[] emailBytes = new byte[Supplier.EMAIL_MAX_LENGTH];
	    System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
	    supplier.setEmail(ConversionUtility.byteArrayToString(emailBytes));
	    index += Supplier.EMAIL_MAX_LENGTH;

	    // copy Supplier City
	    byte[] cityBytes = new byte[Supplier.CITY_MAX_LENGTH];
	    System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
	    supplier.setCity(ConversionUtility.byteArrayToStringList(cityBytes, Supplier.CITY_MAX_LENGTH));
	    index += cityBytes.length;

	    // copy Supplier name
	    byte[] nameBytes = new byte[Supplier.NAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
	    supplier.setName(ConversionUtility.byteArrayToStringList(nameBytes, Supplier.NAME_MAX_LENGTH));
	    index += nameBytes.length;

	    if (index != byteArray.length) {
	        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	    }

	    if (supplier.getId() == 0) {
	        return null;
	    } else {
	        return supplier;
	    }
	}

}
