package interviews.townhall;

public class MySingleton {


    private static MySingleton obj;

    private MySingleton()
    {
        //member initialization
    }

     public static  MySingleton getInstance()
     {
         if(obj == null)
         {
             obj = new MySingleton();
         }
         return obj;
     }


}
