package vn.unigap.api.repository.jpa.Employer;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.api.entity.jpa.Employer;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Optional<Employer> findByEmail(String email);
    Page<Employer> findAll(Pageable page);
}



