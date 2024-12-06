package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Book;

import dagger.internal.Factory;

public class BookFactory implements Factory<Book> {

    private static final class Holder {
        private static final BookFactory INSTANCE = new BookFactory();
    }

    //静态内部类构建对象
    public static BookFactory create() {
        return Holder.INSTANCE;
    }

    @Override
    public Book get() {
        return newInstance();
    }

    public static Book newInstance() {
        return new Book();
    }

}
