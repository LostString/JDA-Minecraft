package me.lost.main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;

import java.awt.*;

public class BroadCast extends ListenerAdapter {


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase("!bc")) {
            // Llamar al método execute() del comando
            Role rol = event.getGuild().getRoleById("EL ID DEL ROL ADMIN");
            Member user = event.getMember();
            if(user.getRoles().contains(rol)){
                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle("BroadCast");
                builder.setDescription("Has enviado un broadcast al servidor");
                builder.setColor(Color.BLUE);
                TextChannel channel = event.getChannel();
                channel.sendMessage(builder.build()).queue();
                Bukkit.broadcastMessage(event.getMessage().getContentDisplay().substring("!bc".length()).trim());
            }else{
                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle("Denegado");
                builder.setDescription("No tienes permisos para hacer esto");
                builder.setColor(Color.RED);
                TextChannel channel = event.getChannel();
                channel.sendMessage(builder.build()).queue();
            }

        }
    }

}

