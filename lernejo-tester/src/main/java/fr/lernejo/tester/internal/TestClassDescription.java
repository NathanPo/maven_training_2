package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class TestClassDescription {
    private final Class<?> test;

    public TestClassDescription(Class<?> test) {
        this.test = test;
    }

    public List<Method> listTestMethods() {
        return Arrays.stream(test.getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .filter(m -> m.getReturnType().equals(void.class))
                .filter(m -> m.getParameterCount() == 0)
                .filter(m -> m.isAnnotationPresent(TestMethod.class))
                .toList();
    }
}
