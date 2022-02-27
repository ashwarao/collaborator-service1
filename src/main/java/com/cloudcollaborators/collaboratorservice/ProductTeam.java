package com.cloudcollaborators.collaboratorservice;

import java.util.List;

public class ProductTeam {

    private int totalTeams;
    private List<String> teamNames;

    public ProductTeam()
    {

    }
    public ProductTeam(int totalTeams, List<String> teamNames) {
        this.totalTeams = totalTeams;
        this.teamNames = teamNames;
    }

    public List<String> getname(){
        return teamNames;
    }

    public void setTeamNames(List<String> teamNames) {
        this.teamNames = teamNames;
    }
    public int getTotalCount(){
        return totalTeams;
    }
    public void setTotalTeams(int totalTeams) {
        this.totalTeams = totalTeams;
    }

}
