package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindLeastComplicatedPathTest {

    @Test
    void minimumMove_StartEqualGoalStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(0,FindLeastComplicatedPath.minimumMove(grid,0,0,0,0));
    }
    @Test
    void minimumMove_Take1SmallStepStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,0,0,1,0));
    }
    @Test
    void minimumMove_Take1BigStepStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,0,0,3,0));
    }
    @Test
    void minimumMove_Take2StepsSmallStepsStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(2,FindLeastComplicatedPath.minimumMove(grid,0,0,1,1));
    }
    @Test
    void minimumMove_Take2StepsBigStepsStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(2,FindLeastComplicatedPath.minimumMove(grid,0,0,3,3));
    }
    @Test
    void minimumMove_CantReachStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(-1,FindLeastComplicatedPath.minimumMove(grid,0,0,0,3));
    }
    @Test
    void minimumMove_CanReachWalls1StepStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,0,0,0,2));
    }
    @Test
    void minimumMove_CanReachWalls3StepStart00_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(3,FindLeastComplicatedPath.minimumMove(grid,0,0,1,3));
    }
    @Test
    void minimumMove_StartEqualGoalStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(0,FindLeastComplicatedPath.minimumMove(grid,1,1,1,1));
    }
    @Test
    void minimumMove_Take1SmallStepStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,1,1,1,0));
    }
    @Test
    void minimumMove_Take1BigStepStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,1,1,3,1));
    }
    @Test
    void minimumMove_Take2StepsSmallStepsStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(2,FindLeastComplicatedPath.minimumMove(grid,1,1,2,2));
    }
    @Test
    void minimumMove_Take2StepsBigStepsStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(2,FindLeastComplicatedPath.minimumMove(grid,1,1,3,3));
    }
    @Test
    void minimumMove_CantReachStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(-1,FindLeastComplicatedPath.minimumMove(grid,1,1,0,3));
    }
    @Test
    void minimumMove_CanReachWalls1StepStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,1,1,1,2));
    }
    @Test
    void minimumMove_CanReachWalls3StepStart11_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(3,FindLeastComplicatedPath.minimumMove(grid,1,1,1,3));
    }

    @Test
    void minimumMove_StartEqualGoalStart03_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(0,FindLeastComplicatedPath.minimumMove(grid,0,3,0,3));
    }
    @Test
    void minimumMove_CanReachWallTake1SmallStepStart03_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,0,3,0,2));
    }
    @Test
    void minimumMove_CantReachStart03_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(-1,FindLeastComplicatedPath.minimumMove(grid,0,3,0,0));
    }
    @Test
    void minimumMove_CantReachWallsStart03_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(-1,FindLeastComplicatedPath.minimumMove(grid,0,3,1,2));
    }
    @Test
    void minimumMove_StartEqualGoalStartInWall_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(0,FindLeastComplicatedPath.minimumMove(grid,0,2,0,2));
    }
    @Test
    void minimumMove_Take1SmallStepStartInWall_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(1,FindLeastComplicatedPath.minimumMove(grid,0,2,0,3));
    }
    @Test
    void minimumMove_Take3StepStartInWall_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(3,FindLeastComplicatedPath.minimumMove(grid,0,2,3,3));
    }
    @Test
    void minimumMove_CanReachWallStartInWall_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("..X.","..XX","....","...."));
        assertEquals(2,FindLeastComplicatedPath.minimumMove(grid,0,2,1,3));
    }

    @Test
    void minimumMove_GridSize15Start68_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("....X.XXX.XX.XX",
                ".XX.XX.XX..X..X", "......XX..X....",
                ".XXX..XXX..X.X.", "X.X..X.....X.XX",
                "X.X...X..XX....", ".............XX",
                ".X..X.XX.......", ".XXX.X..X..XX..",
                "X....XX....X.X.", ".........XX.X..",
                "....X..X.XXX.X.", "..XX......XXXX.",
                ".....X..X....X.", "X....X....X.XX."));
        assertEquals(4, FindLeastComplicatedPath.minimumMove(grid, 6, 8, 3, 2));
    }
    @Test
    void minimumMove_GridSize15Start38_Equals() {
        List<String> grid = new ArrayList<>(Arrays.asList("....X.XXX.XX.XX",
                ".XX.XX.XX..X..X", "......XX..X....",
                ".XXX..XXX..X.X.", "X.X..X.....X.XX",
                "X.X...X..XX....", ".............XX",
                ".X..X.XX.......", ".XXX.X..X..XX..",
                "X....XX....X.X.", ".........XX.X..",
                "....X..X.XXX.X.", "..XX......XXXX.",
                ".....X..X....X.", "X....X....X.XXX"));
        assertEquals(6, FindLeastComplicatedPath.minimumMove(grid, 3, 8, 12, 3));
    }

}