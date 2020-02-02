package fmi.unisofia.oop;

import java.lang.reflect.*;

public class DataReflectionWrapper {
    public static void printAllFields(Object obj) {
        if (obj == null) throw new IllegalArgumentException("obj");

        for (Field field : obj.getClass().getDeclaredFields()) {
            StringBuilder sb = new StringBuilder();
            sb.append(Modifier.toString(field.getModifiers()));
            sb.append(" ");
            sb.append(field.getType().getSimpleName());
            sb.append(" ");
            sb.append(field.getName());

            System.out.println(sb.toString());
        }
    }

    public static void printAllMethods(Object obj) {
        if (obj == null) throw new IllegalArgumentException("obj");

        for (Method method : obj.getClass().getDeclaredMethods()) {
            StringBuilder sb = new StringBuilder();
            sb.append(Modifier.toString(method.getModifiers()));
            sb.append(" ");
            sb.append(method.getReturnType().getSimpleName());
            sb.append(" ");
            sb.append(method.getName());
            sb.append("(");

            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                sb.append(parameter.getType().getSimpleName());
                sb.append(" ");
                sb.append(parameter.getName());
                if (i < parameters.length - 1) sb.append(", ");
            }
            sb.append(")");

            System.out.println(sb.toString());
        }
    }

    public static void setSomeField(Data data, int value) throws NoSuchFieldException, IllegalAccessException {
        if (data == null) throw new IllegalArgumentException("data");

        System.out.println("someField = " + data.getSomeField());

        Field someField = data.getClass().getDeclaredField("someField");
        someField.setAccessible(true);
        someField.setInt(data, value);

        System.out.println("someField = " + data.getSomeField());
    }

    public static void invokeSetSomeField(Data data, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (data == null) throw new IllegalArgumentException("data");

        System.out.println("someField = " + data.getSomeField());

        Method setSomeField = data.getClass().getDeclaredMethod("setSomeField", int.class);
        setSomeField.setAccessible(true);
        setSomeField.invoke(data, value);

        System.out.println("someField = " + data.getSomeField());
    }
    
    public static Data2 constructData(int someField, String otherField) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Data2> constructor = Data2.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        Data2 data = constructor.newInstance(someField, otherField);
        return data;
    }
}
