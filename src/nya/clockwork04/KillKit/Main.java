package nya.clockwork04.KillKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public void onEnable() {
		Bukkit.getServer().getLogger().info("KillKit By Snoopie Enabled!");
	}	
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("KillKit disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args) {
        
		if (!(sender instanceof Player)) {
	         Bukkit.getServer().getLogger().info("Cannot Kill Using Console!");
	         return true;
	       
	      } else {
              Player player = (Player)sender;  
	    	  if (cmd.getName().equalsIgnoreCase("kill")) { //command name
	            if (args.length == 0) {
	               player.setHealth(0);
	               player.sendMessage(ChatColor.RED + "You have committed Seppuku!");
	               Bukkit.getServer().getLogger().info((player.getName()) + " Has Comitted Seppuku!");
	               return true;
	            }

	            Player target = Bukkit.getServer().getPlayer(args[0]); //sets target varib as "target"

	            if (target == null) { //checks if target is exist
	               player.sendMessage(ChatColor.RED + "No Such Player");
	               return true;
	            }
	            if (target.isOp() && !player.isOp()) { //checks if target is OP
		               target.sendMessage(ChatColor.RED + (player.getName()) + " has attempted to kill you!");
		        }

	            if (!player.isOp()) { //checks if sender/player is OP
		               player.sendMessage(ChatColor.RED + "Im sorry " + (player.getName()) + " im afraid i cant do that");
	                   Bukkit.getServer().getLogger().info((player.getName()) + " attempted to kill " + ( target.getName()) + "!");
		               return true;
		        }

	            target.setHealth(0); //sets helth to 0 aka death
	            Bukkit.getServer().getLogger().info((player.getName()) + " has killed " + (target.getName()) + "!");
	            player.sendMessage(ChatColor.GREEN + "Operation Successful!");
	         }

	         return true;
      }
  }
}