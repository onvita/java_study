package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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
  public void submitContaktEdit() {
    click(By.xpath("(//img[@alt='Edit'])[1]"));
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
  public void gotoContaktViewPage() {
    click(By.xpath("(//img[@alt='Details'])[1]"));
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

  //Метод  чекает в списке контактов произвольный контатк
  public void selectContactInList () {
    click(By.name("selected[]"));
  }

}
