package ce103_hw4_library_lib;

public class Medicine {
	public static final int MEDICINE_ID_LENGTH = 4;
	public static final int MEDICINE_NAME_MAX_LENGTH = 40;
	public static final int COMPANY_NAME_MAX_LENGTH = 40;
	public static final int SUPPLIER_NAME_MAX_LENGTH = 50;
	public static final int UNIT_COST_MAX_LENGTH = 20;
	public static final int SALE_COST_MAX_LENGTH = 15;
	public static final int QUANTITY_MAX_LENGTH = 4;
	public static final int MFG_MAX_LENGTH = 10;
	public static final int EXP_MAX_LENGTH = 10;
	public static final int MEDICINE_DATA_BLOCK_SIZE = MEDICINE_ID_LENGTH + MEDICINE_NAME_MAX_LENGTH + COMPANY_NAME_MAX_LENGTH + SUPPLIER_NAME_MAX_LENGTH + UNIT_COST_MAX_LENGTH + SALE_COST_MAX_LENGTH + QUANTITY_MAX_LENGTH + MFG_MAX_LENGTH + EXP_MAX_LENGTH ;
	
	private int _id;
    private String _medicineName;
    private String _companyName;
    private String _supplierName;
    private int _unitCost;
    private int _saleCost;
    private int _quantity;
    private String _mfg;
    private String _exp;
    
    
    
    public int getmId() {return _id;}
	public void setmId(int id) {this._id = id;}

	public String getmedicineName() { return _medicineName;}
	public void setmedicineName(String medicinename) {this._medicineName = medicinename;}
	
	public String getcompanyName() {return _companyName;}
	public void setcompanyName(String companyname) {this._companyName = companyname;}

	public String getsupplierName() {return _supplierName;}
	public void setsupplierName(String suppliername) {this._supplierName = suppliername;}

	public int getunitCost() {return _unitCost;}
	public void setunitCost(int unitcost) {this._unitCost = unitcost;}

	public int getsaleCost() {return _saleCost;}
	public void setsaleCost(int name) {this._saleCost = name;}
	
	public int getquantity() {return _quantity;}
	public void setquantity(int quantity) {this._quantity = quantity;}
	
	public String getmfg() {return _mfg;}
	public void setmfg(String mfg) {this._mfg = mfg;}
	
