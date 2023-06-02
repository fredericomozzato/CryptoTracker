package com.fredericomozzato.cryptotracker.coin;

import com.fredericomozzato.cryptotracker.portfolio.Portfolio;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "rate")
    private BigDecimal usdRate;
    @ManyToMany(mappedBy = "coins")
    private List<Portfolio> portfolios;

    public Coin() {
    }

    public Coin(long id, String name, String ticker, BigDecimal amount, BigDecimal usdRate) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
        this.amount = amount;
        this.usdRate = usdRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(BigDecimal usdRate) {
        this.usdRate = usdRate;
    }

    @Override
    public String toString() {
        return String.format("Coin{'%s'=amount: %f, usd_rate: %f}", this.ticker, this.amount, this.usdRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return id == coin.id && Objects.equals(name, coin.name) && Objects.equals(ticker, coin.ticker) && Objects.equals(amount, coin.amount) && Objects.equals(usdRate, coin.usdRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ticker, amount, usdRate);
    }
}
