import java.util.List;


public enum ShapeType
{
    CIRCLE, SQUARE
}

public abstract class Shape
{
    protected ShapeType _shapeType;

    public ShapeType getType()
    {
        return _shapeType;
    }
}

public class Circle extends Shape
{
    private final double _radius;

    public Circle(double radius)
    {
        _shapeType = ShapeType.CIRCLE;
        _radius = radius;
    }

    public double getRadius()
    {
        return _radius;
    }
}



public class Square extends Shape
{
    private final double _side;

    public Square(double side)
    {
        _shapeType = ShapeType.SQUARE;
        _side = side;
    }

    public double getSide()
    {
        return _side;
    }
}



public class AreaCalculator
{
    public void calculateArea(List<Shape> shapes)
    {
        double area = 0;
        for (Shape shape : shapes) {
            if (shape.getType() == ShapeType.SQUARE) {
                area += calculateSquareArea((Square) shape);
            } else if (shape.getType() == ShapeType.CIRCLE) {
                area += calculateCircleArea((Circle) shape);
            }
        }
        System.out.println("total area = " + area);
    }

    public double calculateSquareArea(Square square)
    {
        return square.getSide() * square.getSide();
    }

    public double calculateCircleArea(Circle circle)
    {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }

}


// Problem

/*
 * If I need to create a new shape, like a triangle, 
 * I would have to modify the DrawShape function.
 * In a complex application, the switch-case would be repeated 
 * each time a new operation is performed on a shape.
 * Every time one of the shapes is modified, all modules would need 
 * to be recompiled, and possibly modified as well.
 */








 /*************************************** */
// solution

public abstract class Shape
{
    public abstract double getArea();
}


public class Square extends Shape
{
    private final double _side;

    public Square(double side)
    {
        _side = side;
    }

    public double getSide()
    {
        return _side;
    }

    @Override
    public double getArea()
    {
        return _side * _side;
    }
}


public class Circle extends Shape
{
    private final double _radius;

    public Circle(double radius)
    {
        _radius = radius;
    }

    public double getRadius()
    {
        return _radius;
    }

    @Override
    public double getArea()
    {
        return Math.PI * _radius * _radius;
    }
}


import java.util.List;

public class AreaCalculator
{
    public void calculateArea(List<Shape> shapes)
    {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }
        System.out.println("total area = " + area);
    }
}




// Solution

 /*
 * In this solution, each shape class (e.g., Circle, Square) now has its own 
 * implementation of an abstract method getArea() defined in the Shape class.
 * 
 * This approach respects the Open/Closed Principle (OCP) by allowing the 
 * system to be extended with new shapes, like Triangle, without modifying 
 * existing code.
 * 
 * The AreaCalculator class no longer needs to know the specific type of each shape, 
 * eliminating the need for a switch-case or if-else checks. Now, it simply calls 
 * getArea() on each shape, allowing for easier maintenance and scalability.
 * 
 * As a result, adding or changing shapes does not require modifying or recompiling 
 * existing modules, ensuring that the system is open for extension but closed for modification.
 */






 /******************************** */
 // Exercice


public enum ResourceType
{
    TIME_SLOT,
    SPACE_SLOT
}

public class ResourceAllocator
{
    private static final int INVALID_RESOURCE_ID = -1;

    public int allocate(ResourceType resourceType)
    {
        int resourceId;
        switch (resourceType) {
        case TIME_SLOT:
            resourceId = findFreeTimeSlot();
            markTimeSlotBusy(resourceId);
            break;
        case SPACE_SLOT:
            resourceId = findFreeSpaceSlot();
            markSpaceSlotBusy(resourceId);
            break;
        default:
            System.out.println("ERROR: Attempted to allocate invalid resource");
            resourceId = INVALID_RESOURCE_ID;
            break;
        }
        return resourceId;
    }

    public void free(ResourceType resourceType, int resourceId)
    {
        switch (resourceType) {
        case TIME_SLOT:
            markTimeSlotFree(resourceId);
            break;
        case SPACE_SLOT:
            markSpaceSlotFree(resourceId);
            break;
        default:
            System.out.println("ERROR: attempted to free invalid resource");
            break;
        }
    }

    private void markSpaceSlotFree(int resourceId)
    {
    }

    private void markTimeSlotFree(int resourceId)
    {
    }

    private void markSpaceSlotBusy(int resourceId)
    {
    }

    private int findFreeSpaceSlot()
    {
        return 0;
    }

    private void markTimeSlotBusy(int resourceId)
    {
    }

    private int findFreeTimeSlot()
    {
        return 0;
    }
}


// Problem
/*
 * OCP Violation in ResourceAllocator:
 * 
 * - Modification Required for New Resource Types:
 *   If a new resource type (e.g., MEMORY_SLOT) is added, both allocate and free methods 
 *     need to be modified to handle the new type.
 * 
 * - Duplicated Logic for Each Resource Type:
 *   The switch cases repeat allocation and freeing logic for each ResourceType, 
 *     making the code harder to maintain and extend.
 * 
 * - Recompilation of Modules:
 *   Adding a new ResourceType requires changes in multiple locations, resulting in 
 *     recompilation of ResourceAllocator and potentially other dependent modules.
 */




 /***************************** */

 //Solution
 
public interface Resource
{
    public abstract int findFreeSlot();
    public abstract void markSlotBusy(int resourceID);
    public abstract void markSlotFree(int resourceID);
}

public class TimeResource implements Resource{
    public TimeResource(){
    }

    @Override
    public int findFreeSlot()
    {
        return 0
    }

    @Override
    public void markSlotBusy(int resourceID)
    {
        
    }

    @Override
    public void markSlotFree(int resourceID)
    {

    }
}

public class SpaceResource implements Resource{
    public SpaceResource(){
    }

    @Override
    public int findFreeSlot()
    {
        return 0
    }

    @Override
    public void markSlotBusy(int resourceID)
    {
        
    }

    @Override
    public void markSlotFree(int resourceID)
    {
        
    }
}




public class ResourceAllocator
{
    private static final int INVALID_RESOURCE_ID = -1;
    private List<Resource> resources; 

    public int allocate()
    {
        Resource resource = resource.findFreeSlot()
        if (resource.resourceId != INVALID_RESOURCE_ID) {
            resource.markSlotBusy();
            return resourceId;
        }
        return INVALID_RESOURCE_ID;
    }
        

    public void free(Resource resource)
    {
            resource.markSlotFree();
    }

    public Resource findFreeSlot(){
        return 
    }

}


/*
 * 
 *    - New resource types can be added by creating new subclasses of `Resource` without changing `ResourceAllocator`.
 * 
 *    - Each resource type (e.g., `TimeResource`, `SpaceResource`) handles its own logic for finding free slots and marking
 *       them busy or free.
 * 
 *    - The design is flexible, allowing the addition of new resource types without modifying existing code
 */





 