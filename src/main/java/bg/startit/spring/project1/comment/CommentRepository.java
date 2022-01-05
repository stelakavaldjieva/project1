package bg.startit.spring.project1.comment;

import bg.startit.spring.project1.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long>
{
  List<Comment> findByUser(User user);

  List<Comment> findByBookId(Long bookId);
}

