package org.mortalraven.moreobjectives.objectives.xlt.internal;

import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class XLTHarvestBerry extends XLObjective {

	public XLTHarvestBerry(){super("HARVEST_BERRY");}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {return true;}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onHarvest(PlayerHarvestBlockEvent event) {
		Player player = event.getPlayer();
		Block block = event.getHarvestedBlock();

		if (block.getType().equals(Material.SWEET_BERRY_BUSH)) {
			for(Tournament tournament : getTournaments()) {
				if(canExecute(tournament, player)) {
					tournament.addScore(player.getUniqueId(), 1, false);
				}
			}
		}
	}
}
