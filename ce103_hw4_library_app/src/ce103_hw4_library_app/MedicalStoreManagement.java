package ce103_hw4_library_app;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import ce103_hw4_library_lib.Bill;
import ce103_hw4_library_lib.ConversionUtility;
import ce103_hw4_library_lib.Customer;
import ce103_hw4_library_lib.FileUtility;
import ce103_hw4_library_lib.Medicine;
import ce103_hw4_library_lib.Supplier;



public class MedicalStoreManagement {
	

	public static void main (String[] args) throws IOException {
    
		        
		        

		      MedicalStoreManagement medicinemenu = new MedicalStoreManagement();
		      medicinemenu.MainMenu(args);
		      
		  }
		public void MainMenu(String[] args) throws IOException 
		{
			
			Scanner scanner = new Scanner(System.in);
			SimpleDateFormat format = new SimpleDateFormat();
	        Date date = new Date();
	        while (true) 
			{ 

	        	gotoxy(5,5);
	        	 System.out.print("\t\t\tWelcome To Medical Store\n");
	        	 Date now = new Date();
	 	         System.out.println(now.toString());

	        	 // Print the top border of the menu
				    System.out.print("+");
				    for (int i = 0; i < 106; i++) {
				      System.out.print("=");
				    }

				    System.out.println("+");

				    // Print the "Welcome To Medical Store" message
				    gotoxy(5, 6);
				    System.out.println("|| 							                                                 ||");

				    // Print the menu options

				    gotoxy(5, 7);
				    System.out.println("|| 1-Supplier Info   2-Customer Info    3-Medicine    4-Report  5-Bill   6-About   7-Exit         	 || ");

				    // Print the blank lines

				    for (int i = 8; i <= 20; i++) {
					      gotoxy(5, i);
					      System.out.println("||                                                                             				 ||");
					    }

					    // Print the "Press First Character" message
				    gotoxy(5, 21);
				    System.out.println("||   								   		              	 	 ||");

				    // Print the bottom border of the menu

				    gotoxy(5, 22);
				    System.out.print("+");
				    for (int i = 0; i < 106; i++) {
				      System.out.print("=");
				    }
				    System.out.println("+");
				    System.out.print("\nEnter your choice: ");

		            int choice;
		            if (!scanner.hasNextInt()) {
		                System.out.println("Invalid input. Please try again.");
		                continue;
		            }
		            choice = scanner.nextInt();
		            switch (choice) 
		            {
		                case 1:
		                	SupplierMenu();
		                    break;
		                case 2:
		                    CustomerMenu();
		                    break;
		                case 3:
		                	MedicineMenu();

		                    break;
		                case 4:
		                	ReportMenu();
		                    break;
		                case 5:
		                	BillMenu();
		                    return;
		                    
		                default:

		             System.out.print("Invalid choice.Please try again.");
		             break;
		            }

		            }
				    
			}
				 

		
   private void gotoxy(int i, int j) {
			// TODO Auto-generated method stub
			
		}
public void SupplierMenu() throws IOException
   {
	gotoxy(5,5);
	Date now = new Date();
     System.out.println(now.toString());


	    System.out.print("+");
	    for (int i = 106; i < 212; i++) {
	      System.out.print("=");
	    }

	    System.out.println("+");

	    // Print the "Welcome To Medical Store" message
	    gotoxy(5, 6);
	    System.out.println("|| 							                                                 ||");

	    // Print the menu options

	    gotoxy(5,7);
	    System.out.println("|| 1- Add New Supplier 2- Update Supplier 3- Search Supplier 4- List Of Existing Supplier 5- Exit       	 || ");
     
	//System.out.println("1) Add New Supplier \n2) Update Supplier \n3) Search Supplier \n4) List Of Existing Supplier \n5) Exit");
	   
	for (int i = 8; i <= 20; i++) {
	      gotoxy(5, i);
	      System.out.println("||                                                                             				 ||");
	    }

	    // Print the "Press First Character" message
  gotoxy(5, 21);
  System.out.println("||   								   		              	 	  ||");

  // Print the bottom border of the menu

  gotoxy(5, 22);
  System.out.print("+");
  for (int i = 0; i < 106; i++) {
    System.out.print("=");
  }
  System.out.println("+");
  System.out.print("\nEnter your choice: ");

  int choice;
  Scanner scanner = new Scanner(System.in);
  choice = scanner.nextInt();
  if (!scanner.hasNextInt()) {
      System.out.println("Invalid input. Please try again.");

  }

	
	 switch(choice)
	 { 
	 case 1 :
		Scanner scanner2 = new Scanner(System.in);
		
	  System.out.print("\nEnter your choice: ");

	  int choice1;
	  Scanner scanner3 = new Scanner(System.in);
	  choice1 = scanner3.nextInt();
	  if (!scanner3.hasNextInt()) {
	      System.out.println("Invalid input. Please try again.");

	  }
		
		
		
		System.out.print("SUPPLIER ID: " );
     	int id = scanner2.nextInt();
     	
     	System.out.print("City: ");
        String city = scanner2.next();
     	System.out.print("EMAIL ID: ");
     	String mail = scanner2.next();
     	System.out.print("Supplier Name: ");
     	String name = scanner2.next();
     	System.out.print("CONTACT NO.: ");
     	String phone = scanner2.next();
     	List<String> City = new ArrayList<>();
     	List<String> Name = new ArrayList<>();
     	City.add(city);
     	Name.add(name);
     	Supplier supplier = new Supplier();
     	supplier.setId(id);
     	supplier.setCity(City);
     	supplier.setEmail(mail);
     	supplier.setName(Name);
     	supplier.setContactNo(phone);

     	byte [] data = Supplier.supplierToByteArrayBlock(supplier);
     	String filePath = "Supplier.dat";
     	FileUtility.appendBlock(id ,Supplier.SUPPLIER_DATA_BLOCK_SIZE,filePath,data);
     	System.out.println("Succesfully Added");
     	
     	break;
	 
	 
	 case 2:
		 
				
				String filePath1 = "Supplier.dat";
				Supplier supplier1 = new Supplier();
				System.out.print("Enter ID TO UPDATE SUPPLIER: ");
				Scanner scanner21 = new Scanner(System.in);
				int update = scanner21.nextInt();
				
				byte[] data2 = FileUtility.readBlock(update, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath1);
				int blocksize = Supplier.SUPPLIER_DATA_BLOCK_SIZE;
				
				for (int i = 0; i < data2.length; i += blocksize) {
					
					byte[] block = new byte[blocksize];
				    System.arraycopy(data2, i, block, 0, blocksize);
				    Supplier currentSupplier = Supplier.byteArrayBlockToSupplier(block);
				    
				    if(currentSupplier == null) {
				    	System.out.println("Supplier not found.");
				    }
				    else {
				    	System.out.println("Id: " + currentSupplier.getId());
					    System.out.println("Contact No: " + currentSupplier.getContactNo());
					    System.out.println("City: " + currentSupplier.getCity());
					    System.out.println("Email: " + currentSupplier.getEmail());
					    System.out.println("Name: " + currentSupplier.getName());
					
					    
					    
					    System.out.print("SUPPLIER ID: ");
						int id2 = scanner21.nextInt();
					    Supplier supplier2 = new Supplier();
					    System.out.print("NEW City: ");
						String city1 = scanner21.next();
						System.out.print("NEW EMAIL ID: ");
						String mail1 = scanner21.next();
						System.out.print("NEW Supplier Name: ");
						String name1 = scanner21.next();
						System.out.print("NEW CONTACT NO.: ");
						String phone1 = scanner21.next();
						
						List<String> city11 = new ArrayList<>();
						List<String> Name1 = new ArrayList<>();
						city11.addAll(city11);
						Name1.add(name1);
						
						supplier2.setId(id2);
						supplier2.setCity(city11);
						supplier2.setEmail(mail1);
						supplier2.setName(Name1);
						supplier2.setContactNo(phone1);
						
						byte [] data1 = Supplier.supplierToByteArrayBlock(supplier2);
						FileUtility.appendBlock( id2, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath1, data1);
						
						System.out.println("Supplier updated successfully.");
				    	
				    }
				}
				
							
break;

	     
	     
	 case 3:

		 	String filePath2 = "Supplier.dat";
			Supplier supplier2 = new Supplier();
			System.out.print("Enter ID TO SEARCH SUPPLIER: ");
			Scanner scanner1 = new Scanner(System.in);
			int search = scanner1.nextInt();
			
			
			
			byte[] data21 = FileUtility.readBlock(search, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath2);
			int blocksize1 = Supplier.SUPPLIER_DATA_BLOCK_SIZE;
			
			for (int i = 0; i < data21.length; i += blocksize1) {
		       
		        byte[] block = new byte[blocksize1];
		        System.arraycopy(data21, i, block, 0, blocksize1);
		        Supplier currentBook = Supplier.byteArrayBlockToSupplier(block);
		        
		        if(currentBook == null)
				{
					System.out.println("ID Not Found");
				}
		        else
		        {
		        	gotoxy(5,5);
		    		Date now1 = new Date();
		    	     System.out.println(now1.toString());


		    		    System.out.print("+");
		    		    for (int i1 = 106; i1 < 212; i1++) {
		    		      System.out.print("=");
		    		    }

		    		    System.out.println("+");

		    		    // Print the "Welcome To Medical Store" message
		    		    gotoxy(5, 6);
		    		    System.out.println("|| 							                                                 ||");

		    		    // Print the menu options

		    		    gotoxy(5,7);
		    		    System.out.println("||        	                                                             || ");
		    		    gotoxy(6, 7);
		    		    
		    		    System.out.println("||                                                                   	 || ");

		    		   
		    		      System.out.println("||                                                                             				 ||");
		    		    }
		    		
		        // Print the blank lines
    		    for (int i1 = 8; i1 <= 20; i1++) {
    		      gotoxy(5, i1);
    		      if(i1 == 10) {
 System.out.println("|| \t\t\t\t\t\tId: " + currentBook.getId());
 				   if(i1==11)
 				  {
 					System.out.println("||");  
 				  }
 				  
    		      }
    		      else if(i1 == 12) {
System.out.println("|| \t\t\t\t\t\tContact No: " + currentBook.getContactNo());
    		      }
    		      if(i1==13)
 				  {
 					System.out.println("||");  
 				  }
 				  
    		      if(i1 == 14) {
System.out.println("|| \t\t\t\t\tCity: " + currentBook.getCity());
    		      }
    		      if(i1==15)
 				  {
 					System.out.println("                                                          ||");  
 				  }
    		      if(i1 == 16) {
System.out.println("|| \t\t\t\t\tEmail: " + currentBook.getEmail());
    		      }
    		      if(i1==17)
 				  {
 					System.out.println("||");  
 				  }
    		      if(i1 == 18) {
System.out.println("|| \t\t\t\t\tName: " + currentBook.getName());}
    		      }
		    		for (int i1 = 8; i1 <= 20; i1++) {
		    		      gotoxy(5, i1);
		    		      System.out.println("||                                                                             				 ||");
		    		    }

		    		    // Print the "Press First Character" message
		    	  gotoxy(5, 21);
		    	  System.out.println("||   								   		              	 	                                         ||");

		    	  // Print the bottom border of the menu

		    	  gotoxy(5, 22);
		    	  System.out.print("+");
		    	  for (int i1 = 0; i1 < 106; i1++) {
		    	    System.out.print("=");
		    	  }
		    	  System.out.println("+");

		    	  
			}
		 break;

		
	     
	 case 4:

		 String filePath21 = "Supplier.dat";
		 int blockSize = Supplier.SUPPLIER_DATA_BLOCK_SIZE;

		 byte[] data211 = FileUtility.readAllBytes(filePath21);
		 for (int i = 0; i < data211.length; i += blockSize) {
		     byte[] block = new byte[blockSize];
		     System.arraycopy(data211, i, block, 0, blockSize);
		     Supplier currentBook = Supplier.byteArrayBlockToSupplier(block);
       if(currentBook != null)
       {
		     System.out.println("Id: " + currentBook.getId());
		     System.out.println("Contact No: " + currentBook.getContactNo());
		     System.out.println("City: " + currentBook.getCity());
		     System.out.println("Email: " + currentBook.getEmail());
		     System.out.println("Name: " + currentBook.getName());
       }
		 }





		     break;
		 


	 case 5:

		 MedicalStoreManagement medicinemenu = new MedicalStoreManagement();
	      medicinemenu.MainMenu(null);	
	      
	 }
	 
	
	 
	}
   
   
   
   
   public void CustomerMenu() throws IOException
   {
		System.out.println("1) Add New Customer \n2) Update Customer \n3) Search Customer \n4) List Of Existing Customer \n5) Exit");
		Scanner customermenu = new Scanner(System.in);
		int entrycustomermenu = customermenu.nextInt();
		
		
		switch(entrycustomermenu)
		 { 
		
		 
		 case 1 :
			Scanner scanner = new Scanner(System.in);
			System.out.print("CUSTOMER ID: ");
	     	int id = scanner.nextInt();
	     	
	     	System.out.print("City: ");
	        String city = scanner.next();
	     	System.out.print("EMAIL ID: ");
	     	String mail = scanner.next();
	     	System.out.print("CUSTOMER NAME: ");
	     	String name = scanner.next();
	     	System.out.print("CONTACT NO.: ");
	     	String phone = scanner.next();
	     	List<String> City = new ArrayList<>();
	     	List<String> Name = new ArrayList<>();
	     	City.add(city);
	     	Name.add(name);
	     	Customer customer = new Customer();
	     	customer.setId(id);
	     	customer.setCity(City);
	     	customer.setEmail(mail);
	     	customer.setName(Name);
	     	customer.setContactNo(phone);

	     	byte [] data = Customer.CustomerToByteArrayBlock(customer);
	     	String filePath = "Customer.dat";
	     	FileUtility.appendBlock(id, Customer.CUSTOMER_DATA_BLOCK_SIZE,filePath,data);
	     	
	     	break;
		 case 2:
			 
			 String filePath1 = "Customer.dat";
			 System.out.print("Enter ID TO UPDATE CUSTOMER: ");
			 Scanner scanner2 = new Scanner(System.in);
			 int update = scanner2.nextInt();
			 byte[] data2 = FileUtility.readBlock(update, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath1);
			 int blocksize = Customer.CUSTOMER_DATA_BLOCK_SIZE;
			 for (int i = 0; i < data2.length; i += blocksize) {

			 byte [] block = new byte[blocksize];
			 System.arraycopy(data2, i, block, 0, blocksize);
			 Customer currentCustomer = Customer.byteArrayBlockToCustomer(block);
			 if(currentCustomer == null)
			 {
			  System.out.println("Customer not found.");

			 }
			 else {
			    	System.out.println("Id: " + currentCustomer.getId());
				    System.out.println("Contact No: " + currentCustomer.getContactNo());
				    System.out.println("City: " + currentCustomer.getCity());
				    System.out.println("Email: " + currentCustomer.getEmail());
				    System.out.println("Name: " + currentCustomer.getName());
				
				    
				    
				    System.out.print("SUPPLIER ID: ");
					int id2 = scanner2.nextInt();
				    Customer customer2 = new Customer();
				    System.out.print("NEW CITY: ");
					String city1 = scanner2.next();
					System.out.print("NEW EMAIL ID: ");
					String mail1 = scanner2.next();
					System.out.print("NEW Supplier Name: ");
					String name1 = scanner2.next();
					System.out.print("NEW CONTACT NO.: ");
					String phone1 = scanner2.next();
					
					List<String> city11 = new ArrayList<>();
					List<String> Name1 = new ArrayList<>();
					city11.addAll(city11);
					Name1.add(name1);
					
					customer2.setId(id2);
					customer2.setCity(city11);
					customer2.setEmail(mail1);
					customer2.setName(Name1);
					customer2.setContactNo(phone1);
					
					byte [] data1 = Customer.CustomerToByteArrayBlock(customer2);
					FileUtility.appendBlock( id2, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath1, data1);
					
					System.out.println("Customer updated successfully.");
			 
			 
			 }
			 
			 }
		 case 3:
			 String filePath2 = "Customer.dat";
				System.out.print("Enter ID TO SEARCH CUSTOMER: ");
				Scanner scanner1 = new Scanner(System.in);
				int search = scanner1.nextInt();
				
				
				
				byte[] data21 = FileUtility.readBlock(search, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath2);
				int blocksize1 = Customer.CUSTOMER_DATA_BLOCK_SIZE;
				
				for (int i = 0; i < data21.length; i += blocksize1) {
			       
			        byte[] block = new byte[blocksize1];
			        System.arraycopy(data21, i, block, 0, blocksize1);
			        Customer currentCustomer = Customer.byteArrayBlockToCustomer(block);
			        
			        if(currentCustomer == null)
					{
						System.out.println("ID Not Found");
					}
			        else
			        {
		            System.out.println("Id: " + currentCustomer.getId());
		            System.out.println("Contact No: " + currentCustomer.getContactNo());
		            System.out.println("City: " + currentCustomer.getCity());
		            System.out.println("Email: " + currentCustomer.getEmail());
		            System.out.println("Name: " + currentCustomer.getName());}
				}
			 break;
			 
		 case 4:

			 String filePath21 = "Customer.dat";
			 int blockSize = Customer.CUSTOMER_DATA_BLOCK_SIZE;

			 byte[] data1 = FileUtility.readAllBytes(filePath21);
			 for (int i = 0; i < data1.length; i += blockSize) {
			     byte[] block = new byte[blockSize];
			     System.arraycopy(data1, i, block, 0, blockSize);
			     Customer currentCustomer = Customer.byteArrayBlockToCustomer(block);
	       if(currentCustomer != null)
	       {
			     System.out.println("Id: " + currentCustomer.getId());
			     System.out.println("Contact No: " + currentCustomer.getContactNo());
			     System.out.println("City: " + currentCustomer.getCity());
			     System.out.println("Email: " + currentCustomer.getEmail());
			     System.out.println("Name: " + currentCustomer.getName());
	       }
			 }
			 
		 case 5:
			 
			 
			 MedicalStoreManagement medicinemenu = new MedicalStoreManagement();
		      medicinemenu.MainMenu(null);		 
		 }
		 
	   
   }
   
