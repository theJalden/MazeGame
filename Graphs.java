import java.awt.Color;

import javalib.colors.*;
import javalib.worldimages.Posn;


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
    
    Posn position;
    // I don't think we need these
    /*
    Edge top;
    Edge left;
    Edge bottom;
    Edge right;
    */
    
    /* maybe parameters
    boolean current;
    boolean visited;
    boolean active;
    */
    
    IColor color;
    
    ACell() {
        /*
        this.top = null;
        this.left = null;
        this.bottom = null;
        this.right = null;
        */
        this.position = null;
        this.color = new White();
    }
    
    ACell(Posn pos, IColor color) {
        /*
        this.top = new Edge(this, top);
        this.left = new Edge(this, left);
        this.bottom = new Edge(this, bottom);
        this.right = new Edge(this, right);
        */
        
        this.position = pos;
        this.color = color;
    }
    
    ACell(int col, int row) {
        this.position = new Posn(col, row);
        this.color = new White();
    }
    
    
    // TODO
    public int hashCode(){
        return 1;
    }
    
    // TODO
    public boolean equals(Object other) {
        return false;
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
    Cell() {
        super();
    }
    
    Cell(int x, int y) {
        super(x, y);
    }
}