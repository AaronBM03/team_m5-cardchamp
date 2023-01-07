package es.teamM5.cardchamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import es.teamM5.cardchamp.dao.CardDao;
import es.teamM5.cardchamp.dao.ClubDao;
import es.teamM5.cardchamp.dao.NationDao;
import es.teamM5.cardchamp.model.Card;
import es.teamM5.cardchamp.model.Club;
import es.teamM5.cardchamp.model.Nation;
import es.teamM5.cardchamp.responses.ClubListResponse;
import es.teamM5.cardchamp.responses.NationListResponse;
import es.teamM5.cardchamp.responses.Pagination;
import es.teamM5.cardchamp.responses.PlayerListResponse;

@SpringBootApplication
public class Ripper {
	
	private static final String MIGUEL_KEY = "c5f84fd0-9b5a-4049-839a-a1164be99234";
	private static final String AARON_KEY = "ff7755ea-fb3e-41a3-9c84-d9b7779ebfce";

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Ripper.class);
		application.run(args);
//		SpringApplication.run(ConsumingRestDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			
			HttpHeaders myHeaders = new HttpHeaders();
			myHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			myHeaders.set("X-AUTH-TOKEN", AARON_KEY);
			HttpEntity<Object> entity = new HttpEntity<>(myHeaders);
			
			// ------------------------------------ NATIONS -------------------------------------
//			Map<Integer, Nation> myNationMap = getNationsFromAPIToSQLiteDatabase(restTemplate, entity);

			
			// ------------------------------------ CLUBS -------------------------------------
//			Map<Integer, Club> myClubsMap = getClubsFromAPIToSQLiteDatabase(restTemplate, entity);

			
			// ------------------------------------ CARDS - PLAYERS ------------------------------
//			getPlayersFromAPIToSQLiteDatabase(restTemplate, entity, myNationMap, myClubsMap);
			
			CardDao cDao = new CardDao();
			
			System.out.println(cDao.getCardById(16917));

		};
	}

	private Map<Integer, Club> getClubsFromAPIToSQLiteDatabase(RestTemplate restTemplate, HttpEntity<Object> entity)
	{
		String urlClubsList = "https://futdb.app/api/clubs";
		
		List<Club> myClubs = new ArrayList<>();
		Map<Integer, Club> myClubsMap = new HashMap<>();
		ClubDao clDao = new ClubDao();
		
		
		ResponseEntity<ClubListResponse> firstPage = restTemplate.exchange(urlClubsList, HttpMethod.GET, entity,
				ClubListResponse.class);
		
		Pagination pagination = firstPage.getBody().getPagination();
		myClubs.addAll(firstPage.getBody().getItems());
		
		for (int i = 2; i < pagination.getPageTotal(); i++) {
			ResponseEntity<ClubListResponse> myResponseListClubs = restTemplate.exchange(urlClubsList + "?page=" + i, HttpMethod.GET, entity,
					ClubListResponse.class);
			myClubs.addAll(myResponseListClubs.getBody().getItems());
		}
		
		System.out.println("Club list: \n" + myClubs.size());
		
		for (Club club : myClubs) {
			myClubsMap.put(club.getId(), club);
			clDao.save(club);
		}
		
		System.err.println("Clubs Saved");
		
		return myClubsMap;
	}

	private Map<Integer, Nation> getNationsFromAPIToSQLiteDatabase(RestTemplate restTemplate, HttpEntity<Object> entity)
	{
		String urlNationList = "https://futdb.app/api/nations";
		
		List<Nation> myNations = new ArrayList<>();
		Map<Integer, Nation> myNationsMap = new HashMap<>();
		NationDao nDao = new NationDao();
		
		
		
		ResponseEntity<NationListResponse> firstPage = restTemplate.exchange(urlNationList, HttpMethod.GET, entity,
				NationListResponse.class);
		
		Pagination pagination = firstPage.getBody().getPagination();
		myNations.addAll(firstPage.getBody().getItems());
		
		for (int i = 2; i < pagination.getPageTotal(); i++) {
			ResponseEntity<NationListResponse> myResponseListNations = restTemplate.exchange(urlNationList + "?page=" + i,
					HttpMethod.GET, entity, NationListResponse.class);
			myNations.addAll(myResponseListNations.getBody().getItems());
		}
		
		System.out.println("Nation list: \n" + myNations.size());
		
		for (Nation nation : myNations) {
			myNationsMap.put(nation.getId(), nation);
			nDao.save(nation);
		}
		
		System.err.println("Nations saved");
		
		return myNationsMap;
	}

	private void getPlayersFromAPIToSQLiteDatabase(RestTemplate restTemplate, HttpEntity<Object> entity, Map<Integer, Nation> nationMap, Map<Integer, Club> clubMap)
	{
		String urlPlayerList = "https://futdb.app/api/players";
		
		List<Card> myCards = new ArrayList<>();
		CardDao cDao = new CardDao();
		
		ResponseEntity<PlayerListResponse> firstPage = restTemplate.exchange(urlPlayerList, HttpMethod.GET, entity,
				PlayerListResponse.class);
		
		Pagination pagination = firstPage.getBody().getPagination();
		myCards.addAll(firstPage.getBody().getItems());
		
		for (int i = 2; i < pagination.getPageTotal(); i++) {
			ResponseEntity<PlayerListResponse> myResponseListCards = restTemplate.exchange(urlPlayerList + "?page=" + i,
					HttpMethod.GET, entity, PlayerListResponse.class);
			myCards.addAll(myResponseListCards.getBody().getItems());
		}
		System.out.println("Card list: \n" + myCards.size());
		
		for (Card card : myCards) {
			card.setClub(clubMap.get(card.getClubId()));
			card.setNation(nationMap.get(card.getNationId()));
			cDao.save(card);
		}
		
		System.err.println("Cards Saved");
	}
}
