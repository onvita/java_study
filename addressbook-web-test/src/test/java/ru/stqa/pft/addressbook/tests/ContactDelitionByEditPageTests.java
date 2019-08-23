package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDelitionByEditPageTests extends TestBase {

  @Test
  // Тест удаляет  контакт нажатием удаления на стр. редактирвоания
  public void testContactDelitionByEditPage ()
  {
    app.getNavigationHelper().gotoHomePage();
      // Перед выбором контакта  проверяем, есль ли контакт
    if (! app.getContactHelper().isThereAContact()) { //  если нет - то вызываем созданеи контакта
        app.getContactHelper().crateContact(new ContactData("Basy", "", "Antonov", "strit", "334-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "", "test11is"), true);
      } // и только после этого переходим на стр. редактирования контакта, с которой и удаляется контакт

    app.getContactHelper().submitContaktEdit();
    app.getContactHelper().submitContactDelite();

  }
}
