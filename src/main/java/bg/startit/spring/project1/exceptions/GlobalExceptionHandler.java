package bg.startit.spring.project1.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
  @ExceptionHandler(InvalidIdException.class)
  public ResponseEntity<String> handleInvalidIdException(InvalidIdException e)
  {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGenericExceptions(Exception e)
  {
    Map<String, Object> exceptionBody = new HashMap<>();
    exceptionBody.put("timestamp: ", LocalDateTime.now());
    exceptionBody.put("message: ", e.getMessage());
    return new ResponseEntity<>(exceptionBody, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
  {
    Map<String, String> validationErrors = new HashMap<>();
    List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
    for (ObjectError objectError : objectErrors) {
      validationErrors.put(((FieldError) objectError).getField(), objectError.getDefaultMessage());
    }
    return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
  }
}
