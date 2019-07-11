package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDelitionByEditPageTests extends TestBase {

  @Test
  // Тест удаляет  контакт нажатием удаления на стр. редактирвоания
  public void testContactDelitionByEditPage ()
  {
    app.getContactHelper().submitContaktEdit();
    app.getContactHelper().submitContactDelite();

  }
}
