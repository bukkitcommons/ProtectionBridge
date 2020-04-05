/*
 * This file is part of ProtectionBridge.
 * ProtectionBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ProtectionBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with ProtectionBridge.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of ProtectionBridge.
 * ProtectionBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ProtectionBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with ProtectionBridge.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.bukkit.protectionbridge;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProtectionBridge extends JavaPlugin {
    private ProtectionBridge plugin;
    private ServicesManager servicesManager;

    @Override
    public void onLoad() {
        // Plugin load logic
        super.onLoad();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        reloadConfig();
        this.servicesManager = Bukkit.getServicesManager();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getScheduler().cancelTasks(this);
        Bukkit.getServicesManager().unregisterAll(this);
    }
}
