package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  // Тест с данными, где расстояние - дробное число
  @Test
  public void testDistance1()
  {
    Point p1=new Point (7.0, 8.0);
    Point p2=new Point (6.0, 20.0);

    Assert.assertEquals(p1.distance(p2), Math.sqrt(145));
  }

// Тест с данными, где гарантировно в результате точность с нулевй дробной частью
  @Test
  public void testDistance2()
  {
    Point p1=new Point (7.0, 8.0);
    Point p2=new Point (4.0, 12.0);

    Assert.assertEquals(p1.distance(p2), 5.0 );
  }
}
