package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.LoggerDriver;
import edu.kis.powp.observer.Publisher;
import edu.kis.powp.jobs2d.command.transformers.ComplexTransformerCommand;
import edu.kis.powp.jobs2d.drivers.adapter.TransformerDriver;

/**
 * Driver manager provides means to setup the driver. It also enables other
 * components and features of the application to react on configuration changes.
 */
public class DriverManager {

	private Job2dDriver currentDriver = new LoggerDriver();
	private final Publisher changePublisher = new Publisher();


	/**
	 * @param driver Set the driver as current.
	 */
	public synchronized void setCurrentDriver(Job2dDriver driver) {

		currentDriver = driver;
		changePublisher.notifyObservers();
	}

	public Job2dDriver transformCurrentDriver(ComplexTransformerCommand transformerCommands, String name) {
		currentDriver = new TransformerDriver(currentDriver, transformerCommands, name);
		return currentDriver;
	}
	/**
	 * @return Current driver.
	 */
	public synchronized Job2dDriver getCurrentDriver() {
		return currentDriver;
	}

	public Publisher getChangePublisher() {
		return changePublisher;
	}
}
