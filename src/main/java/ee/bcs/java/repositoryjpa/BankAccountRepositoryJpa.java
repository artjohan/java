package ee.bcs.java.repositoryjpa;

import ee.bcs.java.controller.BankAccountDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepositoryJpa extends JpaRepository<BankAccountEntity, Integer> {
    BankAccountEntity findByAccNr(String accNr);
    List<BankAccountEntity> findAllByAccNr(String accNr);
    Long deleteAllByAccNr(String accNr);
}
