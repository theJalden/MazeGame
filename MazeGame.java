// Assignment 10
// Sam Berin, Joseph Moore


import java.awt.Color;
import java.util.ArrayList;

import tester.*;
import javalib.impworld.*;
import javalib.colors.*;
import javalib.worldimages.*;



class Edge {
    ACell from;
    ACell to;
    double weight;
    
    Edge(ACell from, ACell to) {
        this.from = from;
        this.to = to;
        
        this.weight = 1.0;
    }
    
    Edge(ACell from, ACell to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    void changeWeight(double factor) {
        this.weight = this.weight * factor;
    }
}

abstract class ACell {    
    
    Edge top;
    Edge left;
    Edge bottom;
    Edge right;
    
    /* maybe parameters
    boolean current;
    boolean visited;
    boolean active;
    */
    
    Color color;
    
    ACell() {
        this.top = null;
        this.left = null;
        this.bottom = null;
        this.right = null;
    }
    
    ACell(ACell top, ACell left, ACell bottom, ACell right, Color color) {
        this.top = new Edge(this, top);
        this.left = new Edge(this, left);
        this.bottom = new Edge(this, bottom);
        this.right = new Edge(this, right);
        
        this.color = color;
    }
    
    
    /*
    WorldImage drawCell(Posn pos) {
        return new RectangleImage(pos, MazeGame.)
    }
    */
    
}

// For cells on the edges to connect to
class NullCell extends ACell{
    ;
}


class Cell extends ACell {
    
}


class MazeGame extends World {
    static final int WINDOW_WIDTH = 500;
    static final int WINDOW_HEIGHT = 300;
    
    static final int BOARD_WIDTH_SMALL = 10;
    static final int BOARD_WIDTH_MEDIUM = 25;
    static final int BOARD_WIDTH_LARGE = 100;
    
    static final int BOARD_HEIGHT_SMALL = 6;
    static final int BOARD_HEIGHT_MEDIUM = 15;
    static final int BOARD_HEIGHT_LARGE = 60;
    
    static final int CELL_SIZE_SMALL = WINDOW_WIDTH / BOARD_HEIGHT_SMALL;
    static final int CELL_SIZE_MEDIUM = WINDOW_WIDTH / BOARD_HEIGHT_MEDIUM;
    static final int CELL_SIZE_LARGE = WINDOW_WIDTH / BOARD_HEIGHT_LARGE;
    
    
    ArrayList<ArrayList<Cell>> cellss;
    
    MazeGame() {
        this.cellss = this.initCellss(1);
    }
    
    ArrayList<ArrayList<Cell>> initCellss(int type) {
        // type = 1 :: small
        // type = 2 :: medium
        // type = 3 :: large
        int width, height;
        
        if (type == 1) {
            width = MazeGame.BOARD_WIDTH_SMALL;
            height = MazeGame.BOARD_HEIGHT_SMALL;
        }
        else if (type == 2) {
            width = MazeGame.BOARD_WIDTH_MEDIUM;
            height = MazeGame.BOARD_HEIGHT_MEDIUM;
        }
        else if (type == 3) {
            width = MazeGame.BOARD_WIDTH_LARGE;
            height = MazeGame.BOARD_HEIGHT_MEDIUM;
        }
        else { throw new IllegalArgumentException("type needs to be 1, 2, or 3; you gave:  " + Integer.toString(type));}
        
        

        // the height is the number of colums
        // the width is the number of cells in each colum
        // highest index on bottom right
        // 0,0 top left
        
        ArrayList<ArrayList<Cell>> ret = new ArrayList<ArrayList<Cell>>();
        
        for (int i = 0; i < width; i += 1) {
            
            ArrayList<Cell> temp = new ArrayList<Cell>();
            
            for (int j = 0; j < height; j += 1) {
                temp.add(new Cell(  /*whatever will go here*/
                        ));
            }
        }
        
        ArrayList<Edge> edges = new ArrayList<Edge>();
        
        boolean onTop, onLeft, onRight, onBottom;
        for (int i = 0; i < width; i += 1) {
            
            if (i == 0) {onLeft = true;}
            else {onLeft = false;}
            
            if (i == width - 1) {onRight = true;}
            else {onRight = false;}
            
            for (int j = 0; j < height; j += 1) {
                if (j == 0) {onTop = true;}
                else {onTop = false;}
                
                if (j == height - 1) {onBottom = true;}
                else {onBottom = false;}
                
                if (!onLeft) {
                    edges.add(new Edge(ret.get(i).get(j), ret.get(i+1).get(j)));
                }
                
                if (!onBottom) {
                    edges.add(new Edge(ret.get(i).get(j), ret.get(i).get(j+1)));
                }
            }
        }
        
     
        return null;
        
    }

    @Override
    public WorldImage makeImage() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}