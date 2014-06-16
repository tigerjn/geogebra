package geogebra.html5.gui.laf;

import geogebra.common.main.App;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Timer;


/**
 * @author geogebra
 * Look and Feel for SMART
 *
 */
public class OfficeLookAndFeel extends SmartLookAndFeel{
	
	@Override
    public boolean undoRedoSupported() {
	    return true;
    }
	
	@Override
    public boolean isSmart() {
		return false;
	}

	@Override
    public String getType() {
	    return "office";
    }

	
	@Override
	public void login(final App app, String loginURL) {
		app.getDialogManager().showLogInDialog();
		Timer loginChecker = new Timer(){
			private String oldCookie = null;
			@Override
            public void run() {
				String cookie = Cookies.getCookie("SSID");
				if(cookie != null && !cookie.equals(oldCookie)){
		    		if(app.getLoginOperation().performCookieLogin(cookie)){
		    			cancel();
		    		}
		    		this.oldCookie = cookie;
				}
            }};
        loginChecker.scheduleRepeating(2000);
    }
}
