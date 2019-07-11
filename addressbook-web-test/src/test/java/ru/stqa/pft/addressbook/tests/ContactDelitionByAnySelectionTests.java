package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelitionByAnySelectionTests extends TestBase{

  @Test
  // Тест удаляет из списка контактов один выбранный контакт

  public void testContactDelitionByAnySelection()
  {
    app.getContactHelper().selectContactInList();
    app.getContactHelper().submitContactDelite();
    app.closeAlertOk();

  }

}
