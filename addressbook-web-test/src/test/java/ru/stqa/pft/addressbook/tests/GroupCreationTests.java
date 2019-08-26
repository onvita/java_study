package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().groupPage();
    // Сохраняем старое множество
    Set<GroupData> before=app.group().all();
    // Создаем новую группу
    GroupData group = new GroupData().withName("Test2");
    app.group().crate(group);
    // Сохраняем новое множество
    Set<GroupData> after=app.group().all();
    // сравниваем размер множеств до и после добавления
    Assert.assertEquals(after.size(), before.size() + 1 );

    // добавленной группе присваиваем идентификатор (withId) и добавляем группу в старое множество
    group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(group);
                        // берем коллекцию содержащую группы с известным идентиыикатором (after),  превращаем ее в поток stream()
                        // поток GroupData преобразуем в поток целых чисел (mapToInt)
                        // анонимная функция, последовательно применяется к элементам потока и каждый из них преобразовывается в число ((g)->g.getId())

    // сравниваем множества (элнменты множества уникальны, т.к. сравниваются и по ид тоже)
    Assert.assertEquals(before, after);

  }


}
