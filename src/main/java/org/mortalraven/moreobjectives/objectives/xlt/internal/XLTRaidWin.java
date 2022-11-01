package org.mortalraven.moreobjectives.objectives.xlt.internal;

import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.raid.RaidFinishEvent;

public class XLTRaidWin extends XLObjective {

	public XLTRaidWin() {
		super("RAID_WIN");
	}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {
		return true;
	}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onRaidEnd(RaidFinishEvent event) {
		event.getWinners().forEach((player) -> {
			for(Tournament tournament : getTournaments()) {
				if(canExecute(tournament, player)) {
					tournament.addScore(player.getUniqueId(), 1, false);
				}
			}
		});
	}
}
