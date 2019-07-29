/**
 * 
 */

function adminCheck() {
	var path = '';
	path = getContextPath();
	window.location.href = path + '/main.do';

}

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
}