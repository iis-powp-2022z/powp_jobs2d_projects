package edu.kis.powp.jobs2d.command.transformers;

public class TranslateCommand implements TransformerCommand {
    private final int x;
    private final int y;

    public TranslateCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public TransformedCoords execute(TransformedCoords coords) {
        return coords.translate(x, y);
    }
}