package ru.stqa.pft.sandbox;

public class Task2Program {

  public static void main(String[] args) {
    // Задание точек
    Point p1=new Point (1.0,2.0);
    Point p2=new Point (4.0,6.0);

    // вычисление и вывод результата при помощи функции
    System.out.println("Функция: Расстояние между точками ("+ p1.x+ ", " +p1.y +") и ("+ p2.x+ ", " +p2.y +") равно " + distance(p1, p2) );

    // вычисление и вывод результата при помощи метода
    System.out.println("Метод: Расстояние между точками ("+ p1.x+ ", " +p1.y +") и ("+ p2.x+ ", " +p2.y +") равно " + p1.distance(p2) );
  }

   // Функция вычисления расстояния между двумя точками - объектами
  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }
}
