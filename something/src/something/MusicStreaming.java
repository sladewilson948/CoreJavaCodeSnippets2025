package something;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class AllArtistCatelog
{
    private List<Artist> artistList;

    public AllArtistCatelog()
    {
        artistList = new ArrayList<>();
    }


    // here we will do method overloading based on what artist we are loading Rap or R&B
    public void addArtistToList(String name, int age, String genre, int albums,String recordLabel, String country)
    {
        artistList.add(new RapArtist(name,age,genre,albums,recordLabel,country));
    }

    //now we will add the method to add artists of the RandB section
    public void addArtistToList(String name, int age, String genre, int albums, String recordLabel, String country, int noOfGrammiesWon)
    {
        artistList.add(new RandBArtist(name,age,genre,albums,recordLabel,country,noOfGrammiesWon));
    }

    public void displayArtist()
    {
        for(Artist artist: artistList)
        {
            System.out.println(artist);
            artist.spitSomeBars();
            ((ArtistStuff) artist).triviaInfo();
        }
    }
}


interface ArtistStuff
{
    void triviaInfo();
}


abstract class Artist
{
    private String name;
    private int age;
    private String genre;
    private int albums;


    public Artist(String name, int age, String genre, int albums)
    {
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.albums = albums;
    }

    public String getName()
    {
        return name;
    }
    public String getGenre()
    {
        return genre;
    }


    @Override
    public String toString()
    {
        return "Hi my name is '" + name + "' and I am '" + age + "' years old.";
    }


    public abstract void spitSomeBars();



}


class RapArtist extends Artist implements ArtistStuff
{

    private String recordLabel;
    private String country;

    public RapArtist(String name, int age, String genre, int albums,String recordLabel, String country)
    {
        super(name,age,genre,albums);
        this.recordLabel = recordLabel;
        this.country = country;
    }


    @Override
    public void spitSomeBars() {
        System.out.println("Ayo Ayo! check this out I am a wrapper from " + country + " and I am signed to "+ recordLabel);
    }

    @Override
    public String toString()
    {
        return super.toString() + ". I am specialised in the genre '" + super.getGenre() + "' and my record lable is '" + recordLabel + "'";
    }

    @Override
    public void triviaInfo()
    {
        System.out.println("Did you know that " + super.getName() + " used to act in movies");
     }
}


class RandBArtist extends Artist implements ArtistStuff
{
    private String recordLabel;
    private String country;
    private int noOfGrammiesWon;

    public RandBArtist(String name, int age, String genre, int albums, String recordLabel, String country, int noOfGrammiesWon)
    {
        super(name,age,genre,albums);
        this.recordLabel = recordLabel;
        this.country = country;
        this.noOfGrammiesWon = noOfGrammiesWon;
    }

    @Override
    public void spitSomeBars()
    {
        System.out.println("Hi there I am a fucking legend and I have have won " + noOfGrammiesWon + " and I am from " + country + " and I am signed to "+ recordLabel);
    }

    @Override
    public String toString()
    {
        return super.toString() + ". I am a fucking Singer man show some respect I have won " + noOfGrammiesWon + " garmmies and I am signed to a 400m record deal to "+ recordLabel +" you dummy!";
    }

    @Override
    public void triviaInfo()
    {
        System.out.println("Did you know that " + super.getName() + " used to act in movies");
    }
}



public class MusicStreaming
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my music streaming platform!!");
        System.out.println("Enter details about your artist");
        /// let's make some aretists for the project
        AllArtistCatelog arts = new AllArtistCatelog();
        arts.addArtistToList("Drake",44, "HipHop", 10,"OVO Sound", "Canada");
        arts.addArtistToList("The Weeknd",42,"R&B",4,"XO","Canada",10);
        arts.displayArtist();
        input.close();
    }

}