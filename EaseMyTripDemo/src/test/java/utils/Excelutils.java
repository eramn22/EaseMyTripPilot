package utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	static String pp;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	public Excelutils(String ep, String sn) {
		try {

			workbook=new XSSFWorkbook(ep);
			sheet=workbook.getSheet(sn); }
		catch(Exception e1) {

			e1.printStackTrace();

		}
	}


	public static void main(String[] args) {
		//getRowcount();
		//getCelldata(0,0);
		//getCelldataNumber(1,1);
		//getColcount();

	}
	public static int getRowcount()
	{
		int rc=0;
		try {

			rc=sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rc);
		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}
		return rc;
	}

	public static int getColcount()
	{
		int cc=0;
		try {

			cc=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Column Count: "+cc);
		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}
		return cc;
	}

	public static String getCelldataString(int rownum,int colnum) {
		String cd=null;
		try {

			cd=sheet.getRow(rownum).getCell(colnum).getStringCellValue();


			//System.out.println(" Data: "+cd);

		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}
		return cd;
	}




	public static void getCelldataNumber(int rownum,int colnum) {

		try {
			double r1=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
			/*cd=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		String r1=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		java.util.Date r2=sheet.getRow(rownum).getCell(colnum).getDateCellValue();
		java.util.Date r3=sheet.getRow(rownum).getCell(colnum).getDateCellValue();
		double r4=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		double r5=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		double r6=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		String r7=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		String r8=sheet.getRow(rownum).getCell(colnum).getStringCellValue();*/


			//System.out.println("Password Data: "+r1);

		}
		catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
		}


	}


}
