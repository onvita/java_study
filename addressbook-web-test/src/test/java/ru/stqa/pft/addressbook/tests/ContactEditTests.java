package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEditTests extends TestBase {

  @Test
  // Тест проверяет редактирование контакта через форму редактирования, переход к которой осуществляется
  // непосредственно из списка контактов нажатием кнопки Edit

  public void testContactEdit ()
  { app.getContactHelper().submitContaktEdit();
    app.getContactHelper().fillContactForm(new ContactData("Васяизbp", "", "Васечкиниз", "Ул.Ленина 28из", "44-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", ""));
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnToHomePage();
  }
}