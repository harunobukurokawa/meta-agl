# On machines that advertise MACHINE_FEATURES += " libcamera" (see
# meta-agl-bsp's conf/include/agl_<machine>.inc), pipewire's own
# PACKAGECONFIG[libcamera] adds a DEPENDS on libcamera (see this layer's
# pipewire_1.%.bbappend). libcamera itself DEPENDS on libsdl2, and SDL2's
# default PACKAGECONFIG pulls in pipewire for its own audio backend when
# DISTRO_FEATURES has "pipewire" -- closing a build cycle:
#   libcamera -> libsdl2 -> pipewire -> libcamera
# Drop SDL2's pipewire audio backend on those machines to break the loop.
# SDL2 apps still get audio via alsa/pulseaudio (pipewire-pulse emulation).
PACKAGECONFIG:remove = "${@bb.utils.contains('MACHINE_FEATURES', 'libcamera', 'pipewire', '', d)}"
