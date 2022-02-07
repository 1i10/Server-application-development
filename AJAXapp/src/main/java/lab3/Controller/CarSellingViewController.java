package lab3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarSellingViewController {
	@GetMapping("/")
    public String homePage() {
        return "index";
    }
	
	@GetMapping("/insert")
    public String insertPage() {
        return "insert";
    }
	
	@GetMapping("/update")
    public String updatePage() {
        return "update";
    }
}

