package br.com.unialfa.pos.soa.spa.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import br.com.unialfa.pos.soa.spa.service.ComunicacaoHttpService;

@Service
public class ComunicacaoHttpServiceImpl implements ComunicacaoHttpService {

	@Override
	public String executeGet(String urlToRead) throws IOException {
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		StringBuilder result = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();

		return result.toString();
	}

}
