package bg.startit.spring.project1.historyrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface HistoryRecordRepository extends JpaRepository<HistoryRecord, Long>
{
  List<HistoryRecord> getByUserId(Long userId);

  List<HistoryRecord> getByUserIdAndReturnDate(Long userId, Date returnDate);

  List<HistoryRecord> getByBookId(Long bookId);

  List<HistoryRecord> getByLendingDate(Date lendingDate);

  List<HistoryRecord> getByReturnDate(Date returnDate);
}
