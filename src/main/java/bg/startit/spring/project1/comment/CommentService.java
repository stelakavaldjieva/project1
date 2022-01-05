package bg.startit.spring.project1.comment;

import bg.startit.spring.project1.user.User;

import java.util.List;

public interface CommentService
{

  Comment getById(Long id);

  List<Comment> getByBookId(Long bookId);

  List<Comment> getAll();

  Comment insert(Comment comment);

  void delete(Long id);

  List<Comment> getByUser(User user);
}
