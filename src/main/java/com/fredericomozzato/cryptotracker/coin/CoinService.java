package com.fredericomozzato.cryptotracker.coin;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService {

    private final CoinRepository repo;

    public CoinService(CoinRepository repo) {
        this.repo = repo;
    }

    public List<Coin> getAllCoins() {
        List<Coin> allCoins = new ArrayList<>();
        Iterable<Coin> coinsFromRepo = this.repo.findAll();

        for (Coin c : coinsFromRepo) {
            allCoins.add(c);
        }
        return allCoins;
    }

    public Coin saveCoin(Coin coinToSave) {
        this.repo.save(coinToSave);
        return this.repo.findCoinByTicker(coinToSave.getTicker());
    }
}
