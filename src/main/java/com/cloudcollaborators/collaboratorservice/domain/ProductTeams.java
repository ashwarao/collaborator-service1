package com.cloudcollaborators.collaboratorservice.domain;




import javax.persistence.*;

import java.util.Map;

@Entity
@Table(name = "productteams")
public class ProductTeams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name ="total_teams")
//    private int totalTeams;

    @Column
    @Convert(converter = HashMapConverter.class)
    @SuppressWarnings("JpaAttributeTypeInspection")
    private  Object teamAttributes;

}

//    public ProductTeams(int totalTeams, List<String> teamNames) {
//        this.totalTeams = totalTeams;
//        this.teamNames = teamNames;
//    }
//
//    public List<String> getname(){
//        return teamNames;
//    }
//
//    public void setTeamNames(List<String> teamNames) {
//        this.teamNames = teamNames;
//    }
//    public int getTotalCount(){
//        return totalTeams;
//    }
//    public void setTotalTeams(int totalTeams) {
//        this.totalTeams = totalTeams;
//    }
//}
