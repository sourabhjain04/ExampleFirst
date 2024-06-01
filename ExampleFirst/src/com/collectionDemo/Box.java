package com.collectionDemo;
// A generic class with a single type parameter T
public class Box<T> {
    private T content;

    // Constructor to initialize the content
    public Box(T content) {
        this.content = content;
    }

    // Getter method to retrieve the content
    public T getContent() {
        return content;
    }

    // Setter method to set the content
    public void setContent(T content) {
        this.content = content;
    }

    public static void main(String[] args) {
        // Creating a Box object to hold an Integer
        Box<Integer> integerBox = new Box<>(123);
        System.out.println("Integer Box contains: " + integerBox.getContent());

        // Creating a Box object to hold a String
        Box<String> stringBox = new Box<>("Hello Generics");
        System.out.println("String Box contains: " + stringBox.getContent());
    }
}
