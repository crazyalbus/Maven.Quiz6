package rocks.zipcode.io.fundamentals;

public class BasicStringUtils {
    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(char[] chars) {

        StringBuilder newString = new StringBuilder();

        for (char c : chars) {
            newString.append(c);
        }

        return newString.toString();
    }

    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(Character[] chars) {
        StringBuilder newString = new StringBuilder();

        for (Character c : chars) {
            newString.append(c);
        }

        return newString.toString();
    }

    /**
     * @param string - string to be manipulated
     * @return identical string with lowercase and uppercase vowels removed
     */
    public static String removeAllVowels(String string) {

        char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};

        return removeSpecifiedCharacters(string, getString(vowels));
    }

    /**
     * @param string             - string to be manipulated
     * @param charactersToRemove - characters to be removed from string
     * @return
     */
    public static String removeSpecifiedCharacters(String string, String charactersToRemove) {

        String newString = string;
        char[] chars = charactersToRemove.toCharArray();

        for (char c : chars) {
            while (newString.indexOf(c) != -1) {
                newString = newString.replace(Character.toString(c), "");
            }
        }

        return newString;
    }
}
