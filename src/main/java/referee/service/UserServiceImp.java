package referee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import referee.model.FootballMatches;
import referee.model.Role;
import referee.model.User;
import referee.repository.FootballMatchesRespository;
import referee.repository.RoleRepository;
import referee.repository.TeamsRepository;
import referee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImp implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FootballMatchesRespository fbrepo;
    @Autowired
    TeamsRepository teamsRepository;




    @Override
    public User findUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsersByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    @Override
    public List<User> findAllUsersByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public List<User> findAllUsersByLastName(String lastname) {
        return userRepository.findAllByLastName(lastname);
    }

    @Override
    public List<User> findAllUsersByPhone(Integer phone) {
        return userRepository.findAllByPhone(phone);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void saveMatch(FootballMatches fbm, int iduser) {
        fbm.setUserID(iduser);
        fbrepo.save(fbm);
    }

    @Override
    public void saveMatch(FootballMatches fbm) {

        fbrepo.save(fbm);
    }

    @Override
    public void deleteMatch(int id){

        fbrepo.deleteById(id);

    }

    @Override
    public void deleteTeam(int id){

        teamsRepository.deleteById(id);

    }

    @Override
    public void deleteUser(int id) {
        try
        {
            // create our mysql database connection
            String myDriver = "org.h2.Driver";
            String myUrl = "jdbc:h2:file:./bazaDanychReferee";
            Class.forName ("org.h2.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:h2:file:./bazaDanychReferee", "sa","");

            Statement st = conn.createStatement();
            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "DELETE FROM auth_user_role WHERE auth_user_id=" + id +"";
            String query1 = "DELETE FROM auth_user WHERE auth_user_id="+ id +"";

            // create the java statement

            // execute the query, and get a java resultset
            st.executeUpdate(query);
            st.executeUpdate(query1);





            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }



    @Override
    public boolean isUserAlreadyPresent(User user) {
        // Try to implement this method, as assignment.
        return false;
    }

}
