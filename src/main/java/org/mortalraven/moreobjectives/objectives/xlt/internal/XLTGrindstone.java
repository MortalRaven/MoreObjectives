package org.mortalraven.moreobjectives.objectives.xlt.internal;

import fun.lewisdev.tournaments.objective.XLObjective;
import fun.lewisdev.tournaments.tournament.Tournament;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class XLTGrindstone extends XLObjective {

	public XLTGrindstone() {super("GRINDSTONE");}

	@Override
	public boolean loadTournament(Tournament var1, FileConfiguration config) {return true;}

	@EventHandler(
			priority = EventPriority.HIGH,
			ignoreCancelled = true
	)
	public void onDisenchant(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();

		if  (inv.getType() == InventoryType.GRINDSTONE) {
			if (event.getRawSlot() != 2 || event.getClick() == ClickType.MIDDLE) return;

			ItemStack item = inv.getItem(2);
			if (item == null || item.getType().isAir()) return;

			for(Tournament tournament : getTournaments()) {
				if(canExecute(tournament, player)) {
					tournament.addScore(player.getUniqueId(), 1, false);
				}
			}
		}
	}
}
