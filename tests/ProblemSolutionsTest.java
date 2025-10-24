import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Comprehensive TestNG Unit Tests for all methods in the ProblemSolutions class.
 */
public class ProblemSolutionsTest {

    // ========================================================================
    // --- Problem 1: Single Character Vowel Checker (isVowel) ---
    // ========================================================================

    @DataProvider(name = "vowelData")
    public Object[][] vowelData() {
        return new Object[][]{
            // True cases (Vowels, case-insensitive)
            {"a", true}, {"E", true}, {"i", true}, {"O", true}, {"u", true},
            // False cases (Consonants)
            {"b", false}, {"Z", false}, {"y", false}, {"p", false},
            // Constraint cases (Length constraint)
            {"ae", false}, {"", false}, {null, false}, {"A E", false}
        };
    }

    @Test(dataProvider = "vowelData", description = "Test 1: Comprehensive vowel and constraint checking")
    public void testIsVowel(String input, boolean expected) {
        assertEquals(ProblemSolutions.isVowel(input), expected, 
                     "isVowel failed for input: '" + input + "'");
    }

    // ========================================================================
    // --- Problem 2: Vowel Counter (countVowels) ---
    // ========================================================================

    @DataProvider(name = "vowelCountData")
    public Object[][] vowelCountData() {
        return new Object[][]{
            {"hello", 2},
            {"Education", 5}, // Mixed case vowels
            {"rhythm", 0},    // No vowels
            {"AEIOUaeiou", 10}, // All vowels
            {"bcdfgh", 0},    // All consonants
            {"", 0},          // Empty string
            {null, 0}         // Null input
        };
    }

    @Test(dataProvider = "vowelCountData", description = "Test 2: Counting vowels in strings with various cases")
    public void testCountVowels(String input, int expected) {
        assertEquals(ProblemSolutions.countVowels(input), expected,
                     "countVowels failed for input: '" + input + "'");
    }

    // ========================================================================
    // --- Problem 3: Remove Character at Specific Index (removeCharAtIndex) ---
    // ========================================================================

    @Test(description = "Test 3.1: Valid removal from the middle")
    public void testRemoveCharAtIndex_middle() {
        assertEquals(ProblemSolutions.removeCharAtIndex("hello", 2), "helo",
                     "Should remove 'l' at index 2.");
    }

    @Test(description = "Test 3.2: Valid removal from the start (index 0)")
    public void testRemoveCharAtIndex_start() {
        assertEquals(ProblemSolutions.removeCharAtIndex("Java", 0), "ava",
                     "Should remove 'J' at index 0.");
    }

    @Test(description = "Test 3.3: Valid removal from the end")
    public void testRemoveCharAtIndex_end() {
        assertEquals(ProblemSolutions.removeCharAtIndex("world", 4), "worl",
                     "Should remove 'd' at the last index.");
    }

    @Test(description = "Test 3.4: Index too large (out of bounds)")
    public void testRemoveCharAtIndex_indexTooLarge() {
        String original = "hello";
        assertEquals(ProblemSolutions.removeCharAtIndex(original, 10), original,
                     "Index 10 is out of bounds, should return original string.");
    }

    @Test(description = "Test 3.5: Negative index")
    public void testRemoveCharAtIndex_negativeIndex() {
        String original = "hello";
        assertEquals(ProblemSolutions.removeCharAtIndex(original, -1), original,
                     "Negative index, should return original string.");
    }

    @Test(description = "Test 3.6: Null and empty string constraints")
    public void testRemoveCharAtIndex_emptyAndNull() {
        assertEquals(ProblemSolutions.removeCharAtIndex("", 5), "", "Empty string should return empty string.");
        assertEquals(ProblemSolutions.removeCharAtIndex(null, 2), "", "Null string should return empty string.");
    }

    // ========================================================================
    // --- Problem 4: Count Substrings of Length 2 (countSubstringsLength2) ---
    // ========================================================================

    @Test(description = "Test 4.1: Standard case ('hello')")
    public void testCountSubstringsLength2_standard() {
        assertEquals(ProblemSolutions.countSubstringsLength2("hello"), 4,
                     "5-length string should yield 4 substrings.");
    }

    @Test(description = "Test 4.2: Edge case for minimum length 2")
    public void testCountSubstringsLength2_minValidLength() {
        assertEquals(ProblemSolutions.countSubstringsLength2("ab"), 1,
                     "Length 2 string should yield 1 substring ('ab').");
    }

