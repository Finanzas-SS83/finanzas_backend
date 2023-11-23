package demo.finanzas_backend.repository;
import demo.finanzas_backend.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItablesRepository extends JpaRepository<Tables, Long>{

}
