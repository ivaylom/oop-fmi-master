package fmi.unisofia.oop;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //Data data = new Data(1, "string");

        //DataReflectionWrapper.printAllMethods(data);
        //DataReflectionWrapper.printAllFields(data);
        //DataReflectionWrapper.setSomeField(data, 2);
        //DataReflectionWrapper.invokeSetSomeField(data, 2);

        Data2 createdByReflection = DataReflectionWrapper.constructData(1, "2");
        System.out.println(createdByReflection.toString());
    }
}
