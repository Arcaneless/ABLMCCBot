package com.killing3k.tgbot;

import com.arcaneless.ablmccapi.ABLMCCAPI;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.logging.ConsoleHandler;

public class TGBot {
    protected static final String LOGTAG = "MAIN";
    public static ABLMCCAPI ablmccapi = new ABLMCCAPI();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        BotLogger.registerLogger(new ConsoleHandler());
        TelegramBotsApi tgBotAPI = new TelegramBotsApi();
        BotLogger.info(LOGTAG, "Registering");
        try {
            tgBotAPI.registerBot(new ABLMCCBot());
            BotLogger.info(LOGTAG, "Registered!");
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
            System.exit(1);
        }

    }
}
