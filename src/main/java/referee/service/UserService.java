package referee.service;


import referee.model.FootballMatches;
import referee.model.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public void saveMatch(FootballMatches fbm,int iduser);
    public void saveMatch(FootballMatches fbm);

    public void deleteMatch(int id);

    void deleteTeam(int id);

    public List<User> findAllUsersByEmail(String email);
    public User findUsersByEmail(String email);
    public List<User> findAllUsersByName(String name);
    public List<User> findAllUsersByLastName(String lastname);
    public List<User> findAllUsersByPhone(Integer phone);

    public void deleteUser(int Id);

    public boolean isUserAlreadyPresent(User user);
}

