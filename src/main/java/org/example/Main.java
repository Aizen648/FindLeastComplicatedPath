package org.example;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
        //TODO: You can resize the grid. Grid size should be > 1. Otherwise it will throw an exception
        int sizeGrid = 15;
        //TODO: You can see the process of finding a solution.
        FindLeastComplicatedPath.DEBUG = true;

        List<String> grid = null;
        int startX;
        int startY;
        int goalX;
        int goalY;

        try {
            grid = Grid.generate(sizeGrid);
            startX = generator.nextInt(sizeGrid);
            startY = generator.nextInt(sizeGrid);
            goalX =  generator.nextInt(sizeGrid);
            goalY =  generator.nextInt(sizeGrid);
        } catch (GridSizeLessThat2Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(grid);
        try {
            System.out.println("We start from the starting point (" + startX + "," + startY + ") and we're trying to get to (" + goalX + "," + goalY + ")");
            int step = FindLeastComplicatedPath.minimumMove(grid, startX, startY, goalX, goalY);
            if(step == -1)
                System.out.println("the road doesn't exist");
            else
                System.out.println("the minimum number of steps needed is "+step);
        }
        catch (NullPointerException npe){
            System.out.println("grid is set to null");
        }
    }
}
