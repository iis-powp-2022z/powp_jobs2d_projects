package edu.kis.powp.jobs2d.command.transformers;

import java.util.List;

public class ComplexTransformerCommand implements TransformerCommand {
    private List<TransformerCommand> transformerCommands;

    public ComplexTransformerCommand(List<TransformerCommand> transformerCommands) {
        this.transformerCommands = transformerCommands;
    }

    @Override
    public TransformedCoords execute(TransformedCoords coords) {
        TransformedCoords transformedCoords = coords;
        for (TransformerCommand command : transformerCommands)
            transformedCoords = command.execute(transformedCoords);
        return transformedCoords;
    }
}