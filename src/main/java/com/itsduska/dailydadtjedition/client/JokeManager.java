package com.itsduska.dailydadtjedition.client;

import com.itsduska.dailydadtjedition.DailyDadTJEdition;
import com.itsduska.dailydadtjedition.joke.JokeFetcher;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import java.io.IOException;

public class JokeManager {
    private TextComponentString joke = null;

    @SubscribeEvent
    public void onScreenOpen(GuiOpenEvent event) {
        final GuiScreen screen = event.getGui();
        if (screen instanceof GuiMainMenu) {
            generateJoke(false);
        }
    }


    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {

        if (event.player != null)
        {

            generateJoke(true);

            event.player.sendMessage(joke);

            // Reset
            joke = null;
        }
    }

    private void generateJoke(boolean withName) {
        this.joke = null;

        try
        {
            TextComponentString jokeComponent = JokeFetcher.getDadJoke();

            if(jokeComponent != null)
            {
                joke = getFinalComponent(jokeComponent, withName);
            }
        }
        catch(IOException e)
        {
            joke = null;
        }

        if(joke == null)
        {
            DailyDadTJEdition.LOGGER.info("Getting internal dad joke instead");

            TextComponentString internalJoke = (TextComponentString) JokeFetcher.getInternalDadJoke().createCopy();

            joke = getFinalComponent(internalJoke, withName);
        }
    }

    private TextComponentString getFinalComponent(TextComponentString component, boolean withName) {
        if(withName)
        {
            TextComponentString prefix = new TextComponentString("<Daily Dad TJ Edition> ");
            prefix.getStyle().setColor(TextFormatting.GOLD);
            return (TextComponentString) prefix.appendSibling(component);
        }
        else
        {
            return component.createCopy();
        }
    }
}
