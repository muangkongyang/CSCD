package cscd210Classes;

public class Book implements Comparable<Book>
{
   private String [] authors;
   private String isbn;
   private int pages;
   private String title;
   
   public Book(final String title, final String isbn, final int pages, final String [] authors)
   {
      //Preconditions
      if(title == null || title.isEmpty() || isbn == null || isbn.isEmpty() ||
         pages < 1 || authors == null || authors.length < 0)
         throw new IllegalArgumentException("bad Book params");
      
      this.title = title;
      this.isbn = isbn;
      this.pages = pages;
      this.authors = new String[authors.length];
   }
   
   public String getISBN()
   {
      return this.isbn;
   }
   
   @Override
   public String toString()
   {
      String str = "Title: " + this.title;
      String str1 = "\nAuthor(s): ";
      String str2 = "", str3 = "";
      for(int i = 0; i < authors.length; i++)
      {
         if(i < authors.length - 1)
            str2 = this.authors[i] + ", ";
         else
            str3 = this.authors[i];
      }
      String str4 = "\nISBN: " + this.isbn;
      
      return str + str1 + str2 + str3 + str4 + "\n";
   }
   
   @Override
   public boolean equals(final Object obj)
   {
      if(obj == null)
         return false;
      if(this == obj)
         return true;
      if(!(obj instanceof Book))
         return false;
      
      Book another = (Book) obj;
      boolean res = this.authors.equals(another.authors) && this.title.equals(another.title)
                    && this.isbn.equals(another.isbn) && this.pages == another.pages;
                    
      return res;
   }
   
   @Override
   public int hashCode()
   {
      return this.title.hashCode() + this.isbn.hashCode() +
               Integer.valueOf(this.pages).hashCode();
   }
   
   @Override
   public int compareTo(final Book another)
   {
      //Preconditions
      if(another == null)
         throw new IllegalArgumentException("bad compareTo param");
         
      int res = Integer.valueOf(this.title).compareTo(Integer.valueOf(another.title));
      if(res != 0)
         return res;
      res = Integer.valueOf(this.pages).compareTo(Integer.valueOf(another.pages));
      if(res!= 0)
         return res;
      
      return Integer.valueOf(this.isbn).compareTo(Integer.valueOf(another.isbn));   
   }
}