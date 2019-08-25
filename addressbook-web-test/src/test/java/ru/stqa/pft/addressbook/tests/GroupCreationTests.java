package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before=app.getGroupHelper().getGroupList();     // before и after - будут содержать список элементов- список объектов типа GroupData
    GroupData group = new GroupData("test44", null, null);
    app.getGroupHelper().crateGroup(group);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1 ); // сравниваем размер списков до и после добавления

//  Записываем идентификатор только созданный - это максимальный из имеющихся в новом списке
    // Список превращаем в поток, after.stream()
    // по этому потоку пробегается функция-сравниватель и находится максимальный элемент max
    // при этом сравниваются объекты типа GroupData (o1, o2) путем сравнения их идентификаторов Integer.compare(o1.getId(), o2.getId()
    // на выходе будет максимальный объект (группа с максимальным идентификатором) get()
    // берем ее идентификатор getId()
    // всю конструкцию вызываем в group.setId(...)
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    // меняем старый список - добавляем новое
    before.add(group);
    // создаем множества из списков и сравниваем их
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
