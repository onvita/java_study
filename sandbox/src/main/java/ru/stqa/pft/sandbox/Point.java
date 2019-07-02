package ru.stqa.pft.sandbox;

public class Point {
  // поля объекта
  public double x;
  public double y;
  // заполнение полей объекта
  public Point (double x, double y)
  {
    this.x=x;
    this.y=y;
  }
  // Метод вычисления расстояния от "текущей" точки до другой
  public double distance(Point p)
  {
    return Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
  }

}
