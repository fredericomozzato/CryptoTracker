package com.fredericomozzato.cryptotracker.config;

import com.fredericomozzato.cryptotracker.coin.Coin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Configuration
public class Configs {

    @Bean
    public List<Coin> coinList() {
        return new CopyOnWriteArrayList<>();
    }
}
