package referee.model;

import javax.persistence.*;


@Entity
@Table(name = "Teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private int id_team;

    @Column(name = "TeamName")
    private String teamName;

    @Column(name = "TeamAddress")
    private String teamAddress;

    @Column(name = "TeamPhone")
    private int tphone;

    @Column(name = "TeamEmail")
    private String temail;

    public Teams() {

    }

    public Teams(int id_team, String teamName, String teamAddress, int tphone, String temail) {
        this.id_team = id_team;
        this.teamName = teamName;
        this.teamAddress = teamAddress;
        this.tphone = tphone;
        this.temail = temail;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
    }

    public int getTphone() {
        return tphone;
    }

    public void setTphone(int tphone) {
        this.tphone = tphone;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }
}