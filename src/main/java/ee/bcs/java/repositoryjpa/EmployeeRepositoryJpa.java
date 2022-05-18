package ee.bcs.java.repositoryjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepositoryJpa extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findAllByFirstNameContainingIgnoreCase(String name);
}
