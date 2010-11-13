on growl(titleParam, descriptionParam, iconParam)
	tell application "GrowlHelperApp"
		--	set the titleParam to "foo"
		--	set the descriptionParam to "bar"
		--	set the iconParam to "Eclipse"
		set the applicationName to "JavaApplicationNotifier"
		set the defaultList to "JavaGrowlList"
		set the allNotificationsList to {defaultList}
		set the enabledNotificationsList to {defaultList}
		register as application applicationName all notifications allNotificationsList default notifications enabledNotificationsList icon of application iconParam
		notify with name defaultList title titleParam description descriptionParam application name applicationName
	end tell
end growl