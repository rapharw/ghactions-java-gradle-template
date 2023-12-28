package com.rrw.templates.ghactionsjavagradlewebappforcontainers.domain.teams;

public class SecretTeamsIsNotAllowed {

    private SecretTeamsIsNotAllowed(){
        //default constructor
    }
    public static boolean validate(Team team){
        return !team.isSecret();
    }

}
