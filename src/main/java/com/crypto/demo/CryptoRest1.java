package com.crypto.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@JsonIgnoreProperties
public class CryptoRest1 {

        private static final Logger log = (Logger) LoggerFactory.getLogger(CryptoRest1.class);

        @Scheduled(fixedRate = 5000)
        public void rePrint() {
            RestTemplate restTemplate = new RestTemplate();
            Ticker updated = restTemplate.getForObject("https://api.cryptonator.com/api/ticker/btc-usd", Ticker.class);
            assert updated != null;
            log.info(updated.toString());
        }
}

