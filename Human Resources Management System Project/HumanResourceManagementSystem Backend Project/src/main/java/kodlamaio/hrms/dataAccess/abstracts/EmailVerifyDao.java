package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmailVerify;

public interface EmailVerifyDao extends JpaRepository<EmailVerify, Integer> {

	Optional<EmailVerify> findByUserId(Integer userId);

}
