# 3D Geometry Project

This project involves creating a series of classes to represent 3D geometries in Cartesian space. The project includes creating points, vectors, triangles, faces, and constructing a 3D cube using a mesh of triangles and faces. Below are details of the classes, their functionality, and the objectives of the project.

## Table of Contents

- [Classes](#classes)
  - [Point.java](#pointjava)
  - [UnitVector.java](#unitvectorjava)
  - [Triangle.java](#trianglejava)
  - [Face.java](#facejava)
  - [Cube.java](#cubejava)
- [Instructions](#instructions)
- [Grading](#grading)
- [Additional Notes](#additional-notes)

## Classes

### Point.java

This class represents a point in 3D Cartesian space.

- **Fields**:
  - `x`, `y`, `z` (all `double`, private): Represents the coordinates of the point.
  
- **Constructors**:
  - `Point(double x, double y, double z)`: Initializes the point with given coordinates.
  - `Point()`: Initializes the point at `(0.0, 0.0, 0.0)`.

- **Methods**:
  - `getX()`, `getY()`, `getZ()`: Returns the respective coordinate values.
  - `setX(double x)`, `setY(double y)`, `setZ(double z)`: Sets the respective coordinate values.
  - `compareWith(Point point)`: Compares this point with another within a precision of ±0.0001.
  - `toString()`: Returns the formatted string of the point `(xX.xxx, yY.xxx, zZ.xxx)`.

### UnitVector.java

Represents a 3D unit vector with a magnitude of 1.

- **Fields**:
  - `i`, `j`, `k` (all `double`, private): The vector components.

- **Constructors**:
  - `UnitVector(double i, double j, double k)`: Creates a vector and scales it to ensure its magnitude is 1.
  - `UnitVector(Point start, Point end)`: Creates a vector from two points and scales it if necessary.
  - `UnitVector()`: Creates an invalid vector `(0.0, 0.0, 0.0)`.

- **Methods**:
  - `getI()`, `getJ()`, `getK()`: Returns the respective vector components.
  - `compareWith(UnitVector vector)`: Compares two vectors for equality within ±0.0001.
  - `crossProduct(UnitVector b)`: Returns the cross product of two unit vectors.
  - `toString()`: Returns the formatted string representation `<iI.xxx, jJ.xxx, kK.xxx>`.

### Triangle.java

Represents a triangle in 3D space defined by three vertices and a surface normal.

- **Fields**:
  - `vertexA`, `vertexB`, `vertexC` (all `Point`, private): The three vertices.
  - `surfaceNormal` (`UnitVector`, private): The surface normal vector.

- **Constructors**:
  - `Triangle(Point vertA, Point vertB, Point vertC)`: Initializes a triangle with the cross product of vectors from A to B and A to C.
  - `Triangle()`: Creates a default triangle with vertices at `(0.0, 0.0, 0.0)` and an invalid surface normal.

- **Methods**:
  - `getVertexA()`, `getVertexB()`, `getVertexC()`: Returns the respective vertex points.
  - `getSurfaceNormal()`: Returns the surface normal vector.
  - `getVertices()`: Returns an array of the triangle's vertices.
  - `compareWith(Triangle triangle)`: Compares this triangle with another for equality.
  - `toString()`: Returns the formatted string representation of the triangle.

### Face.java

Represents a face of a cube made up of two triangles sharing two vertices.

- **Fields**:
  - `mesh` (`Triangle[]`, private): Array of two triangles forming a face.
  - `surfaceNormal` (`UnitVector`, private): The surface normal vector.

- **Constructors**:
  - `Face(Triangle one, Triangle two)`: Initializes the face if the triangles share two vertices and have equal surface normals.
  - `Face()`: Initializes an invalid face.

- **Methods**:
  - `getMesh()`: Returns the array of triangles forming the face.
  - `getSurfaceNormal()`: Returns the surface normal vector.
  - `compareWith(Face face)`: Compares this face with another for equality.
  - `toString()`: Returns the formatted string representation of the face.

### Cube.java

Represents a cube comprised of six faces, each of which is made up of two triangles.

- **Fields**:
  - `mesh` (`Face[]`, private): Array of six faces making up the cube.

- **Constructors**:
  - `Cube(Face one, Face two, Face three, Face four, Face five, Face six)`: Initializes a cube if each face shares an edge with four others and opposed faces have opposite normals.
  - `Cube()`: Initializes an invalid cube.

- **Methods**:
  - `getMesh()`: Returns the array of faces forming the cube.
  - `toString()`: Returns the formatted string representation of the cube.

## Instructions

1. Implement the classes as specified above.
2. Ensure that all constructors and methods work as per the assignment description.
3. Test your classes using the provided `GeoFactory.java`.
4. Adhere to the coding style guidelines.

## Grading

This project is worth 2.5% of your final grade. Your code will be graded on the following:
- Correctness of implementation
- Adherence to coding standards
- Handling of edge cases and precision requirements

## Additional Notes

- **Double Precision**: For this assignment, comparisons of `double` values should be within ±0.0001.
- **Equality Checks**: Use precision checks for comparing `Point`, `UnitVector`, `Triangle`, and `Face` objects.
- **Cube Geometry**: No need to differentiate between squares and parallelograms or cubes and parallelepipeds.
- **Invalid Objects**: Handle invalid triangles, faces, and cubes as described.

Good luck, and remember to test thoroughly!
