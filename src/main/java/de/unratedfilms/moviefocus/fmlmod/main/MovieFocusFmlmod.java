
package de.unratedfilms.moviefocus.fmlmod.main;

import java.util.Arrays;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import de.unratedfilms.moviefocus.fmlmod.conf.FocusConfigManager;
import de.unratedfilms.moviefocus.fmlmod.conf.impls.EntityFocusConfig;
import de.unratedfilms.moviefocus.fmlmod.conf.impls.FixedFocusConfig;
import de.unratedfilms.moviefocus.fmlmod.conf.impls.PointFocusConfig;
import de.unratedfilms.moviefocus.fmlmod.keys.KeyBindings;
import de.unratedfilms.moviefocus.fmlmod.keys.KeyHandler;
import de.unratedfilms.moviefocus.fmlmod.render.OverlayRenderer;
import de.unratedfilms.moviefocus.shared.Consts;

@Mod (modid = Consts.MOD_ID, version = Consts.MOD_VERSION)
public class MovieFocusFmlmod {

    @EventHandler
    public void init(FMLInitializationEvent event) {

        // Install the focus config manager
        FocusConfigManager.install(new FocusConfigManager(Arrays.asList(
                new FixedFocusConfig(), new PointFocusConfig(), new EntityFocusConfig())));

        // Initialize the key bindings
        KeyBindings.initialize();
        FMLCommonHandler.instance().bus().register(new KeyHandler());

        // Initialize the overlay renderer
        MinecraftForge.EVENT_BUS.register(new OverlayRenderer());
    }

}
