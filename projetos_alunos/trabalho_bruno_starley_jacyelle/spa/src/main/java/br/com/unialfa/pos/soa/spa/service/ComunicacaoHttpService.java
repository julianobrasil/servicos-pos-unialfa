package br.com.unialfa.pos.soa.spa.service;

import java.io.IOException;

public interface ComunicacaoHttpService {

	String executeGet(String urlToRead) throws IOException;

}
