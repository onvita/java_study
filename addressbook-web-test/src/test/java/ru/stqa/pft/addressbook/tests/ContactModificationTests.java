package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  // Тест проверяет редактирование контакта через форму модификации, переход к которой осуществляется
  // со страницы просмотра контакта,нажатием кнопки Modify
  public void testContactModification ()
  {
   app.getNavigationHelper().gotoHomePage();

    // Перед выбором контакта  проверяем, есль ли контакт
    if (! app.getContactHelper().isThereAContact()) { //  если нет - то вызываем созданеи контакта
        app.getContactHelper().crateContact(new ContactData("Basy", "", "Antonov", "strit", "334-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "", "test11is"), true);
    }
    // и только после этого переходим на стр. просмотра контакта
   app.getContactHelper().gotoContaktViewPage();
   app.getContactHelper().submitContactModifiy();
   app.getContactHelper().fillContactForm(new ContactData("Pety", "", "Пирожков", "nmmnmn", "22-33-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "", null), false);
   app.getContactHelper().submitContactUpdate();
   app.getContactHelper().returnToHomePage();
  }
}
