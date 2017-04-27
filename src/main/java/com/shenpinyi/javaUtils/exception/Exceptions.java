package com.shenpinyi.javaUtils.exception;

/**
 * Created by jack on 26/04/2017.
 */
public class Exceptions {
    /**
     * Throwable
     *   Error (An Error is a subclass of Throwable that indicates serious problems
     *          that a reasonable application should not try to catch.
     *          Most such errors are abnormal conditions.)
     *      AssertionError
     *      LinkageError
     *      VirtualMachineError
     *      AnnotationFormatError
     *      OutOfMemoryError
     *   Exception
     *      RuntimeException (Unchecked Exception)
     *      everything else
     *
     *  Casting: ClassCastException
     *  Arrays: ArrayIndexOutOfBoundsException, NullPointerException
     *  Collections: NullPointerException, ClassCastException (if you're not using autoboxing and you screw it up)
     *  IO: java.io.IOException, java.io.FileNotFoundException, java.io.EOFException
     *  Serialization: java.io.ObjectStreamException (AND ITS SUBCLASSES, which I'm too lazy to enumerate)
     *  Threads: InterruptedException, SecurityException, IllegalThreadStateException
     *  Potentially common to all situations: NullPointerException, IllegalArgumentException
     *
     *
     * Unchecked Exception List
     *      ArrayIndexOutOfBoundsException
     *      ClassCastException
     *      IllegalArgumentException
     *      IllegalStateException
     *      NullPointerException
     *      NumberFormatException
     *      AssertionError
     *      ExceptionInInitializerError
     *      StackOverflowError
     *      NoClassDefFoundError
     * Checked Exception List
     *      Exception
     *      IOException
     *      FileNotFoundException
     *      ParseException
     *      ClassNotFoundException
     *      CloneNotSupportedException
     *      InstantiationException
     *      InterruptedException
     *      NoSuchMethodException
     *      NoSuchFieldException
     */

    public static void run() {
        try {
            System.exit(0);
        } finally {
            System.out.println("finally");  // will not be executed
        }
    }

    public static void run1() {
        try {
            return;
        } finally {
            System.out.println("finally"); // will be executed
        }
    }

    public static void run2() {
        try {
            return;
        } finally {
            int a = 1/0;
            System.out.println("finally"); // will not be executed
        }
    }

}
