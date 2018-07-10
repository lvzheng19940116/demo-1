package ad.util;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MsExcelW extends MsExcelR {

	public MsExcelW() {
		super();
	}

	// 创建文件
	public boolean createExcelx(String type) {
		wb = new XSSFWorkbook();
		if (("xls").equals(type)) {
			wb = new HSSFWorkbook();
			workbookType = WorkbookType.xls;
		} else if (("xlsx").equals(type)) {
			wb = new XSSFWorkbook();
			workbookType = WorkbookType.xlsx;
		} else if (("xlt").equals(type)) {
			wb = new HSSFWorkbook();
			workbookType = WorkbookType.xlt;
		} else {
			System.out.println("创建Excelx文件件出错，不识别的文件类型：" + type);
			return false;
		}
		return true;
	}

	public void copySheet(MsExcelW fromExcelW,int index,String sheetName) {
		switch (workbookType) {
			case xls: {
				break;
			}
			case xlsx: {
				XSSFSheet sheetTo = (XSSFSheet)wb.createSheet(sheetName);
				XSSFSheet sheetFrom = (XSSFSheet)fromExcelW.getSheet(index);
				copySheet2007(sheetFrom,sheetTo);
				break;
			}
			case xlt: {
				break;
			}
		}
	}

	public Sheet cloneSheet(int sheetIndex) {
		return wb.cloneSheet(sheetIndex);
	}

	@Override
	public void setSheetName(int sheetIndex,String name) {
		wb.setSheetName(sheetIndex,name);
	}

	public void deleteSheet(int sheetIndex) {
		wb.removeSheetAt(sheetIndex);
	}

	private XSSFSheet copySheet2007(XSSFSheet sheetFrom, XSSFSheet sheetTo) {
		// 初期化
		CellRangeAddress region = null;
		XSSFRow rowFrom = null;
		XSSFRow rowTo = null;
		XSSFCell cellFrom = null;
		XSSFCell cellTo = null;
		for (int i = 0; i < sheetFrom.getNumMergedRegions(); i++) {
			region = sheetFrom.getMergedRegion(i);
			if ((region.getFirstColumn() >= sheetFrom.getFirstRowNum())
					&& (region.getLastRow() <= sheetFrom.getLastRowNum())) {
				sheetTo.addMergedRegion(region);
			}
		}

		for (int intRow = sheetFrom.getFirstRowNum(); intRow < sheetFrom.getLastRowNum(); intRow++) {
			rowFrom = sheetFrom.getRow(intRow);
			rowTo = sheetTo.createRow(intRow);
			if (null == rowFrom){
				continue;
			} 
			rowTo.setHeight(rowFrom.getHeight());

			for (int intCol = 0; intCol < rowFrom.getLastCellNum(); intCol++) {
				sheetTo.setDefaultColumnStyle(intCol, sheetFrom.getColumnStyle(intCol));
				sheetTo.setColumnWidth(intCol, sheetFrom.getColumnWidth(intCol));
				cellFrom = rowFrom.getCell(intCol);
				if (null == cellFrom) {
					continue;
				}
				cellTo = rowTo.createCell(intCol);

				//XSSFCellStyle cellStyle = (XSSFCellStyle)wb.createCellStyle();
				//cellStyle.cloneStyleFrom(cellFrom.getCellStyle());
				XSSFCellStyle cellStyle = cellTo.getCellStyle();
				cellStyle.cloneStyleFrom(cellFrom.getCellStyle());
				cellTo.setCellStyle(cellStyle);
				cellTo.setCellType(cellFrom.getCellType());
				//if (null != exchagneValue(cellFrom) && !"".equals(exchagneValue(cellFrom)))
					//cellTo.setCellValue(exchagneValue(cellFrom));

				switch (cellFrom.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC: //0 数值型
					cellTo.setCellValue(cellFrom.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING: //1 字符串型
					cellTo.setCellValue(cellFrom.getStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA: //2 公式型
					cellTo.setCellValue(cellFrom.getRichStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_BLANK: //3 空值
					cellTo.setCellValue(cellFrom.getRichStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN: //4 布尔值
					cellTo.setCellValue(cellFrom.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_ERROR: //5 错误
					cellTo.setCellValue(cellFrom.getErrorCellValue());
					break;
				default:
					System.out.println("表格数据类型未知！");
				}
			}
		}
		sheetTo.setDisplayGridlines(false);
		sheetTo.setZoom(80, 100);
		return sheetTo;
	}

	private HSSFSheet copySheet2003(HSSFSheet sheetFrom, HSSFSheet sheetTo) {
		// 初期化
		CellRangeAddress region = null;
		Row rowFrom = null;
		Row rowTo = null;
		Cell cellFrom = null;
		Cell cellTo = null;

		for (int i = 0; i < sheetFrom.getNumMergedRegions(); i++) {
			region = sheetFrom.getMergedRegion(i);
			if ((region.getFirstColumn() >= sheetFrom.getFirstRowNum())
					&& (region.getLastRow() <= sheetFrom.getLastRowNum())) {
				sheetTo.addMergedRegion(region);
			}
		}

		for (int intRow = sheetFrom.getFirstRowNum(); intRow < sheetFrom.getLastRowNum(); intRow++) {
			rowFrom = sheetFrom.getRow(intRow);
			rowTo = sheetTo.createRow(intRow);
			if (null == rowFrom){
				continue;
			} 
			rowTo.setHeight(rowFrom.getHeight());
			for (int intCol = 0; intCol < rowFrom.getLastCellNum(); intCol++) {
				sheetTo.setDefaultColumnStyle(intCol, sheetFrom.getColumnStyle(intCol));
				sheetTo.setColumnWidth(intCol, sheetFrom.getColumnWidth(intCol));
				cellFrom = rowFrom.getCell(intCol);
				cellTo = rowTo.createCell(intCol);
				if (null == cellFrom) {
					continue;
				}
				cellTo.setCellStyle(cellFrom.getCellStyle());
				cellTo.setCellType(cellFrom.getCellType());
				if (null != cellFrom.getStringCellValue() && !"".equals(cellFrom.getStringCellValue().trim())){
					cellTo.setCellValue(cellFrom.getStringCellValue());
				}
			}
		}
		sheetTo.setDisplayGridlines(false);
		sheetTo.setZoom(80, 100);
		return sheetTo;
	}

	/**
	 * 保存excel对象到文件
	 * @param fileName 文件名称
	 * @return
	 * @throws IOException
	 */
	public void writeExcelx(String fileName) throws IOException {
		FileOutputStream out = new FileOutputStream(fileName);
		wb.write(out);
		out.close();
	}

	/**
	 * 保存excel对象到流
	 * @param fileName 文件名称
	 * @return
	 * @throws IOException
	 */
	public void writeExcelx(OutputStream out) throws IOException {
		wb.write(out);
		out.close();
	}

	// 判断一个单元格是否是合并单元格
	/*private boolean isMergedRegion(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}*/

	// 插入新行
	public void insertRow(int sheetIndex, int startRow, int rows) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), rows, true, false);
		startRow = startRow - 1;
		for (int i = 0; i < rows; i++) {
			Row sourceRow = null;//原始位置
			Row targetRow = null;//移动后位置
			Cell sourceCell = null;
			Cell targetCell = null;
			startRow = startRow + 1;
			sourceRow = sheet.getRow(startRow);
			targetRow = sheet.createRow(startRow + 1);
			targetRow.setHeight(sourceRow.getHeight());

			int columnNum = sourceRow.getPhysicalNumberOfCells();
			for (int j=0; j<columnNum; j++) {
				sourceCell = sourceRow.getCell(j);
				//if (sourceCell == null || isMergedRegion(sheet,startRow,j)) continue;
				if (sourceCell == null){
					continue;
				} 
				targetCell = targetRow.createCell(j);
				targetCell.setCellStyle(sourceCell.getCellStyle());
				targetCell.setCellType(sourceCell.getCellType());
			}
		}
	}

	// 设置列宽
	public void setColumnWidth(int sheetIndex, int columnIndex, int width) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		sheet.setColumnWidth(columnIndex, 256*width+184);
	}

	// 合并单元格
	public void addMergedRegion(int sheetIndex,int startRow, int endRow, int startColumn, int endColumn) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		// CellRangeAddress 四个参数分别是：起始行，结束行，起始列，结束列
		sheet.addMergedRegion(new CellRangeAddress(startRow, endRow, startColumn, endColumn));
	}

	/**
	 * 定位单元格写文字
	 *
	 * @param sheetIndex
	 *			sheet索引
	 * @param rowIndex
	 *			行索引
	 * @param cellIndex
	 *			列索引
	 * @param text
	 *			写入文本
	 * @return
	 */
	public void gotoCellWriteText(int sheetIndex, int rowIndex, int cellIndex, String text, boolean ifCreateRow) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		if (sheet == null) {
			return ;
		}

		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}

		if (ifCreateRow) {
			insertRow(sheetIndex,rowIndex,1);
		}

		Cell cell = row.getCell(cellIndex);
		if (cell == null) {
			Cell cellTmp = row.getCell(cellIndex-1);
			cell = row.createCell(cellIndex);
			cell.setCellStyle(cellTmp.getCellStyle());
		}

		switch(cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC: {
				cell.setCellValue(Double.valueOf(text));
				break;
			}
			case Cell.CELL_TYPE_STRING: {
				cell.setCellValue(text);
				break;
			}
			case Cell.CELL_TYPE_FORMULA: { // 公式
				cell.setCellValue(Double.valueOf(text));
				break;
			}
			case Cell.CELL_TYPE_BLANK: { // 空白
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(text);
				break;
			}
			case Cell.CELL_TYPE_BOOLEAN: { // 布尔
				cell.setCellValue(Boolean.valueOf(text));
				break;
			}
			case Cell.CELL_TYPE_ERROR: {
				byte cellValue = cell.getErrorCellValue();
				//String str = new String(cellValue);
				log.error("模板表格数据错误：" + cellValue);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(text);
				break;
			}
		}
		cell.setCellValue(text);
	}

	/**
	 * 向表格的指定位置入图片(如果连续插入多张图片时需要外部计算图片的长和宽，调整行列参数位置)
	 *
	 * @param bytes
	 *			图片字节流
	 * @param sheetIndex
	 *			sheet索引
	 * @param row
	 *			插入图片的行
	 * @param coll
	 *			插入图片的列
	 * @return
	 */
	public void gotoInsertPicture(byte[] bytes, int sheetIndex, int row, int coll) {
		CreationHelper helper = wb.getCreationHelper();
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		// create drawing
		Drawing drawing = wb.getSheetAt(sheetIndex).createDrawingPatriarch();
		// add a picture shape
		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setCol1(coll);
		anchor.setRow1(row);
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		// auto-size picture
		pict.resize(1);
	}

	/**
	 * 新建sheet，并定位单元格写文字
	 *
	 * @param rowIndex
	 *			行索引
	 * @param cellIndex
	 *			列索引
	 * @param text
	 *			写入文本
	 * @return
	 */
	public void createSheetGotoCellWriteText(String sheetName, int rowIndex, int cellIndex, String text) {
		Sheet sheet = wb.createSheet(sheetName);
		Cell cell = sheet.getRow(rowIndex).getCell(cellIndex);
		if (cell != null) {
			cell.setCellValue(text);
		}
	}
	/*
	 * 查找表格中数据替换
	 */
	public void xlsxSearchAndReplace(String source, String target) {
		for (Sheet sheet : sheetList) {
			int rowNum = sheet.getLastRowNum();
			for (int i=0; i<rowNum;i++) {
				Row row = sheet.getRow(i);
				int columnNum = row.getPhysicalNumberOfCells();
				for (int j=0; j<columnNum; j++) {
					Cell cell = row.getCell(j);
					if (cell == null){
						continue;
					} 
					try {
						switch(cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC: {
								Double cellValue = cell.getNumericCellValue();
								String str = String.valueOf(cellValue);
								if (str != null && str.contains(source)) {
									str = str.replace(source, target);
									cell.setCellValue(Double.valueOf(str));
								}
								break;
							}
							case Cell.CELL_TYPE_STRING: {
								String cellValue = cell.getStringCellValue();
								if (cellValue != null && cellValue.contains(source)) {
									cellValue = cellValue.replace(source, target);
									cell.setCellValue(cellValue);
								}
								break;
							}
							case Cell.CELL_TYPE_FORMULA: { // 公式
								Double cellValue = cell.getNumericCellValue();
								String str = String.valueOf(cellValue);
								if (str != null && str.contains(source)) {
									str = str.replace(source, target);
									cell.setCellValue(Double.valueOf(str));
								}
								break;
							}
							case Cell.CELL_TYPE_BLANK: { // 空白
								break;
							}
							case Cell.CELL_TYPE_BOOLEAN: { // 布尔
								boolean cellValue = cell.getBooleanCellValue();
								if (String.valueOf(cellValue).equals(source)) {
									cell.setCellValue(Boolean.valueOf(target));
								}
								break;
							}
							case Cell.CELL_TYPE_ERROR: {
								byte cellValue = cell.getErrorCellValue();
								//String str = new String(cellValue);
								log.error("模板表格数据错误：" + cellValue);
								break;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


}
