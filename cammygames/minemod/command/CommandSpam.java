package cammygames.minemod.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;

public class CommandSpam extends CommandBase
{
    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 1;
    }
	
    public String getCommandName()
    {
        return "spam";
    }

    public void processCommand(ICommandSender var1, String[] var2)
    {
    	if (var2.length >= 1 && var2[0].length() > 0)
    	{    	
    	 
    		EntityPlayerMP var3 = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(var2[0]);

    	 	String var4 = "Your comment was Flagged as Spam Kicked by an operator.";
        
        	boolean var5 = false;

        	if (var3 == null)
        	{
            	throw new PlayerNotFoundException();
        	}
        	else
        	{
            	if (var2.length >= 2)
            	{
                	var4 = func_82360_a(var1, var2, 1);
                	var5 = true;
            	}

            		var3.playerNetServerHandler.kickPlayerFromServer(var4);

            	if (var5)
            	{
            		notifyAdmins(var1, "Kicked " + var3.username + " For Spam", new Object[] {var3.getEntityName(), var4});
            	}
            	else
            	{
            		notifyAdmins(var1, "Kicked " + var3.username + " For Spam", new Object[] {var3.getEntityName()});
            	}
        }
      }
    }
    

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length >= 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames()) : null;
    }
}
