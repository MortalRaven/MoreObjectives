package org.mortalraven.moreobjectives;

import fun.lewisdev.tournaments.XLTournamentsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.mortalraven.moreobjectives.objectives.xlt.external.XLTBreweryDrink;
import org.mortalraven.moreobjectives.objectives.xlt.external.XLTBreweryPuke;
import org.mortalraven.moreobjectives.objectives.xlt.internal.*;

public class MoreObjectives extends JavaPlugin {

	@Override
	public void onEnable() {

		XLTournamentsAPI api = (XLTournamentsAPI) Bukkit.getPluginManager().getPlugin("XLTournaments");

		api.registerObjective(new XLTBreed());
		api.registerObjective(new XLTConsume());
		api.registerObjective(new XLTEnchant());
		api.registerObjective(new XLTFertilise());
		api.registerObjective(new XLTGrindstone());
		api.registerObjective(new XLTHarvestBerry());
		api.registerObjective(new XLTHoneyCombExtract());
		api.registerObjective(new XLTHoneyExtract());
		api.registerObjective(new XLTItemBreak());
		api.registerObjective(new XLTMilk());
		api.registerObjective(new XLTRaidWin());
		api.registerObjective(new XLTShear());
		api.registerObjective(new XLTTame());
		api.registerObjective(new XLTVillagerTrade());

		api.registerObjective(new XLTBreweryDrink(), "Brewery");
		api.registerObjective(new XLTBreweryPuke(), "Brewery");

		getLogger().info("MoreObjectives successfully loaded.");
	}

	@Override
	public void onDisable() {
		getLogger().info("MoreObjectives successfully disabled.");
	}

}
