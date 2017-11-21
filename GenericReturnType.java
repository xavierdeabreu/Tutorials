package Merces;

public class Main {

    public static void main(String[] args) {
        System.out.println(max(23, 42, 1));
        //This wil return the biggest letter of the alphabet
        System.out.println(max("zetas", "chicken", "tots"));
    }

    public static <T extends Comparable<T>> T max(T a, T b, T c) {
        T m = a;

        if (b.compareTo(a) > 0)
            m = b;

        if (c.compareTo(m) > 0)
            m = c;

        return m;
    }
}
