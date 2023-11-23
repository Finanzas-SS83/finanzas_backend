package demo.finanzas_backend.repository;

import demo.finanzas_backend.entities.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IusersRepository  extends JpaRepository<users, Long>{


    users findByEmail(String email);
}
