package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class TestClassDescription {
    Class<?> test;

    public TestClassDescription(Class<?> test) {
        this.test = test;
    }

    public List<Method> listTestMethods() {
        List<Method> list =  Arrays.stream(test.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .filter(m -> !Modifier.isStatic(m.getModifiers()))
            .filter(m -> m.getParameterCount() == 0)
            .filter(m -> m.getReturnType() == void.class)
            .filter(m -> m.isAnnotationPresent(TestMethod.class))
            .toList();
        return list;
    }
}
