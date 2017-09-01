package TestShape;
	
abstract class Shape {
	abstract double area();
	abstract double perimeter();
	protected void show() {
		System.out.printf("Area: %3.1f\tperimeter: %3.1f\n",area(),perimeter());
	};
}
