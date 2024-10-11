public class UnitVector {
    private double i;
    private double j;
    private double k;

    public UnitVector(double i, double j, double k){
        double magnitude = Math.sqrt(i*i + j*j + k*k);
        if (1 <= magnitude - .0001 && 1 >= magnitude + .0001){
            this.i = i / magnitude;
            this.j = j / magnitude;
            this.k = k / magnitude;
        }

    }

    public UnitVector (Point start, Point end){
        this.i = end.getX() - start.getX();
        this.j = end.getY() - start.getY();
        this.k = end.getZ() - start.getZ();
        double magnitude = Math.sqrt(i*i + j*j + k*k);
        if (1 <= magnitude - .0001 && 1 >= magnitude + .0001){
            this.i = i / magnitude;
            this.j = j / magnitude;
            this.k = k / magnitude;
        }


    }
    public UnitVector(){
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    public double getI() {
        return i;
    }

    public double getJ() {
        return j;
    }

    public double getK() {
        return k;
    }

    public boolean compareWith(UnitVector vector) {
        return (this.i > vector.i - 0.0001 && this.i < vector.i + 0.0001) &&
                (this.j > vector.j - 0.0001 && this.j < vector.j + 0.0001) &&
                (this.k > vector.k - 0.0001 && this.k < vector.k+ 0.0001);
    }

    public UnitVector crossProduct(UnitVector b){
        i=this.j*b.k-this.k*b.j;
        j=this.i*b.k-this.k*b.i;
        k=this.i*b.k+this.j*b.i;
        double magnitude = Math.sqrt(i*i + j*j + k*k);
        if (1 <= magnitude - .0001 && 1 >= magnitude + .0001){
            this.i /= magnitude;
            this.j /= magnitude;
            this.k /= magnitude;
        }

        return this;

        }

        public String toString(){
            String formattedX = String.format("%.3f", this.i);
            String formattedY = String.format("%.3f", this.j);
            String formattedZ = String.format("%.3f", this.k);
            if (i != 0 && j != 0 && k != 0){
                return "<InvalidUnitVector>";
            }
            else {
                return "<" + i + "i, " + j + "j, " + k + "k>";
            }

        }

}
