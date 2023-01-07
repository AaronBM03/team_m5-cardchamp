//package es.teamM5.ConsumingRESTDemo;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import es.teamM5.ConsumingRESTDemo.dao.NationDao;
//import es.teamM5.ConsumingRESTDemo.model.Card;
//import es.teamM5.ConsumingRESTDemo.model.Club;
//import es.teamM5.ConsumingRESTDemo.model.Nation;
//import es.teamM5.ConsumingRESTDemo.responses.ClubListResponse;
//import es.teamM5.ConsumingRESTDemo.responses.NationListResponse;
//import es.teamM5.ConsumingRESTDemo.responses.PlayerListResponse;
//
//@SpringBootApplication
//public class ConsumingRestDemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(ConsumingRestDemoApplication.class);
//		application.run(args);
////		SpringApplication.run(ConsumingRestDemoApplication.class, args);
//	}
//
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//
//			String urlPlayer = "https://futdb.app/api/players/16917";
//			String urlPlayerList = "https://futdb.app/api/players";
//			int playerPages = 855;
//			String urlNationList = "https://futdb.app/api/nations?page=2";
//			int nationPages = 156;
//			String urlClubsList = "https://futdb.app/api/clubs?page=1";
//			int clubPages = 8;
//			HttpHeaders myHeaders = new HttpHeaders();
//			myHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//			myHeaders.set("X-AUTH-TOKEN", "c5f84fd0-9b5a-4049-839a-a1164be99234");
//
//			HttpEntity entity = new HttpEntity<>(myHeaders);
//
////			ResponseEntity<Player> myResponseCard = restTemplate.exchange(urlPlayer, HttpMethod.GET, entity,
////					Player.class);
////			System.out.println("Raw Exchange: \n" + myResponseCard.getBody().getPlayer());
//
//			// Manual deserialization
//			ObjectMapper objMap = new ObjectMapper();
//
////			ResponseEntity<String> myResponseString = restTemplate.exchange(urlPlayer, HttpMethod.GET, entity, String.class);
////			Player myCard = objMap.readValue(myResponseString.getBody(), Player.class);
////			System.out.println("Response Body: " + myResponseString.getBody());
////			System.out.println("Object Mapper: " + myCard.getPlayer());
//
//			List<Card> myCards = new ArrayList<>();
//
//			ResponseEntity<PlayerListResponse> myResponseList = restTemplate.exchange(urlPlayerList, HttpMethod.GET, entity,
//					PlayerListResponse.class);
//			myCards.addAll(myResponseList.getBody().getItems());
//
////			for (int i = 1; i < 10; i++) {
////				ResponseEntity<String> myResponseList = restTemplate.exchange(urlPlayerList + "?page=" + i, HttpMethod.GET, entity,
////						String.class);
////				String[] stringArray = myResponseList.getBody().split(",\"items\":");
////				String response = stringArray[stringArray.length-1].replaceAll("\\}$", "");
////				myCards.addAll(objMap.readValue(response, new TypeReference<List<Card>>() {}));
////			}
//			System.out.println("List: \n" + myCards.size());
//
//			Map<Integer, Card> myCardMap = new HashMap<>();
//
//			for (Card card : myCards) {
////				if (card.isSupported())
//				myCardMap.put(card.getId(), card);
//			}
//
//			int peleMax = 14112;
//			int peleLower = 14115;
//
//			System.out.println(myCardMap.get(peleMax));
//			System.out.println(myCardMap.get(peleLower));
//
//			// ------------------------------------ NATIONS
//			// -------------------------------------
//			List<Nation> myNations = new ArrayList<>();
//			
//			for (int i = 0; i < nationPages; i++) {
//				ResponseEntity<NationListResponse> myResponseListNations = restTemplate.exchange(urlNationList,
//					HttpMethod.GET, entity, NationListResponse.class);
//				myNations.addAll(myResponseListNations.getBody().getItems());
//			}
//			
//			NationDao nDao = new NationDao();
//			for (Nation nation : myNations) {
//				nDao.save(nation);
//			}
//			
//			System.out.println("Nation list: \n" + myCards.size());
//
////			Map<Integer, Nation> myNationsMap = new HashMap<>();
////			for (Nation nation : myNations) {
////				myNationsMap.put(nation.getId(), nation);
////			}
////
////			System.out.println(myNationsMap.get(21).getName());
//
//			// ------------------------------------ CLUBS
//			// -------------------------------------
//			List<Club> myClubs = new ArrayList<>();
//			ResponseEntity<ClubListResponse> myResponseListClubs = restTemplate.exchange(urlClubsList, HttpMethod.GET,
//					entity, ClubListResponse.class);
//			myClubs.addAll(myResponseListClubs.getBody().getItems());
//
//			System.out.println("Club list: \n" + myClubs.size());
//
////			Map<Integer, Club> myClubsMap = new HashMap<>();
////			for (Club club : myClubs) {
////				myClubsMap.put(club.getId(), club);
////			}
////
////			System.out.println(myClubsMap.get(2).getName());
//
//		};
//	}
//
//}
