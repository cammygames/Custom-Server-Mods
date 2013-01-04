package cammygames.minemod;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.command.CommandServerMessage;
import net.minecraft.command.CommandServerSay;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.network.IChatListener;

public class Chat implements IChatListener
{
	private static BufferedReader bufferm;
	private static BufferedReader buffera;
	private static BufferedReader bufferss;
	private static BufferedReader bufferd;
	private static BufferedReader bufferdo;
	
	public static void loadchatconfig()
	{	
		try
		{
			bufferm.close();
			buffera.close();
			bufferss.close();
			bufferd.close();
			bufferdo.close();
			
			
			MineMod.mods = new ArrayList();
			MineMod.admins = new ArrayList();
			MineMod.seniorstaff = new ArrayList();
			MineMod.dev = new ArrayList();
			MineMod.donor = new ArrayList();
			
		}
		catch (Exception e) {e.printStackTrace();}

	}
	
	@ForgeSubscribe
	public  void chatEvent(ServerChatEvent event) 
	{			
		try
		{
			   MineMod.filem = new FileReader("CustomChat/Staff/modnames.txt");
			   MineMod.filea = new FileReader("CustomChat/Staff/adminnames.txt");
			   MineMod.filess = new FileReader("CustomChat/Staff/seniorstaffnames.txt");
			   MineMod.filed = new FileReader("CustomChat/Staff/devnames.txt");
			   MineMod.filedo = new FileReader("CustomChat/Donator/donornames.txt");	
					   
               bufferm = new BufferedReader(MineMod.filem);
               buffera = new BufferedReader(MineMod.filea);
               bufferss = new BufferedReader(MineMod.filess);
               bufferd = new BufferedReader(MineMod.filed);
               bufferdo = new BufferedReader(MineMod.filedo);
               
               
               String name = bufferm.readLine();
               
               while(name != null)
               {
                       MineMod.mods.add(name.trim());
                       name = bufferm.readLine();
               }
               
               name = buffera.readLine();
               
               while(name != null)
               {
            	       MineMod.admins.add(name.trim());
                       name = buffera.readLine();
               }
              
               name = bufferss.readLine();
               
               while(name != null)
               {
            	       MineMod.seniorstaff.add(name.trim());
                       name = buffera.readLine();
               }
              
               name = bufferd.readLine();
               
               while(name != null)
               {
            	       MineMod.dev.add(name.trim());
                       name = buffera.readLine();
               }
              
               name = bufferdo.readLine();
               
               while(name != null)
               {
            	       MineMod.donor.add(name.trim());
                       name = bufferdo.readLine();
               }
                             
               if (MineMod.mods.contains(event.player.username))
               {
            	   event.line = "\u00a72" +  "<" + event.player.username + ">\u00a7r " + event.message;
       				bufferm.close();

               }
               
               if (MineMod.admins.contains(event.player.username))
               {
            	   event.line = "\u00a75" +  "<" + event.player.username + ">\u00a7r " + event.message;
       				buffera.close();

               }
               
               if (MineMod.seniorstaff.contains(event.player.username))
               {
            	   event.line = "\u00a7a" +  "<" + event.player.username + "> \u00a7r " + event.message;
          			bufferss.close();
               }
               
               if (MineMod.dev.contains(event.player.username))
               {
            	   event.line = "\u00a74" +  "<" + event.player.username + ">\u00a7r " + event.message;
          			bufferd.close();
               }               
               
               if(MineMod.dev.contains(event.player.username)& MineMod.mods.contains(event.player.username))
               {
            	   event.line = "\u00a72" +  "<" + event.player.username + ">\u00a7r " + event.message;
            	   bufferd.close();
            	   bufferdo.close();
               }
               
               if (MineMod.donor.contains(event.player.username))
               {
            	   event.line = "\u00a73" + "<" + event.player.username + ">" + event.message;
         			bufferdo.close();
               }
             
               if (containsIgnoreCase(event.message,"fuck"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say fuck in the chat!");
               }
                                       
               if (containsIgnoreCase(event.message,"cunt"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4);
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say fucker in the chat!");
               }
               
               if (containsIgnoreCase(event.message,"dick"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say dick in the chat!");
               }
          
               if (containsIgnoreCase(event.message,"penis"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say penis in the chat!");
               }      
               
               if (containsIgnoreCase(event.message,"bitch"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say bitch in the chat!");
               }    
               
               if (containsIgnoreCase(event.message,"fuck off"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say fuck off in the chat!");
               }  
               
               if (containsIgnoreCase(event.message,"cock"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say cock in the chat!");
               }  
               
               if (containsIgnoreCase(event.message,"fucks"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say fucks in the chat!");
               }  
               
               if (containsIgnoreCase(event.message,"cunts"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say fucks in the chat!");
               }  
               
               if (containsIgnoreCase(event.message,"mother fucker"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say mother fucker in the chat!");
               }  
             
               if (containsIgnoreCase(event.message,"bastard"))
               {
            	   String var4 = "You where kicked by the chat filter for foul Language.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say bastard in the chat!");
               } 
               
               if (containsIgnoreCase(event.message,"nigger"))
               {
            	   String var4 = "You where kicked by the chat filter for racial slures.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say nigger in the chat!");
               }  
               
               
               if (containsIgnoreCase(event.message,"fucker"))
               {
            	   String var4 = "You where kicked by the chat filter for racial slures.";
            	   
            	   event.line = "\u00a7r" + "<" + event.player.username + ">" + " ## Censored ## ";
              	   event.player.playerNetServerHandler.kickPlayerFromServer(var4); 
              	   System.out.println("[CHAT FILTER]" + event.player.username + " Tried to say fucker in the chat!");
               } 
               
		}
		catch (Exception e) {e.printStackTrace();}
	}
	
	
	@Override
	public Packet3Chat serverChat(NetHandler handler, Packet3Chat message)
	{
		return message;
	}

	@Override
	public Packet3Chat clientChat(NetHandler handler, Packet3Chat message)
	{
		return message;
	}
			
	public boolean containsIgnoreCase( String haystack, String needle )
	{
		  if(needle.equals(""))
		    return true;
		  if(haystack == null || needle == null || haystack .equals(""))
		    return false; 

		  Pattern p = Pattern.compile(needle,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
		  Matcher m = p.matcher(haystack);
		  return m.find();
	}
	
}
