package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.concurrent.TimeUnit;

import java.util.List;
import org.openqa.selenium.WebDriver;

public class ContactDelitionByAnySelectionTests extends TestBase{

  @Test
  // Тест удаляет из списка контактов один выбранный контакт

  public void testContactDelitionByAnySelection()
  {
    app.getNavigationHelper().gotoHomePage();
      // Перед выбором контакта  проверяем, есль ли контакт
      if (! app.getContactHelper().isThereAContact()) { //  если нет - то вызываем созданеи контакта
        app.getContactHelper().crateContact(new ContactData("Basy", "", "Antonov", "strit", "334-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "", "test2222"), true);
      }

    List<ContactData> before =app.getContactHelper().getContactList();

      // и только после этого выбираем контакт из списка и удаляем
    app.getContactHelper().selectContactInList(before.size()-1);
    app.getContactHelper().submitContactDelite();
    app.closeAlertOk();
    app.waitMessage();
    app.getNavigationHelper().gotoHomePage();



    List<ContactData> after=app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);

  }

}
