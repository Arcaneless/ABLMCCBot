package com.killing3k.tgbot.botcmd;

import com.killing3k.tgbot.LoggerHelper;
import com.killing3k.tgbot.TGBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class NewsCommand extends BotCommand {

    public NewsCommand() {
        super("news", "Get News");
    }

    public void execute(final AbsSender absSender, User user, Chat chat, String[] strings) {
        LoggerHelper.logCommand("/news", strings, user);
        TGBot.ablmccapi.getGeneralInfo(c -> {
            SendMessage sm = new SendMessage();
            sm.setChatId(chat.getId()).setText(c.toString());
            try {
                absSender.sendMessage(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }
}
