package TestShape;


class Rectangle extends Shape{
	protected double length, width, area, perimeter;
	public Rectangle(double i, double j) {
		SetData(i,j);
	}
	
	public void SetData (double i, double j) {
		if (i > 0 && j > 0) {
			length = i;
			width = j;
		}
		else {
			length = 0;
			width = 0;
		}
	}

	@Override
	public double area() {
		area = length * width;
		return area;
	}

	@Override
	public double perimeter() {
		perimeter = 2*length + 2*width;
		return perimeter;
	}

//	@Override
//	void show() {
//		System.out.printf("type: %10s\tArea: %3.1f\t%3.1f\n","Rectagle",area(),perimeter());
//	}

}
