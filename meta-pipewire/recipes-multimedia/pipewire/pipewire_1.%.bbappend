PACKAGECONFIG:class-target = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluez5', 'bluez', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'alsa pipewire-alsa', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'sndfile pw-cat readline', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd systemd-system-service', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'libcamera', 'libcamera', '', d)} \
    gstreamer v4l2 wireplumber \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Fixes the spa-libcamera plugin build against libcamera's Model control,
# which is a std::string_view (see property_ids.h) rather than a
# std::string. Only relevant when PACKAGECONFIG[libcamera] is enabled
# above, so it's a no-op patch-wise on machines without it (the plugin
# directory isn't even compiled) but harmless to always list.
SRC_URI:append = " file://0001-spa-libcamera-fix-build-against-libcamera-Model-str.patch"
