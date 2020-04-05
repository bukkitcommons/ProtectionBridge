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

package cc.bukkit.protectionbridge.protection;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface ProtectionFlag {
    /**
     * Gets flag name.
     * @return The name of flag.
     */
    @NotNull String getName();

    /**
     * Gets flag owning plugin.
     * @return The flag's plugin of owning
     */
    @NotNull Plugin getPlugin();
}
