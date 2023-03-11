package me.lost.main.commands;

import me.lost.main.discord.Discord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class dcsay implements CommandExecutor {

    private Discord bot;
    private JDA jda;

    public dcsay(JDA jda) {
        this.jda = jda;
    }

    public boolean onCommand(CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("dc")) {
            if (args.length == 0) {
                return false;
            }

            try{
                String message = String.join(" ", args);
                TextChannel channel = jda.getTextChannelById("ID DEL CANAL");
                if(channel == null){
                    return false;
                }else{
                    channel.sendMessage("[Minecraft] " + sender.getName() + ": " + message).queue();
                }


            }catch (Exception e){

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cHay un error en el codigo. &b(Revisa la consola)"));
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + String.valueOf(e));

            }


        }

        return false;
    }
}
