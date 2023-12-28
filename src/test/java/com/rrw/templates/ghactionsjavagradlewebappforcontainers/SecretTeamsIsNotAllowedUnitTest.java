package com.rrw.templates.ghactionsjavagradlewebappforcontainers;

import com.rrw.templates.ghactionsjavagradlewebappforcontainers.domain.teams.SecretTeamsIsNotAllowed;
import com.rrw.templates.ghactionsjavagradlewebappforcontainers.domain.teams.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = { SecretTeamsIsNotAllowedUnitTest.class} )
@SpringBootTest
class SecretTeamsIsNotAllowedUnitTest {


    private List<Team> stubTeamsWith_3Secret_2_NotSecret(){
        return List.of(
                Team.builder().id(1).privacy("secret").build(),
                Team.builder().id(2).privacy("secret").build(),
                Team.builder().id(3).privacy("secret").build(),
                Team.builder().id(4).privacy("not-secret").build(),
                Team.builder().id(5).privacy("not-secret").build()
        );
    }

    @Test
    @Description("Should return only valid teams, which is Teams is Not Secret)")
    void shoulReturnTeamsWhichIsNotASecretTeam() {

        // arrange
        List<Team> teams = stubTeamsWith_3Secret_2_NotSecret();
        int teamsSizeExpected = 2; // two "not-secret"

        // act (filter only
        List<Team> teamsFilteredOnlyIsSecret = teams.stream().filter(SecretTeamsIsNotAllowed::validate).collect(Collectors.toList());
        int teamsSizeActual = teamsFilteredOnlyIsSecret.size();

        // assert
        assertEquals(teamsSizeExpected, teamsSizeActual);
    }

    @Test
    @Description("Should return only NOT valid teams, which is Teams is Secret)")
    void shoulReturnTeamsWhichIsSecretTeam() {

        // arrange
        List<Team> teams = stubTeamsWith_3Secret_2_NotSecret();
        int teamsSizeExpected = 3; // three "secret"

        // act (filter only not secret)
        List<Team> teamsFilteredOnlyIsNotSecret = teams.stream().filter(team -> !SecretTeamsIsNotAllowed.validate(team)).collect(Collectors.toList());
        int teamsSizeActual = teamsFilteredOnlyIsNotSecret.size();

        // assert
        assertEquals(teamsSizeExpected, teamsSizeActual);
    }
}