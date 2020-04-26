package referee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import referee.model.Teams;
import referee.model.User;
import referee.repository.TeamsRepository;

import java.util.List;


@Service
public class TeamsServiceImp implements TeamService{


    @Autowired
    TeamsRepository teamsRepository;


    @Override
    public List<Teams> findAllTeamsByTeamName(String teamName) {
        return teamsRepository.findAllByTeamName(teamName);
    }

    @Override
    public List<Teams> findAllTeamsByTphone(Integer phone) {
        return teamsRepository.findAllByTphone(phone);
    }


}
