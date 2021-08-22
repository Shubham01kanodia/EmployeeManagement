package com.gyandeep.ElasticSpringData;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
//@EnableElasticsearchRepositories(basePackages = "com.gyandeep.ElasticSpringData.repository")
public class EsConfig extends AbstractElasticsearchConfiguration{

	@Value("${spring.data.elasticsearch.cluster-nodes}")
    private String nodes;
	@Value("${spring.elasticsearch.rest.connection-timeout}")
    private long connectionTimeout;
	@Value("${spring.elasticsearch.rest.read-timeout}")
    private long readTimeout;

    /*@Value("${spring.data.elasticsearch.cluster-name}")
    private String EsClusterName;
    
	@Override
	public RestHighLevelClient elasticsearchClient() {
		System.out.println(nodes+" "+EsClusterName);
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()  
	            .connectedTo(nodes)
	            .build();

	        return RestClients.create(clientConfiguration).rest();
	}*/
	
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
      final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
          .connectedTo(nodes)
          .withConnectTimeout(connectionTimeout)
          .withSocketTimeout(readTimeout)
          .build();

      return RestClients.create(clientConfiguration).rest();
    }

}
