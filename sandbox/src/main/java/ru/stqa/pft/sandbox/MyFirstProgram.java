package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Ya");

    Square s=new Square(5);
    System.out.println("������� �������� �� �������� "+s.l+"="+s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("������� �������������� �� ��������� "+r.a+" � " + r.b +"="+r.area());

  }

  public static void hello(String somebody )
  {        System.out.println("Hello,"+ somebody +"!");  }

}