   public void MedicineMenu() throws IOException

   {
	   
	   System.out.println("1) Purchase New Medicine \n2) Sale Medine \n3) Stock Of Medicine \n4) Exit");
	   Scanner medicinemenu = new Scanner(System.in);
		int entrymedicinemenu = medicinemenu.nextInt();
		switch(entrymedicinemenu)
		{
		
		case 1:
				
			Scanner scanner = new Scanner(System.in);
			System.out.print("MEDICINE ID: ");
	     	int mid = scanner.nextInt();
	     	
	     	System.out.print("Medicine Name: ");
	        String medicinename = scanner.next();
	        
	     	System.out.print("Company Name: ");
	     	String companyname = scanner.next();
	     	
	     	System.out.print("Supplier Name");
	     	String suppliername = scanner.next();
	     	
	     	System.out.print("Unit Cost: ");
	     	int unitcost = scanner.nextInt();
	     	
	     	System.out.print("Sale Cost: ");
	     	int salecost = scanner.nextInt();
	     	
	     	System.out.print("Quantity: ");
	     	int quantity =scanner.nextInt();
	     	
	     	System.out.print("MFG Date");
	     	String mfg = scanner.next();
	     	
	     	System.out.print("EXP Date");
	     	String exp = scanner.next();

	     	Medicine medicine = new Medicine();
	     
	     	medicine.setmId(mid);
	     	medicine.setmedicineName(medicinename);
	     	medicine.setcompanyName(companyname);
	     	medicine.setsupplierName(suppliername);
	     	medicine.setunitCost(unitcost);
	     	medicine.setsaleCost(salecost);
	     	medicine.setquantity(quantity);
	     	medicine.setmfg(mfg);
	     	medicine.setexp(exp);
  	
	     	byte [] data = Medicine.medicineToByteArrayBlock(medicine);
	     	String filePath = "Medicine.dat";
	     	FileUtility.appendBlock(mid, Medicine.MEDICINE_DATA_BLOCK_SIZE,filePath,data);
		
		break;
		
		case 2:
			    System.out.print("MEDICINE ID TO BE SOLD  :");
				Scanner scanner1 = new Scanner(System.in);
				int smid = scanner1.nextInt();
		     	String path = "Medicine.dat";
		     	String billPath = "Bill.dat";
		     	
				byte[] data1 = FileUtility.readBlock(smid, Medicine.MEDICINE_DATA_BLOCK_SIZE, path);
				int blocksize1 = Medicine.MEDICINE_DATA_BLOCK_SIZE;
				
				for (int i = 0; i < data1.length; i += blocksize1) {
			       
			        byte[] block = new byte[blocksize1];
			        System.arraycopy(data1, i, block, 0, blocksize1);
			        Medicine currentMedicine = Medicine.byteArrayBlockToMedicine(block);
			        
			        if(currentMedicine == null)
					{
						System.out.println("ID Not Found");
						
						MedicineMenu();
					}
			        else
			        {
		            System.out.println("Id: " + currentMedicine.getmId());
		            System.out.println("Medicine Name: " + currentMedicine.getmedicineName());
		            System.out.println("Company Name: " + currentMedicine.getcompanyName());
		            System.out.println("Supplier Name: " +currentMedicine.getsupplierName());
		            System.out.println("Unit Cost: " + currentMedicine.getunitCost());
		            System.out.println("Sale Cost: " + currentMedicine.getsaleCost());
		            System.out.println("Quantity: " + currentMedicine.getquantity());
		            System.out.println("Mfg: " + currentMedicine.getmfg());
		            System.out.println("Exp: " + currentMedicine.getexp());
		            System.out.println("");
			        
			        System.out.print("Enter Bill Number");
	        		Scanner scanner3 = new Scanner(System.in);
	        		int billid = scanner3.nextInt();
	        		System.out.print("Enter Customer Name: ");
	        		String customername = scanner3.next();
	        		System.out.print("Quantity Want To Sale");
	        		int QuantitySale = scanner3.nextInt();
	        		 Medicine medicine2 = new Medicine();
	        		String file = "Medicine.dat";
	        		
	        		
					 
					Bill bill2 = new Bill();
					bill2.setbillId(billid);
					bill2.setsupllierName(customername);
					bill2.setmedicineName(currentMedicine.getmedicineName());
					bill2.setQuantity(QuantitySale);
					bill2.setrate(currentMedicine.getsaleCost());
					bill2.settotal(currentMedicine.getsaleCost()*QuantitySale);
					
					byte[] billDataByte = Bill.billToByteArrayBlock(bill2);
					FileUtility.appendBlock(smid, Bill.BILL_DATA_BLOCK_SIZE, billPath, billDataByte);
					
					
					
				   }
			        
			        }

				break;
				
		case 3:
		
			String filePath2 = "Medicine.dat";
			 int blockSize = Medicine.MEDICINE_DATA_BLOCK_SIZE;

			 byte[] data2 = FileUtility.readAllBytes(filePath2);
			 for (int i = 0; i < data2.length; i += blockSize) {
			     byte[] block1 = new byte[blockSize];
			     System.arraycopy(data2, i, block1, 0, blockSize);
			     Medicine currentBook1 = Medicine.byteArrayBlockToMedicine(block1);
	       if(currentBook1 != null)
	       {
			     System.out.println("Id: " + currentBook1.getmId());
			     System.out.println("Medicine Name : " + currentBook1.getmedicineName());
			     System.out.println("Company Name : " + currentBook1.getcompanyName());
			     System.out.println("Supplier Name : " + currentBook1.getsupplierName());
			     System.out.println("Unit Cost: " + currentBook1.getunitCost());
			     System.out.println("Sale Cost: " + currentBook1.getsaleCost());
			     System.out.println("Quantity : " + currentBook1.getquantity());
			     System.out.println("MFG : " + currentBook1.getmfg());
			     System.out.println("EXP: " + currentBook1.getexp());
			     System.out.println("");
			     
	       }
			 }
			

		 break;
			
			
		}
   }
   
   
   public void ReportMenu()
   {
	System.out.println("1) Purchase Report \n2) Sale Report \n3) Profit Report \n4) Daily Sale Report \n5) Exit");   
	
	   Scanner reportmenu = new Scanner(System.in);
		int entryreportmenu = reportmenu.nextInt();
		switch(entryreportmenu)
		{
		
		case 1:
		
		
	
	
	
		}
	   
   }
   
   public void BillMenu() throws IOException
   {
	   
	   String filePath2 = "Bill.dat";
		 int blockSize = Bill.BILL_DATA_BLOCK_SIZE;

		 byte[] data2 = FileUtility.readAllBytes(filePath2);
		 for (int i = 0; i < data2.length; i += blockSize) {
		     byte[] block1 = new byte[blockSize];
		     System.arraycopy(data2, i, block1, 0, blockSize);
		    Bill currentBook1 = Bill.byteArrayBlockToBill(block1);
     if(currentBook1 != null)
     {
		     System.out.println("Id: " + currentBook1.getbillId());
		     System.out.println("Medicine Name : " + currentBook1.getmedicineName());
		     System.out.println("Supplier Name : " + currentBook1.getsupllierName());
		     System.out.println("Quantity : " + currentBook1.getQuantity());
		     System.out.println("Rate : " + currentBook1.getrate());
		     System.out.println("Total : " + currentBook1.gettotal());

		     
      }
		 }   
		    
		    
		    
		
	 	 
	   
   }
   
   
	
}