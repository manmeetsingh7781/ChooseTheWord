package GuessWord;
import java.util.ArrayList;
import java.util.*;

public class All_Elements {
    static File_Reader read = new File_Reader();
    static public ArrayList<Object> all_together = new ArrayList<Object>();
       All_Elements() {
        List<Object> all = new ArrayList<Object>();
        for (Object each: read.getElems()) {
            all.add(each);
        }
        all_together.addAll(all);
        RandomWord.random(all_together);
        shuffle();
    }
    static void shuffle(){
        Collections.shuffle(all_together);
        System.out.println("\n\n\n\nList of Words: " + all_together);
    }

    static Object[] get_list(){
           return all_together.toArray();
    }
}
