public class Elipse extends GeometricalForm{

    private int hRadius;
    private int vRadius;

    public Elipse(int x, int y, int hRadius, int vRadius){
        super(x,y);
        this.hRadius = hRadius;
        this.vRadius = vRadius;
    }

    @Override
    public void shrink() {
        if(getHorizRadius() > 1)
            setHorizRadius(getHorizRadius() - 1);
        else throw new IllegalArgumentException("Horizontal radius is already 1");
        if(getVertRadius() > 1)
            setVertRadius(getVertRadius() - 1);
        else throw new IllegalArgumentException("Vertical radius is already 1");
    }

    @Override
    public void enlarge() {
        setHorizRadius(getHorizRadius() + 1);
        setVertRadius(getVertRadius() + 1);
    }

    public int getHorizRadius() {
        return hRadius;
    }

    public void setHorizRadius(int hRadius) {
        this.hRadius = hRadius;
    }

    public int getVertRadius() {
        return vRadius;
    }

    public void setVertRadius(int vRadius) {
        this.vRadius = vRadius;
    }

    @Override
    public String toString(){
        String show = "X: " + this.getXCoordinate();
        show += "\nY: " + this.getYCoordinate();
        show += "\nInner Color: " + this.getInnerColor();
        show += "\nForm Color: " + this.getFormColor();
        show += "\nHorizontal Radius: " + this.getHorizRadius();
        show += "\nVertical Radius: " + this.getVertRadius();

        return show;
    }
}