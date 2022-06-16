package interviews;



public class ROT {
    int delta ;

    public ROT()
    {
        this.delta = 3;
    }

    public ROT(int delta)
    {
        this.delta = delta;
    }

    public String rotateString (String input)
    {

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length();i++)
        {
            if ( (input.charAt(i) + delta ) < 'a' )
            {
                sb.append ((char)(input.charAt(i) + delta + 26));
            }
            else if ((input.charAt(i) + delta ) > 'z' )
            {

                sb.append ( (char)(input.charAt(i) + delta - 26));
            }
            else {
                char newChar = (char) (input.charAt(i) + delta);
                sb.append (newChar);
            }

        }

        return sb.toString();
    }

    public static void main (String args[])
    {
        ROT rot = new ROT();
        System.out.println(rot.rotateString("test"));
        ROT rot26 = new ROT(26);
        System.out.println(rot26.rotateString("xyz"));
        ROT rot1 = new ROT(-3);
        System.out.println(rot1.rotateString("whvw"));
    }


}