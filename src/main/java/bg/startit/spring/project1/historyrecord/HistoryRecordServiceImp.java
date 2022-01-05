package bg.startit.spring.project1.historyrecord;

import bg.startit.spring.project1.exceptions.InvalidIdException;
import bg.startit.spring.project1.historyrecord.dto.HistoryRecordRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;

@Service
@EnableTransactionManagement
public class HistoryRecordServiceImp implements HistoryRecordService
{
  private final HistoryRecordRepository historyRecordRepository;

  public HistoryRecordServiceImp(HistoryRecordRepository historyRecordRepository)
  {
    this.historyRecordRepository = historyRecordRepository;
  }

  @Override
  public HistoryRecord getById(Long id)
  {
    return historyRecordRepository.findById(id).get();
  }

  @Override
  public List<HistoryRecord> getByUserId(Long userId)
  {
    return historyRecordRepository.getByUserId(userId);
  }

  @Override
  public List<HistoryRecord> getByBookId(Long bookId)
  {
    return historyRecordRepository.getByBookId(bookId);
  }

  @Override
  public List<HistoryRecord> getByLendingDate(Date lendingDate)
  {
    return historyRecordRepository.getByLendingDate(lendingDate);
  }

  @Override
  public List<HistoryRecord> getByReturnDate(Date returnDate)
  {
    return historyRecordRepository.getByReturnDate(returnDate);
  }

  @Override
  public List<HistoryRecord> getByUserIdAndReturnDate(Long userId, Date returnDate)
  {
    return historyRecordRepository.getByUserIdAndReturnDate(userId, returnDate);
  }

  @Override
  public List<HistoryRecord> getAll()
  {
    return historyRecordRepository.findAll();
  }

  @Override
  public HistoryRecord insert(Long id)
  {
    HistoryRecord historyRecord = getById(id);
    try {
      return historyRecordRepository.save(historyRecord);
    }
    catch (Exception e) {
      throw new InvalidIdException("Invalid history record input");
    }
  }

  @Override
  public HistoryRecord insert(HistoryRecordRequest historyRecordRequest)
  {
    HistoryRecord historyRecord = new HistoryRecord(null,
        historyRecordRequest.getBook(),
        historyRecordRequest.getUser(),
        historyRecordRequest.getDateOfLending(),
        historyRecordRequest.getDateOfReturn());
    try {
      return historyRecordRepository.save(historyRecord);
    }
    catch (Exception e) {
      throw new InvalidIdException("Invalid history record input");
    }
  }

  @Override
  public void delete(Long id)
  {
    if (historyRecordRepository.findById(id).isPresent()) {
      historyRecordRepository.deleteById(id);
      return;
    }
    throw new InvalidIdException("You cannot delete a non existing record!");
  }
}
