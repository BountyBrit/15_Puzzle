package com.example.a15_puzzle;

/*
 * Board
 *
 * This class represents the board of buttons/tiles.
 * Methods within this class move tiles, gets tiles
 * and checks if the board is solved
 *
 * @author M. Brit Dannen
 * @version February 2023
 */
public class Board {
    private int[][] tiles;

    public Board() {
        tiles = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j] = i * 4 + j + 1;
            }
        }
        tiles[3][3] = 0;
    }

    // getTile returns the tile at a certain row and col
    public int getTile(int row, int col) {
        return tiles[row][col];
    }

    // moveTile moves the tile from a row and col to a new rol and col
    public void moveTile(int fromRow, int fromCol, int toRow, int toCol) {
        int temp = tiles[fromRow][fromCol];
        tiles[fromRow][fromCol] = tiles[toRow][toCol];
        tiles[toRow][toCol] = temp;
    }

    // isSolved checks the board if it is solved
    public boolean isSolved() {
        int n = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tiles[i][j] != n && !(i == 3 && j == 3 && tiles[i][j] == 0)) {
                    return false;
                }
                n++;
            }
        }
        return true;
    }
}

