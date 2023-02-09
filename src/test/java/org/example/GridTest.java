package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void generate_GridSizeNegative_ThrowsGridSizeLessThat2Exception() {
        int sizeGrid = -1;
        assertThrows(GridSizeLessThat2Exception.class,()->Grid.generate(sizeGrid));
    }
    @Test
    void generate_GridSizeTooSmall_ThrowsGridSizeLessThat2Exception() {
        int sizeGrid = 1;
        assertThrows(GridSizeLessThat2Exception.class,()->Grid.generate(sizeGrid));
    }
    @Test
    void generate_GridSizeTooOk2_GridSizeEquals2() {
        int sizeGrid = 2;
        assertEquals(sizeGrid,Grid.generate(sizeGrid).size());
    }
    @Test
    void generate_GridSizeTooOk300_GridSizeEquals300() {
        int sizeGrid = 300;
        assertEquals(sizeGrid,Grid.generate(sizeGrid).size());
    }
    @Test
    void generate_GridSizeTooBig_GridSizeEquals300() {
        int sizeGrid = 301;
        assertEquals(300,Grid.generate(sizeGrid).size());
    }
}