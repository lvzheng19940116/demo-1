package ad.bean;

import java.io.Serializable;

public class ImgObject implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 6319003854391818008L;
	private String Img;

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	@Override
	public String toString() {
		return "ImgObject [Img=" + Img + "]";
	}
	
}
