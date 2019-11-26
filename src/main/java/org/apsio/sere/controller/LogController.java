package org.apsio.sere.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

	@CrossOrigin
    @RequestMapping("/logger")
    public void logger(@RequestParam(value="message") String message) {
		System.out.println(message);
    }
}
