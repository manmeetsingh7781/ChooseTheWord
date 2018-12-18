package GuessWord;
import java.util.List;
import java.util.Random;

public class RandomWord {
    public static String random(List all_together){
        Random rands = new Random();
        int randNumber = rands.nextInt(all_together.size());
        Object rand = all_together.toArray()[randNumber];
        MainGame.makeList(rand.toString());
        return rand.toString();
    }

}
