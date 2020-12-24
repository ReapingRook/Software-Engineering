package pa1;

public class Vector3D {
	double x;
	double y;
	double z;

	public Vector3D(double x, double y, double z) { // Constructor
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3D scale(double f) { // Multiply x, y and z by f
		double x = this.x * f;
		double y = this.y * f;
		double z = this.z * f;
		
		Vector3D output = new Vector3D(x, y ,z);
		return output;
	}

	public Vector3D add(Vector3D v) { // Add two vectors together
		double x = this.x + v.x;
		double y = this.y + v.y;
		double z = this.z + v.z;
		
		Vector3D output = new Vector3D(x, y, z);
		
		return output;
	}

	public Vector3D subtract(Vector3D v) { // Subtract two vectors together
		double x = this.x - v.x;
		double y = this.y - v.y;
		double z = this.z - v.z;
		
		Vector3D output = new Vector3D(x, y ,z);
		return output;
	}

	public Vector3D negate(Vector3D v) {
		return v.scale(-1);
	}

	public double dot(Vector3D v) {
		return (this.x * v.x) + (this.y * v.y) + (this.z * v.z);
	}

	public double magnitude(Vector3D v) { // Return sqrt(x^2 + y^2 + z^2)

		return Math.sqrt(Math.pow(v.x,2) + Math.pow(v.y,2) + Math.pow(v.z,2));
	}

	public String toString() { // Print x, y, and z
		String output = "{" + this.x + ", " + this.y + ", " + this.z + "}";
		return output;
	}

	public boolean equals(Vector3D v) { // Test if this and v are equal. Tolerance: 5 decimal places
		double dx;
		double dy;
		double dz;
		double diff;

		dx = Math.abs(v.x - this.x);
		dy = Math.abs(v.y - this.y);
		dz = Math.abs(v.z - this.z);
		diff = dx + dy + dz;
		if(diff < 0.00001) { return true; } else { return false; }
	}
}
