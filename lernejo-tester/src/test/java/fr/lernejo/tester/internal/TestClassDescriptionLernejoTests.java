package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

public class TestClassDescriptionLernejoTests {
    public static void main(String[] args) {
        // call tests fonction
        test();
    }

    @TestMethod
    public static void test() {
        try {
            var list = new TestClassDescription(SomeLernejoTests.class).listTestMethods();
            System.out.println(list);
            assertEq(2, list.size());

            assertTrue(list.contains(SomeLernejoTests.class.getMethod("ok")));
            assertTrue(list.contains(SomeLernejoTests.class.getMethod("ko")));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public static void assertEq(int expect, int got) {
        if (expect != got)
            throw new RuntimeException("Assertion failed, expected " + expect + ", got " + got + "!");
    }

    public static void assertTrue(boolean test) {
        if (!test)
            throw new RuntimeException("Assertion failed (expected true got false)!");
    }
}
