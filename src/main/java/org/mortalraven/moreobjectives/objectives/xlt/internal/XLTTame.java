package org.mortalraven.moreobjectives.objectives.xlt.internal;

import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityTameEvent;

public class XLTTame extends XLObjective {

	public XLTTame() {
		super("TAME");
	}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {
		return true;
	}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onTame(EntityTameEvent event) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();

			for(Tournament tournament : getTournaments()) {
				if(canExecute(tournament, player)) {
					tournament.addScore(player.getUniqueId(), 1, false);
				}
			}
		}
	}
}
