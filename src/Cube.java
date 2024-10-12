public class Cube {
    private Face[] mesh;

    public Cube(Face one, Face two, Face three, Face four, Face five, Face six) {
        mesh = new Face[]{one, two, three, four, five, six};

        if (!isValidCube()) {
            invalidateFaces();
        }
    }

    public Cube() {
        mesh = new Face[]{new Face(), new Face(), new Face(), new Face(), new Face(), new Face()};
    }

    public Face[] getMesh() {
        return mesh;
    }

    private boolean isValidCube() {
        for (int i = 0; i < mesh.length; i++) {
            for (int j = i + 1; j < mesh.length; j++) {
                if (mesh[i].compareWith(mesh[j])) {
                    return false; // No face should be the same
                }
            }
        }
        return true;
    }

    private void invalidateFaces() {
        for (int i = 0; i < mesh.length; i++) {
            mesh[i] = new Face(); // Set to invalid face
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("|C");
        for (Face face : mesh) {
            if (face.toString().equals("{InvalidFace}")) {
                return "|InvalidCube|"; // If any face is invalid, return invalid cube
            }
            sb.append(face.toString());
        }
        sb.append("|");
        return sb.toString();
    }
}
