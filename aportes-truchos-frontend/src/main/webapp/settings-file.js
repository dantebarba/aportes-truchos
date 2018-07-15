/**
 * 
 */

function protocol() {
	return window.location.protocol;
}

function settingsUrl() {
	return protocol()  + "//" + ${api.url};
}

