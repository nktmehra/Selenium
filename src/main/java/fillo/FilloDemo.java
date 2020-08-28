package fillo;

import java.util.HashMap;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloDemo {

	public HashMap<String, String> testData;
	public Fillo fillo;
	public Connection con;
	public Recordset rec;
	public HashMap<String, String> data ;

	public static void main(String[] args) {
		FilloDemo fd = new FilloDemo();
		fd.readTestData();
	}

	public void readTestData() {
		try {
			fillo = new Fillo();
			con = fillo.getConnection("C:\\Users\\Acer\\Documents\\FilloTestData.xlsx");
			rec = con.executeQuery("Select * from Sheet1 where TCName='3'");
			while (rec.next()) {
				System.out.println(rec.getFieldNames());
				System.out.println(rec.getField("FirstName"));
				System.out.println(rec.getCount());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to process Fillo");
		} finally {
			rec.close();
			con.close();
		}
	}


	
	 public HashMap<String, String> readTestDataHashMap(String m) {
		try {
			
			fillo = new Fillo();
			con = fillo.getConnection("C:\\Users\\Acer\\Documents\\FilloTestData.xlsx");
			rec = con.executeQuery("Select * from Sheet1 where TCName='"+m+"'");
			while (rec.next()) {
				data = new HashMap<String, String>();
				for( String columnName :rec.getFieldNames()) {
					if(!rec.getField(columnName).isEmpty()) {
						data.put(columnName, rec.getField(columnName));
					}
	            }
			}
		} catch (Exception e) {
			System.err.println("Unable to Process the Fillo \nThe error message: " + e.getMessage());
		}finally {
			rec.close();
			con.close();
		}
		return data;

	}
	
	

}
