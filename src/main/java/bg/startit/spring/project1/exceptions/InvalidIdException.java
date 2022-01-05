package bg.startit.spring.project1.exceptions;

public class InvalidIdException extends RuntimeException
{
  public InvalidIdException()
  {
  }

  public InvalidIdException(String message)
  {
    super(message);
  }

  public InvalidIdException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public InvalidIdException(Throwable cause)
  {
    super(cause);
  }

  public InvalidIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
