public class Course {
    public String name;
    public int creditPoints;


    public enum Type{
        Foundamental, Specialization, Discipline;
    }
    public enum Stream{
        English, French, German;
    }
    private final Stream stream;
    private final Type type;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Stream getStream() {
        return stream;
    }

    public Type getType() {
        return type;
    }

    public Course(String name, int creditPoints, Stream stream, Type type) {
        this.name = name;
        this.creditPoints = creditPoints;
        this.stream = stream;
        this.type = type;
    }
}
