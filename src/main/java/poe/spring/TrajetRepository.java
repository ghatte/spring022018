package poe.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet, Long> {

	public List<Trajet> findByDepartLike(String ville);
}
