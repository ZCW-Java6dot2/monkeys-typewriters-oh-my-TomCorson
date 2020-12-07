package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        Thread unsafeMonkey1 = new Thread(new UnsafeCopier(introduction));
        Thread unsafeMonkey2 = new Thread(new UnsafeCopier(introduction));
        Thread unsafeMonkey3 = new Thread(new UnsafeCopier(introduction));
        Thread unsafeMonkey4 = new Thread(new UnsafeCopier(introduction));
        Thread unsafeMonkey5 = new Thread(new UnsafeCopier(introduction));
        unsafeMonkey1.start();
        unsafeMonkey2.start();
        unsafeMonkey3.start();
        unsafeMonkey4.start();
        unsafeMonkey5.start();



        Thread safeMonkey1 = new Thread(new SafeCopier(introduction));
        Thread safeMonkey2 = new Thread(new SafeCopier(introduction));
        Thread safeMonkey3 = new Thread(new SafeCopier(introduction));
        Thread safeMonkey4 = new Thread(new SafeCopier(introduction));
        Thread safeMonkey5 = new Thread(new SafeCopier(introduction));
        safeMonkey1.start();
        try{ safeMonkey1.join();} catch (Exception e){e.printStackTrace();}
        safeMonkey2.start();
        try{ safeMonkey2.join();} catch (Exception e){e.printStackTrace();}
        safeMonkey3.start();
        try{ safeMonkey3.join();} catch (Exception e){e.printStackTrace();}
        safeMonkey4.start();
        try{ safeMonkey4.join();} catch (Exception e){e.printStackTrace();}
        safeMonkey5.start();
        try{ safeMonkey5.join();} catch (Exception e){e.printStackTrace();}



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
    }
}