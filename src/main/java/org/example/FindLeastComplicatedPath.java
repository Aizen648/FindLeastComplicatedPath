package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class FindLeastComplicatedPath {
    public static boolean DEBUG = false;
    private static final int dealt_no_reach_value = -1;
    private static final Coordinates[] directions = {
            new Coordinates(1, 0),
            new Coordinates(0, -1),
            new Coordinates(0, 1),
            new Coordinates(-1, 0)};

    private final Integer[][] cellsStatus;
    private final Coordinates start;
    private final Coordinates goal;
    private int finalMove;
    private Deque<Coordinates> cellsToVisit;
    private final int sizeofGrid;
    private enum TypeOfCell {
        START('S', -2),
        GOAL('G', -3),
        BLOCK('X', -4);
        final char responsible;
        final int valueOf;

        TypeOfCell(char responsible, int valueOf) {
            this.responsible = responsible;
            this.valueOf = valueOf;
        }

        @Override
        public String toString() {
            return Character.toString(responsible);
        }


    }
    private static class Coordinates {
        int x, y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Coordinates coordinates) {
            return coordinates.x == this.x && coordinates.y == this.y;
        }

        public Coordinates move(Coordinates coordinates) {
            return new Coordinates(this.x + coordinates.x, this.y + coordinates.y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

    }
    private FindLeastComplicatedPath(List<String> arr, int startX, int startY, int goalX, int goalY) {
        sizeofGrid = arr.size();
        cellsStatus = new Integer[sizeofGrid][sizeofGrid];
        for (int x = 0; x < sizeofGrid; x++) {
            char[] chars = arr.get(x).toCharArray();
            for (int y = 0; y < sizeofGrid; y++) {
                if (startX == x && startY == y) cellsStatus[x][y] = TypeOfCell.START.valueOf;
                else if (goalX == x && goalY == y) cellsStatus[x][y] = TypeOfCell.GOAL.valueOf;
                else if (chars[y] == 'X') cellsStatus[x][y] = TypeOfCell.BLOCK.valueOf;
            }
        }
        this.start = new Coordinates(startX, startY);
        this.goal = new Coordinates(goalX, goalY);
    }
    private int findMinimumRoute() {
        if (start.equals(goal)) return 0;
        if (sizeofGrid < 2) return dealt_no_reach_value;
        cellsToVisit = new ArrayDeque<>();
        finalMove = -1;
        Coordinates currentCell = start;
        setMovesDistance(currentCell, 0);
        do {
            if (reachNeighbors(currentCell)) return finalMove;
        } while ((currentCell = cellsToVisit.poll()) != null);
        return dealt_no_reach_value;
    }
    private boolean reachNeighbors(Coordinates currentCell) {
        if (DEBUG)
            System.out.println("Odwiedzono " + currentCell + " w " + getMovesDistance(currentCell) + " ruchach");
        int nextMove = getMovesDistance(currentCell) + 1;
        for (Coordinates direction : directions) {
            Coordinates nextCell = currentCell;
            do {
                nextCell = nextCell.move(direction);
            } while (finalMove < 0 && checkCell(nextCell, nextMove));
        }
        return finalMove >= 0;
    }

    private boolean checkCell(Coordinates nextCell, int nextMove) {
        if (nextCell.x < 0 || nextCell.x >= sizeofGrid || nextCell.y < 0 || nextCell.y >= sizeofGrid) return false;
        if (nextCell.equals(goal)) {
            if (DEBUG) System.out.println("Osiągnieto cel w " + nextMove + " ruchach");
            finalMove = nextMove;
            return false;
        }
        if (isBlocked(nextCell)) return false;
        if (this.cellsStatus[nextCell.x][nextCell.y] == null) {
            setMovesDistance(nextCell, nextMove);
            cellsToVisit.add(nextCell);
        }
        return true;
    }

    private boolean isBlocked(Coordinates curCell) {
        if (cellsStatus[curCell.x][curCell.y] == null) return false;
        return this.cellsStatus[curCell.x][curCell.y] == TypeOfCell.BLOCK.valueOf;
    }

    private int getMovesDistance(Coordinates curCell) {
        return this.cellsStatus[curCell.x][curCell.y];
    }

    private void setMovesDistance(Coordinates currentCell, int step) {
        this.cellsStatus[currentCell.x][currentCell.y] = step;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < sizeofGrid; x++) {
            sb.append('[').append(x).append(": \t");
            for (int y = 0; y < sizeofGrid; y++) {
                if (cellsStatus[x][y] == null) sb.append("  ?\t");
                else if (cellsStatus[x][y] > 0) sb.append("  ").append(cellsStatus[x][y]).append(" ");
                else if (cellsStatus[x][y] == 0) sb.append("  ").append(TypeOfCell.START).append("\t");
                else if (cellsStatus[x][y] == TypeOfCell.GOAL.valueOf)
                    sb.append("  ").append(TypeOfCell.GOAL).append("\t");
                else if (cellsStatus[x][y] == TypeOfCell.BLOCK.valueOf)
                    sb.append("  ").append(TypeOfCell.BLOCK).append("\t");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static int minimumMove(List<String> arr, int startX, int startY, int goalX, int goalY) {
        FindLeastComplicatedPath path = new FindLeastComplicatedPath(arr, startX, startY, goalX, goalY);
        int steps = path.findMinimumRoute();
        if (DEBUG) System.out.println(path);
        return steps;
    }
}