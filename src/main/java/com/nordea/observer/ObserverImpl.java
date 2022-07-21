package com.nordea.observer;

import com.nordea.sink.Sink;
import com.nordea.util.CryptoUtil;

public class ObserverImpl implements Observer{

    private byte[] salt;

    private Sink sink;

    public ObserverImpl(Sink sink) {
        this.sink = sink;
    }

    @Override
    public void onSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public void onMessage(long id, byte[] message) {

        byte[] hash = message;
        for (int i = 0; i < 5000; i++) {
            hash = CryptoUtil.computeHash(hash, salt);
        }

        sink.publishHash(id, message, salt, hash);
    }
}