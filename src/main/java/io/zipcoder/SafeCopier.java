package io.zipcoder;

import java.util.Iterator;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    public SafeCopier(String toCopy) {
        super(toCopy);
    }
    //using syncronized block

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

}
