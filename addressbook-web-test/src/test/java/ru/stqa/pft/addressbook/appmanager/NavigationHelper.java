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
    //  Выходим из метода  gotoGroupPage если выполнятся условия
    if (isElementPresent(By.tagName("h1"))   // На странице найден эленент h1
        && wd.findElement(By.tagName("h1")).getText().equals ("Groups") // и  значение текста его равно  "Groups"
        && isElementPresent(By.name("new"))) { //  И есть элемент с названием "new"
      return; // выходим
    }

    click(By.linkText("groups"));
    }

  // Метода для перехода на  главную страницу
  public void gotoHomePage() {
    //  Выходим из метода  gotoHomePage если выполнятся условия
   if (isElementPresent(By.id("maintable")))   // На странице есть таблица id="maintable"
    { return; // выходим
    }

    click(By.linkText("home"));
  }
}
