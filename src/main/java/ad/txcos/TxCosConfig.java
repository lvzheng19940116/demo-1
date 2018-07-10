package ad.txcos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.sign.Credentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TxCosConfig {

	@Value("${tx_cos_config.appId}")
	private long appId;
	@Value("${tx_cos_config.secretId}")
	private String secretId;
	@Value("${tx_cos_config.secretKey}")
	private String secretKey;
	@Value("${tx_cos_config.bucketName}")
	public String bucketName;
	@Value("${tx_cos_config.region}")
	private String region;
	@Value("${tx_cos_config.local_dir}")
	private String localDir;
	@Value("${tx_cos_config.target_dir}")
	private String targetDir;

	private COSClient cosClient = null;

	@Bean
	public COSClient getCosClient() {
		if (cosClient == null) {
			// 初始化秘钥信息
			Credentials cred = new Credentials(appId, secretId, secretKey);
			// 初始化客户端配置
			ClientConfig clientConfig = new ClientConfig();
			// 设置bucket所在的区域，比如华南园区：gz； 华北园区：tj；华东园区：sh ；
			clientConfig.setRegion(region);
			// 初始化cosClient
			cosClient = new COSClient(clientConfig, cred);
		}
		return cosClient;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocalDir() {
		return localDir;
	}

	public void setLocalDir(String localDir) {
		this.localDir = localDir;
	}

	public String getTargetDir() {
		return targetDir;
	}

	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	public void setCosClient(COSClient cosClient) {
		this.cosClient = cosClient;
	}
}
