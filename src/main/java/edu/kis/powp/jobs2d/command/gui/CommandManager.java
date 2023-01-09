package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.observer.Publisher;

public interface CommandManager {
    void runCommand();
    void clearCurrentCommand();
    void setCurrentCommand(DriverCommand driverCommand);
    String getCurrentCommandString();
    Publisher getChangePublisher();
}
