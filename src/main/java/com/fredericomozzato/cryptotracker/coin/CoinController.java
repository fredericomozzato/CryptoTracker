package com.fredericomozzato.cryptotracker.coin;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coin")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping()
    public List<Coin> getCoins() {
        return this.coinService.getAllCoins();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Coin addCoin(@RequestBody Coin newCoin) {
        return this.coinService.saveCoin(newCoin);
    }


}
