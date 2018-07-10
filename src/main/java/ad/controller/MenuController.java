package ad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ad")
public class MenuController {
	@RequestMapping("/menu")
	public String menuList(){
		
		
		return "";
	}

}
