package com.fb;

/**
 * Created by Tian on 2017/5/2.
 */
public class CircularBuffer {
    int maxsize;
    int start;
    int end;
    int buflen;
    char[] buf;

    public CircularBuffer(int buflen) {
        buf = new char[buflen];
        maxsize = buflen;
        start = end = 0;
    }

    public boolean isFull() {
        return buflen == maxsize;
    }

    public boolean isEmpty() {
        return buflen == 0;
    }

    public void add(char c) {
        if (!isFull()) {
            buflen++;
            end = (end + 1) % maxsize;
            buf[end] = c;
        } else {
            System.out.println("full");
            display();
        }
    }

    public char poll() {
        if (!isEmpty()) {
            buflen--;
            start = (start + 1) % maxsize;
            return buf[start];
        } else {
            System.out.println("empty");
            display();
            return ' ';
        }
    }

    public void display() {
        System.out.println("start:" + start + "end:" + end + "buflen:" + buflen);
        for (int i = 0; i < maxsize; i++) {
            System.out.print(i + ":" + buf[i]);
        }
        System.out.println("max:" + maxsize);
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(5);
        cb.add('1');
        cb.add('2');
        cb.add('3');
        cb.poll();
        cb.poll();
        cb.poll();
        cb.poll();
        cb.add('4');
        cb.poll();
        cb.poll();
        cb.add('4');
        cb.poll();
        cb.poll();
        cb.add('4');
        cb.poll();
        cb.poll();
    }
}
