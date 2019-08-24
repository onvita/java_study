package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    // Вариант объявления и заполнения
     //String[] langs=new String[4];
    // langs[0]="Java";
    // langs[1]="C#";
    // langs[2]="Phyhon";
    // langs[3]="PHP";

    // Вариант когда заполняем сразу при объявлении
       String[] langs ={"Java", "C#", "Phyhon", "PHP"};

       List<String> languages = new ArrayList<String>();
       languages.add("Java");
       languages.add("C#");
       languages.add( "Phyhon");
       languages.add("PHP");


     //  for (int i=0; i <langs.length; i++)
     //  { System.out.println("Я хочу выучить " + langs[i]);}
    // Равносильная ей конструкция
     for (String l : languages ) // l -это ссылка на непосредственно элемент массива
        { System.out.println("Я хочу выучить " + l);}

     }
}
