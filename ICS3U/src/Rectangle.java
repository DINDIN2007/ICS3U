// 1. Define the class.
class Rectangle {
	/* integer left – the x-coordinate of the left edge
	   integer bottom – the y-coordinate of the bottom edge
	   integer width – the width of the rectangle
	   integer height – the height of the rectangle */ 
	private int left, bottom, width, height;
	
	// 2. Write a constructor method called Rectangle that has no parameters,
	// which sets all fields to zero.
	
	public Rectangle() {
		this.left = 0;
		this.bottom = 0;
		this.width = 0;
		this.height = 0;
	}
	
	// 3. Write a constructor method called Rectangle that has four integer parameters
	// representing the four fields of the class (in the order listed above). 
	// The constructor should replace any negative length parameters with zero.
	public Rectangle(int left, int bottom, int width, int height) {
		this.left = Math.max(0, left);
		this.bottom = Math.max(0, bottom);
		this.width = Math.max(0, width);
		this.height = Math.max(0, height);
	}
	
	// 4. Write a mutator method called set that has four integer parameters
	// representing the four fields of the class (in the order listed above).
	// The mutator should replace any negative length parameters with zero.
	public void set(int left, int bottom, int width, int height) {
		this.left = Math.max(0, left);
		this.bottom = Math.max(0, bottom);
		this.width = Math.max(0, width);
		this.height = Math.max(0, height);
	}
	
	// 5. Write a toString instance method.
	// For the rectangle with a lower left corner located at
	// (-3, 2) and having a width of 4 and a height of 5,
	// the method should return exactly “base: (-3,2) w:4 h:5”.
	public String toString() {
		return "base : (" 
					+ this.left + ","
					+ this.bottom + ")"
					+ " w:"  + this.width
					+ " h:" + this.height;
	}
	
	// 6. Write an instance method, area, 
	// that returns the integer area of the calling rectangle.
	public int area() {
		return this.width * this.height;
	}
	
	// 7. Write an instance method, perimeter, that returns the integer perimeter of the calling rectangle.
	// The perimeter of a straight line is its length.
	public int perimeter() {
		if (this.width == 0 || this.height == 0) return this.width + this.height;
		return 2 * (this.width + this.height);
	}
	
	// 8. Write a class method, intersection, that has two Rectangle parameters.
	// The method should return the rectangle formed by the area common to the two rectangles
	// (i.e., the rectangle formed where they overlap with each other).
	// If they do not intersect, the method should return a rectangle where all fields are zero.
	// If the rectangles only touch, but do not overlap, then the width or height may be zero,
	// but all other parameters should be properly calculated and stored.
	public static Rectangle intersection(Rectangle r1, Rectangle r2) {
		// Check if one rectangle contains the other
		if (r1.contains(r2)) return r2;
		if (r2.contains(r1)) return r1;
		
		// Find the edges of the inner rectangle knowing coordinates are positive
		int insideLeft = Math.max(r1.left, r2.left);
		int insideBottom = Math.max(r1.bottom, r2.bottom);
		int insideWidth = Math.min(r1.left + r1.width, r2.left + r2.width) - insideLeft;
		int insideHeight = Math.min(r1.bottom + r1.height, r2.bottom + r2.height) - insideBottom;
		
		// If the height is negative, it meant that the rectangle don't intersect
		if (insideWidth < 0 || insideHeight < 0) return new Rectangle();
		
		// Otherwise return inside rectangle
		return new Rectangle(insideLeft, insideBottom, insideWidth, insideHeight);
	}
	
	// 9. Write a class method, totalPerimeter, that has two Rectangle parameters.
	// The method should return the total perimeter, as an integer, of the figure formed by the two rectangles.
	// It should only count those portions that are on the edges of the exterior of the resulting figure.
	// If one rectangle is completely contained by the other, then return the perimeter of the outer rectangle.
	// If the rectangles do not intersect, the method should return the sum of the individual perimeters.
	public static int totalPerimeter(Rectangle r1, Rectangle r2) {
		return r1.perimeter() + r2.perimeter() - Rectangle.intersection(r1, r2).perimeter();
	}
	
	// 10.Write an instance method, contains, that has one parameter of type Rectangle.
	// The method should return true if every point of the specified rectangle
	// (i.e., passed by the explicit parameter) is on or within the implicit parameter
	// (i.e., the object invoking the instance method).
	// It should return false otherwise.
	// For example, a.contains(b) would return true if the rectangle b is entirely within a.
	public Boolean contains(Rectangle other) {
		Boolean leftSide = this.left <= other.left;
		Boolean rightSide = this.left + this.width >= other.left + other.width;
		Boolean bottomSide = this.bottom <= other.bottom;
		Boolean topSide = this.bottom + this.height >= other.bottom + other.height;
		return leftSide && rightSide && bottomSide && topSide;
	}
}