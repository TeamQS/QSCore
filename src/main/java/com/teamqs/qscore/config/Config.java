package com.teamqs.qscore.config;

import com.teamqs.qscore.Constants;
import com.teamqs.qscore.integrations.GassesNamesListing;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    private static boolean gassesNamesListing;

    public static Configuration config;

    public static void init() {
        File main_dir = new File(Constants.MAIN_CONFIG_DIR);
        if (!main_dir.exists()) main_dir.mkdir();
        registerGeneral();
        registerConfigDirs();

        checkupAndCreateDirs();
    }

    public static void registerConfigDirs() {
        for (String dir : Constants.DIRS) {
            Constants.CONFIG_DIRS.add(new File(Constants.MAIN_CONFIG_DIR + "/" + dir));
        }
        registerModDirs();
    }

    public static void registerModDirs() {
        if (Constants.MEKA_LOADED) {
            Constants.CONFIG_DIRS.add(new File(Constants.MEKA_CONFIG_DIR));
            if (getGassesNamesListing()) {
                new GassesNamesListing();
            }
        }
    }

    public static void checkupAndCreateDirs() {
        for (File dir : Constants.CONFIG_DIRS) {
            if (!dir.exists()) dir.mkdir();
        }
    }

    public static boolean getGassesNamesListing() {
        return gassesNamesListing;
    }

    public static void registerGeneral() {
        config = new Configuration(new File(Constants.MAIN_CONFIG_DIR, "general.cfg"));
        String category;

        category = "Mekanism";
        config.addCustomCategoryComment(category, "Mekanism settings");
        gassesNamesListing = config.getBoolean("gassesNamesListing", category, false, "Outputs the names of all gases and their IDs");

        config.save();
    }

}
