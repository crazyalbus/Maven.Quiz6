package rocks.zipcode.io.collections.collectionutils;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.io.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;

public class ContainsPositiveTest {
    // given
    private Collection<?> collection1 = Arrays.asList(10, 11, 12, 13);
    private Collection<?> collection2 = Arrays.asList(15, 110, 115, 120);
    private Collection<?> collection3 = Arrays.asList(110, 120, 130, 140);
    private Collection<?> collection4 = Arrays.asList(115, 130, 145, 160);
    private Collection<? extends Collection<?>> nestedCollection = Arrays.asList(
            collection1,collection2, collection3, collection4);

    @Test
    public void test1() {
        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection1);

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void test2() {
        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection2);

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void test3() {
        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection3);

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void test4() {
        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection4);

        // then
        Assert.assertTrue(outcome);
    }
}
