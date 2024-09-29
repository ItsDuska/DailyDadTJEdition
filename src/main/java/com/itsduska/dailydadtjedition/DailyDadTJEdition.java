package com.itsduska.dailydadtjedition;

import com.itsduska.dailydadtjedition.client.JokeManager;
import com.itsduska.dailydadtjedition.config.JokeConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid= DailyDadTJEdition.MOD_ID, version = DailyDadTJEdition.VERSION, name = DailyDadTJEdition.NAME)
public class DailyDadTJEdition {
	public static final String MOD_ID = "daily_dad_tj_edition";
	public static final String VERSION = "1.0";
	public static final String NAME = "Daily Dad TJ Edition";
	public static final Logger LOGGER = LogManager.getLogger();
	

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		JokeConfig.loadConfig(event,LOGGER);

		if (event.getSide().isClient())
		{
			MinecraftForge.EVENT_BUS.register(new JokeManager());
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		LOGGER.info("{} : guh buh uuuhhh...", DailyDadTJEdition.NAME);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LOGGER.info("{}: wah?", DailyDadTJEdition.NAME);
	}
}
