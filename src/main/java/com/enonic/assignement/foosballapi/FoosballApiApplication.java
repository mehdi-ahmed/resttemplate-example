package com.enonic.assignement.foosballapi;

import com.enonic.assignement.foosballapi.bean.DataResponse;
import com.enonic.assignement.foosballapi.bean.League;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoosballApiApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoosballApiApplication.class);

    private static final String ENDPOINT_URL = "https://officeleague.rocks/app/api/graphql";
    private static final String REQUEST_BODY_JSON = "{ \"query\": \"{league(name:\\\"Enonic Foos\\\") {id name leaguePlayers { id rating ranking player { id name nationality stats { gameCount winningGameCount goalCount } } } leagueTeams { id rating ranking team { id name stats { gameCount winningGameCount goalCount } } } } }\"}";


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FoosballApiApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(REQUEST_BODY_JSON, headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        DataResponse response = restTemplate.postForObject(ENDPOINT_URL, entity, DataResponse.class);
        League league = response != null ? response.getData().getLeague() : null;

        return args -> {
            if (league == null) {
                throw new RuntimeException("Empty response !");
            }
            
            LOGGER.info(league.toString());
        };

    }
}
