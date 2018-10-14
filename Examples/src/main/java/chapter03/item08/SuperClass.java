package chapter03.item08;

public class SuperClass {
    private final int x;
    private final int y;

    public SuperClass(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SuperClass))
            return false;
        SuperClass sc = (SuperClass) o;
        return sc.getX() == this.getX()
                && sc.getY() == this.getY();
    }
}
