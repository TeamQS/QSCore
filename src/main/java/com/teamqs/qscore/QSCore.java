package com.teamqs.qscore;

import com.teamqs.qscore.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(
        modid = Constants.MOD_ID,
        name = Constants.MOD_NAME,
        version = Constants.VERSION,
        acceptedMinecraftVersions = "[1.12,1.12.2]"
)
public class QSCore {

    public static final Logger LOGGER = LogManager.getLogger(Constants.MOD_ID);

    public static File config;

    @SidedProxy(
            clientSide = "com.teamqs.qscore.proxy.ClientProxy",
            serverSide = "com.teamqs.qscore.proxy.CommonProxy",
            modId = Constants.MOD_ID)
    public static CommonProxy proxy;

    @Instance(Constants.MOD_ID)
    public static QSCore instance;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(final FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
