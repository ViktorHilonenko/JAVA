package ua.training;

public class Square extends Point {
    private double side;

    public Square(double side) {
        checkSide(side);
    }

    public Square(double x, double y, double side) {
        super(x, y);
        checkSide(side);
    }

    //@Override
    public void setAllParameters(double x, double y, double side) {
        super.setAllParameters(x, y);
        setSide(side);
    }

    @Override
    public void moveCoordinate(double dX, double dY) {
        super.moveCoordinate(dX, dY);
    }

    public final void checkSide(double side) throws IllegalArgumentException {
        if( side <= 0 ){
            throw new IllegalArgumentException("side must be greater then 0");
        }
        this.side = side;
    }

    public void setSide(double side) {
        checkSide(side);
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Square{" +
                super.toString()+
                "side=" + side +
                '}';
    }
}
