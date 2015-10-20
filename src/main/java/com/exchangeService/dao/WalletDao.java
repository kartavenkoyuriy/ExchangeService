package com.exchangeService.dao;

import com.exchangeService.Wallet;

import java.util.List;

public interface WalletDao {
    Wallet create();

    Wallet read(int id);

    void update(Wallet wallet);

    void delete(Wallet wallet);

    List<Wallet> getAllWallets();//throws?
}
