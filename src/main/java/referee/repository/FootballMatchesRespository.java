package referee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import referee.model.FootballMatches;

import java.util.List;
import java.util.Optional;


@Repository
public interface FootballMatchesRespository extends JpaRepository<FootballMatches, Integer> {

    List<FootballMatches> findAll();

    List<FootballMatches> findAllByuserID(int usid);

}
