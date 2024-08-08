package de.jonasheilig.serverStorySOne

import de.jonasheilig.serverStorySOne.commands.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.plugin.java.JavaPlugin

class ServerStorySOne : JavaPlugin(), Listener {

    override fun onEnable() {
        // Plugin startup logic
        server.pluginManager.registerEvents(this, this)
        getCommand("story")?.setExecutor(StoryCommand(this))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val player = event.entity
        val totalExperience = player.totalExperience
        val experienceToKeep = (totalExperience * 0.05).toInt()

        event.drops.clear()

        player.totalExperience = experienceToKeep

        val initialLevel = player.level
        player.totalExperience = experienceToKeep
        val finalLevel = player.level
        val levelsLost = initialLevel - finalLevel

        server.broadcastMessage("${player.name} hat $levelsLost Level beim Tod verloren.")
    }
}
