package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEditTests extends TestBase {

  @Test
  // ���� ��������� �������������� �������� ����� ����� ��������������, ������� � ������� ��������������
  // ��������������� �� ������ ��������� �������� ������ Edit

  public void testContactEdit ()
  { app.getContactHelper().submitContaktEdit();
    app.getContactHelper().fillContactForm(new ContactData("������bp", "", "����������", "��.������ 28��", "44-44-44", "+7 444-444-44-44", "" , "���@mail.ru", "", ""));
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnToHomePage();
  }
}
