package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    // ������� ���������� � ����������
     //String[] langs=new String[4];
    // langs[0]="Java";
    // langs[1]="C#";
    // langs[2]="Phyhon";
    // langs[3]="PHP";

    // ������� ����� ��������� ����� ��� ����������
       String[] langs ={"Java", "C#", "Phyhon", "PHP"};

       List<String> languages = new ArrayList<String>();
       languages.add("Java");
       languages.add("C#");
       languages.add( "Phyhon");
       languages.add("PHP");


     //  for (int i=0; i <langs.length; i++)
     //  { System.out.println("� ���� ������� " + langs[i]);}
    // ������������ �� �����������
     for (String l : languages ) // l -��� ������ �� ��������������� ������� �������
        { System.out.println("� ���� ������� " + l);}

     }
}
