package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.enums.RECORDING_STATUS;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.util.List;

public class RecordingManager {

    private RECORDING_STATUS status = RECORDING_STATUS.STOPPED;
    private Job2dDriver replacedDriver = null;
    private final CommandsRecorderDriver recorderDriver = new CommandsRecorderDriver();

    public void startRecording() {
        replacedDriver = DriverFeature.getDriverManager().getCurrentDriver();
        DriverFeature.getDriverManager().setCurrentDriver(recorderDriver);
        status = RECORDING_STATUS.IN_PROGRESS;
    }

    public void resumeRecording() {
        replacedDriver = DriverFeature.getDriverManager().getCurrentDriver();
        DriverFeature.getDriverManager().setCurrentDriver(recorderDriver);
        status = RECORDING_STATUS.IN_PROGRESS;
    }

    public void stopRecording() {
        DriverFeature.getDriverManager().setCurrentDriver(replacedDriver);
        status = RECORDING_STATUS.STOPPED;
    }

    public void loadRecording() {
        List<DriverCommand> commands = recorderDriver.getCommands();
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(commands, "Recorded commands");
    }

    public RECORDING_STATUS getStatus() {
        return status;
    }

    public void clearRecording() {
        recorderDriver.clear();
    }
}