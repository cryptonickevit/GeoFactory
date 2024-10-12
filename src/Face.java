public class Face {
    private Triangle[] mesh;
    private UnitVector surfaceNormal;

    public Face(Triangle one, Triangle two) {
        if (shareTwoVertices(one, two) && one.getSurfaceNormal().compareWith(two.getSurfaceNormal())) {
            mesh = new Triangle[]{one, two}; // Triangle one is index 0
            surfaceNormal = one.getSurfaceNormal();
        } else {
            mesh = new Triangle[]{new Triangle(), new Triangle()};
            surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
        }
    }

    public Face() {
        mesh = new Triangle[]{new Triangle(), new Triangle()};
        surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
    }

    private boolean shareTwoVertices(Triangle one, Triangle two) {
        int sharedVertices = 0;
        for (Point vertexOne : one.getVertices()) {
            for (Point vertexTwo : two.getVertices()) {
                if (vertexOne.compareWith(vertexTwo)) {
                    sharedVertices++;
                }
            }
        }
        return sharedVertices == 2;
    }

    public Triangle[] getMesh() {
        return mesh;
    }

    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }

    public boolean compareWith(Face face) {
        boolean trianglesEqual = this.mesh[0].compareWith(face.mesh[0]) && this.mesh[1].compareWith(face.mesh[1]);
        boolean normalsEqual = this.surfaceNormal.compareWith(face.surfaceNormal);
        return trianglesEqual && normalsEqual;
    }

    @Override
    public String toString() {
        if (mesh[0].toString().equals("[InvalidTriangle]") || mesh[1].toString().equals("[InvalidTriangle]")) {
            return "{InvalidFace}";
        }
        String meshString = String.format("{F%s %s N<%.3fi, %.3fj, %.3fk>}",
                mesh[0].toString(), mesh[1].toString(),
                surfaceNormal.getI(), surfaceNormal.getJ(), surfaceNormal.getK());
        return meshString;
    }
}
