package com.killing3k.tgbot.botcmd;

import com.killing3k.tgbot.LoggerHelper;
import com.killing3k.tgbot.TGBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class NoticeCommand extends BotCommand {

    public NoticeCommand() {
        super("notice", "Get Notice");
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        LoggerHelper.logCommand("/notice", strings, user);
        if(strings.length > 0) {
            int year = Integer.valueOf(strings[0]);
            String query = "";
            if (strings.length > 1) query = strings[1];
            TGBot.ablmccapi.getNotice(c -> {
                SendMessage sm = new SendMessage();
                sm.setChatId(chat.getId()).setText(c.toString());
                try {
                    absSender.sendMessage(sm);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }, year, query);
        }
    }
}
