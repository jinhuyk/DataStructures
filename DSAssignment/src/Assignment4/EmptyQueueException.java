package Assignment4;

@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException
{
   public EmptyQueueException()
   {
      this( "Queue is empty" );
   }

   public EmptyQueueException(String exception )
   {
      super( exception );
   } 
} 