public class Rectangle extends GeometricalForm {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void shrink() {
        if(getHeight() > 1)
            setHeight(getHeight() - 1);
        else throw new IllegalArgumentException("Height is already 1");
        if(getWidth() > 1)
            setWidth(getWidth() - 1);
        else throw new IllegalArgumentException("Width is already 1");
    }

    @Override
    public void enlarge() {
        setHeight(getHeight() + 1);
        setWidth(getWidth() + 1);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString(){
        String show = "X: " + this.getXCoordinate();
        show += "\nY: " + this.getYCoordinate();
        show += "\nInner Color: " + this.getInnerColor();
        show += "\nForm Color: " + this.getFormColor();
        show += "\nWidth: " + this.getWidth();
        show += "\nHeight: " + this.getHeight();

        return show;
    }
}
