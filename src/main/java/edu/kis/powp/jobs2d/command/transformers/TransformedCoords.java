package edu.kis.powp.jobs2d.command.transformers;

public class TransformedCoords {
    private int x;
    private int y;

    public TransformedCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TransformedCoords scale(double scaleX, double scaleY) {
        x = (int) (x * scaleX);
        y = (int) (y * scaleY);
        return this;
    }

    public TransformedCoords translate(double translateX, double translateY) {
        x += (int) translateX;
        y += (int) translateY;
        return this;
    }

    public TransformedCoords rotate(double angle) {
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));
        x = (int) (x * cos - y * sin);
        y = (int) (x * sin + y * cos);
        return this;
    }
}