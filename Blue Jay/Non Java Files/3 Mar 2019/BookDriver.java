import java.util.*;
import java.io.*;
/**
 * The Bookdriver reads in books from the text file then lists them in order of price or title depending on what is
 * commented out in the Book class.
 *
 * @author Austin Lowery
 * @version 3/27/2019
 */
public class BookDriver
{
    public static void main(String[] args) throws IOException{
        Book[] books;
        Scanner reader = new Scanner(new File("books.txt"));
        StringTokenizer tokenizer;
        
        String title;
        String author;
        String price;
        
        int minPos;
        Book minValue;
        
        books = new Book[Integer.parseInt(reader.nextLine())]; // sets the array's length to whatever the first line in the document indicates
        
        int i = 0;
        while(reader.hasNext()){
            tokenizer = new StringTokenizer(reader.nextLine(),",");
            
            title = tokenizer.nextToken();
            author = tokenizer.nextToken();
            price = tokenizer.nextToken();
            
            books[i] = new Book(title, author, Double.parseDouble(price));
            i++;
        }
        
        for(Book b: books){ // prints each book in the list
            System.out.println(b.toString()+"\n");
        }
        
        System.out.println();
        
        for(i = 0; i < books.length; i++){
            minPos = i; // starts by assuming the minimum position is i
            minValue = books[i];
            for(int j = i; j < books.length; j++){ // j starts at i and goes on until it reaches book length
                if(books[j].compareTo(minValue) < 0){ // if the book at j index is less than the current smallest book title
                    // minPos and minValue are set
                    minPos = j;
                    minValue = books[j];
                }
            }
            books[minPos] = books[i]; // the minimum position is replaced with books i
            books[i] = minValue; // books i is changed to the minimum value
        }
        
        for(Book b: books){ // prints each book in the list
            System.out.println(b.toString()+"\n");
        }
    }
}
