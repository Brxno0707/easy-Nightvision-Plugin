package de.brxno.nightVisionPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionCommand extends BukkitCommand {

    public NightVisionCommand(String name) {
        super(name);
        this.setDescription("Toggle night vision on/off");
        this.setUsage("/nv");
        this.setPermission("nightvision.use");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNur Spieler können diesen Befehl benutzen!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("nightvision.use")) {
            player.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            player.sendMessage("§eNightVision deaktiviert!");
        } else {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false));
            player.sendMessage("§aNightVision aktiviert!");
        }
        return true;
    }
}
