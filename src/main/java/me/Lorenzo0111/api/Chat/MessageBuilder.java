package me.Lorenzo0111.api.Chat;

import org.bukkit.ChatColor;

public class MessageBuilder {

    private String message;
    private String placeholder;
    private String text;

    public MessageBuilder(String message) {
        this.message = message;
    }

    public MessageBuilder(String message, String placeholder, String text) {
        this.message = message;
        this.placeholder = placeholder;
        this.text = text;
    }

    public String build() {
        if (placeholder != null && text != null) {
            return message.replace(placeholder,text);
        }
        return message;
    }

    public MessageBuilder colorize() {
        this.message = ChatColor.translateAlternateColorCodes('&', this.message);
        return this;
    }

    public MessageBuilder colorize(char altColorChar) {
        this.message = ChatColor.translateAlternateColorCodes(altColorChar, this.message);
        return this;
    }

    public MessageBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public MessageBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public MessageBuilder setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getText() {
        return text;
    }
}