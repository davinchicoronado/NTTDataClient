package com.nttdata.client.rest.NTTDataClients;

import com.nttdata.client.rest.NTTDataClients.data.Client;
import com.nttdata.client.rest.NTTDataClients.data.TypeDocument;
import com.nttdata.client.rest.NTTDataClients.dto.ClientDto;
import com.nttdata.client.rest.NTTDataClients.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.mockito.Mockito.when;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class NttDataClientsApplicationTests {

	@LocalServerPort
	private int port;

	@MockBean
	private  ClientService clientService;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getClient() throws Exception{

		Client client = new Client(
				"23445322",
				"Andres",
				"Miguel",
				"Gonzalez",
				"Fuquene",
				"7777777",
				"Calle 85b 90-25",
				"Bogotá",
				TypeDocument.C);

		ClientDto clientDto = new ClientDto("Andres",
				"Miguel",
				"Gonzalez",
				"Fuquene",
				"7777777",
				"Calle 85b 90-25",
				"Bogotá");


		when(clientService.find("23445322","C")).thenReturn(client);
		ClientDto clientDtoService =  this.restTemplate.getForObject("http://localhost:" + port + "/v1/client/id/23445322/type-document/C",ClientDto.class);

		Assertions.assertTrue(clientDtoService.equals(clientDto));

	}

}
