package referee.service;



import referee.model.Teams;

import java.util.List;

public interface TeamService {

    List<Teams> findAllTeamsByTeamName(String teamName);
    List<Teams> findAllTeamsByTphone(Integer name);
}
