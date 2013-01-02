package cammygames.minemod.command;

import cpw.mods.fml.common.FMLCommonHandler;
import cammygames.minemod.Chat;
import cammygames.minemod.MineMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;

public class CommandAll extends CommandBase
{

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 3;
    }
	
	@Override
	public String getCommandName() 
	{
		return "customchat";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2)
	{
        if (var2[0].equals("reload"))
        {
            MinecraftServer.getServer().getConfigurationManager();
            Chat.loadchatconfig();
            notifyAdmins(var1, "Reloaded Custom Chat", new Object[0]);
            return;
        }
		
        if (var2[0].equals("info"))
        {
        		MinecraftServer.getServer().getConfigurationManager().func_92027_k("[INFO]" + "\u00a7c" + " Teamspeak : ts.minemod.org:50275");
        		MinecraftServer.getServer().getConfigurationManager().func_92027_k("[INFO]" + "\u00a7c" + " Mumble : mumble.minemod.org:50798");
        		MinecraftServer.getServer().getConfigurationManager().func_92027_k("[INFO]" + "\u00a7c" + " Twitch : http://www.twitch.tv/minemodtv/");
        		MinecraftServer.getServer().getConfigurationManager().func_92027_k("[INFO]" + "\u00a7c" + " Website : http://minemod.org/");
            return;
        }
                
        if (var2[0].equals("version"))
        {
        	var1.sendChatToPlayer("The Current Version of Custom Chat is "+ MineMod.VERSION);
        } 
	}

}
