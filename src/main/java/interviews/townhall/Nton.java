package interviews.townhall;

public class Nton {

    public int id ;
    private static int n;
    private static Nton[] ntonObjects  = new Nton[]{};
    private static int index = 0;

    private Nton (int n)
    {
        n=n;
    }

    public static Nton getInstance()
    {
        Nton obj = null;
        if(ntonObjects.length==0)
        {
             obj = new Nton(n);
             obj.id = 1;
             ntonObjects[index++] = obj;
        }
        else if(ntonObjects.length <= n)
        {
             obj = getUnUsedObj();
            if(null == obj && index < n)
            {
                obj = new Nton(n);
                obj.id = 1;
                ntonObjects[index++] = obj;
            }
        }

        return obj;
    }

    public void setUnused()
    {
        this.id = -1;
    }


    private static Nton getUnUsedObj()
    {
        for(int i=0;i<ntonObjects.length;i++)
        {
            if(ntonObjects[i].id ==-1)
            {
                return ntonObjects[i];
            }
        }
        return null;
    }

}