	public String getexp() {return _exp;}
	public void setexp(String exp) {this._exp = exp;}
	
	
	public static byte[] medicineToByteArrayBlock(Medicine medicine)
	{
		int index1 = 0;	
		byte[] dataBuffer1 = new byte[MEDICINE_DATA_BLOCK_SIZE];
		
		byte[] mIdBytes = ConversionUtility.intToByteArray(medicine.getmId());
		System.arraycopy(mIdBytes, 0, dataBuffer1, index1, mIdBytes.length);
		index1 += Medicine.MEDICINE_ID_LENGTH;
		   
		byte[] medicineNameBytes = ConversionUtility.stringToByteArray(medicine.getmedicineName());
		System.arraycopy(medicineNameBytes, 0, dataBuffer1, index1, medicineNameBytes.length);
		index1 += Medicine.MEDICINE_NAME_MAX_LENGTH;
			
		byte[] companyNameBytes = ConversionUtility.stringToByteArray(medicine.getcompanyName());
		System.arraycopy(companyNameBytes, 0, dataBuffer1, index1, companyNameBytes.length);
		index1 += Medicine.COMPANY_NAME_MAX_LENGTH;
		
		byte[] supplierNameBytes = ConversionUtility.stringToByteArray(medicine.getsupplierName());
		System.arraycopy(supplierNameBytes, 0, dataBuffer1, index1, supplierNameBytes.length);
		index1 += Medicine.SUPPLIER_NAME_MAX_LENGTH;
		
		byte[] unitCostBytes = ConversionUtility.intToByteArray(medicine.getunitCost());
		System.arraycopy(unitCostBytes, 0, dataBuffer1, index1, unitCostBytes.length);
		index1 += Medicine.UNIT_COST_MAX_LENGTH;
		
		byte[] saleCostBytes = ConversionUtility.intToByteArray(medicine.getsaleCost());
		System.arraycopy(saleCostBytes, 0, dataBuffer1, index1, saleCostBytes.length);
		index1 += Medicine.SALE_COST_MAX_LENGTH;
		
		byte[] quantityBytes = ConversionUtility.intToByteArray(medicine.getquantity());
		System.arraycopy(quantityBytes, 0, dataBuffer1, index1, quantityBytes.length);
		index1 += Medicine.QUANTITY_MAX_LENGTH;
		
		byte[] mfgBytes = ConversionUtility.stringToByteArray(medicine.getmfg());
		System.arraycopy(mfgBytes, 0, dataBuffer1, index1, mfgBytes.length);
		index1 += Medicine.MFG_MAX_LENGTH;
		
		byte[] expBytes = ConversionUtility.stringToByteArray(medicine.getexp());
		System.arraycopy(expBytes, 0, dataBuffer1, index1, expBytes.length);
		index1 += Medicine.EXP_MAX_LENGTH;
		
		if(index1 != dataBuffer1.length)
		{
		throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

		}
	
		return dataBuffer1;	
	}
	public static Medicine byteArrayBlockToMedicine(byte[] byteArray) {
		Medicine medicine = new Medicine();
		if (byteArray.length != MEDICINE_DATA_BLOCK_SIZE) {
	        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	    }
		 int index1 = 0;
		    
		    byte[] mIdBytes = new byte[Medicine.MEDICINE_ID_LENGTH];
		    System.arraycopy(byteArray, index1, mIdBytes, 0, mIdBytes.length);
		    medicine.setmId(ConversionUtility.byteArrayToInt(mIdBytes));
		    index1 += Medicine.MEDICINE_ID_LENGTH;
		    
		    byte[] medicineNameBytes = new byte[Medicine.MEDICINE_NAME_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, medicineNameBytes, 0, medicineNameBytes.length);
		    medicine.setmedicineName(ConversionUtility.byteArrayToString(medicineNameBytes));
		    index1 += Medicine.MEDICINE_NAME_MAX_LENGTH;
		    
		    byte[] companyNameBytes = new byte[Medicine.COMPANY_NAME_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, companyNameBytes, 0, companyNameBytes.length);
		    medicine.setcompanyName(ConversionUtility.byteArrayToString(companyNameBytes));
		    index1 += Medicine.COMPANY_NAME_MAX_LENGTH;
		    
		    byte[] supplierNameBytes = new byte[Medicine.SUPPLIER_NAME_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, supplierNameBytes, 0, supplierNameBytes.length);
		    medicine.setsupplierName(ConversionUtility.byteArrayToString(supplierNameBytes));
		    index1 += Medicine.SUPPLIER_NAME_MAX_LENGTH;
		    
		    byte[] unitCostBytes = new byte[Medicine.UNIT_COST_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, unitCostBytes, 0, unitCostBytes.length);
		    medicine.setunitCost(ConversionUtility.byteArrayToInt(unitCostBytes));
		    index1 += Medicine.UNIT_COST_MAX_LENGTH;
		    
		    byte[] saleCostBytes = new byte[Medicine.SALE_COST_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, saleCostBytes, 0, saleCostBytes.length);
		    medicine.setsaleCost(ConversionUtility.byteArrayToInt(saleCostBytes));
		    index1 += Medicine.SALE_COST_MAX_LENGTH;
	
		    byte[] quantityBytes = new byte[Medicine.QUANTITY_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, quantityBytes, 0, quantityBytes.length);
		    medicine.setquantity(ConversionUtility.byteArrayToInt(quantityBytes));
		    index1 += Medicine.QUANTITY_MAX_LENGTH;
		    
		    byte[] mfgBytes = new byte[Medicine.MFG_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, mfgBytes, 0, mfgBytes.length);
		    medicine.setmfg(ConversionUtility.byteArrayToString(mfgBytes));
		    index1 += Medicine.MFG_MAX_LENGTH;
		    
		    byte[] expBytes = new byte[Medicine.EXP_MAX_LENGTH];
		    System.arraycopy(byteArray, index1, expBytes, 0, expBytes.length);
		    medicine.setexp(ConversionUtility.byteArrayToString(expBytes));
		    index1 += Medicine.EXP_MAX_LENGTH;
		    
		    if (index1 != byteArray.length) {
		        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		    }

		    if (medicine.getmId() == 0) {
		        return null;
		    } else {
		    	
		        return medicine;
		    }
	}
	
	
	
	
}



	