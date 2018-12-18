package GuessWord;
import java.util.ArrayList;
import java.util.*;


public class MainGame {
    public static ArrayList<String> list = new ArrayList<>();
    private static ArrayList<String> words_list = new ArrayList<>();
    private static MainGame game = new MainGame();

    static void makeList(String len) {
        for (int x = 0; x < len.length(); x++) {
            String[] w = len.split("");
            list.add("___" + (x + 1) + "___");
            words_list.add(w[x]);
        }
        game.Main();
    }

   private void Main(){
        Placing placing = new Placing();
    }


// Only Accessible for this class MainGame only
 private class Placing {
       Placing() {
           Integer counter = 0;
           ArrayList<Integer> nums = new ArrayList<>();
           boolean hard = false;
           for (int x = 0; x < list.size(); x++) {
               nums.add(x);
           }
           String start_with = words_list.get(0);
           System.out.println(start_with);
           Object original_list = words_list.clone();
           Collections.shuffle(nums);
           Collections.shuffle(words_list);
           Collections.shuffle(words_list);
           System.out.println("\n" +
                   "--     _____                                 _______  _                   __          __              _      \n" +
                   "--    / ____|                               |__   __|| |                  \\ \\        / /             | |     \n" +
                   "--   | |  __  _   _   ___  ___  ___            | |   | |__    ___          \\ \\  /\\  / /___   _ __  __| | ___ \n" +
                   "--   | | |_ || | | | / _ \\/ __|/ __|           | |   | '_ \\  / _ \\          \\ \\/  \\/ // _ \\ | '__|/ _` |/ __|\n" +
                   "--   | |__| || |_| ||  __/\\__ \\\\__ \\           | |   | | | ||  __/           \\  /\\  /| (_) || |  | (_| |\\__ \\\n" +
                   "--    \\_____| \\__,_| \\___||___/|___/           |_|   |_| |_| \\___|            \\/  \\/  \\___/ |_|   \\__,_||___/\n" +
                   "--                                                                                                           \n" +
                   "--                                                                                                           \n" +
                   " ");
           System.out.println("Press 1 for Easy Mode and 0 for Hard Mode");
           try {
               Scanner mode = new Scanner(System.in);
               int response = mode.nextInt();
               if (response == 0) {
                   hard = true;
               }
               do {
                   All_Elements.shuffle();
                   System.out.println("++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("Word Length " + list.size());
                   System.out.println("Turns: " + counter);
                   System.out.println("Results: " + list);
                   System.out.println("Word Starts with: "+ start_with);
                   if (!hard) {
                       System.out.println("Words to solve with: " + words_list);
                       System.out.println("Mode: Easy");
                   } else {
                       System.out.println("Mode: Hard");
                   }
                   System.out.println("++++++++++++++++++++++++++++++++++++++++");
                   int get_word_int = nums.get(counter);
                   String choosen_word = words_list.get(get_word_int);
                   System.out.println("Place '" + choosen_word + "' at the index position");
                   Scanner get_data = new Scanner(System.in);
                   int get_data_result = get_data.nextInt() - 1;
                   if (get_data_result > list.size()) {
                       System.out.println("Position must be valid within the length of word");
                       if (hard) {
                           counter++;
                       }
                   } else {
                       list.remove(get_data_result);
                       list.add(get_data_result, choosen_word);
                       System.out.println(list);
                       counter++;
                   }
               } while (counter < list.size());
               if (counter >= list.size()) {
                   String final_res = "";
                   for (String l : list) {
                       final_res += l;
                   }

                   wining(final_res, original_list);
               }
           } catch (Exception e) {
               System.out.println("Exiting...");
               System.exit(0);
           }
       }
   }

   private static void wining(String result, Object original_word) {
        boolean foundMatched = false;
        for (Object each : All_Elements.get_list()) {
            String each_word = each.toString();
            if (each_word.length() == result.length() && each_word.equals(result)) {
                foundMatched = true;
            }
        }
        if (foundMatched) {
            System.out.println("======================= RESULT YOU WON =======================");
            System.out.println("You're input: '" + result + "' Has been matched with System");
            System.out.println("System input: " + original_word);
        } else {
            System.out.println("======================= RESULT YOU LOST =======================");
            System.out.println("You're input: '" + result + "' did not matched with System");
            System.out.println("System input: " + original_word);
        }
        System.out.println("Would you like to play again?\nPress 1 to play and any key to exit");
        Scanner answer = new Scanner(System.in);
        if (answer.nextInt() == 1) {
            list.clear();
            words_list.clear();
            makeList(RandomWord.random(All_Elements.all_together));
            game.Main();
        } else if (answer.nextInt() != 1) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
