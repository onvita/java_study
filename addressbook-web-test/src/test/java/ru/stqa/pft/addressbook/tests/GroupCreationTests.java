package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before=app.getGroupHelper().getGroupList();     // before и after - будут содержать список элементов- список объектов типа GroupData
    GroupData group = new GroupData("test31", null, null);
    app.getGroupHelper().crateGroup(group);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1 ); // сравниваем размер списков до и после добавления


// ищем максимальный идентификаор в номо списке и его сохраняем
    int max=0;
    for (GroupData g: after ) { //GroupData - переменная, которая пробегает список after
      if (g.getId() > max) { max=g.getId(); }
           }
    group.setId(max);

    // меняем старый список - добавляем новое
    before.add(group);
    // создаем множества из списков и сравниваем их
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
