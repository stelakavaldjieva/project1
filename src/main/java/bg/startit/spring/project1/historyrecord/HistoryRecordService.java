package bg.startit.spring.project1.historyrecord;

import bg.startit.spring.project1.historyrecord.dto.HistoryRecordRequest;
import java.util.Date;
import java.util.List;

public interface HistoryRecordService
{
  HistoryRecord getById(Long id);

  List<HistoryRecord> getByUserId(Long userId);

  List<HistoryRecord> getAll();

  HistoryRecord insert(Long id);

  HistoryRecord insert(HistoryRecordRequest historyRecordRequest);

  void delete(Long id);

  List<HistoryRecord> getByBookId(Long bookId);

  List<HistoryRecord> getByLendingDate(Date lendingDate);

  List<HistoryRecord> getByReturnDate(Date returnDate);

  List<HistoryRecord> getByUserIdAndReturnDate(Long userId, Date returnDate);

}
