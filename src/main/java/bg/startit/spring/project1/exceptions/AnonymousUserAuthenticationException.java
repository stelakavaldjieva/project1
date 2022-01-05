package bg.startit.spring.project1.exceptions;

import org.springframework.security.core.AuthenticationException;

public class AnonymousUserAuthenticationException extends AuthenticationException
{

  public AnonymousUserAuthenticationException(String msg)
  {
    super(msg);
  }
}
