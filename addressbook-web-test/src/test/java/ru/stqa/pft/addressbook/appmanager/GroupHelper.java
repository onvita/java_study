package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {
  private WebDriver wd;

  // Конструктор
  public GroupHelper(WebDriver wd) {
    this.wd=wd;
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
