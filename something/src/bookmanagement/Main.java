package bookmanagement;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

class Book implements Serializable
{
    private int id;
    private String title;
    private String author;
    private Boolean isIssued;


    public Book(int id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }


    public String getTitle(){ return title;}
    public String getAuthor(){ return author;}
    public Boolean getIsIssued(){ return isIssued;}

    public void setIsIssued()
    {
        this.isIssued = true;
    }


    @Override
    public String toString()
    {
        return "The book id is '" + id + "', name of the book is '" + title + "' by '" + author + "' this book is '" + (isIssued? "Issued" : "Available") + "'";
    }


}

class FileUtil
{

    /// this will be where we store the book data and load the books data
    private static final String FILE_PATH = "D://JAVA2025//something//src//bookmanagement//allbooks.dat";


    public static void saveBooks(List<Book> books)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH)))
        {
            oos.writeObject(books);
            System.out.println("Data Saved");
        }
        catch(IOException e)
        {
            System.out.println("Error while saving the data onto the object");
        }
    }

    public static void loadBooks()
    {

    }


}


public class Main {



}
