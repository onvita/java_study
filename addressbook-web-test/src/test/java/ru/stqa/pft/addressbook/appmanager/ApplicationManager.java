package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private WebDriver wd;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // Метод авторизации
  public void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  // Метода для перехода на стр. групп
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  // Метод для перехода на стр. создания новой группы ( Нажатие кнопки new)
  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  // Заполнить поля  на форме создания группы
  public void fillGroupForm(GroupData groupDat) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupDat.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupDat.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupDat.getFooter());
  }

  // Метод - подтвержаем создание новой группы- (нажатие кнопки подтверждения)
  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  // Метод возврата на страницу групп
  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  // Метод Удалить выбранные группы
  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  //Метод Выбрать группу произвольную
  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
