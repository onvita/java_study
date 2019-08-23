package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDelitionByAnySelectionTests extends TestBase{

  @Test
  // Тест удаляет из списка контактов один выбранный контакт

  public void testContactDelitionByAnySelection()
  {
    app.getNavigationHelper().gotoHomePage();
      // Перед выбором контакта  проверяем, есль ли контакт
      if (! app.getContactHelper().isThereAContact()) { //  если нет - то вызываем созданеи контакта
        app.getContactHelper().crateContact(new ContactData("Basy", "", "Antonov", "strit", "334-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "", "test11is"), true);
      }
      // и только после этого выбираем контакт из списка и удаляем
    app.getContactHelper().selectContactInList();
    app.getContactHelper().submitContactDelite();
    app.closeAlertOk();

  }

}
