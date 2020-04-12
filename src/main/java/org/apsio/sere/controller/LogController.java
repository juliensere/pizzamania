package org.apsio.sere.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@CrossOrigin
    @RequestMapping("/logger")
    public void logger(@RequestParam(value="message") String message) {
		System.out.println(message);
    }

    @CrossOrigin
    @RequestMapping(value={"/logger/info"})
    public String info(@RequestParam(value="message") String message) {
        this.logger.info("Log : " + message);
        return "";
    }

    @CrossOrigin
    @RequestMapping(value={"/logger/warn"})
    public String warn(@RequestParam(value="message") String message) {
        this.logger.warn("Log : " + message);
        return "";
    }

    @CrossOrigin
    @RequestMapping(value={"/logger/error"})
    public String error(@RequestParam(value="message") String message) {
        this.logger.error("Log : " + message);
        return "";
    }
}
