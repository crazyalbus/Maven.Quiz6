package rocks.zipcode.io.collections.collectionutils;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.io.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;

public class ContainsNegativeTest {
    @Test
    public void test1() {
        // given
        Collection<?> collection1 = Arrays.asList(10, 11, 12, 13);
        Collection<?> collection2 = Arrays.asList(110, 111, 112, 113);
        Collection<?> collection3 = Arrays.asList(1110, 1111, 1112, 1113);
        Collection<?> collection4 = Arrays.asList(11110, 11111, 11112, 11113);
        Collection<? extends Collection<?>> nestedCollection = Arrays.asList(
                collection2, collection3, collection4);

        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection1);

        // then
        Assert.assertFalse(outcome);
    }

    @Test
    public void test2() {
        // given
        Collection<?> collection1 = Arrays.asList(10, 11, 12, 13);
        Collection<?> collection2 = Arrays.asList(110, 111, 112, 113);
        Collection<?> collection3 = Arrays.asList(1110, 1111, 1112, 1113);
        Collection<?> collection4 = Arrays.asList(11110, 11111, 11112, 11113);
        Collection<? extends Collection<?>> nestedCollection = Arrays.asList(
                collection1, collection3, collection4);

        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection2);

        // then
        Assert.assertFalse(outcome);
    }

    @Test
    public void test3() {
        // given
        Collection<?> collection1 = Arrays.asList(10, 11, 12, 13);
        Collection<?> collection2 = Arrays.asList(110, 111, 112, 113);
        Collection<?> collection3 = Arrays.asList(1110, 1111, 1112, 1113);
        Collection<?> collection4 = Arrays.asList(11110, 11111, 11112, 11113);
        Collection<? extends Collection<?>> nestedCollection = Arrays.asList(
                collection1, collection2, collection4);

        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection3);

        // then
        Assert.assertFalse(outcome);
    }

    @Test
    public void test4() {
        // given
        Collection<?> collection1 = Arrays.asList(10, 11, 12, 13);
        Collection<?> collection2 = Arrays.asList(110, 111, 112, 113);
        Collection<?> collection3 = Arrays.asList(1110, 1111, 1112, 1113);
        Collection<?> collection4 = Arrays.asList(11110, 11111, 11112, 11113);
        Collection<? extends Collection<?>> nestedCollection = Arrays.asList(
                collection1, collection2, collection3);

        // when
        Boolean outcome = CollectionUtils.contains(nestedCollection, collection4);

        // then
        Assert.assertFalse(outcome);
    }
}

