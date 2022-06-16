package system.design.patterns;


//other ways of creating singleton -> https://www.baeldung.com/java-singleton-double-checked-locking
public class Singleton {

    private static volatile Singleton singleInstance;

    private Singleton ()
    {

    }

    public static Singleton getInstance()
    {
        if(singleInstance == null)
        {
            synchronized (Singleton.class)
            {
                if(singleInstance ==null)
                {
                    singleInstance = new Singleton();
                }
            }
        }
        return singleInstance;
    }
}
