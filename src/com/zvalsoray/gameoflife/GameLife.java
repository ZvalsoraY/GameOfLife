package com.zvalsoray.gameoflife;

// Game of Life
public class GameLife {
    private int[][] map;
    private final int rows;
    private final int columns;

    public GameLife(int[][] map)
    {
        this.map = map;
        rows = map.length;
        columns = map[0].length;
    }

    /**
     * Alive neighbors count per point location.
     * @param row row coordinate
     * @param column column coordinate
     * @return number of alive neighbors
     */
    public int countAliveNeighbors(int row, int column)
    {
        int aliveNeighbours = 0;
        aliveNeighbours -= map[row][column];
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++) {
                if((row + i >= 0 && row + i < rows) && (column + j >= 0 && column + j < columns)){
                    aliveNeighbours += map[row + i ][column + j];
                }
            }
        }
        return aliveNeighbours;
    }

    /**
     * Next map generator.
     */
    public void nextMapGen()
    {
        int[][] nextMapGen = new int[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                int neighbors = countAliveNeighbors(i, j);
                if (map[i][j] == 1 && (neighbors < 2 || neighbors > 3 )){
                    nextMapGen[i][j] = 0; // dies
                }
                else if ((map[i][j] == 0) && (neighbors == 3)) {
                    nextMapGen[i][j] = 1; // born
                }
                else {
                    nextMapGen[i][j] = map [i][j]; // the same
                }
            }
        }
        map = nextMapGen;
    }

    /**
     * Map printer.
     */
    public void printmap(){
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
