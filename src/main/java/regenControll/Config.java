package regenControll;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static int regenTime=80, minHunger=16;
	public static float exhaustion=6F;
	
	public static void readcfg(){
		Configuration cfg=RegenControll.config;
		try{
			cfg.load();
			initConfig(cfg);
		} catch(Exception e){
			System.out.println("Regen Controll mod could not load configs");
		} finally{
			if(cfg.hasChanged()){
				cfg.save();
			}
		}
	}
	
	public static void initConfig(Configuration cfg){
		cfg.addCustomCategoryComment("GENERAL", "general config");
		regenTime=cfg.getInt("regenTime", "GENERAL", 80, 1, 2000000000, "The interval in ticks between heals. Since combat update vanilla is 10. Before combat update vanilla is 80");
		minHunger=cfg.getInt("minHunger", "GENERAL", 16, 6, 20, "The minimum amount of hunger needed for healing. Vanilla is 18");
		exhaustion=cfg.getFloat("exhaustion", "GENERAL", 6F, 0F, 80F, "The exhaustion value added by healing. 4 exhaustion equals 1 saturation/hunger point lost");
	}
	
}
