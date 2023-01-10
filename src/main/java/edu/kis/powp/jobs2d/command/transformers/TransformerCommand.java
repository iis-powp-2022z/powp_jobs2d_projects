package edu.kis.powp.jobs2d.command.transformers;

public interface TransformerCommand {
    TransformedCoords execute(TransformedCoords coords);
}