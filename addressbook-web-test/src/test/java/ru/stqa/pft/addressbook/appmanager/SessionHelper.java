package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
 // private WebDriver wd; собственная ссылка на драйыер не неужна, т.к. она наследуется от базового класса

  //конструктор
  public SessionHelper(WebDriver wd) {
    super(wd); //Обращение к конструктору базового класса HelperBase
    }
  // Метод авторизации
  public void login(String username, String password) {
    type(By.name("user"),username );
    type(By.name("pass"),password );
    click(By.xpath("//input[@value='Login']"));
  }

}
