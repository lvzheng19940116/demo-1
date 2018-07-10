package ad.txcos;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.GetFileLocalRequest;
import com.qcloud.cos.request.StatFileRequest;
import com.qcloud.cos.request.UploadFileRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

@Configuration
@Import(TxCosConfig.class)
public class TxCosUtil {
    private static final Logger logger = LoggerFactory.getLogger(TxCosUtil.class);
    @Autowired
    private TxCosConfig txCosConfig;
    @Autowired
    private COSClient cosClient;
    public String filePath="";

    /**
     * @param localfile
     * @param targetFile
     * @return
     */
    public TxCosResponse upload(String localfile, String targetFile) {
        TxCosResponse txCosResponse = null;
        try {
            UploadFileRequest uploadFileRequest = new UploadFileRequest(txCosConfig.bucketName, filePath+targetFile, localfile);
            String uploadFileRet = cosClient.uploadFile(uploadFileRequest);
            if (!StringUtils.isEmpty(uploadFileRet)) {
                txCosResponse = JSONObject.parseObject(uploadFileRet, TxCosResponse.class);
            }
        } catch (Exception e) {
            logger.error("请求腾讯对象存储服务异常{},BuketName:{},目标存储地址：{}", e, txCosConfig.bucketName, filePath+targetFile);
        }

        return txCosResponse;
    }

    /**
     *
     * @Title: downFile
     * @Description: 下载文件
     * @return
     */
    public String downFile( String targetFile) {
        String cosFilePath = txCosConfig.getTargetDir()+targetFile;
        String localPathDown = "E:/test/"+targetFile;
        GetFileLocalRequest getFileLocalRequest = new GetFileLocalRequest(txCosConfig.bucketName, cosFilePath, localPathDown);
        getFileLocalRequest.setUseCDN(false);
        getFileLocalRequest.setReferer("*.myweb.cn");
        String getFileResult = cosClient.getFileLocal(getFileLocalRequest);
        return getFileResult;
    }

    /**
     *
     * @Title: getFileProp
     * @Description: 获取文件
     * @return
     */
    public String getFileProp(String targetFile) {
        String cosFilePath = txCosConfig.getTargetDir()+targetFile;
        StatFileRequest statFileRequest = new StatFileRequest(txCosConfig.bucketName, cosFilePath);
        String statFileRet = cosClient.statFile(statFileRequest);
        return statFileRet;
    }

    
}
