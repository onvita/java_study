package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

  // Перед каждым тестовым методом, в данном тесте, будет выполняться этот метод - проверка предусловия
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    // Перед выбором группы  проверяем, есль ли группа, если нет - то вызываем созданеи группы
    if (app.group().list().size() ==0) {
      app.group().crate(new GroupData().withName("Test1")); }
  }

  @Test
  public void testGroupModification ()
  {

    Set<GroupData> before=app.group().all();
    // Выбираем группу для изменения, перебираем список через итератор случайным образом и  получм некий элемент, не обязательно последний
    GroupData modifiedGroup = before.iterator().next();

    GroupData group =new GroupData()
            .withId(modifiedGroup.getId()).withName("test2222").withHeader("test12is").withFooter("test13is");

    // Модифицируем
    app.group().modify(group);

    Set<GroupData> after=app.group().all();
    Assert.assertEquals(after.size(), before.size());

    // меняем старый список - удаляем старое значение, добавляем новое
    before.remove(modifiedGroup);
    before.add(group);


    // сравниваем списки напрямую, т.к. они оба упорядочены одинаково
    Assert.assertEquals(before, after);

  }


}
