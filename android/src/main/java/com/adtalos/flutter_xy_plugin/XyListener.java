package com.adtalos.flutter_xy_plugin;

import java.util.HashMap;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.xy.DefaultCustomListener;
import io.flutter.plugin.xy.Listener;
import io.flutter.plugin.xy.VideoController;
import io.flutter.plugin.xy.VideoListener;

class XyListener implements Listener, VideoListener, DefaultCustomListener {
    private MethodChannel channel;
    private String id;
    private HashMap<String, Object> defaultArguments;

    XyListener(MethodChannel channel, final String id) {
        this.channel = channel;
        this.id = id;
        defaultArguments = new HashMap<String, Object>() {{
            put("id", id);
        }};
    }

    @Override
    public void on(final String name, final String data) {
        if (channel != null) {
            channel.invokeMethod("onCustom", new HashMap<String, Object>() {{
                put("id", id);
                put("name", name);
                put("data", data);
            }});
        }
    }

    @Override
    public void onRendered() {
        if (channel != null) {
            channel.invokeMethod("onRendered", defaultArguments);
        }
    }

    @Override
    public void onImpressionFinished() {
        if (channel != null) {
            channel.invokeMethod("onImpressionFinished",
                    defaultArguments);
        }
    }

    @Override
    public void onImpressionFailed() {
        if (channel != null) {
            channel.invokeMethod("onImpressionFailed",
                    defaultArguments);
        }
    }

    @Override
    public void onImpressionReceivedError(final int errorCode, final String description) {
        if (channel != null) {
            channel.invokeMethod("onImpressionReceivedError",
                    new HashMap<String, Object>() {{
                        put("id", id);
                        put("error", errorCode + ":" + description);
                    }});
        }
    }

    @Override
    public void onLoaded() {
        if (channel != null) {
            channel.invokeMethod("onLoaded",
                    defaultArguments);
        }
    }

    @Override
    public void onFailedToLoad(final Exception e) {
        if (channel != null) {
            channel.invokeMethod("onFailedToLoad",
                    new HashMap<String, Object>() {{
                        put("id", id);
                        put("error", e.getMessage());
                    }});
        }
    }

    @Override
    public void onOpened() {
        if (channel != null) {
            channel.invokeMethod("onOpened",
                    defaultArguments);
        }
    }

    @Override
    public void onClicked() {
        if (channel != null) {
            channel.invokeMethod("onClicked",
                    defaultArguments);
        }
    }

    @Override
    public void onLeftApplication() {
        if (channel != null) {
            channel.invokeMethod("onLeftApplication",
                    defaultArguments);
        }
    }

    @Override
    public void onClosed() {
        if (channel != null) {
            channel.invokeMethod("onClosed",
                    defaultArguments);
        }
    }

    @Override
    public void onVideoLoad(final VideoController.Metadata metadata) {
        if (channel != null) {
            channel.invokeMethod("onVideoLoad", new HashMap<String, Object>() {{
                put("id", id);
                put("metadata", new HashMap<String, Object>() {{
                    put("currentTime", metadata.getCurrentTime());
                    put("duration", metadata.getDuration());
                    put("videoWidth", metadata.getVideoWidth());
                    put("videoHeight", metadata.getVideoHeight());
                    put("autoplay", metadata.isAutoplay());
                    put("muted", metadata.isMuted());
                    put("volume", metadata.getVolume());
                    put("type", metadata.getType());
                    put("status", metadata.getStatus());
                    put("ended", false);
                }});
            }});
        }
    }

    @Override
    public void onVideoStart() {
        if (channel != null) {
            channel.invokeMethod("onVideoStart",
                    defaultArguments);
        }
    }

    @Override
    public void onVideoPlay() {
        if (channel != null) {
            channel.invokeMethod("onVideoPlay",
                    defaultArguments);
        }
    }

    @Override
    public void onVideoPause() {
        if (channel != null) {
            channel.invokeMethod("onVideoPause",
                    defaultArguments);
        }
    }

    @Override
    public void onVideoEnd() {
        if (channel != null) {
            channel.invokeMethod("onVideoEnd",
                    defaultArguments);
        }
    }

    @Override
    public void onVideoVolumeChange(final double volume, final boolean muted) {
        if (channel != null) {
            channel.invokeMethod("onVideoVolumeChange",
                    new HashMap<String, Object>() {{
                        put("id", id);
                        put("volume", volume);
                        put("muted", muted);
                    }});
        }
    }

    @Override
    public void onVideoTimeUpdate(final double currentTime, final double duration) {
        if (channel != null) {
            channel.invokeMethod("onVideoTimeUpdate",
                    new HashMap<String, Object>() {{
                        put("id", id);
                        put("currentTime", currentTime);
                        put("duration", duration);
                    }});
        }
    }

    @Override
    public void onVideoError() {
        if (channel != null) {
            channel.invokeMethod("onVideoError",
                    defaultArguments);
        }
    }

    @Override
    public void onVideoBreak() {
        if (channel != null) {
            channel.invokeMethod("onVideoBreak",
                    defaultArguments);
        }
    }

}
