package com.killing3k.tgbot;

import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.logging.BotLogger;

public class LoggerHelper {

    public static void logCommand(String cmd, String[] args, User user) {
        BotLogger.info("CMD", "Received command: " + cmd + " " + String.join(" ", args) + " from " + user.getUserName());
    }
}
