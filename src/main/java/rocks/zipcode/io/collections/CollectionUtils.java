package rocks.zipcode.io.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionUtils {

    /**
     * @param collection - object to be converted to list
     * @param <E>        - type of collection
     * @return list with identical contents
     */
    public static <E> List<E> toList(Collection collection) {

        Stream<E> stream = collection.stream();
        List<E> list = stream.collect(Collectors.toList());

        return list;
    }

    /**
     * @param nestedCollection - collection to be evaluated
     * @param collection       - collections to be sought within `nestedCollection`
     * @return true if `nestedCollection` contains a collection with contents identical to `collection`
     */
    public static Boolean contains(Collection<? extends Collection<?>> nestedCollection, Collection<?> collection) {

        Boolean containsCollection = false;

        for (Collection<?> c : nestedCollection) {
            if(c.equals(collection)){
                containsCollection = true;
            }
        }

        return containsCollection;
    }

    /**
     * @param collections - collections to be nested
     * @return a single collection containing each of the collections passed in as an argument
     */
    public static Collection<? extends Collection<?>> nest(Collection<?>... collections) {
        Stream<Collection<?>> stream = Stream.of(collections);
        Collection<? extends Collection<?>> collection = stream.collect(Collectors.toCollection(ArrayList::new));

        return collection;
    }

    /**
     * @param collections - collections to be combined
     * @return a single collection containing the aggregate contents of each collection passed in as an argument
     */
    public static Collection<?> flatten(Collection<?>... collections) {

        Collection<?> flatCollection = new ArrayList<>();

        for (Collection<?> collection : collections) {
            flatCollection.addAll(toList(collection));
        }

        return flatCollection;
    }

//    public Stream<?> itemStream(Collection<?> collection) {
//
//
//
//        return collection.stream();
//    }
//
//    public Stream<?> flatStream(Stream<Collection<?>> stream) {
//        return stream.flatMap(this::itemStream);
//    }
}