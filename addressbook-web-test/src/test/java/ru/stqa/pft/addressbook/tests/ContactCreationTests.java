package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();

    // запомнить старый список
    List<ContactData> before =app.getContactHelper().getContactList();

    // создаем новый объект контакт, без ид
    ContactData contact = new ContactData("Евгений", "", "Трошкин", "ул. попова", "333", "44-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "test2222");
    app.getContactHelper().crateContact(contact, true);

    // Запоминаем новый список
    List<ContactData> after=app.getContactHelper().getContactList();

    // Сравниваем количество
    Assert.assertEquals(after.size(), before.size()+1);

    // В старый список добавляем новое значение
    before.add(contact);

    // Сортируем оба списка
    Comparator<? super ContactData> byId=(g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    // сравниваем списки напрямую, т.к. они оба упорядочены одинаково
    Assert.assertEquals(before, after);
  }


}
