package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactHelper  extends HelperBase{
  //
  public ContactHelper(WebDriver wd) {
    super(wd);//Обращение к конструктору базового класса HelperBase
  }

  // Переход на странцу создания нового контакта кликом по "add new"
  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  // Заполнение полей на форме создания\редактирования контакта
  // Параметр cration определяет, это форма создания контакта или можификации - true - значит создания
  public void fillContactForm(ContactData contactData, boolean cration) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWork());
    type(By.name("email") ,contactData.getEmail());
    type(By.name("email2") ,contactData.getEmail2());
    type(By.name("email3") ,contactData.getEmail3());

    // Заполняем группу
    // Чтобы выбрать элемент из выпадающего списка используется Вспомогательный класс select
    // Параметр класса, элемент найденный на стр. приложения
    if (cration) // Если это форма контакта - элемент должен быть, и нужно выбирать эл. из выпадающего списка
            {  new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
     } else   // иначе  это форма модификации и элемента быть не должно - проверяем это
            {  Assert.assertFalse(isElementPresent(By.name("new_group"))); }
  }

  // подверждение создания нового контакта нажатием кнопки подтверждения
  public void submitContaktCreation() {
    click(By.xpath("(//input[@name='submit'])[1]"));
  }

  // Нажатие кнопки редактирования для контакта (переход на страницу релактирования соответсвующего контакта из списка контактов)
  public void submitContaktEdit(int index) {
    click(By.xpath("(//img[@alt='Edit'])["+index+"]"));
  }
// Подтверждение редактирования контакта ( нажатие кнопки Update на стр. редактирования контакта)
  public void submitContactUpdate() {
    click(By.name("update"));
  }

  // Метод возврата на страницу со списком контактов
  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  // Метод перехода на страницу просмотра контакта, нажатием кнопки просмотр (или детально) в списке контактов
  public void gotoContaktViewPage(int index) {
    click(By.xpath("(//img[@alt='Details'])["+index+"]"));
  }

  // Переход к странице модификации контакта ( нажатие кнопки Modify на стр. просмотра контакта)
  public void submitContactModifiy() {
    click(By.name("modifiy"));
  }

  //Метод Выбрать контакт с конкретным ид
  public void selectContactById(String ContactID) {
    click(By.id(ContactID));
  }

  // Нажатие Delete для контакта
  public void submitContactDelite()  {
    click(By.xpath("//input[@value='Delete']")); }

  //Метод  чекает в списке контактов  контакт с индексом index
  public void selectContactInList (int index) {
     wd.findElements(By.name("selected[]")).get(index).click();
  }

  // Метод создания контакта
  public void crateContact(ContactData contact, boolean cration) {
    initContactCreation(); // инициализировать создание нового контакта
    fillContactForm(contact, cration); // заполнить форму данными
    submitContaktCreation();// подтвердить создание контакта
    returnToHomePage();// вернуться
  }

  // Метод проверяет, есть ли  в таблице строчки
  public boolean isThereAContact() {
      return  isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    // findElements возвращает список элементов, объект типа list
    return wd.findElements(By.name("selected[]")).size();
  }

  // Метод находит на стр. контакты и создает соответсвующий список
  public List<ContactData> getContactList() {

    // создаем список, который будем заполнять
    List<ContactData> contacts=new ArrayList<ContactData>(); // ArrayList - т.к нужно указать конкретный класс, который реализует интерфейс List
   // получаем список объектов типа вебэлемент
    List<WebElement> elements =wd.findElements(By.name("entry")); // найти все элементы, которые имеют name("entry")
   // нужно по элементам пройти в цикле и выполнить действия
    for (WebElement element: elements) {                                 // element  пробегает по списку elements
      int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id")); // достаем ид
      String  lastname=element.findElement(By.xpath(".//td[2]")).getText();
      String  firstname=element.findElement(By.xpath(".//td[3]")).getText();

      //  создаем объект типа ContactData, сравнение будет по ид и имени, поэтому уже в спсике другие данные
      // объекта ContactData не нужны, их выставляем null
      ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null, null , null, null, null, null);
      contacts.add(contact);                                                 // добавляем созданный объект в список
    }

    return  contacts; // Метод вернет список контактов

  }

}
