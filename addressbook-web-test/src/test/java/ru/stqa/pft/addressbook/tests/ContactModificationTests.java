package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test //(enabled = false)
  // Тест проверяет редактирование контакта через форму модификации, переход к которой осуществляется
  // со страницы просмотра контакта,нажатием кнопки Modify
  public void testContactModification ()
  {
   app.goTo().gotoHomePage();

    // Перед выбором контакта  проверяем, есль ли контакт
    if (! app.getContactHelper().isThereAContact()) { //  если нет - то вызываем созданеи контакта
        app.getContactHelper().crateContact(new ContactData("Basy", "", "Antonov", "strit", "334-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "", "test11is"), true);
    }

    // запомнить старый список
    List<ContactData> before =app.getContactHelper().getContactList();

    // Переход на стр. просмотра последнего контакта и нажатие редактировать
   app.getContactHelper().gotoContaktViewPage(before.size());
   app.getContactHelper().submitContactModifiy();
    // создаем новый объект контакт, с новыми данными, но ид выбранного (берем из запомненного списка)
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Дмитрий", "", "Петров", "ул. попова", "333", "44-44-44", "+7 444-444-44-44", "" , "ссс@mail.ru", "", "");
    // Редактируем контакт
    app.getContactHelper().fillContactForm(contact, false);
    // Подтверждаем и возвращаемся
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnToHomePage();

    // Запоминаем новый список
    List<ContactData> after=app.getContactHelper().getContactList();

    // Сравниваем количество
    Assert.assertEquals(after.size(), before.size());

    // Меняем старый список - удаляем старое значение, добавляем новое
    before.remove(before.size()-1);
    before.add(contact);

    // Сортируем оба списка
    Comparator<? super ContactData> byId=(g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    // сравниваем списки напрямую, т.к. они оба упорядочены одинаково
    Assert.assertEquals(before, after);

  }
}
