package ee.bcs.java.repositoryjpa;

import liquibase.pro.packaged.T;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepositoryJpa extends JpaRepository<TransactionsEntity, Integer> {
    List<TransactionsEntity> findAllByReceiverOrSender(String receiver, String sender);
    List<TransactionsEntity> findAllByReceiver_Employee_IdOrSender_Employee_Id(Integer id, Integer id2);
}
