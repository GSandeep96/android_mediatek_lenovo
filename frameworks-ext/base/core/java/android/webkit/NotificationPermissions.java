package android.webkit;

import com.mediatek.common.featureoption.FeatureOption;

/**
 * HTML5 web notification
 *
 * This class is used to manage permissions for the WebView's Notification
 * JavaScript API.
 *
 * @author
 *
 * @hide
 * @internal
 */
public class NotificationPermissions {
    /**
     * A callback interface used by the host application to set the Notification
     * permission state for an origin.
     *
     * @hide
     * @internal
     */
    public interface Callback {
        /**
         * Sets the Notification permission state for the supplied origin.
         * 
         * @param origin the origin for which permissions are set
         * @param allow whether or not the origin should be allowed to use the
         *              Notification API
         * 
         * @internal
         */
        public void invoke(String origin, boolean allow);

        /**
         * When user open or close the notification, notify these events to webkit.
         * 
         * @param eventName the event name occured
         * @param pointer   notification id
         * 
         * @internal
         */
        public void invokeEvent(String eventName, int pointer);

        /**
         * Notify id and counter generated by app.
         * 
         * @param id        id generated by app
         * @param counter   notification coutner
         * 
         * @internal
         */
        public void invokeNotificationID(int id, int counter);
    }

    /**
     * Gets the singleton instance of this class.
     *
     * @return the singleton {@link NotificationPermissions} instance
     *         If do not support notification, return null.
     *
     * @internal
     */
    public static NotificationPermissions getInstance() {
        if (!FeatureOption.MTK_WEB_NOTIFICATION_SUPPORT) {
            return null;
        }

      return WebViewFactory.getProvider().getNotificationPermissions();
    }

    /**
     * Clears the Notification permission state for all origins.
     * 
     * @internal
     */
    public void clearAll() {
        // Must be a no-op for backward compatibility: see the hidden constructor for reason.
    }
}
