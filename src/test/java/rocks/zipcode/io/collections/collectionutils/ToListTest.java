package rocks.zipcode.io.collections.collectionutils;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.io.collections.CollectionUtils;

import java.util.*;
import java.util.function.Supplier;

public class ToListTest {
    @Test
    public void test1() {
        test(TreeSet::new, 10, 15, 110, 115);
    }

    @Test
    public void test2() {
        test(TreeSet::new, "10", "110", "115", "15");
    }

    @Test
    public void test3() {
        test(TreeSet::new, '1', '2', '3', '4');
    }

    @Test
    public void test4() {
        test(Stack::new, 10, 15, 110, 115);
    }

    @Test
    public void test5() {
        test(Stack::new, "10", "15", "110", "115");
    }

    @Test
    public void test6() {
        test(Stack::new, 'g', 'h', 'i', 'j');
    }


    private <E> void test(Supplier<? extends Collection<E>> collectionSupplier, E... items) {
        // given
        Collection<E> collection = collectionSupplier.get();
        List<E> expected = Arrays.asList(items);
        collection.addAll(expected);

        // when
        List<E> actual = CollectionUtils.toList(collection);

        // then
        Assert.assertEquals(expected, actual);
    }
}
