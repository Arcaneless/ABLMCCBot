package com.killing3k.tgbot;

import com.killing3k.tgbot.botcmd.HWCommand;
import com.killing3k.tgbot.botcmd.NewsCommand;
import com.killing3k.tgbot.botcmd.NoticeCommand;
import com.killing3k.tgbot.botcmd.StartCommand;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class ABLMCCBot extends TelegramLongPollingCommandBot {

    public ABLMCCBot() {
        register(new NewsCommand());
        register(new NoticeCommand());
        register(new HWCommand());
        register(new StartCommand());

        registerDefaultAction((absSender, message) -> {
            SendMessage commandUnknownMessage = new SendMessage();
            commandUnknownMessage.setChatId(message.getChatId());
            commandUnknownMessage.setText("The command '" + message.getText() + "' is not known by this bot. Here comes some help!");
            try {
                absSender.sendMessage(commandUnknownMessage);
            } catch (TelegramApiException e) {
                BotLogger.error(TGBot.LOGTAG, e);
            }
        });
    }


    public String getBotToken() {
        return "340378693:AAGuH5Uk-uXme6J6oTIFzWQJ89TckxK_tlY";
    }



    public void processNonCommandUpdate(Update update) {
        if(update.hasMessage()) {
            SendMessage sm = new SendMessage();
            sm.setChatId(update.getMessage().getChatId()).setText("/news\n/notice\n/hw");
            try {
                sendMessage(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "ABLMCCBot";
    }

}
