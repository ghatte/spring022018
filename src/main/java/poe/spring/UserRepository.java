package poe.spring;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByLogin(String login);

    @Query("select u from User u where u.login = :log")
    void rechercherParLogin(@Param("log") String login);
	

}
