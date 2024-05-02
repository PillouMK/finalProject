package com.zip.projectFinal;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoMVCController {
	@GetMapping("/display")
	public String displayMessage() {
		return "first/display";
	}
}
