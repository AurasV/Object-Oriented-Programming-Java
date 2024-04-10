public class GeometricalForm implements FormOperations {
    private int xCoord;
    private int yCoord;
    private String iColor;
    private String fColor;

    public GeometricalForm(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    public int getXCoordinate() {
        return xCoord;
    }


    public int getYCoordinate() {
        return yCoord;
    }


    public String getInnerColor() {
        return iColor;
    }

    public String getFormColor() {
        return fColor;
    }

    public void setXCoordinate(int x) {
        this.xCoord = x;
    }

    public void setYCoordinate(int y) {
        this.yCoord = y;
    }

    public void setInnerColor(String color) {
        this.iColor = color;
    }

    public void setFormColor(String color) {
        this.fColor = color;
    }


    @Override
    public void move(int x, int y) {
        setXCoordinate(x);
        setYCoordinate(y);
    }

    @Override
    public void shrink() {

    }

    @Override
    public void enlarge() {

    }

    @Override
    public void changeInnerColor(String color) {
        setInnerColor(color);
    }

    @Override
    public void changeFormColor(String color) {
        setFormColor(color);
    }

    @Override
    public String toString(){
        String show = "X: " + this.getXCoordinate();
        show += "\nY: " + this.getYCoordinate();
        show += "\nInner Color: " + this.getInnerColor();
        show += "\nForm Color: " + this.getFormColor();

        return show;
    }
}
