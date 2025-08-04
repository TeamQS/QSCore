package com.teamqs.qscore;

import net.minecraftforge.fml.common.Loader;

import java.io.File;
import java.util.ArrayList;

public class Constants {

    public static final String MOD_ID = "qscore";
    public static final String MOD_NAME = "QSCore";
    public static final String VERSION = "1.0";

    public static final String MAIN_CONFIG_DIR = "config/" + MOD_NAME;
    public static final String[] DIRS = {};
    public static final ArrayList<File> CONFIG_DIRS = new ArrayList<>();

    public static final String MEKA_ID = "mekanism";
    public static final boolean MEKA_LOADED = Loader.isModLoaded(MEKA_ID);
    public static final String MEKA_CONFIG_DIR = MAIN_CONFIG_DIR  + "/" + "mekanism";
}
