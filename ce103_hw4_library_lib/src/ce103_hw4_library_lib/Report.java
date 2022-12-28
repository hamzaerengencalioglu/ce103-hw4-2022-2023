package ce103_hw4_library_lib;

public class Report {
	public static final int MEDICINE_ID_LENGTH = 4;
	public static final int MEDICINE_NAME_MAX_LENGTH = 40;
	public static final int SUPPLIER_NAME_MAX_LENGTH = 50;
	public static final int TOTAL_MAX_LENGTH = 20;
	public static final int RATE_MAX_LENGTH = 15;
	public static final int QUANTITY_MAX_LENGTH = 4;
	public static final int EXP_MAX_LENGTH = 10;
	public static final int RREPORT_DATA_BLOCK_SIZE = MEDICINE_ID_LENGTH + MEDICINE_NAME_MAX_LENGTH + SUPPLIER_NAME_MAX_LENGTH + TOTAL_MAX_LENGTH + RATE_MAX_LENGTH + QUANTITY_MAX_LENGTH + EXP_MAX_LENGTH ;

	private int _id;
    private String _medicineName;
    private String _supplierName;
    private int _total;
    private int _rate;
    private int _quantity;
    private String _mfg;
    
    
    public int getmId() {return _id;}
	public void setmId(int id) {this._id = id;}

	public String getmedicineName() { return _medicineName;}
	public void setmedicineName(String medicinename) {this._medicineName = medicinename;}
	
	public String getsupplierName() {return _supplierName;}
	public void setsupplierName(String suppliername) {this._supplierName = suppliername;}

	public int gettotal() {return _total;}
	public void settotal(int total) {this._total = total;}

	public int getrate() {return _rate;}
	public void setrate(int rate) {this._rate = rate;}
	
	public int getquantity() {return _quantity;}
	public void setquantity(int quantity) {this._quantity = quantity;}
	
	public String getexp() {return _mfg;}
	public void setexp(String Exp) {this._mfg = Exp;}
	

	public static byte[] reportToByteArrayBlock(Report report)
	{
		int index = 0;	
		byte[] dataBuffer = new byte[RREPORT_DATA_BLOCK_SIZE];
		
		byte[] mIdBytes = ConversionUtility.intToByteArray(report.getmId());
		System.arraycopy(mIdBytes, 0, dataBuffer, index, mIdBytes.length);
		index += Report.MEDICINE_ID_LENGTH;
		   
		byte[] medicineNameBytes = ConversionUtility.stringToByteArray(report.getmedicineName());
		System.arraycopy(medicineNameBytes, 0, dataBuffer, index, medicineNameBytes.length);
		index += Report.MEDICINE_NAME_MAX_LENGTH;
		
		byte[] supplierNameBytes = ConversionUtility.stringToByteArray(report.getsupplierName());
		System.arraycopy(supplierNameBytes, 0, dataBuffer, index, supplierNameBytes.length);
		index += Report.SUPPLIER_NAME_MAX_LENGTH;
		
		byte[] totalBytes = ConversionUtility.intToByteArray(report.gettotal());
		System.arraycopy(totalBytes, 0, dataBuffer, index, totalBytes.length);
		index += Report.TOTAL_MAX_LENGTH;
		
		byte[] rateBytes = ConversionUtility.intToByteArray(report.getrate());
		System.arraycopy(rateBytes, 0, dataBuffer, index, rateBytes.length);
		index += Report.RATE_MAX_LENGTH;
		
		byte[] quantityBytes = ConversionUtility.intToByteArray(report.getquantity());
		System.arraycopy(quantityBytes, 0, dataBuffer, index, quantityBytes.length);
		index += Report.QUANTITY_MAX_LENGTH;
		
		byte[] expBytes = ConversionUtility.stringToByteArray(report.getexp());
		System.arraycopy(expBytes, 0, dataBuffer, index, expBytes.length);
		index += Report.EXP_MAX_LENGTH;
		
		if(index != dataBuffer.length)
		{
		throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

		}
		return dataBuffer;	
	}
	
	public static Report byteArrayBlockToreport(byte[] byteArray) {
		Report report = new Report();

	    if (byteArray.length != RREPORT_DATA_BLOCK_SIZE) {
	        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	    }

	    int index = 0;
	    
	    byte[] mIdBytes = new byte[Report.MEDICINE_ID_LENGTH];
	    System.arraycopy(byteArray, index, mIdBytes, 0, mIdBytes.length);
	    report.setmId(ConversionUtility.byteArrayToInteger(mIdBytes));
	    index += Report.MEDICINE_ID_LENGTH;
	    
	    byte[] medicineNameBytes = new byte[Report.MEDICINE_NAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, medicineNameBytes, 0, medicineNameBytes.length);
	    report.setmedicineName(ConversionUtility.byteArrayToString(medicineNameBytes));
	    index += Report.MEDICINE_NAME_MAX_LENGTH;
	    
	    byte[] supplierNameBytes = new byte[Report.SUPPLIER_NAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, supplierNameBytes, 0, supplierNameBytes.length);
	    report.setsupplierName(ConversionUtility.byteArrayToString(supplierNameBytes));
	    index += Report.SUPPLIER_NAME_MAX_LENGTH;
	    
	    byte[] totalBytes = new byte[Report.TOTAL_MAX_LENGTH];
	    System.arraycopy(byteArray, index, totalBytes, 0, totalBytes.length);
	    report.settotal(ConversionUtility.byteArrayToInteger(totalBytes));
	    index += Report.TOTAL_MAX_LENGTH;
	    
	    byte[] rateBytes = new byte[Report.RATE_MAX_LENGTH];
	    System.arraycopy(byteArray, index, rateBytes, 0, rateBytes.length);
	    report.setrate(ConversionUtility.byteArrayToInteger(rateBytes));
	    index += Report.RATE_MAX_LENGTH;
	    
	    byte[] quantityBytes = new byte[Report.QUANTITY_MAX_LENGTH];
	    System.arraycopy(byteArray, index, quantityBytes, 0, quantityBytes.length);
	    report.setquantity(ConversionUtility.byteArrayToInteger(quantityBytes));
	    index += Report.QUANTITY_MAX_LENGTH;
	    
	    byte[] expBytes = new byte[Report.EXP_MAX_LENGTH];
	    System.arraycopy(byteArray, index, expBytes, 0, expBytes.length);
	    report.setexp(ConversionUtility.byteArrayToString(expBytes));
	    index += Report.EXP_MAX_LENGTH;
	    
	    if (index != byteArray.length) {
	        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	    }

	    if (report.getmId() == 0) {
	        return null;
	    } else {
	    	
	        return report;
	        
	    }    
	}
}