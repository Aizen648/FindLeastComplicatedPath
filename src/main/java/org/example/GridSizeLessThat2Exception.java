package org.example;

public class GridSizeLessThat2Exception extends IllegalArgumentException{
    public GridSizeLessThat2Exception() {
        super("Grid Size cannot be less that 2.");
    }
}
