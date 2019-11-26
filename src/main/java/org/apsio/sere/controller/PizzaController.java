package org.apsio.sere.controller;

import org.apsio.sere.PizzaUtil;
import org.apsio.sere.model.Pizza;
import org.apsio.sere.model.PizzaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PizzaController {

	private static final String template = "Commande %s";
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@CrossOrigin
	@RequestMapping(value={"/commanderPizza"})
	public PizzaResponse commanderPizza(@RequestParam(value="name", defaultValue="World") String name) {
		if (!this.rollSuccess(80)) {
			throw new RuntimeException("Simulation d'echec de commande");
		}
		int duration = ThreadLocalRandom.current().nextInt(500, 2501);
		if (duration > 2000) {
			duration += ThreadLocalRandom.current().nextInt(500, 2501);
		}
		this.logger.info("API GET /commanderPizza (" + duration + " ms)");
		try {
			Thread.sleep(duration);
		}
		catch (InterruptedException interruptedException) {
			// empty catch block
		}
		long commandeCounter = this.counter.incrementAndGet();
		return new PizzaResponse(commandeCounter, String.format(template, commandeCounter));
	}

	private boolean rollSuccess(int poucentSuccess) {
		int isSuccess = ThreadLocalRandom.current().nextInt(0, 101);
		return isSuccess < poucentSuccess;
	}

	@CrossOrigin
	@RequestMapping(value={"/commanderPizza"}, method={RequestMethod.POST})
	public PizzaResponse commanderPizza2(@RequestParam(value="base") String base, @RequestParam(value="pate") String pate, @RequestParam(value="anchois") String anchois, @RequestParam(value="miel") String miel, @RequestParam(value="magret") String magret, @RequestParam(value="jambon") String jambon) {
		if (!this.rollSuccess(80)) {
			throw new RuntimeException("Simulation d'echec de commande");
		}
		boolean isMiel = false;
		boolean isJambon = false;
		boolean isMagret = false;
		boolean isAnchois = false;
		isMiel = Boolean.parseBoolean(miel);
		isJambon = Boolean.parseBoolean(jambon);
		isMagret = Boolean.parseBoolean(magret);
		isAnchois = Boolean.parseBoolean(anchois);
		int duration = ThreadLocalRandom.current().nextInt(500, 2501);
		if (duration > 2000) {
			duration += ThreadLocalRandom.current().nextInt(500, 2501);
		}
		this.logger.info("API POST /commanderPizza (" + duration + " ms)");
		Pizza pizza = new Pizza("sur mesure", pate, base, isMiel, isAnchois, isJambon, isMagret);
		try {
			Thread.sleep(duration);
		}
		catch (InterruptedException interruptedException) {
			// empty catch block
		}
		long commandeCounter = this.counter.incrementAndGet();
		this.logger.info("Commande " + this.counter + " d'une " + pizza.toString());
		return new PizzaResponse(commandeCounter, String.format(template, commandeCounter));
	}

	@CrossOrigin
	@RequestMapping(value={"/hello"})
	public String hello(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello " + name;
	}

	@CrossOrigin
	@RequestMapping(value={"/logger/info"})
	public String info(@RequestParam(value="message") String message) {
		this.logger.info(message);
		return "";
	}

	@CrossOrigin
	@RequestMapping(value={"/logger/warn"})
	public String warn(@RequestParam(value="message") String message) {
		this.logger.warn(message);
		return "";
	}

	@CrossOrigin
	@RequestMapping(value={"/logger/error"})
	public String error(@RequestParam(value="message") String message) {
		this.logger.error(message);
		return "";
	}

	@CrossOrigin
	@RequestMapping(value={"/test"})
	public String test() {
		int duration = ThreadLocalRandom.current().nextInt(500, 2501);
		try {
			Thread.sleep(duration);
		}
		catch (InterruptedException interruptedException) {
			// empty catch block
		}
		return "Hello World";
	}

	@CrossOrigin
	@RequestMapping(value={"/pizzas"})
	public List<Pizza> pizzas() {
		int duration = ThreadLocalRandom.current().nextInt(500, 2501);
		this.logger.info("API GET /pizzas (" + duration + " ms)");
		try {
			Thread.sleep(duration);
		}
		catch (InterruptedException interruptedException) {
			// empty catch block
		}
		return PizzaUtil.getPizzas();
	}
}