package fr.xephi.authme.util;

import org.bukkit.entity.Player;
import org.geysermc.connector.GeyserConnector;
import org.geysermc.connector.network.session.GeyserSession;

/**
 * Player utilities.
 */
public final class PlayerUtils {

    // Utility class
    private PlayerUtils() {
    }

    /**
     * Returns the IP of the given player.
     *
     * @param player The player to return the IP address for
     * @return The player's IP address
     */
    public static String getPlayerIp(Player player) {
        String geyserIp = getGeyserIp(player);
        if (geyserIp != null)
            return geyserIp;
        return player.getAddress().getAddress().getHostAddress();
    }

    /**
     * Returns if the player is an NPC or not.
     *
     * @param player The player to check
     * @return True if the player is an NPC, false otherwise
     */
    public static boolean isNpc(Player player) {
        return player.hasMetadata("NPC");
    }

    public static String getGeyserIp(Player player) {
        if (player == null)
            return null;
        GeyserConnector connector = GeyserConnector.getInstance();
        if (connector == null)
            return null;
        GeyserSession session = connector.getPlayerByUuid(player.getUniqueId());
        if (session == null)
            return null;
        return session.getSocketAddress().getAddress().getHostAddress();
    }

}
