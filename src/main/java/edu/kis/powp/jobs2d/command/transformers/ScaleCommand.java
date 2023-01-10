package edu.kis.powp.jobs2d.command.transformers;

public class ScaleCommand implements TransformerCommand {
    private final double scaleX;
    private final double scaleY;

    public ScaleCommand(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public TransformedCoords execute(TransformedCoords coords) {
        return coords.scale(scaleX, scaleY);
    }
}