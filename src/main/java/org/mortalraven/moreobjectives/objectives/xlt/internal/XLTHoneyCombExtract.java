package org.mortalraven.moreobjectives.objectives.xlt.internal;

import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class XLTHoneyCombExtract extends XLObjective {

	public XLTHoneyCombExtract() {super("HONEY_COMB_EXTRACT");}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {return true;}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onHoneyExtract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();

		if (event.hasItem() && event.hasBlock() && block != null && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (block.getType().equals(Material.BEE_NEST) || block.getType().equals(Material.BEEHIVE)) {
				Beehive beehive = (Beehive) block.getBlockData();
				if (beehive.getHoneyLevel() >= 5) {
					if (player.getItemInHand().getType().equals(Material.SHEARS)) {
						for(Tournament tournament : getTournaments()) {
							if(canExecute(tournament, player)) {
								tournament.addScore(player.getUniqueId(), 1, false);
							}
						}
					}
				}
			}
		}
	}
}
