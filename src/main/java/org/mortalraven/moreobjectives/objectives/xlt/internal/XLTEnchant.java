package org.mortalraven.moreobjectives.objectives.xlt.internal;

import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class XLTEnchant extends XLObjective {

	public XLTEnchant() {
		super("ENCHANT");
	}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {
		return true;
	}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onEnchant(EnchantItemEvent event) {
		Player player = event.getEnchanter();

		for(Tournament tournament : getTournaments()) {
			if(canExecute(tournament, player)) {
				tournament.addScore(player.getUniqueId(), 1, false);
			}
		}
	}
}
