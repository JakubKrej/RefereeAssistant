package referee.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "FootballMatches")
public class FootballMatches {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private int match_id;

    @Column(name = "TeamA")
    private String teamA;

    @Column(name = "ScoreTeamA")
    private String scrA;

    @Column(name = "ScoreTeamB")
    private String scrB;

    @Column(name = "TeamB")
    private String teamB;

    @Column(name = "date")
    private Date date;

    @Column(name = "userID")
    private int userID;

    @Column(name = "matchAddress")
    private String matchAddress;

    @Column(name = "info")
    private String info;

    public FootballMatches(int match_id, String teamA, String scrA, String scrB, String teamB, Date date,int userID, String matchAddress, String info) {
        this.match_id = match_id;
        this.teamA = teamA;
        this.scrA = scrA;
        this.scrB = scrB;
        this.teamB = teamB;
        this.date = date;
        this.userID = userID;
        this.matchAddress = matchAddress;
        this.info = info;
    }

    public FootballMatches() {
    }

    public int getId_match() {
        return match_id;
    }

    public void setId_match(int match_id) {
        this.match_id = match_id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getScrA() {
        return scrA;
    }

    public void setScrA(String scrA) {
        this.scrA = scrA;
    }

    public String getScrB() {
        return scrB;
    }

    public void setScrB(String scrB) {
        this.scrB = scrB;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMatchAddress() {
        return matchAddress;
    }

    public void setMatchAddress(String matchAddress) {
        this.matchAddress = matchAddress;
    }
}
