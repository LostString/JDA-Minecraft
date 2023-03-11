package me.lost.main.discord;

import me.lost.main.Main;
import me.lost.main.commands.BroadCast;
import me.lost.main.commands.dcsay;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Discord {

    private JDA jda;
    private final Main main = Main.getInstance();


    public void run(){
        try {
            jda = JDABuilder.createDefault("Tu token").enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
                    .addEventListeners(new BroadCast()) // Agregamos el listener al bot
                    .setActivity(Activity.playing("Minecraft")).build().awaitReady();

        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lEl Bot no se inicio "));
        }

        main.getCommand("dc").setExecutor(new dcsay(jda));
        
    }

    public void disconnect() {

        if (this.jda != null) {
            try {

                this.jda.shutdown();
                this.jda = null;
                this.main.getLogger().info("¡El Bot ha sido cerrado!");

            } catch (Exception e) {

                this.main.getLogger().severe("La conexión entre el servidor y el bot de Discord no se apagó de manera segura." +
                        " Si este problema persiste, ¡comuníquese con los autores!");

                e.printStackTrace();

            }
        }

    }






}