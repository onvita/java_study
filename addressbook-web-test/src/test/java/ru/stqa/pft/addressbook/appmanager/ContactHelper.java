package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

  // Заполнение полей на форме создания нового контакта
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getLastname());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWork());
    type(By.name("email") ,contactData.getEmail());
    type(By.name("email2") ,contactData.getEmail2());
    type(By.name("email3") ,contactData.getEmail3());

  }

  // подверждение создания нового контакта нажатием кнопки подтверждения
  public void submitContaktCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

}
