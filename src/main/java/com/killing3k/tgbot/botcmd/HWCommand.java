package com.killing3k.tgbot.botcmd;

import com.killing3k.tgbot.LoggerHelper;
import com.killing3k.tgbot.TGBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Arrays;

public class HWCommand extends BotCommand {

    public HWCommand() {
        super("hw", "Get Homework");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        LoggerHelper.logCommand("/hw", strings, user);
        if(strings.length == 1) {
            TGBot.ablmccapi.getAssignment(c -> {
                SendMessage sm = new SendMessage();
                sm.setChatId(chat.getId()).setText(c.toString());
                try {
                    absSender.sendMessage(sm);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }, strings[0]);
        }
    }
}
