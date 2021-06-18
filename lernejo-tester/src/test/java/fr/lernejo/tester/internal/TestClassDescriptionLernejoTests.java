package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TestClassDescriptionLernejoTests {
    @TestMethod
    public void listing_test_methods_annoted() {
        TestClassDescription desc = new TestClassDescription(SomeLernejoTests.class);
        List<Method> methods = desc.listTestMethods();

        Assertions.assertThat(methods)
            .extracting(method -> method.getName())
            .containsExactlyInAnyOrder("ok", "ko");
    }

    public static void main(String[] args) {
        new TestClassDescriptionLernejoTests().listing_test_methods_annoted();
    }
}
