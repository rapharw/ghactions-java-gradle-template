package com.rrw.templates.ghactionsjavagradlewebappforcontainers;

import com.rrw.templates.ghactionsjavagradlewebappforcontainers.domain.teams.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = { TeamIsSecretUnitTest.class} )
@SpringBootTest
public class TeamIsSecretUnitTest {


    @Test
    @Description("Should return true when team isSecret 'privacy' is 'secret'")
    void shoulReturnTrueWhenTeamIsSecret() {

        // arrange
        Team secretTeam = Team.builder().id(1).privacy("secret").build();

        // act
        boolean isSecretTeamActual = secretTeam.isSecret();

        // assert
        assertTrue(isSecretTeamActual);
    }

    @Test
    @Description("Should return false when team isSecret different of 'secret'")
    void shoulReturnTrueWhenTeamIsNotSecret() {

        // arrange
        Team secretTeam = Team.builder().id(1).privacy("not-secret").build();

        // act
        boolean isSecretTeamActual = secretTeam.isSecret();

        // assert
        assertFalse(isSecretTeamActual);
    }

}
