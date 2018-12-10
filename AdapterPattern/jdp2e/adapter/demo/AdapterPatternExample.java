package jdp2e.adapter.demo;
class Rectangle
{
	public double length;
	public double width;
}
class Calculator
{
	public double getArea(Rectangle rect)
	{
		return rect.length * rect.width;
	}
}
class Triangle
{
	public double base;//base
	public double height;//height
	public Triangle(int b, int h)
	{
		this.base = b;
		this.height = h;
	}
}
class CalculatorAdapter
{
	public double getArea(Triangle triangle)
	{
		Calculator c = new Calculator();
		Rectangle rect = new Rectangle();
		//Area of Triangle=0.5*base*height
		rect.length = triangle.base;
		rect.width = 0.5 * triangle.height;
		return c.getArea(rect);
	}
}

class AdapterPatternExample {
	public static void main(String[] args) {
		System.out.println("***Adapter Pattern Demo***\n");
		CalculatorAdapter calculatorAdapter = new CalculatorAdapter();
		Triangle t = new Triangle(20,10);
		System.out.println("Area of Triangle is " + calculatorAdapter.getArea(t) + " Square unit");
	}
}
