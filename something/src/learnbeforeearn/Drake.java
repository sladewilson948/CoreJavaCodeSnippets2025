package learnbeforeearn;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;


public class Drake
{

    private static Map<String,String> rap = new HashMap<>();
    private static Map<String,String> randb = new HashMap<>();


    public static void showAllRapSongs()
    {
        /// in this method what we need to do it go through all the songs in the rap maps and print them
        System.out.println("Here is a list of all rap songs by drake!!");
        for(String songName: rap.keySet())
        {
            System.out.println("Song name : "+songName);
        }
    }

    public static void showAllRandBSongs()
    {
        System.out.println("Here is a list of all randb songs by drake!!");
        for(String songName: randb.keySet())
        {
            System.out.println("Song name : "+songName);
        }
    }

    public static void drakeRapSongsCollections(String filePath)
    {
        /// in this method basically what we are going to do is populate the map of the rap songs with the song name and the file path. Data will be fed from a file seperate
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String line;
            while((line = br.readLine())!=null)
            {
                /// so basically each line is comma seperated so basicaly we will be reading the songs name and then the path of the song
                List<String> p1 = new ArrayList<>(Arrays.asList(line.split(" ")));
                rap.put(p1.get(0),p1.get(1));
            }
            System.out.println("Loaded all the rap songs!!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Something went wrong while reading the file!!");

        }
    }

    public static void drakeRandBSongsCollections()
    {
        ///
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the program to play all drake songs");
        System.out.println("Choose category Rap/R&B");
        drakeRapSongsCollections("D:\\JAVA2025\\something\\src\\learnbeforeearn\\rapsongs.txt");
        System.out.println("To choose RAP press 1");
        System.out.println("To choose R&B press 2");
        System.out.println("Showing all rap songs by drake!!");
        showAllRapSongs();


        input.close();
    }
}