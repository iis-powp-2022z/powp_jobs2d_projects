package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.transformers.ComplexTransformerCommand;
import edu.kis.powp.jobs2d.command.transformers.TransformedCoords;
import edu.kis.powp.jobs2d.command.transformers.TransformerCommand;

public class TransformerDriver implements Job2dDriver {
    private Job2dDriver job2dDriver;
    private ComplexTransformerCommand transformerCommands;
    private String name;

    public TransformerDriver(Job2dDriver job2dDriver, ComplexTransformerCommand transformerCommands, String name) {
        this.job2dDriver = job2dDriver;
        this.transformerCommands = transformerCommands;
        this.name = name;
    }

    @Override
    public void setPosition(int x, int y) {
        TransformedCoords transformedCoords = transformerCommands.execute(new TransformedCoords(x, y));
        job2dDriver.setPosition(transformedCoords.getX(), transformedCoords.getY());
    }

    @Override
    public void operateTo(int x, int y) {
        TransformedCoords transformedCoords = transformerCommands.execute(new TransformedCoords(x, y));
        job2dDriver.operateTo(transformedCoords.getX(), transformedCoords.getY());
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }
}