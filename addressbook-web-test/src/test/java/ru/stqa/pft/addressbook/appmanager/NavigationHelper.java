package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  // private WebDriver wd; собственная ссылка на драйыер не неужна, т.к. она наследуется от базового класса

  //  конструктор
  public NavigationHelper(WebDriver wd) {
   super(wd); //Обращение к конструктору базового класса HelperBase?
    // this.wd=wd; не нужно больше, т.к. заменено вызовом конструктора базового класса
  }

  // Метода для перехода на стр. групп
  public void gotoGroupPage() {
    click(By.linkText("groups"));
    }


}
