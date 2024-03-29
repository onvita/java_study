package ru.stqa.pft.addressbook.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  //Метод Выбрать группу произвольную по индексу
  public void selectGroup(int index) {
    // click(By.name("selected[]")); до добавления индекса было так, но правильнее работать со списком элементов
    // Находим все элементы по локатору By.name("selected[]"), среди них выбираем нужный по индексу и по этому элементу выполнить клик
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  //Метод Выбрать группу по ид
  public void selectGroupById(int id) {
    // Находим элемент  у которого тег input, у него атрибут value = ид  и  по нему кликаем
    wd.findElement(By.cssSelector("input[value='"+ id + "']")).click();
  }


  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  // Метод создания группы
  public void crate(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(GroupData group) {
   selectGroupById(group.getId());
   initGroupModification();
   fillGroupForm(group);
   submitGroupModification();
  // app.goTo().groupPage()
   returnToGroupPage();
  }
// "Старый" метод удаления, выбирает по порядковому номеру ( можно удалять из списков, но не из множества)
  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }
  // Второй метод удаления, выбирает по ид. ( можно удалять из неупорядоченного множества)
  public void delete(GroupData Group) {
    selectGroupById(Group.getId()); // метод по ид группы выбирает нужный на странице
    deleteSelectedGroups(); // и удаляет ( кнопка удалить)
    returnToGroupPage();
  }


// Метод проверяет, есть ли элемент  выбора  на странице ( есть ли группы)
  public boolean isThereAGroup() {
    return  isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {

    // findElements возвращает список элементов, объект типа list
    return wd.findElements(By.name("selected[]")).size();

  }

  // Метод находит на стр. группы и создает соответсвующий список групп
  public List<GroupData> list() {
 // создаем список, который будем заполнять
    List<GroupData> groups=new ArrayList<GroupData>(); // ArrayList - т.к нужно указать конкретный класс, который реализует интерфейс List
// получаем список объектов типа вебэлемент
    List<WebElement> elements =wd.findElements(By.cssSelector("span.group")); // найти все элементы, которые имеют тег span и класс   group
// нужно по элементам пройти в цикле и выполнить действия
    for (WebElement element: elements) {                                 // element  пробегает по списку elements
      String name =element.getText();                                    // из каждого получаем текст - имя группы
      int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // достаем ид
      groups.add(new GroupData().withId(id).withName(name));                                                 // добавляем созданный объект в список
    }


    return  groups; // Метод вернет список групп

  }

  // Метод находит на стр. группы и создает соответсвующий список групп
  public Set<GroupData> all() {
    // создаем список, который будем заполнять
    Set<GroupData> groups=new HashSet<GroupData>();
    // получаем список объектов типа вебэлемент
    List<WebElement> elements =wd.findElements(By.cssSelector("span.group")); // найти все элементы, которые имеют тег span и класс   group
// нужно по элементам пройти в цикле и выполнить действия
    for (WebElement element: elements) {                                 // element  пробегает по списку elements
      String name =element.getText();                                    // из каждого получаем текст - имя группы
      int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // достаем ид
      groups.add(new GroupData().withId(id).withName(name));                                                 // добавляем созданный объект в список
    }


    return  groups; // Метод вернет список групп

  }


}
