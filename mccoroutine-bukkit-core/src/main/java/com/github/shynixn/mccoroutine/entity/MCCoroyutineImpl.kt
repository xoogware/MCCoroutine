package com.github.shynixn.mccoroutine.entity

import com.github.shynixn.mccoroutine.contract.CoroutineSession
import com.github.shynixn.mccoroutine.contract.MCCoroutine
import com.github.shynixn.mccoroutine.listener.PluginListener
import org.bukkit.plugin.Plugin

internal class MCCoroyutineImpl : MCCoroutine {
    private val items = HashMap<Plugin, CoroutineSession>()

    /**
     * Get coroutine session for the given plugin.
     */
    override fun getCoroutineSession(plugin: Plugin): CoroutineSession {
        if (!items.containsKey(plugin)) {
            startCoroutineSession(plugin)
        }

        return items[plugin]!!
    }

    /**
     * Disables coroutine for the given plugin.
     */
    override fun disable(plugin: Plugin) {
        if (!items.containsKey(plugin)) {
            return
        }

        val session = items[plugin]!!
        session.dispose()
        items.remove(plugin)
    }

    /**
     * Starts a new coroutine session.
     */
    private fun startCoroutineSession(plugin: Plugin) {
        val pluginListener = PluginListener(this, plugin)
        items[plugin] = CoroutineSessionImpl(plugin)
        plugin.server.pluginManager.registerEvents(pluginListener, plugin)
    }
}
