package com.yanesh.loterie.nationale.extractor.services;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yanesh.loterie.nationale.extractor.bean.LotoTicket;

@RestController
public class ExtractService {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Value("${tirageUrl}")
	private String rootUrl;
	
	@Value("${tirageUrl.parameter.date}")
	private String urlParameter;
	
	
	@GetMapping("/getTirage")
	public LotoTicket getTirage(@RequestParam("date") String date) {
		try {
								
			Document doc = Jsoup.connect(getURL(date).toString())
			.userAgent("Mozilla")
			.get();
			
			return getResult(doc);
			
		} catch (MalformedURLException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}



	/**
	 * @param doc
	 * @return
	 */
	private LotoTicket getResult(Document doc) {
		String[] resultats = doc.getElementById("num-gagnants").text().replaceAll("\\s", "").split(",");
		return new LotoTicket(resultats[0], resultats[1], resultats[2], resultats[3], resultats[4], resultats[5]);
	}



	/**
	 * @param date
	 * @return
	 */
	private StringBuilder getURL(String date) {
		StringBuilder apiEndpoint = new StringBuilder(rootUrl);
		apiEndpoint.append("?");
		apiEndpoint.append(urlParameter);
		apiEndpoint.append("=");
		apiEndpoint.append(date);
		return apiEndpoint;
	}

}
