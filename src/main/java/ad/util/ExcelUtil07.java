package ad.util;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import sun.misc.BASE64Decoder;

public class ExcelUtil07 extends MsExcelW
{
	//private final MsExcelW excel = new MsExcelW();

	/**
	 *
	 * <p>Discription:根据报表模板的路径和输出流初始化NtasReport类</p>
	 * @coustructor 方法.
	 */
	public void init(String model_file, String report_file) throws Exception {
		createFolder(new File(report_file).getParentFile().getPath());
		openExcel(model_file);
	}
	/**
	 * 创建目录
	 * @param path
	 * @throws IOException
	 */
	private static void createFolder(String path) throws IOException {
		File fileDir = new File(path);
		if (!fileDir.exists()){
			FileUtils.forceMkdir(fileDir);
		}
	}
	/**
	 * 打开已知的excel文档
	 *
	 * @param docPath
	 *            文档路径
	 * @throws IOException
	 */
	public boolean openExcel(final String docPath) throws IOException
	{
		return init(docPath);
	}

	/**
	 * 关闭excel应用程序
	 * @throws IOException 
	 *
	 * @throws Exception
	 */
	public void closeExcel(final String excelPath) throws IOException
	{
		writeExcelx(excelPath);
	}
	
	/**
	 * 关闭excel应用程序
	 * @throws IOException 
	 *
	 * @throws Exception
	 */
	public void closeExcel(final OutputStream out) throws IOException
	{
		writeExcelx(out);
	}

	/**
	 * 向表格的第一个sheet页0行0列插入图片
	 */
	public void insertImage(int sheetIndex, byte[] bytes) {
		gotoInsertPicture(bytes, sheetIndex, 0, 0);
	}
	
	/**
	 * 根据模板将数据写入excel并令存
	 * 
	 * @param templateFileUrl 模板文件访问地址
	 * @param targetFileUrl 目标文件访问地址
	 * @param startLen 模板中起始行写入
	 * @param keys 写入数据字段顺序
	 * @param listMap 待写入数据
	 * @throws IOException
	 */
	public void writeExcel(String templateFileUrl,String targetFileUrl,int startLen,String[] keys,List<Map<String, String>> listMap) throws IOException {
		int len = 1;
		if (!openExcel(templateFileUrl)){
			throw new AdException("模板：[" + templateFileUrl + "]打开失败！");
		} 
		for (Map<String, String> map : listMap) {
			int cellIndex = 1;
			gotoCellWriteText(0, startLen, cellIndex, String.valueOf(len),false);
			len++;
			for (String key : keys) {
				cellIndex++;
				if (map.get(key) != null && !"null".equals(map.get(key))) {
					gotoCellWriteText(0, startLen, cellIndex, map.get(key),false);
				}
			}
			startLen++;
		}
		closeExcel(targetFileUrl);
	}
	
	/**
	 * 根据模板将数据写入excel格式流
	 * 
	 * @param templateFileUrl 模板文件访问地址
	 * @param startLen 模板中起始行写入
	 * @param keys 写入数据字段顺序
	 * @param listMap 待写入数据
	 * @throws IOException
	 */
	public void writeExcel(String templateFileUrl,OutputStream out,int startLen,String[] keys,List<Map<String, String>> listMap,List<ImageBase64DTO> imgDTOList, int sheetIndex, int row, int coll) throws IOException {
		int len = 1;
		if (!openExcel(templateFileUrl)){
			throw new AdException("模板：[" + templateFileUrl + "]打开失败！");
		} 
		for (Map<String, String> map : listMap) {
			int cellIndex = 1;
			gotoCellWriteText(0, startLen, cellIndex, String.valueOf(len),false);
			len++;
			for (String key : keys) {
				cellIndex++;
				if (map.get(key) != null && !"null".equals(map.get(key))) {
					gotoCellWriteText(0, startLen, cellIndex, map.get(key),false);
				}
			}
			startLen++;
		}
		
		int imgHeight = 0;
		//int imgWidth = 0;
		for (ImageBase64DTO dto : imgDTOList) {
			//System.out.println(dto.getWidth());
			//System.out.println(dto.getHeight());
			gotoInsertPicture(base64StringToImage(dto.getBase64Img()),sheetIndex + 1,imgHeight,coll);
			imgHeight += row + Integer.valueOf(dto.getHeight()) / 15;
		}
		
		closeExcel(out);
	}
	
	/**
	 * 将图片串转换成byte流数据
	 */
	static byte[] base64StringToImage(String base64String) {
		byte[] bytes = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			bytes = decoder.decodeBuffer(base64String);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bytes;
	}
}
