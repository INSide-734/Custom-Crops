/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customcrops.compatibility.item;

import io.lumine.mythic.bukkit.MythicBukkit;
import net.momirealms.customcrops.api.integration.ItemLibrary;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MythicMobsItemImpl implements ItemLibrary {

    private MythicBukkit mythicBukkit;

    public MythicMobsItemImpl() {
        this.mythicBukkit = MythicBukkit.inst();
    }

    @Override
    public String identification() {
        return "MythicMobs";
    }

    @Override
    public ItemStack buildItem(Player player, String id) {
        if (mythicBukkit == null || mythicBukkit.isClosed()) {
            this.mythicBukkit = MythicBukkit.inst();
        }
        return mythicBukkit.getItemManager().getItemStack(id);
    }

    @Override
    public String getItemID(ItemStack itemStack) {
        return mythicBukkit.getItemManager().getMythicTypeFromItem(itemStack);
    }
}