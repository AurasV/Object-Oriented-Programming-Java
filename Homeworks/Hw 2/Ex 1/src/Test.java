public class Test {
    public static void main(String[] args) {
        GeometricalForm x = new Rectangle(1,2,3,4);
        GeometricalForm y = new Elipse(2,3,4,5);
        GeometricalForm z = new GeometricalForm(3,4);

        System.out.println("Rectangle: ");
        x.changeInnerColor("Red");
        x.changeFormColor("Green");
        x.move(2,3);
        x.shrink();
        System.out.println(x.toString());
        x.enlarge();
        System.out.println("---------------------------------");
        System.out.println(x.toString());

        System.out.println("---------------------------------");

        System.out.println("Elipse: ");
        y.changeInnerColor("Blue");
        y.changeFormColor("Yellow");
        y.move(3,4);
        y.shrink();
        System.out.println(y.toString());
        y.enlarge();
        System.out.println("---------------------------------");
        System.out.println(y.toString());

        System.out.println("---------------------------------");

        System.out.println("GeometricalForm: ");
        z.changeInnerColor("Black");
        z.changeFormColor("White");
        z.move(4,5);
        z.shrink();
        System.out.println(z.toString());
        System.out.println("---------------------------------");
        z.enlarge();
        System.out.println(z.toString());
    }
}