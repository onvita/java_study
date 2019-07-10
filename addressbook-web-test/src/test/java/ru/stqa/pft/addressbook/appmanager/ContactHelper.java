package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper  extends HelperBase{
  //
  public ContactHelper(WebDriver wd) {
    super(wd);//��������� � ������������ �������� ������ HelperBase
  }

  // ������� �� ������� �������� ������ �������� ������ �� "add new"
  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  // ���������� ����� �� ����� ��������\�������������� ��������
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getLastname());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWork());
    type(By.name("email") ,contactData.getEmail());
    type(By.name("email2") ,contactData.getEmail2());
    type(By.name("email3") ,contactData.getEmail3());

  }

  // ������������ �������� ������ �������� �������� ������ �������������
  public void submitContaktCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  // ������� ������ �������������� ��� �������� (������� �� �������� �������������� ��������������� �������� �� ������ ���������)
  public void submitContaktEdit() {
    click(By.xpath("(//img[@alt='Edit'])[4]"));
  }
// ������������� �������������� �������� ( ������� ������ Update �� ���. �������������� ��������)
  public void submitContactUpdate() {
    click(By.name("update"));
  }

  // ����� �������� �� �������� �� ������� ���������
  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  // ����� �������� �� �������� ��������� ��������, �������� ������ �������� (��� ��������) � ������ ���������
  public void gotoContaktViewPage() {
    click(By.xpath("(//img[@alt='Details'])[5]"));
  }

  // ������� � �������� ����������� �������� ( ������� ������ Modify �� ���. ��������� ��������)
  public void submitContactModifiy() {
    click(By.name("modifiy"));
  }
}
