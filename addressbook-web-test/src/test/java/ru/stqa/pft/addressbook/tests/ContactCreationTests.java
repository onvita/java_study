package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;

@Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation(); // инициализировать создание нового контакта
    app.getContactHelper().fillContactForm(new ContactData("Вася", "", "Васечкин", "Ул.Ленина 28", "44-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "")); // заполнить форму данными
    app.getContactHelper().submitContaktCreation  ();// подтвердить создание контакта
  }


}
