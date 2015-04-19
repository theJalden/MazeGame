// Assignment 10
// Sam Berin, Joseph Moore


import java.awt.Color;
import java.util.ArrayList;

import javalib.impworld.*;
import javalib.colors.*;
import javalib.worldimages.*;






class MazeGame extends World {
    static final int W_WIDTH = 1000;
    static final int W_HEIGHT = 600;
    
    static final int B_WIDTH_SMALL = 10;
    static final int B_WIDTH_MEDIUM = 25;
    static final int B_WIDTH_LARGE = 100;
    
    static final int B_HEIGHT_SMALL = 6;
    static final int B_HEIGHT_MEDIUM = 15;
    static final int B_HEIGHT_LARGE = 60;
    
    static final int CELL_SIZE_SMALL = W_WIDTH / B_HEIGHT_SMALL;
    static final int CELL_SIZE_MEDIUM = W_WIDTH / B_HEIGHT_MEDIUM;
    static final int CELL_SIZE_LARGE = W_WIDTH / B_HEIGHT_LARGE;
    
    static final WorldImage BG = new RectangleImage(
            new Posn(W_WIDTH/2, (100 + W_HEIGHT)/2), 
            W_WIDTH, (100 + W_HEIGHT),
            new Black()).overlayImages(
                    new RectangleImage(new Posn(W_WIDTH/2, W_HEIGHT/2), 
                                       W_WIDTH, W_HEIGHT,
                                       new White()));
    
    
    
    ArrayList<ArrayList<Cell>> cellss;
    ArrayList<Edge> maze;
    
    MazeGame() {
        this.cellss = this.initCellss(1);
        this.maze = this.initMaze();
        
    }
    
    ArrayList<ArrayList<Cell>> initCellss(int type) {
        // type = 1 :: small
        // type = 2 :: medium
        // type = 3 :: large
        int width, height;
        
        if (type == 1) {
            width = MazeGame.B_WIDTH_SMALL;
            height = MazeGame.B_HEIGHT_SMALL;
        }
        else if (type == 2) {
            width = MazeGame.B_WIDTH_MEDIUM;
            height = MazeGame.B_HEIGHT_MEDIUM;
        }
        else if (type == 3) {
            width = MazeGame.B_WIDTH_LARGE;
            height = MazeGame.B_HEIGHT_MEDIUM;
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
                temp.add(new Cell());
            }
            
            ret.add(temp);
        }
        
     
        return ret;
        
    }
    
    
    ArrayList<Edge> initMaze() {
        ArrayList<Edge> edges = new ArrayList<Edge>();

        boolean onRight, onBottom;

        // adds a new edge for every node to the right and bottom
        // execpt for the rightmost nodes and the bottom most nodes

        // i represents the col of the arraylist of cells
        
        int width, height;
        
        width = this.cellss.size();
        height = this.cellss.get(0).size();
        
        for (int i = 0; i < width; i += 1) {

            if (i >= width - 1) {onRight = true;}
            else {onRight = false;}

            // j represents the position within the ith col
            for (int j = 0; j < height; j += 1) {

                if (j >= height - 1) {onBottom = true;}
                else {onBottom = false;}

                if (!onRight) {
                    edges.add(new Edge((this.cellss.get(i)).get(j), (this.cellss.get(i+1)).get(j)));
                }

                if (!onBottom) {
                    edges.add(new Edge(this.cellss.get(i).get(j), this.cellss.get(i).get(j+1)));
                }
            }
        }


        // randomize edges
        for (Edge edge: edges) {
            edge.changeWeight(Math.random());
        }

        // sort edges
        edges = this.sortEdges(edges);

        return edges;
    }
    
    // Quick sort algorithm, could be made more efficient
    ArrayList<Edge> sortEdges(ArrayList<Edge> edges) {
        
        ArrayList<Edge> lower = new ArrayList<Edge>();
        ArrayList<Edge> higher = new ArrayList<Edge>();
        
        // base case
        if (edges.size() <= 1) {return edges;}
        
        Edge pivot = edges.get(0);
        
        for (Edge e: edges) {
            if (e.weight < pivot.weight) {
                lower.add(e);
            }
            else if (e.weight > pivot.weight){
                higher.add(e);
            }
        }
        
        
        lower = this.sortEdges(lower);
        higher = this.sortEdges(higher);
        
        lower.add(pivot);
        lower.addAll(higher);
        
        return lower;
        
        
    }
    

    public WorldImage makeImage() {
        return BG;
    }
    
    
}