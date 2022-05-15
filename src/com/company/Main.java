package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AnnotationValue(Students.class);

    }

//Створити метод який буде записувати поля класу які промарковані анотацією в файл.
    public static void AnnotationValue(Class<?> myClass) throws IOException, ClassNotFoundException {
        Field[] fields = myClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getAnnotation(Annotation.class) instanceof Annotation) {
                File file = new File("serialize.txt");
                serialize(file, field.getName());
                Serializable students1 = deserealize(file);
                System.out.println(students1);
            }
        }
    }


    public static Serializable deserealize(File file) throws IOException, ClassNotFoundException {
        InputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Serializable object = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return object;
    }

    public static void serialize(File file, String object) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }


}
