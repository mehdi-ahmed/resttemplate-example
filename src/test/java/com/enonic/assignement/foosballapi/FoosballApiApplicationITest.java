package com.enonic.assignement.foosballapi;

import com.enonic.assignement.foosballapi.bean.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class FoosballApiApplicationITest {

    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private HttpEntity entity;

    private static final String ENDPOINT_URL = "https://officeleague.rocks/app/api/graphql";
    private static final String REQUEST_BODY_JSON = "{ \"query\": \"{league(name:\\\"Enonic Foos\\\") {id name leaguePlayers { id rating ranking player { id name nationality stats { gameCount winningGameCount goalCount } } } leagueTeams { id rating ranking team { id name stats { gameCount winningGameCount goalCount } } } } }\"}";


    @Before
    public void beforeTest() {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity(REQUEST_BODY_JSON, headers);
    }

    @Test
    public void retrieveDataInJsonFormatFromEndpointITest() {

        HttpEntity entity = new HttpEntity(REQUEST_BODY_JSON, headers);
        ResponseEntity<String> response = restTemplate.exchange(ENDPOINT_URL, HttpMethod.POST, entity, String.class);
        Assert.assertNotNull(response);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void retrieveDataObjectFromEndpointITest() {
        DataResponse leagueResponse = restTemplate.postForObject(ENDPOINT_URL, entity, DataResponse.class);
        Assert.assertNotNull(leagueResponse);
        Assert.assertNotNull(leagueResponse.getData().getLeague());
    }

    @Test
    public void assertSomeRandomFieldsFromJsonDataAgainstRetrievedObjectITest() {
        DataResponse leagueResponse = restTemplate.postForObject(ENDPOINT_URL, entity, DataResponse.class);

        assert leagueResponse != null;
        League retrievedLeague = leagueResponse.getData().getLeague();

        assertThat(retrievedLeague.getId(), equalTo("379ec58c-6bbd-4e80-9d9d-5feb8be2823f"));
        assertThat(retrievedLeague.getName(), equalTo("Enonic Foos"));
        assertThat(retrievedLeague.getLeaguePlayers().size(), equalTo(10));
        assertThat(retrievedLeague.getLeagueTeams().size(), equalTo(10));

        LeagueTeams retrievedLeagueTeamsIndex9 = retrievedLeague.getLeagueTeams().get(9);
        Team retrievedTeamIndex9 = retrievedLeague.getLeagueTeams().get(9).getTeam();

        assertThat(retrievedTeamIndex9.getName(), equalTo("Les carottes sont cuites"));
        assertThat(retrievedLeagueTeamsIndex9.getRating(), equalTo(1648L));

        Stats  retrievedStatsIndex5 = retrievedLeague.getLeagueTeams().get(4).getTeam().getStats();
        assertThat(retrievedStatsIndex5.getGameCount(), equalTo(43L));
        assertThat(retrievedStatsIndex5.getWinningGameCount(), equalTo(35L));
        assertThat(retrievedStatsIndex5.getGoalCount(), equalTo(416L));

    }

}


