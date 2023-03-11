package me.lost.main;

import me.lost.main.commands.dcsay;
import me.lost.main.discord.Discord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public final class Main extends JavaPlugin {

    private JDA jda;
    private static Main instance;
    private Discord bot;


    @Override
    public void onEnable() {

        instance = this;

        this.bot = new Discord();
        this.bot.run();



    }

    @Override
    public void onDisable() {

        this.bot.disconnect();
        // Plugin shutdown logic
    }

    public static Main getInstance() { return instance; }
}
