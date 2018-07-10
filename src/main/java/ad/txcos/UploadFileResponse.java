package ad.txcos;

import java.io.Serializable;

public class UploadFileResponse implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8133783803775241335L;
	private String access_url;
    private String resource_path;
    private String source_url;
    private String url;

    public String getAccess_url() {
        return access_url;
    }

    public void setAccess_url(String access_url) {
        this.access_url = access_url;
    }

    public String getResource_path() {
        return resource_path;
    }

    public void setResource_path(String resource_path) {
        this.resource_path = resource_path;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "access_url='" + access_url + '\'' +
                ", resource_path='" + resource_path + '\'' +
                ", source_url='" + source_url + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
