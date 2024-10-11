public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean compareWith(Point p) {
        return (this.x > p.x - 0.0001 && this.x < p.x + 0.0001) &&
                (this.y > p.y - 0.0001 && this.y < p.y + 0.0001) &&
                (this.z > p.z - 0.0001 && this.z < p.z + 0.0001);
    }

    public String toString(){
        String formattedX = String.format("%.3f", this.x);
        String formattedY = String.format("%.3f", this.y);
        String formattedZ = String.format("%.3f", this.z);

        return "(x" + formattedX + ", y" + formattedY + ", z" + formattedZ + ")";
    }
}
