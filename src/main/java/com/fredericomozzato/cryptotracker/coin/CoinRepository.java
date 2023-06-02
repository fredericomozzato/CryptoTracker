package com.fredericomozzato.cryptotracker.coin;

import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long> {

    public Coin findCoinByTicker(String ticker);
}
