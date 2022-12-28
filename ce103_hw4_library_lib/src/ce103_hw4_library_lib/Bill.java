package ce103_hw4_library_lib;

public class Bill {
	public static final int BILL_ID_LENGTH = 4;
	public static final int SUPPLIER_NAME_MAX_LENGTH = 50;
	public static final int MEDICINE_NAME_MAX_LENGTH = 40;
	public static final int QUANTITY_MAX_LENGTH = 4;
	public static final int RATE_MAX_LENGTH = 4;
	public static final int TOTAL_MAX_LENGTH = 4;
	public static final int BILL_DATA_BLOCK_SIZE = BILL_ID_LENGTH + SUPPLIER_NAME_MAX_LENGTH + MEDICINE_NAME_MAX_LENGTH + QUANTITY_MAX_LENGTH + RATE_MAX_LENGTH + TOTAL_MAX_LENGTH;
	
	
	private int _billid;
    private String _supllierName;
    private String _medicineName;
    private int _quantity;
    private int _rate;
    private int _total;
    
    public int getbillId() {return _billid;}
   	public void setbillId(int billId) {this._billid = billId;}
   	
   	public String getsupllierName() {return _supllierName;}
   	public void setsupllierName(String suplliername) {this._supllierName = suplliername;}
   	
   	public String getmedicineName() {return _medicineName;}
   	public void setmedicineName(String medicinename) {this._medicineName = medicinename;}
   	
   	public int getQuantity() {return _quantity;}
   	public void setQuantity(int quantity) {this._quantity = quantity;}
   	
   	public int getrate() {return _rate;}
   	public void setrate(int Rate) {this._rate = Rate;}
   	
	public int gettotal() {return _total;}
   	public void settotal(int Total) {this._total = Total;}
   	
   	
   	public static byte[] billToByteArrayBlock(Bill bill)
	{
		int index = 0;	
		byte[] dataBuffer = new byte[BILL_DATA_BLOCK_SIZE];
		
		byte[] bIdBytes = ConversionUtility.intToByteArray(bill.getbillId());
		System.arraycopy(bIdBytes, 0, dataBuffer, index, bIdBytes.length);
		index += Bill.BILL_ID_LENGTH;
		
		byte[] supllierNameBytes = ConversionUtility.stringToByteArray(bill.getsupllierName());
		System.arraycopy(supllierNameBytes, 0, dataBuffer, index, supllierNameBytes.length);
		index += Bill.SUPPLIER_NAME_MAX_LENGTH;
		
		byte[] medicineNameBytes = ConversionUtility.stringToByteArray(bill.getmedicineName());
		System.arraycopy(medicineNameBytes, 0, dataBuffer, index, medicineNameBytes.length);
		index += Bill.MEDICINE_NAME_MAX_LENGTH;
		
		byte[] QuantityBytes = ConversionUtility.intToByteArray(bill.getQuantity());
		System.arraycopy(QuantityBytes, 0, dataBuffer, index, QuantityBytes.length);
		index += Bill.QUANTITY_MAX_LENGTH;
		
		byte[] rateBytes = ConversionUtility.intToByteArray(bill.getrate());
		System.arraycopy(rateBytes, 0, dataBuffer, index, rateBytes.length);
		index += Bill.RATE_MAX_LENGTH;
		
		byte[] totalBytes = ConversionUtility.intToByteArray(bill.gettotal());
		System.arraycopy(totalBytes, 0, dataBuffer, index, totalBytes.length);
		index += Bill.TOTAL_MAX_LENGTH;
		
		if(index != dataBuffer.length)
		{
		throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

		}
		return dataBuffer;	
	}
   	
   	public static Bill byteArrayBlockToBill(byte[] byteArray) {
   		Bill bill = new Bill();

	    if (byteArray.length != BILL_DATA_BLOCK_SIZE) {
	        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	    }

	    int index = 0;
	    
	    byte[] BIdBytes = new byte[Bill.BILL_ID_LENGTH];
	    System.arraycopy(byteArray, index, BIdBytes, 0, BIdBytes.length);
	    bill.setbillId(ConversionUtility.byteArrayToInteger(BIdBytes));
	    index += Bill.BILL_ID_LENGTH;
	    
	    byte[] supllierNameBytes = new byte[Bill.SUPPLIER_NAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, supllierNameBytes, 0, supllierNameBytes.length);
	    bill.setsupllierName(ConversionUtility.byteArrayToString(supllierNameBytes));
	    index += Bill.SUPPLIER_NAME_MAX_LENGTH;
	    
	    byte[] medicineNameBytes = new byte[Bill.MEDICINE_NAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, medicineNameBytes, 0, medicineNameBytes.length);
	    bill.setmedicineName(ConversionUtility.byteArrayToString(medicineNameBytes));
	    index += Bill.MEDICINE_NAME_MAX_LENGTH;
	    
	    byte[] QuantityBytes = new byte[Bill.QUANTITY_MAX_LENGTH];
	    System.arraycopy(byteArray, index, QuantityBytes, 0, QuantityBytes.length);
	    bill.setQuantity(ConversionUtility.byteArrayToInteger(QuantityBytes));
	    index += Bill.QUANTITY_MAX_LENGTH;
	    
	    byte[] rateBytes = new byte[Bill.RATE_MAX_LENGTH];
	    System.arraycopy(byteArray, index, rateBytes, 0, rateBytes.length);
	    bill.setrate(ConversionUtility.byteArrayToInteger(rateBytes));
	    index += Bill.RATE_MAX_LENGTH;
	    
	    byte[] totalBytes = new byte[Bill.TOTAL_MAX_LENGTH];
	    System.arraycopy(byteArray, index, totalBytes, 0, totalBytes.length);
	    bill.settotal(ConversionUtility.byteArrayToInteger(totalBytes));
	    index += Bill.TOTAL_MAX_LENGTH;
	    
	    if (index != byteArray.length) {
	        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	    }

	    if (bill.getbillId() == 0) {
	        return null;
	    } else {
	    	
	        return bill;
	        
	    } 
	    
   	}
   	
   	
   	
   	
}