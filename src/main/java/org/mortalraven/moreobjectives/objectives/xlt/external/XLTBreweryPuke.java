package org.mortalraven.moreobjectives.objectives.xlt.external;

import com.dre.brewery.api.events.PlayerPukeEvent;
import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class XLTBreweryPuke extends XLObjective {

	public XLTBreweryPuke() {super("BREWERY_PUKE");}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {
		return true;
	}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onPuke(PlayerPukeEvent event) {
		Player player = event.getPlayer();

		for(Tournament tournament : getTournaments()) {
			if(canExecute(tournament, player)) {
				tournament.addScore(player.getUniqueId(), 1, false);
			}
		}
	}
}
