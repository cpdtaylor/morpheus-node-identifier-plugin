package com.morpheusdata.support

import com.morpheusdata.model.Permission
import com.morpheusdata.views.JsonResponse
import com.morpheusdata.views.ViewModel
import com.morpheusdata.web.PluginController
import com.morpheusdata.web.Route
import com.morpheusdata.core.Plugin
import com.morpheusdata.core.MorpheusContext
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class NodeUIController implements PluginController {

	MorpheusContext morpheusContext
	Plugin plugin

	public NodeUIController(Plugin plugin, MorpheusContext morpheusContext) {
		this.plugin = plugin
		this.morpheusContext = morpheusContext
	}

	@Override
	public String getCode() {
		return 'nodeUIController'
	}

	@Override
	String getName() {
		return 'Node UI Controller'
	}

	@Override
	MorpheusContext getMorpheus() {
		return morpheusContext
	}

	List<Route> getRoutes() {
		[
			Route.build("/ping", "ping", [Permission.build("nodeUIPlugin", "full")])
		]
	}

	def ping(ViewModel <Map> model){
		def rtn = [:]
		rtn.hostName = java.net.InetAddress.getLocalHost().getHostName()
		rtn.ipAddress = java.net.InetAddress.getLocalHost().getHostAddress()
		return JsonResponse.of(rtn)
	}
}