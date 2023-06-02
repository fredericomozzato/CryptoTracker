package com.fredericomozzato.cryptotracker.portfolio;

import com.fredericomozzato.cryptotracker.coin.Coin;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "holdings",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "coin_id")
    )
    private List<Coin> coins;

    public Portfolio() {
    }

    public Portfolio(List<Coin> coins) {
        this.coins = coins;
    }

    public long getId() {
        return id;
    }

    public List<Coin> getCoins() {
        return coins;
    }
}
