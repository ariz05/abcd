package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.idemia.dob.utils.ConfigManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHook {
	private Scenario scenario;
	private static Logger logger = Logger.getLogger(AttachHook.class);

	/*@Before
	public void setUp(Scenario scenario) throws IOException {
		logger.info("Inside set up method of before hook");
		ConfigManager.loadConfig();
		this.scenario = scenario;
		System.out.println(scenario.getName());
		if (System.getenv("ExecutionPlatform") != null) {
			if (System.getenv("ExecutionPlatform").equalsIgnoreCase("Api"))
				ConfigManager.setProperty("ExecutionPlatform", "api");
			System.out.println("Environment Variable fetched from jenkins = " + System.getenv("ExecutionPlatform"));
			ConfigManager.getProperty("ExecutionPlatform");

		}

		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Api")) {
			System.out.println("API Execution Start");
		}

	}
	@After
	public void tearDown() throws InstantiationException, IllegalAccessException, IOException {
		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Api")) {
			System.out.println("API Execution Stop :) ");
		}
	}

*/}
