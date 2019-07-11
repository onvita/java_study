package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  // Конструктор
  public HelperBase(WebDriver wd) {
    this.wd=wd;
  }

  protected void type(By locator, String text) {
     click(locator);
    // Далее, если в поле уже введено нужное значение, то с этим полем ничего делать не нужно, подробнее
    if (text !=null) // если текст есть
      { String existingText = wd.findElement(locator).getAttribute("value"); // извлекаем из поля то значение, которое в нем хранится  в переменную existingText
           if (!text.equals(existingText)) { // если не верно, что текст переданный в метод (через text) совпадает с уже существующим в нем текстом (только что извлекли)
               wd.findElement(locator).clear(); // очищаем его
               wd.findElement(locator).sendKeys(text); // и заполняем новым значением
              }// иначе (если текст совпадает) ничего не делаем, оставляем как было
      }// Иначе (текст пустой) ничего не даелаем, оставляем как было
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }



  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
