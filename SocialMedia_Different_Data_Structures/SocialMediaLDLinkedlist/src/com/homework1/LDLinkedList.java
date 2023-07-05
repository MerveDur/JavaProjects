package com.homework1;
import java.util.LinkedList;
public class LDLinkedList<E> extends LinkedList<E>{
    int lazy_Deletion=0;
    int lazyDeletionCount=0;

    public int getLazy_Deletion() {
        return lazy_Deletion;
    }

    public void setLazy_Deletion(int lazy_Deletion) {
        this.lazy_Deletion = lazy_Deletion;
    }

    public int getLazyDeletionCount() {
        return lazyDeletionCount;
    }

    public void setLazyDeletionCount(int lazyDeletionCount) {
        this.lazyDeletionCount = lazyDeletionCount;
    }


    @Override
    public boolean remove(Object o)
    {
        if (lazyDeletionCount == 0)
        {
            // The number to be deleted has not been reached yet
            lazyDeletionCount++;
            lazy_Deletion = 1;
            return false;
        }
        else if (lazyDeletionCount == 1)
        {
          //If lazy Deletion Count is 1, previous deletion and new deletion are performed.
            int index = 0;
            for (E item : this)
            {
                if (item != null && item.equals(o))
                {
                    if (lazy_Deletion == 1)
                    {
                        this.remove(index - 1);
                        lazy_Deletion = 0;
                        lazyDeletionCount = 0;
                        return true;
                    }
                    else
                    {
                        lazy_Deletion = 1;
                    }
                }
                index++;
            }
            //Looped to end of list and object not found, so don't delete
            lazyDeletionCount = 0;
            return false;
        }
        else
        {
            return false;
        }
    }
}
