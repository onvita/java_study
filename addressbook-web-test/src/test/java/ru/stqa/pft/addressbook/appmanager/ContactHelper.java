package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper  extends HelperBase{
  //
  public ContactHelper(WebDriver wd) {
    super(wd);//ќбращение к конструктору базового класса HelperBase
  }

  // ѕереход на странцу создани€ нового контакта кликом по "add new"
  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  // «аполнение полей на форме создани€\редактировани€ контакта
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

  // подверждение создани€ нового контакта нажатием кнопки подтверждени€
  public void submitContaktCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  // Ќажатие кнопки редактировани€ дл€ контакта (переход на страницу релактировани€ соответсвующего контакта из списка контактов)
  public void submitContaktEdit() {
    click(By.xpath("(//img[@alt='Edit'])[4]"));
  }
// ѕодтверждение редактировани€ контакта ( нажатие кнопки Update на стр. редактировани€ контакта)
  public void submitContactUpdate() {
    click(By.name("update"));
  }

  // ћетод возврата на страницу со списком контактов
  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  // ћетод перехода на страницу просмотра контакта, нажатием кнопки просмотр (или детально) в списке контактов
  public void gotoContaktViewPage() {
    click(By.xpath("(//img[@alt='Details'])[5]"));
  }

  // ѕереход к странице модификации контакта ( нажатие кнопки Modify на стр. просмотра контакта)
  public void submitContactModifiy() {
    click(By.name("modifiy"));
  }

  //ћетод ¬ыбрать контакт с конкретным ид
  public void selectContactById(String ContactID) {
    click(By.id(ContactID));
  }
  // Ќажатие Delete дл€ контакта
  public void submitContactDelite()  {
    click(By.xpath("//input[@value='Delete']")); }


}
