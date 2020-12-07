package io.zipcoder;

import java.util.Iterator;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    String name;

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try{
            Iterator<String> it = stringIterator;
            while(it.hasNext()){
                String s = it.next();
                System.out.println(s);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String monkeyWrite() {
        Iterator<String> it = stringIterator;
        String word = "";
        while (it.hasNext()) {
            String s = it.next();
            word += s;
            //copied += s + " " + name;
        }
        return word;
    }
}