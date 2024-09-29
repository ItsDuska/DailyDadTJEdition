package com.itsduska.dailydadtjedition.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
public class JokeConfig
{
    public static Configuration config;
    public static List<String> internalDataBase;

    public static void loadConfig(FMLPreInitializationEvent event, Logger logger) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        String[] defaultDataBase = new String[] {
                "I invented a new word! Plagiarism!",
                "Whoever invented the knock-knock joke should get a no bell prize.",
                "My pet mouse 'Elvis' died last night. He was caught in a trap..",
                "Why should you never trust a pig with a secret? Because it's bound to squeal.",
                "How do you organize a space party? You planet.",
                "Somebody stole my Microsoft Office and they're going to pay - you have my Word.",
                "What do you call a nervous javelin thrower? Shakespeare.",
                "I went to the zoo the other day, there was only one dog in it. It was a shitzu.",
                "“Hold on, I have something in my shoe”  “I’m pretty sure it’s a foot”",
                "What's black and white and read all over? The newspaper.",
                "Do you know where you can get chicken broth in bulk? The stock market.",
                "What kind of dinosaur loves to sleep? A stega-snore-us.",
                "I used to be a banker, but I lost interest.",
                "What kind of music do planets listen to? Nep-tunes.",
                "My friend said to me: \"What rhymes with orange\" I said: \"no it doesn't\"",
                "I asked the surgeon if I could administer my own anesthetic, they said: go ahead, knock yourself out.",
                "Why did the worker get fired from the orange juice factory? Lack of concentration.",
                "Why did the cookie cry? Because his mother was a wafer so long",
                "Where did Captain Hook get his hook? From a second hand store.",
                "I wish I could clean mirrors for a living. It's just something I can see myself doing.",
                "Yesterday a clown held a door open for me. I thought it was a nice jester.",
                "How many bones are in the human hand? A handful of them.",
                "A Sandwich walks into a bar, the bartender says “Sorry, we don’t serve food here”",
                "The invention of the wheel was what got things rolling",
                "Geology rocks, but Geography is where it's at!",
                "Did you know you should always take an extra pair of pants golfing? Just in case you get a hole in one.",
                "What do you get if you put a duck in a cement mixer? Quacks in the pavement.",
                "Why did the opera singer go sailing? They wanted to hit the high Cs.",
                "How does a French skeleton say hello? Bone-jour.",
                "What did the dog say to the two trees? Bark bark."
        };

        internalDataBase = Arrays.asList(config.getStringList("internalDataBase", Configuration.CATEGORY_CLIENT,
                defaultDataBase, "The internal database of jokes for in case the mod is unable to reach the API"));

        if (config.hasChanged()) {
            config.save();
            logger.info("Daily Dad TJ Edition config updated and saved.");
        }
    }
}