    @Test(description = "Test 4.3: Constraint case (Length less than 2)")
    public void testCountSubstringsLength2_tooShort() {
        assertEquals(ProblemSolutions.countSubstringsLength2("a"), 0,
                     "Length 1 string should yield 0 substrings.");
    }

    @Test(description = "Test 4.4: Null and empty constraint")
    public void testCountSubstringsLength2_emptyAndNull() {
        assertEquals(ProblemSolutions.countSubstringsLength2(""), 0, "Empty string should yield 0.");
        assertEquals(ProblemSolutions.countSubstringsLength2(null), 0, "Null string should yield 0.");
    }

    // ========================================================================
    // --- Problem 5: Print String in a Box (printInBox) ---
    // ========================================================================

    @Test(description = "Test 5.1: Single digit input (Example: '5')")
    public void testPrintInBox_singleDigit() {
        String input = "5";
        // Expected: +---+\n| 5 |\n+---+
        String expected = 
            "+---+\n" + 
            "| 5 |\n" + 
            "+---+";
        assertEquals(ProblemSolutions.printInBox(input), expected, 
                     "Box for '5' is incorrectly formatted (Expected 3 dashes).");
    }

    @Test(description = "Test 5.2: Multi-digit input (Example: '99')")
    public void testPrintInBox_multiDigits() {
        String input = "99";
        // Expected: +----+\n| 99 |\n+----+
        String expected = 
            "+----+\n" + 
            "| 99 |\n" + 
            "+----+";
        assertEquals(ProblemSolutions.printInBox(input), expected, 
                     "Box for '99' is incorrectly formatted (Expected 4 dashes).");
    }

    @Test(description = "Test 5.3: Long string input")
    public void testPrintInBox_longString() {
        String input = "HelloWorld"; // Length 10, needs 12 dashes
        // Expected: +------------+\n| HelloWorld |\n+------------+
        String expected = 
            "+------------+\n" + 
            "| HelloWorld |\n" + 
            "+------------+";
        assertEquals(ProblemSolutions.printInBox(input), expected, 
                     "Box for 'HelloWorld' is incorrectly formatted.");
    }

    @Test(description = "Test 5.4: Empty string constraint")
    public void testPrintInBox_emptyString() {
        String input = "";
        // Expected: ++\n||\n++ (Minimal box)
        String expected = "++\n||\n++"; 
        assertEquals(ProblemSolutions.printInBox(input), expected, 
                     "Minimal box for empty string is incorrect.");
    }

    @Test(description = "Test 5.5: Null input constraint")
    public void testPrintInBox_nullInput() {
        String input = null;
        // Should return minimal box (same as empty string).
        String expected = "++\n||\n++"; 
        assertEquals(ProblemSolutions.printInBox(input), expected, 
                     "Should return minimal box for null input.");
    }

    // ========================================================================
    // --- Problem 6: Longest String in Array (findLongestString) ---
    // ========================================================================

    @Test(description = "Test 6.1: Standard case - returns the absolute longest string")
    public void testFindLongestString_standardCase() {
        String[] input = {"1", "1234", "45", "123456789", "8", "99"};
        String expected = "123456789";
        assertEquals(ProblemSolutions.findLongestString(input), expected, 
                     "Should return the string with the greatest length (9).");
    }

    @Test(description = "Test 6.2: Tie-breaker - returns the first string of max length")
    public void testFindLongestString_tieBreaker() {
        String[] input = {"cat", "dogs", "bird", "fish", "tree"};
        String expected = "dogs"; // "dogs" is the first one of length 4.
        assertEquals(ProblemSolutions.findLongestString(input), expected, 
                     "Should return the first longest string in case of a length tie.");
    }

    @Test(description = "Test 6.3: Empty array constraint")
    public void testFindLongestString_emptyArray() {
        String[] input = {};
        String expected = ""; 
        assertEquals(ProblemSolutions.findLongestString(input), expected, 
                     "Should return empty string for an empty array.");
    }

    @Test(description = "Test 6.4: Null array constraint")
    public void testFindLongestString_nullArray() {
        String[] input = null;
        String expected = ""; 
        assertEquals(ProblemSolutions.findLongestString(input), expected, 
                     "Should return empty string for a null array.");
    }

    @Test(description = "Test 6.5: Array containing null and empty strings")
    public void testFindLongestString_withNullElements() {
        String[] input = {"short", null, "", "longestString", "medium"};
        String expected = "longestString"; 
        assertEquals(ProblemSolutions.findLongestString(input), expected, 
                     "Should correctly ignore null/empty elements and find the longest non-null string.");
    }
}
