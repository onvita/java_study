package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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

    List<GroupData> before=app.group().list();
    int index = before.size()-1;
    GroupData group =new GroupData()
            .withId(before.get(index).getId()).withName("test2222").withHeader("test12is").withFooter("test13is");

    // Модифицируем
    app.group().modify(index, group);

    List<GroupData> after=app.group().list();
    Assert.assertEquals(after.size(), before.size());

    // меняем старый список - удаляем старое значение, добавляем новое
    before.remove(index);
    before.add(group);

    // Сортируем оба списка
    Comparator<? super GroupData> byId=(g1,g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    // сравниваем списки напрямую, т.к. они оба упорядочены одинаково
    Assert.assertEquals(before, after);

  }


}
