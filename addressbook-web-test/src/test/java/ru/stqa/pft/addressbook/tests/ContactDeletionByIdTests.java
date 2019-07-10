package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionByIdTests extends TestBase{

  @Test
  // Тест удаляет из списка контактов контакт с конкретным id

  public void testContactDeletionById ()
  {
    app.getContactHelper().selectContactById("10");
    app.getContactHelper().submitContactDelite();
    app.closeAlertOk();
  }


}
