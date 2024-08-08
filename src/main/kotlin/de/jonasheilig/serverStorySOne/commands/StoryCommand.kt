package de.jonasheilig.serverStorySOne.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class StoryCommand(private val plugin: JavaPlugin) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player && !sender.hasPermission("serverstory.story")) {
            sender.sendMessage("Du hast keine Berechtigung, diesen Befehl zu verwenden.")
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage("Bitte gib eine Zahl (1, 2, 3, ...) als Parameter an.")
            return false
        }

        when (args[0]) {
            "1" -> {
                sendDelayedMessages(
                    listOf(
                        "",
                        "",
                    )
                )
            }
            "2" -> {
                sendDelayedMessages(
                    listOf(
                        "",
                        "",
                    )
                )
            }
            "3" -> {
                sendDelayedMessages(
                    listOf(
                        "",
                        "",
                    )
                )
            }
            else -> sender.sendMessage("Ungültiger Parameter. Bitte wähle 1, 2, 3, ...")
        }
        return true
    }

    private fun sendDelayedMessages(messages: List<String>, delay: Long = 40L) { // time in ticks (40 ticks = 2 seconds)
        messages.forEachIndexed { index, message ->
            plugin.server.scheduler.runTaskLater(plugin, Runnable {
                Bukkit.broadcastMessage(message)
            }, delay * index)
        }
    }
}
