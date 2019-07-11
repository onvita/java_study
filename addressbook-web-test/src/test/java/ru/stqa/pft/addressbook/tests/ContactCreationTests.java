package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation(); // ���������������� �������� ������ ��������
    app.getContactHelper().fillContactForm(new ContactData("����4", "", "������4", "��.������ 28", "44-44-44", "+7 444-444-44-44", "" , "���@mail.ru", "", "")); // ��������� ����� �������
    app.getContactHelper().submitContaktCreation  ();// ����������� �������� ��������
  }


}
