package cammygames.minemod;

import java.awt.List;
import java.io.FileReader;
import java.util.ArrayList;

import cammygames.minemod.command.CommandAll;
import cammygames.minemod.command.CommandSpam;

import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "CustomChat", name = "CustomChat", version = "0.4")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class MineMod 
{
	public static String VERSION = "0.4";
	
	private ServerConfigurationManager serverConfigManager;
	
	public static ArrayList<String> mods = new ArrayList();
	public static ArrayList<String> admins = new ArrayList();
	public static ArrayList<String> seniorstaff = new ArrayList();
	public static ArrayList<String> dev = new ArrayList();
	public static ArrayList<String> donor = new ArrayList();
		
	public static FileReader filem;
	public static FileReader filea;
	public static FileReader filess;
	public static FileReader filed;
	public static FileReader filedo;
	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent e)
	{		
		Chat chat = new Chat();
		MinecraftForge.EVENT_BUS.register(chat);
		
		System.out.println("[Custom Chat] Loaded Custom Chat Mod Version " + this.VERSION);
				
		e.registerServerCommand(new CommandAll());
		e.registerServerCommand(new CommandSpam());
	}
	
	public ServerConfigurationManager getConfigurationManager()
	{
		return serverConfigManager;
	}


}
