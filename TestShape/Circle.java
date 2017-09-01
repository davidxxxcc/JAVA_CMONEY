package TestShape;


class Circle extends Shape{
	protected double radius, area, perimeter;
	protected double pi = 3.14;
	public Circle (double r) {
		if (r > 0)
			radius = r;
		else
			r = 0;
	}

	@Override
	double area() {
		double area = radius * radius * pi;
		return area;
	}

	@Override
	double perimeter() {
		double perimeter = 2 * pi * radius;
		return perimeter;
	}
	
//	@Override
//	void show() {
//		System.out.printf("type: %10s\tArea: %3.1f\tperimeter: %3.1f\n","Circle",area(),perimeter());
//	}

}
