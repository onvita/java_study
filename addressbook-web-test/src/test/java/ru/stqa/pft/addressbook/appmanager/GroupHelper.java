package ru.stqa.pft.addressbook.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  // Конструктор
  public GroupHelper(WebDriver wd) {
     super(wd); //Обращение к конструктору базового класса HelperBase
  }

  // Метод для перехода на стр. создания новой группы ( Нажатие кнопки new)
  public void initGroupCreation() {
    click(By.name("new"));
  }

  // Заполнить поля  на форме создания группы
  public void fillGroupForm(GroupData groupDat) {
    type(By.name("group_name"), groupDat.getName());
    type(By.name("group_header"), groupDat.getHeader());
    type(By.name("group_footer"), groupDat.getFooter());
  }

  // Метод - подтвержаем создание новой группы- (нажатие кнопки подтверждения)
  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  // Метод возврата на страницу групп
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  // Метод Удалить выбранные группы
  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  //Метод Выбрать группу произвольную
  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  // Метод создания группы
  public void crateGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }
// Метод проверяет, есть ли элемент  выбора  на странице ( есть ли группы)
  public boolean isThereAGroup() {
    return  isElementPresent(By.name("selected[]"));
  }
}
