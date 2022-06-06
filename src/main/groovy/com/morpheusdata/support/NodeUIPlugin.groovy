package com.morpheusdata.support

import com.morpheusdata.core.Plugin
import com.morpheusdata.model.Permission
import com.morpheusdata.model.OptionType
import com.morpheusdata.views.HandlebarsRenderer

class NodeUIPlugin extends Plugin {

	@Override
	String getCode() {
		return 'node-ui-integration'
	}

	@Override
	void initialize() {
		this.setRenderer(new HandlebarsRenderer(this.classLoader))
		this.controllers.add(new NodeUIController(this, morpheus))
		this.setName("Node UI Integration")
		this.setDescription("Node UI integration plugin")
	}

	@Override
	void onDestroy() {
	}

	@Override
	public List<Permission> getPermissions() {
		Permission permission = new Permission('Node UI Integation', 'nodeUIPlugin', [Permission.AccessType.none, Permission.AccessType.full])
		return [permission];
	}
}