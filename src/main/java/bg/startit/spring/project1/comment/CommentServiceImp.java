package bg.startit.spring.project1.comment;

import bg.startit.spring.project1.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class CommentServiceImp implements CommentService
{
  private final CommentRepository commentRepository;


  public CommentServiceImp(CommentRepository commentRepository)
  {
    this.commentRepository = commentRepository;
  }

  @Override
  @Transactional
  public Comment getById(Long id)
  {
    return commentRepository.findById(id).get();
  }

  @Override
  public List<Comment> getByBookId(Long bookId)
  {
    return commentRepository.findByBookId(bookId);
  }

  @Override
  public List<Comment> getAll()
  {
    return commentRepository.findAll();
  }


  @Override
  @Transactional
  public Comment insert(Comment comment)
  {
    return commentRepository.save(comment);
  }

  @Override
  @Transactional
  public void delete(Long id)
  {
    if (commentRepository.findById(id) != null) {
      commentRepository.deleteById(id);
    }
  }

  @Override
  public List<Comment> getByUser(User user)
  {
    return commentRepository.findByUser(user);
  }
}
