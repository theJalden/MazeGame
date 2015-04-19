import java.awt.Color;

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
}