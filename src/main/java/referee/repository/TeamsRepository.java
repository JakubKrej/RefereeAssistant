package referee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import referee.model.Teams;
import referee.model.User;

import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

    List<Teams> findAll();
    List<Teams> findAllByTeamName(String teamName);
    List<Teams> findAllByTphone(Integer phone);
}
