package interviews.townhall;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

    }

    //implement a stack



}


class Stack
{
    private ArrayList<Integer> elements;


    public Stack()
    {
        elements = new ArrayList<>();
    }

    public Integer pop () throws StackEmptyException {
        if(elements.size()==0)
            throw new StackEmptyException();
        else {
            return elements.remove(elements.size()-1);
        }

    }

    public boolean push(Integer num)
    {
        return elements.add(num);
    }

    public Integer peek()
    {
        return elements.get(elements.size()-1);
    }

    public boolean isEmpty()
    {
        return elements.size() == 0 ;
    }
}

class StackEmptyException  extends Exception
{
    //String message;
    public StackEmptyException()
    {
        super();
    }

}
