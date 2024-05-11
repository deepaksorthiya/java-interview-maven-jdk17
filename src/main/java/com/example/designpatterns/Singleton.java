package com.example.designpatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InaccessibleObjectException;

/**
 * Java implementation of singleton design pattern.
 * this is thread safe double lock checking lazy initialization also it
 * prevent breaking from clone, reflection and serialization <br>
 * <a href="https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/">GFG Link</a> </a>
 */
public class Singleton implements Serializable, Cloneable {

    private static volatile Singleton INSTANCE;

    private Singleton() {
        if (INSTANCE != null) {
            System.out.println("Instance already created. Throwing exception.");
            throw new InaccessibleObjectException();
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    private Object writeReplace() throws ObjectStreamException {
        return INSTANCE;
    }

    //Driver Code
    public static void main(String[] args) {
        checkSerialization();
        checkReflection();
        checkClone();
    }

    public static void checkSerialization() {
        System.out.println("###############Serialization Check Start#######################");
        try {
            Singleton instance1 = Singleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(
                    new FileInputStream("file.text"));

            Singleton instance2
                    = (Singleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("###############Serialization Check End#######################");
    }

    public static void checkReflection() {
        System.out.println("###############Reflection Check Start#######################");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;
        try {
            Constructor[] constructors
                    = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton
                // pattern
                constructor.setAccessible(true);
                instance2
                        = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- "
                + instance1.hashCode());
        System.out.println("instance2.hashCode():- "
                + (instance2 != null ? instance2.hashCode() : "null"));
        System.out.println("###############Serialization Check End#######################");
    }

    public static void checkClone() {
        System.out.println("###############Clone Check Start#######################");
        try {
            Singleton instance1 = Singleton.getInstance();

            Singleton instance2 = (Singleton) instance1.clone();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("###############Clone Check Start#######################");
    }
}
