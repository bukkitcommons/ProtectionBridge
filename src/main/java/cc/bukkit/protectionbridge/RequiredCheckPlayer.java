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
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class RequiredCheckPlayer {
    private static final UUID virtualUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    @NotNull
    private final UUID uuid;
    @NotNull
    private final String username;

    /**
     * Create RequiredCheckPlayer from original UUID+Username.
     *
     * @param uuid     The player uuid.
     * @param username The player username.
     */
    public RequiredCheckPlayer(final @NotNull UUID uuid, final @NotNull String username) {
        this.uuid = uuid;
        this.username = username;
    }

    /**
     * Create RequiredCheckPlaayer from online player.
     *
     * @param player The player
     */
    public RequiredCheckPlayer(final @NotNull Player player) {
        this.uuid = player.getUniqueId();
        this.username = player.getName();
    }

    /**
     * Create RequiredCheckPlayer from offline/online player.
     *
     * @param offlinePlayer The player, it can be online or offline.
     */
    public RequiredCheckPlayer(final @NotNull OfflinePlayer offlinePlayer) {
        this.uuid = offlinePlayer.getUniqueId();
        this.username = offlinePlayer.getName();
    }

    /**
     * Create RequiredCheckPlayer from username or FAKE player.
     *
     * @param playerName The player name.
     * @param isVirtual  Is a FAKE player.
     */
    public RequiredCheckPlayer(final @NotNull String playerName, boolean isVirtual) {
        if (!isVirtual) {
            this.uuid = virtualUUID;
        } else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
            this.uuid = offlinePlayer.getUniqueId();
        }
        this.username = playerName;
    }

    /**
     * Get player username (it can be virtual player, call isVirtual before process it like regular player)
     *
     * @return Player username
     */
    public @NotNull String getUsername() {
        return username;
    }

    /**
     * Get player uuid (it can be virtual player, call isVirtual before process it like regular player)
     *
     * @return Player uuid
     */
    public @NotNull UUID getUuid() {
        return uuid;
    }

    /**
     * Checks if player created from a FAKE player.
     * @return
     */
    public boolean isVirtual(){
        return uuid.equals(virtualUUID);
    }

}
