package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Bookingutils {
	static String pp;
	static XSSFWorkbook workbook2;
	static XSSFSheet sheet2;
	public Bookingutils(String ep, String sn) {
		try {

			workbook2=new XSSFWorkbook(ep);
			sheet2=workbook2.getSheet(sn); }
		catch(Exception e1) {

			e1.printStackTrace();

		}
	}

	public static void main(String[] args) {
		//getRowCount();
		//getColCount();
		//getCellDataString(0,0);
		//getCellDataNumber(1,1);


	}




	public static int getRowCount()
	{
		int rc=0;
		try {

			rc=sheet2.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rc);
		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}
		return rc;
	}


	public static int getColCount()
	{
		int cc=0;
		try {

			cc=sheet2.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Column Count: "+cc);
		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}
		return cc;
	}

	public static String getCellDataString(int rownum,int colnum) {
		String cd=null;
		try {

			cd=sheet2.getRow(rownum).getCell(colnum).getStringCellValue();


			System.out.println(" Data: "+cd);

		}

		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}
		return cd;
	}




	public static String getCellDataNumber(int rownum,int colnum) {
		String r1=null;

		try {
			r1=sheet2.getRow(rownum).getCell(colnum).getStringCellValue();



			System.out.println("Password Data: "+r1);

		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}

		return r1;



	}

}




