package chapter03.item08;

public class SubClass extends SuperClass {
    private final String type;

    public SubClass(int x, int y, String type) {
        super(x,y);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SubClass))
            return false;
        SubClass sc = (SubClass) o;
        return this.getX() == sc.getX()
                && this.getY() == sc.getY()
                && this.getType() == null ? sc.getType() == null : this.getType().equals(sc.getType());
    }
}
