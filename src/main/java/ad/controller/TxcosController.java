package ad.controller;

import ad.bean.AbAdver;
import ad.bean.AbAdvertOrder;
import ad.service.IAdvertisingManService;
import ad.service.ITxcosService;
import ad.txcos.TxCosConfig;
import ad.txcos.TxCosResponse;
import ad.txcos.TxCosUtil;
import ad.util.FileUtil;
import ad.util.MessageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Desc:腾讯云对象存储用法示例
 * @Author: ZhangYue
 * @Date: create in 2018/1/31
 * @copyright Navi WeCloud
 */
@RestController
@RequestMapping("upload")
public class TxcosController {

	@Autowired
	private TxCosUtil txCosUtil;
	@Autowired
	private ITxcosService iTxcosService;

	/**
	 * 上传文件
	 * @param file
	 * @param request
	 * @param response
	 * @param type
	 * @param pageNum
	 * @param dmlType
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", produces = {
			"application/json; charset=utf-8" }, method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, Integer type, Integer pageNum, String dmlType) {// type=1上传图片，
																							// pageNum为上传第几张图片
		// null代表上传视频或doc文档
		return iTxcosService.uploadFile(file, request, response, type, pageNum, dmlType);
	}

	/**
	 *
	 * @Title: downloadFile
	 * @Description: 下载文件
	 * @return
	 */
	@RequestMapping(value = "downloadFile", produces = { "application/json; charset=utf-8" })
	public String downFile(String uuid) {
		return txCosUtil.downFile(uuid);
	}

	/**
	 *
	 * @Title: getFile
	 * @Description: 获取文件
	 * @return
	 */
	@RequestMapping(value = "getFile", produces = { "application/json; charset=utf-8" })
	public String getFile(String uuid) {
		return txCosUtil.getFileProp(uuid);
	}

}
