package ReflectionAndAnnotation.Lab._2_GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeSet;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Method[] methods = Reflection.class.getDeclaredMethods();

        TreeSet<Method> getters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods, "get"));

        TreeSet<Method> setters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods, "set"));

        Function<Class<?>, String> formatType = c -> c == int.class ? "class int" : c.toString();

        getters
                .forEach(m -> System.out.printf("%s will return %s%n", m.getName(),
                        formatType.apply(m.getReturnType())));

        setters
                .forEach(m -> System.out.printf("%s and will set field of %s%n", m.getName(),
                        formatType.apply(m.getParameterTypes()[0])));

    }
}
