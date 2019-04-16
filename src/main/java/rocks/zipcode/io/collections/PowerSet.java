package rocks.zipcode.io.collections;

import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class PowerSet<TypeOfSet> {
    protected final Set<TypeOfSet> originalSet;

    public PowerSet(TypeOfSet[] originalSet) {
        this.originalSet = new HashSet<>(Arrays.asList(originalSet));
    }

    /**
     * @return the powerset of `originalSet`
     */
    public Set<Set<TypeOfSet>> permute() {
        List<TypeOfSet> originalList = new ArrayList<>(originalSet);
        Set<Set<TypeOfSet>> powerSet = new HashSet<>();

        int powerSetSize = (int) Math.pow(2, originalSet.size());

        int i = powerSetSize - 1;
        while (i >= 0) {
            Set<TypeOfSet> temp = new HashSet<>();
            String pattern = Integer.toBinaryString(i);
            while(pattern.length() < Integer.toBinaryString(powerSetSize-1).length()) {
                pattern = "0" + pattern;
            }
            for (int j = 0; j < pattern.length(); j++) {
                if(pattern.charAt(j) == '1') {
                    temp.add(originalList.get(j));
                }
            }
            powerSet.add(temp);
            i--;
        }
        return powerSet;
    }

    /**
     * @return `originalSet`
     */
    public Set<TypeOfSet> getOriginalSet() {
        return originalSet;
    }
}
