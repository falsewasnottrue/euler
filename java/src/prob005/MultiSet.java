package prob005;

import java.util.*;
import java.util.function.BiFunction;

public class MultiSet<T> {

    private final Map<T, Integer> occurrences = new HashMap<>();

    public MultiSet() {}

    public MultiSet(final Collection<T> c) {
        for (final T elem : c) { put(elem); }
    }

    public int size() {
        return occurrences.size();
    }

    public Set<T> elements() {
        return occurrences.keySet();
    }

    public void put(final T elem) {
        occurrences.put(elem, occurrences.getOrDefault(elem, 0) + 1);
    }

    public int get(final T elem) {
        return occurrences.getOrDefault(elem, 0);
    }

    public MultiSet<T> union(final MultiSet<T> other, final BiFunction<Integer, Integer, Integer> combiner) {
        final MultiSet<T> result = new MultiSet<T>();
        final Set<T> keys = new HashSet<T>(occurrences.keySet());
        keys.addAll(other.occurrences.keySet());

        for (final T elem : keys) {
            final int count = combiner.apply(get(elem), other.get(elem));
            for (int i=0; i < count; i++) {
                result.put(elem);
            }
        }

        return result;
    }
}
