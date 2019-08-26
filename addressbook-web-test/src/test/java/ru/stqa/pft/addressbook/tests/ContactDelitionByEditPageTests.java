package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


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

    // запомнить старый список
    List<ContactData> before =app.getContactHelper().getContactList();

    // Переход на стр. редактирования и нажатие удалить
    app.getContactHelper().submitContaktEdit(before.size()); // before.size() без -1, т.е. порядок едитов начинается с 1, а не с 0
    app.getContactHelper().submitContactDelite();

    // Ждем сообщения об удалении и переходим на главную
    app.waitMessage();
    app.getNavigationHelper().gotoHomePage();

    // Запоминаем новый список
    List<ContactData> after=app.getContactHelper().getContactList();

    // Сравниваем количество
    Assert.assertEquals(after.size(), before.size()-1);

    // Убираем из старого удаленный элемент и сравниваем содержимое списков
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);


  }
}
