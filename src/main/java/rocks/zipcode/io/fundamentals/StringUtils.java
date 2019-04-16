package rocks.zipcode.io.fundamentals;


import rocks.zipcode.io.arrays.ArrayUtils;
import rocks.zipcode.io.collections.PowerSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static rocks.zipcode.io.fundamentals.BasicStringUtils.getString;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        // get length of string
        Integer length = string.length();

        // get range of length
        Integer[] range = ArrayUtils.getRange(0, length - 1);

        // get power-set of range
        PowerSet<Integer> ps = new PowerSet<>(range);
        Set<Set<Integer>> powerSet = ps.permute();

        Collection<String> allCasings = new HashSet<>();

        // for every set in power-set
        for (Set<Integer> set : powerSet) {
            String temp = string;
            for (Integer i : set) {
                temp = upperCaseIndices(temp, i);
            }
            allCasings.add(temp);
        }
            // uppercase indices of string using set


        return allCasings;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {

        char[] stringAsArray = string.toCharArray();

        for (Integer i : indices) {
            stringAsArray[i] = Character.toUpperCase(stringAsArray[i]);
        }

        return getString(stringAsArray);
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {

        StringBuilder newString = new StringBuilder();

        newString.append(stringToBeManipulated.substring(0,index));
        newString.append(valueToBeInserted);
        newString.append(stringToBeManipulated.substring(index));

        return newString.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {

        StringBuilder newString = new StringBuilder();

        newString.append(stringToBeManipulated.substring(0,index));
        newString.append(replacementValue);
        newString.append(stringToBeManipulated.substring(index + 1));

        return newString.toString();
    }
}