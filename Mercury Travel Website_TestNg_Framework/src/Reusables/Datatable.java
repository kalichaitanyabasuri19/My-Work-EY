package Reusables;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.*;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Datatable {
	static Workbook wbook;
	static WritableWorkbook wwbCopy;
	static Sheet shSheet;
	WritableWorkbook ResultFile;
	static WritableSheet ResultSheet;

	public boolean resultFile(String strFileName) {
		try {
			wbook = Workbook.getWorkbook(new File(strFileName));
			String TestResultFile = "./src/Test Results/testresult.xls" + "copy"
					+ ".xls";
			ResultFile = Workbook.createWorkbook(new File(TestResultFile),
					wbook);
			ResultSheet = ResultFile.getSheet(0);
		} catch (Exception e) {
			System.out.println("Unable to open the file 1 " + strFileName);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean result_SetSheet(String strSheet) {
		ResultSheet = ResultFile.getSheet(strSheet);
		return true;
	}

	public String[] result_GetAllSheetNames() {
		return ResultFile.getSheetNames();
		
	}

	// new iteration method
	public List<Integer> dataset_count(int h) {
		int rowCount = shSheet.getRows();
		int columnCount = shSheet.getColumns();
		System.out.println("rows are " + rowCount + "  columns are "
				+ columnCount);

		String dataSet;
		dataSet = "DataSet" + h;
		System.out.println(dataSet);
		String columnName = "DataSet";
		int count = 0;
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < columnCount; i++) {

			String ColName = Datatable.getValuefromCell(i, 0).trim();

			if (columnName.equalsIgnoreCase(ColName)) {
				for (int j = 1; j < rowCount; j++) {

					String str2 = shSheet.getCell(i, j).getContents().trim();
					if (str2.equalsIgnoreCase(dataSet)) {
						count = count + 1;
						ints.add(j);

					}
				}

			}

		}
		return ints;
	}

	public String result_GetValuefromCell(String columnName, int iRowNumber) {
		String str1 = null;
		try {
			int columnCount = Datatable.result_GetColumnCount();
			for (int i = 0; i < columnCount; i++) {
				String ColName = Datatable.result_GetValuefromCell(i, 0).trim();
				if (columnName.equalsIgnoreCase(ColName)) {
			
					str1 = ResultSheet.getCell(i, iRowNumber).getContents()
							.trim();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			closeFile();
		}
		return str1;
	}

	public static String result_GetValuefromCell(int iColumnNumber,
			int iRowNumber) {
		String str1 = null;
		try {
			str1 = ResultSheet.getCell(iColumnNumber, iRowNumber).getContents()
					.trim();
		} catch (Exception e) {
			closeFile();
		}
		return str1;
	}

	public int result_GetRowCount() {
		int rowCount = ResultSheet.getRows();
		return rowCount;
	}

	public static int result_GetColumnCount() {
		int columnCount = ResultSheet.getColumns();
		return columnCount;
	}

	public String result_GetCurrentSheet() {
		return ResultSheet.getName();
	}

	public void result_SetValueIntoCell(String strSheetName, int iColumnNumber,
			int iRowNumber, String strData) {
		WritableSheet wshTemp = ResultFile.getSheet(strSheetName);
		Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
		try {
			wshTemp.addCell(labTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeStyleString(String strSheetName, int col, int row,
			String value) throws WriteException {
		WritableSheet she = ResultFile.getSheet(strSheetName);
		WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);
		cellFont.setBoldStyle(WritableFont.BOLD);
		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(
				cellFont);
		wcfF.setAlignment(jxl.format.Alignment.CENTRE);
		wcfF.setBackground(jxl.format.Colour.LIGHT_GREEN);
	
		wcfF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		wcfF.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcfF.setShrinkToFit(true);
		wcfF.setWrap(true);
		jxl.write.Label labelCF = new jxl.write.Label(col, row, value);
		labelCF.setCellFormat(wcfF);
		she.addCell(labelCF);
	}
	
	public void writeStyleString1(String strSheetName, int col, int row,
			String value) throws WriteException {
		WritableSheet she = ResultFile.getSheet(strSheetName);
		WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);
		cellFont.setBoldStyle(WritableFont.BOLD);
		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(
				cellFont);
		wcfF.setAlignment(jxl.format.Alignment.CENTRE);
		wcfF.setBackground(jxl.format.Colour.WHITE);
	
		wcfF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		wcfF.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcfF.setShrinkToFit(true);
		wcfF.setWrap(true);
		jxl.write.Label labelCF = new jxl.write.Label(col, row, value);
		labelCF.setCellFormat(wcfF);
		she.addCell(labelCF);
	}
	public void writeStyleString2(String strSheetName, int col, int row,
			String value) throws WriteException {
		WritableSheet she = ResultFile.getSheet(strSheetName);
		WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);
		cellFont.setBoldStyle(WritableFont.BOLD);
		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(
				cellFont);
		wcfF.setAlignment(jxl.format.Alignment.CENTRE);
		wcfF.setBackground(jxl.format.Colour.YELLOW);
	
		wcfF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		wcfF.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcfF.setShrinkToFit(true);
		wcfF.setWrap(true);
		jxl.write.Label labelCF = new jxl.write.Label(col, row, value);
		labelCF.setCellFormat(wcfF);
		she.addCell(labelCF);
	}

	public void writeStyleString3(String strSheetName, int col, int row,
			String value) throws WriteException {
		WritableSheet she = ResultFile.getSheet(strSheetName);
		WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);
		cellFont.setBoldStyle(WritableFont.BOLD);
		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(
				cellFont);
		wcfF.setAlignment(jxl.format.Alignment.CENTRE);
		wcfF.setBackground(jxl.format.Colour.RED);
	
		wcfF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		wcfF.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcfF.setShrinkToFit(true);
		wcfF.setWrap(true);
		jxl.write.Label labelCF = new jxl.write.Label(col, row, value);
		labelCF.setCellFormat(wcfF);
		she.addCell(labelCF);
	}

	public boolean result_ExportToFile(String strFile) {
		try {
			File fileTemp = new File(strFile);
			ResultFile.setOutputFile(fileTemp);
			// fileTemp = null;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public void result_CloseFile() {
		try {
			// Closing the writable work book
			ResultFile.write();
			ResultFile.close();
			// Closing the original work book
			wbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean openExcelSheet(String strFileName) {
		try {
			wbook = Workbook.getWorkbook(new File(strFileName));
			// String timeStamp = new
			// SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()).toString();
			String Result = strFileName.replace(".xls", "_Copy.xls");
			wwbCopy = Workbook.createWorkbook(new File(Result), wbook);
			wbook.close();
			shSheet = wwbCopy.getSheet(0);
		} catch (Exception e) {
			System.out.println("Unable to open the file" + strFileName);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String[] getAllSheetNames() {
		return wwbCopy.getSheetNames();
	}

	public boolean setSheet(String strSheet) {
		shSheet = wwbCopy.getSheet(strSheet);
		return true;
	}

	public static String getValuefromCell(String columnName, int iRowNumber) {
		String str1 = null;
		try {
			int columnCount = Datatable.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				String ColName = Datatable.getValuefromCell(i, 0).trim();
				if (columnName.equalsIgnoreCase(ColName)) {
					str1 = shSheet.getCell(i, iRowNumber).getContents().trim();
					break;
				}
			}
		} catch (Exception e) {
			closeFile();
		}
		return str1;
	}

	public static String getValuefromCell(int iColumnNumber, int iRowNumber) {
		String str1 = null;
		try {
			str1 = shSheet.getCell(iColumnNumber, iRowNumber).getContents()
					.trim();
		} catch (Exception e) {
			closeFile();
		}
		return str1;
	}

	public static int getRowCount() {
		int rowCount = shSheet.getRows();
		return rowCount;
	}

	public static int getColumnCount() {
		int columnCount = shSheet.getColumns();
		return columnCount;
	}

	public String getCurrentSheet() {
		return shSheet.getName();
	}

	public void setValueIntoCell(String strSheetName, int iColumnNumber,
			int iRowNumber, String strData) {
		WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
		Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
		try {
			wshTemp.addCell(labTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean exportToFile(String strFile) {
		try {
			File fileTemp = new File(strFile);
			wwbCopy.setOutputFile(fileTemp);
			// fileTemp = null;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void closeFile() {
		try {
			// Closing the writable work book
			wwbCopy.write();
			wwbCopy.close();
			// Closing the original work book
			wbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}