package referee.repository;

import referee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    public User findByEmail(String email);
    public List<User> findAllByEmail(String email);
    public List<User> findAllByName(String name);
    public List<User> findAllByLastName(String lastname);
    public List<User> findAllByPhone(Integer phone);


    List<User> findAll();

}
