package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private final String originalString;

    public ReversedSequence(String originalString) {
        this.originalString = originalString;
    }

    @Override
    public int length() {
        return originalString.length();
    }

    @Override
    public char charAt(int index) {
        return originalString.charAt(length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String originalSubstr = originalString
                .substring(originalString.length() - end, originalString.length() - start);
        StringBuilder reversedSubstr = new StringBuilder(originalSubstr).reverse();
        return new ReversedSequence(reversedSubstr.toString());
    }


    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder();
        for (int i = length() - 1; i >= 0; i--) {
            reversed.append(originalString.charAt(i));
        }
        return reversed.toString();
    }
}

// END
