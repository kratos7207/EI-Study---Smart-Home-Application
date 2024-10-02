// Product Interface

interface Shape {

    void draw();
}

// Concrete Product
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Concrete Product
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Creator
abstract class ShapeFactory {

    public abstract Shape createShape();
}

// Concrete Creator
class CircleFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Circle();
    }
}

// Concrete Creator
class RectangleFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

// Example usage
public class FactoryMethodPatternDemo {

    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}
