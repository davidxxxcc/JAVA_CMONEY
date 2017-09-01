package TestShape;


class Trapezoid extends Shape{
	protected double upper, lower, height, area, perimeter;
	//於創建時存入上底、下底與高
	public Trapezoid (double u, double l, double h){
		if (u > 0 && l > 0 && h > 0) {
			upper = u;
			lower = l;
			height = h;
		}
		else {
			upper = 0;
			lower = 0;
			height = 0;
		}
	}
	@Override
	double area() {
		double area = 0.5 * (upper+lower)*height;
		return area;
	}
	@Override
	double perimeter() {
		double max = upper;
		double min = lower;
		if (lower > upper) {
			max = lower;
			min = upper;
		}
		double incline = Math.sqrt(Math.pow((max - min)/2, 2) + Math.pow(height,2));
		double perimeter = upper + lower + 2 * incline;
		return perimeter;
	}
	
//	@Override
//	void show() {
//		System.out.printf("type: %10s\tArea: %3.1f\t%3.1f\n","Trapezoid",area(),perimeter());
//	}
	
	
}
