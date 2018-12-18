package GuessWord;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

interface Rules {
    void createFile();
    void readFile();
    void fileName();
    int getLength();
   Object[] getElems();
}
public class File_Reader implements Rules {
    private int length = 0;
    private ArrayList<String> list_of_object = new ArrayList<String>();
    public void createFile(){
        try {
            Formatter file = new Formatter("C:\\Users\\manme\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\java\\GuessWord\\"+"newfile.txt");
            System.out.println("File has been created");
            file.format("%s","Hello World");
            file.close();
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void readFile(){
        File read = new File("C:\\Users\\manme\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\java\\GuessWord\\"+"newfile.txt");
        try{
            Scanner reader = new Scanner(read);
            do {
                System.out.println(reader.nextLine());
                } while(reader.hasNext());
            } catch (FileNotFoundException e) {
            System.out.println(e);
            }
            }


    public int getLength() {
        File read = new File("C:\\Users\\manme\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\java\\GuessWord\\" + "newfile.txt");
        try {
            Scanner reader = new Scanner(read);
            do {
                reader.nextLine();
                length++;
            } while (reader.hasNext());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return length;
    }

    public void fileName(){
        File read = new File("C:\\Users\\manme\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\java\\GuessWord\\" + "newfile.txt");
        System.out.println(read.getName());
    }

    public Object[] getElems(){
        File read = new File("C:\\Users\\manme\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\java\\GuessWord\\" + "newfile.txt");
        try {
            Scanner reader = new Scanner(read);
            do {
                list_of_object.add(reader.nextLine());
                length++;
            } while (reader.hasNext());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return list_of_object.toArray();
    }
}
