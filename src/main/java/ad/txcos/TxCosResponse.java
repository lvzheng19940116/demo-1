package ad.txcos;

import java.io.Serializable;

public class TxCosResponse implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7299029950271155514L;
	private int code;
    private String message;
    private String request_id;
    private UploadFileResponse data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public UploadFileResponse getData() {
        return data;
    }

    public void setData(UploadFileResponse data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TxCosResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", request_id='" + request_id + '\'' +
                ", data=" + data +
                '}';
    }
}
