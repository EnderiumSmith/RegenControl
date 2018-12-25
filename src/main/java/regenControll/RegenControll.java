package regenControll;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=RegenControll.MODID, name=RegenControll.MODNAME, version=RegenControll.VERSION, acceptableRemoteVersions="*")
public class RegenControll {
	
	public final static String MODID="regen_controll";
	public final static String MODNAME="Regen Controll";
	public final static String VERSION="1.0";
	
	public static Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		File file=e.getModConfigurationDirectory();
		config=new Configuration(new File(file.getPath(),"regen_controll.cfg"));
		Config.readcfg();
		MinecraftForge.EVENT_BUS.register(new regenControll.EventHandler());
	}
	@EventHandler
	public void init(FMLInitializationEvent e){
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		if(config.hasChanged()){
			config.save();
		}
	}
}
