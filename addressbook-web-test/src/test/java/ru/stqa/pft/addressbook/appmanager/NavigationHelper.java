package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd;

  //  конструктор
  public NavigationHelper(WebDriver wd) {
    this.wd=wd;
  }

  // Метода для перехода на стр. групп
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
