package com.vanilla.eugene.command;

import com.vanilla.eugene.user.Cache;
import com.vanilla.eugene.user.User;
import com.vanilla.eugene.util.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Optional;

/**
 * Command responsible for allowing players to change their ranks.
 *
 * @author NickTheDev
 */
public class RankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            User user = User.get(sender.getName()).get();

            user.getCache().push(Cache.Key.RANK, args[0]);
            Chat.to(user.toPlayer(), Chat.SUCCESS, "Your rank has been updated.");
            return true;
        }

        if(!sender.isOp()) {
            sender.sendMessage(Chat.get(Chat.ERROR, "You must be an operator to use this command."));

            return false;
        }

        if(args.length != 2) {
            sender.sendMessage(Chat.get(Chat.ERROR, "You must specify a player and a rank."));

            return false;
        }

        /*
        if(!args[1].matches("^[a-zA-Z0-9]+$")) {
            sender.sendMessage(Chat.get(Chat.ERROR, "Invalid rank to set."));

            return false;
        }
         */

        Optional<User> user = User.get(args[0]);

        if(!user.isPresent()) {
            sender.sendMessage(Chat.get(Chat.ERROR, "Cannot find requested player."));

            return false;
        }

        user.get().getCache().push(Cache.Key.RANK, args[1]);
        Chat.to(user.get().toPlayer(), Chat.SUCCESS, "Your rank has been updated.");
        return true;
    }

}
