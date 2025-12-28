package glowredman.nood;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(acceptedMinecraftVersions = "1.7.10", modid = "nood", name = "Nood", version = Tags.VERSION)
public class Nood {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // TODO config
        // TODO blocks
        // TODO items
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // TODO compat
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // TODO recipe
        // TODO register world gen
    }

    @EventHandler
    public void onMissingMapping(FMLMissingMappingsEvent event) {
        // TODO make Nood drop-in
    }
}
