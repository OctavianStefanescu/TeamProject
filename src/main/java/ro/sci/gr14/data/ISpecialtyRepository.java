package ro.sci.gr14.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sci.gr14.model.Specialty;

@Repository
public interface ISpecialtyRepository extends CrudRepository<Specialty, Long> {
}
