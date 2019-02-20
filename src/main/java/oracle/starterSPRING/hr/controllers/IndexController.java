package oracle.starterSPRING.hr.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController{
	
	private static final String PATH = "/error";
	
	public String getErrorPath() {
		return PATH;
	}
	
	
	public String error() {
		return "mapping issue" + this.getErrorPath();
	}

}
