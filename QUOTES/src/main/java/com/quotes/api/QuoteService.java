package com.quotes.api;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.QueuedJobCount;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private static String QuoteApi = "https://animechan.vercel.app/api/random";
	private static String tenAnimApi = "https://animechan.vercel.app/api/quotes";

//	@Scheduled(cron = "* 2 * * * *")
	@PostConstruct
	public Quotes randomAnim() throws IOException, InterruptedException {
		Quotes q = new Quotes();
//		List<Quotes> quotes = new ArrayList<>();

		// first make a http call to the url
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(QuoteApi)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(httpResponse.body());

//		StringReader jsonreader = new StringReader(httpResponse.body());

		JSONObject obj = new JSONObject(httpResponse.body());
		System.out.println("wait");
		q.setAnime(obj.getString("anime"));
		q.setCharacter(obj.getString("character"));
		q.setQuote(obj.getString("quote"));

		return q;
	}

	@PostConstruct
	public List<Quotes> tenAnime() throws IOException, InterruptedException {

		List<Quotes> quotes = new ArrayList<>();
		// first make a http call to the url
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(tenAnimApi)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

		JSONArray arr = new JSONArray(httpResponse.body());
		System.out.println("array");
		System.out.println(arr);
		// loop over the array
		System.out.println("array length");
		System.out.println(arr.length());

		System.out.println(
				"================================================================================================\n");
		for (int i = 0; i < arr.length(); i++) {
			Quotes q = new Quotes();
			JSONObject obj = arr.getJSONObject(i);

			System.out.println("==object==");
			System.out.println(obj.toString());
//			
//			q.setAnime(obj.getString("anime"));
//			q.setCharacter(obj.getString("character"));
//			q.setQuote(obj.getString("quote"));
//		
			String anime = obj.getString("anime");
			String charr = obj.getString("character");
			String quote = obj.getString("quote");

			q.setAnime(anime);
			q.setCharacter(charr);
			q.setQuote(quote);

			quotes.add(q);
		}
		System.out.println("list==>" + quotes);
//		System.out.println(quotes);
		return quotes;
	}

}
