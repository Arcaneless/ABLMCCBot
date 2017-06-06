package com.killing3k.tgbot.botcmd;

import com.killing3k.tgbot.LoggerHelper;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class StartCommand extends BotCommand {

    public StartCommand() {
        super("start", "Start");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        LoggerHelper.logCommand("/start", strings, user);
        SendMessage sm = new SendMessage();
        sm.setChatId(chat.getId()).setText("Started ABLMCC Bot!\nListed commands:\n/news\n/notice\n/hw");
        try {
            absSender.sendMessage(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
