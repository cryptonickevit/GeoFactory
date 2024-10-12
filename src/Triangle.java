public class Triangle {
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private UnitVector surfaceNormal;

    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        UnitVector AB = new UnitVector(vertexA, vertexB); // Vector from A to B
        UnitVector AC = new UnitVector(vertexA, vertexC);

        surfaceNormal = AB.crossProduct(AC);

    }

    public Triangle(){
        this.vertexA = new Point();
        this.vertexB = new Point();
        this.vertexC = new Point();
        surfaceNormal = new UnitVector();
    }

    public Point getVertexA() {
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }

    public Point[] getVertices(){
        return new Point[]{vertexA, vertexB, vertexC};
    }

        public boolean compareWith(Triangle triangle) {
            double epsilon = 0.0001;

            // Compare all coordinates of vertexA with ±0.0001 tolerance
            boolean vertexAEqual = (this.vertexA.getX() < triangle.vertexA.getX() + epsilon &&
                    this.vertexA.getX() > triangle.vertexA.getX() - epsilon) &&
                    (this.vertexA.getY() < triangle.vertexA.getY() + epsilon &&
                            this.vertexA.getY() > triangle.vertexA.getY() - epsilon) &&
                    (this.vertexA.getZ() < triangle.vertexA.getZ() + epsilon &&
                            this.vertexA.getZ() > triangle.vertexA.getZ() - epsilon);

            // Compare all coordinates of vertexB with ±0.0001 tolerance
            boolean vertexBEqual = (this.vertexB.getX() < triangle.vertexB.getX() + epsilon &&
                    this.vertexB.getX() > triangle.vertexB.getX() - epsilon) &&
                    (this.vertexB.getY() < triangle.vertexB.getY() + epsilon &&
                            this.vertexB.getY() > triangle.vertexB.getY() - epsilon) &&
                    (this.vertexB.getZ() < triangle.vertexB.getZ() + epsilon &&
                            this.vertexB.getZ() > triangle.vertexB.getZ() - epsilon);

            // Compare all coordinates of vertexC with ±0.0001 tolerance
            boolean vertexCEqual = (this.vertexC.getX() < triangle.vertexC.getX() + epsilon &&
                    this.vertexC.getX() > triangle.vertexC.getX() - epsilon) &&
                    (this.vertexC.getY() < triangle.vertexC.getY() + epsilon &&
                            this.vertexC.getY() > triangle.vertexC.getY() - epsilon) &&
                    (this.vertexC.getZ() < triangle.vertexC.getZ() + epsilon &&
                            this.vertexC.getZ() > triangle.vertexC.getZ() - epsilon);

            boolean surfaceNormalEqual = (this.surfaceNormal.getI() < triangle.surfaceNormal.getI() + epsilon &&
                    this.surfaceNormal.getI() > triangle.surfaceNormal.getI() - epsilon) &&
                    (this.surfaceNormal.getJ() < triangle.surfaceNormal.getJ() + epsilon &&
                            this.surfaceNormal.getJ() > triangle.surfaceNormal.getJ() - epsilon) &&
                    (this.surfaceNormal.getK() < triangle.surfaceNormal.getK() + epsilon &&
                            this.surfaceNormal.getK() > triangle.surfaceNormal.getK() - epsilon);

            return vertexAEqual && vertexBEqual && vertexCEqual && surfaceNormalEqual;
        }

    @Override
    public String toString() {
        if (isInvalidTriangle()) {
            return "[InvalidTriangle]";
        }

        String formattedVertexA = String.format("A(x%.3f, y%.3f, z%.3f)", vertexA.getX(), vertexA.getY(), vertexA.getZ());
        String formattedVertexB = String.format("B(x%.3f, y%.3f, z%.3f)", vertexB.getX(), vertexB.getY(), vertexB.getZ());
        String formattedVertexC = String.format("C(x%.3f, y%.3f, z%.3f)", vertexC.getX(), vertexC.getY(), vertexC.getZ());

        String formattedSurfaceNormal = String.format("N<%.3fi, %.3fj, %.3fk>",
                surfaceNormal.getI(),
                surfaceNormal.getJ(),
                surfaceNormal.getK());

        return String.format("[%s; %s; %s; %s]", formattedVertexA, formattedVertexB, formattedVertexC, formattedSurfaceNormal);
    }

    private boolean isInvalidTriangle() {
        boolean verticesAreUnique = !(vertexA.equals(vertexB) || vertexA.equals(vertexC) || vertexB.equals(vertexC));

        // Check if the surface normal is valid (not zero in all components)
        boolean normalIsValid = !(Math.abs(surfaceNormal.getI()) < 0.0001 &&
                Math.abs(surfaceNormal.getJ()) < 0.0001 &&
                Math.abs(surfaceNormal.getK()) < 0.0001);

        return !verticesAreUnique || !normalIsValid;
    }






}
