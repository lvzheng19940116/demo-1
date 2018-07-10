package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface ITxcosService {

	String uploadFile(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, Integer type,Integer pageNum,String dmlType);
}
