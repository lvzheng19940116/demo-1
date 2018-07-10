package ad.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ad.bean.AbAdver;
import ad.mapper.AbAdverMapper;
import ad.service.IAdvertisingManService;
import ad.service.ITxcosService;
import ad.txcos.TxCosConfig;
import ad.txcos.TxCosResponse;
import ad.txcos.TxCosUtil;
import ad.util.FileUtil;
import ad.util.MessageUtils;

@Service
public class TxcosServiceImpl implements ITxcosService {

	@Autowired
	private TxCosUtil txCosUtil;
	@Autowired
	private TxCosConfig txCosConfig;
	@Autowired
	private AbAdverMapper abAdverMapper;

	@Override
	public String uploadFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response, Integer type,
			Integer pageNum, String dmlType) {
		File f = null;
		try {
			String fileName = file.getOriginalFilename();
			// String filePath = ResourceUtils.getURL("classpath:").getPath() +
			// "upload/";
			AbAdver maxId = abAdverMapper.selectMaxId();

			Integer id = 0;
			String uuid = "";
			if (type != null && type == 1) {// 说明上传的是图片
				if (maxId == null) {
					id = 1;
				} else {
					if ("add".equals(dmlType)) { // 新增的时候maxid加1
						id = maxId.getId() + 1;
					} else {// 修改
						id = Integer.parseInt(dmlType);
					}
				}
				uuid = getUUIDName(id, pageNum, fileName); // 定义名称

			} else if (type != null && type == 2) {// 上传的是视频
				if ("add".equals(dmlType)) {
					uuid = String.valueOf(maxId.getId() + 1);
				} else {
					uuid = dmlType.toString();
				}
				uuid = getUUIDName(id, pageNum, fileName); // 定义名称
			} else if (type != null && type == 3) {
				uuid = fileName;

			}
			String filePath = txCosConfig.getLocalDir() + "upload/";
			String localFile = filePath + uuid;
			FileUtil.uploadFile(file.getBytes(), filePath, uuid);
			String targetFile = txCosConfig.getTargetDir() + uuid;
			TxCosResponse txCosResponse = txCosUtil.upload(localFile, targetFile);
			f = new File(localFile);
			String pixel = null;

			if (txCosResponse.getCode() == 0) {
				String sourceUrl = txCosResponse.getData().getSource_url();

				if (type != null && type == 1) {
					// 获取分辨率
					if (f.exists() && f.isFile()) {
						BufferedImage bi = null;
						try {
							bi = ImageIO.read(f);
						} catch (IOException e) {
							e.printStackTrace();
						}

						int width = bi.getWidth();
						int height = bi.getHeight();
						pixel = width + "X" + height;
						if ("800X480".equals(pixel) || "480X800".equals(pixel) || "1024X600".equals(pixel)
								|| "600X1024".equals(pixel) || "1024X768".equals(pixel) || "768X1024".equals(pixel)
								|| "1280X480".equals(pixel) || "720X1280".equals(pixel) || "1280X800".equals(pixel)
								|| "1920X1080".equals(pixel) || "1280X720".equals(pixel)) {
							return MessageUtils.commonReturnMessage(1, null, sourceUrl, pixel);
						} else {
							if (f != null && f.exists()) {
								f.delete();
							}
							return MessageUtils.commonReturnMessage(2, "分辨率不符");
						}
					}
				}

				if (f.exists()) {
					// 删除本地文件
					// f.delete();
				}

				return MessageUtils.commonReturnMessage(1, null, sourceUrl, pixel);
				// 保存source_url到数据库中
			} else {
				if (f != null && f.exists()) {
					// 删除本地文件
					f.delete();
				}
				return MessageUtils.commonReturnMessage(0, "上传失败");
			}

		} catch (Exception e) {
			if (f != null && f.exists()) {
				// 删除本地文件
				f.delete();
			}
			return MessageUtils.commonReturnMessage(0, "服务异常");
		}
	}

	/**
	 * 传入文件的名称，返回的唯一的名称 例如：gril.jpg 返回sdjsljfsjdl.jpg
	 * 
	 * @param filename
	 * @return
	 */
	public static String getUUIDName(Integer id, Integer pageNum, String fileName) {
		// 先查找
		int index = fileName.lastIndexOf(".");
		// // 截取
		String lastname = fileName.substring(index, fileName.length());
		//
		// String string = UUID.randomUUID().toString();
		// long currentTimeMillis = System.currentTimeMillis();
		long time = System.currentTimeMillis();
		String a = String.valueOf(time);
		String substring = a.substring(5, 13);

		// return id+"_"+pageNum.toString()+lastname;
		return substring + pageNum + lastname;
	}

}
