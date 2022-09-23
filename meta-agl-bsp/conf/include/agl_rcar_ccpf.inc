#Keep this as a reminder
#This file is copied from meta-agl-bsp/meta-rcar-gen3-adas/conf/include/rcar-gen3-adas.inc
#MACHINEOVERRIDES .= ":kingfisher"
#PACKAGE_EXTRA_ARCHS:append = " kingfisher"

# Add a feature as a low-impact way to detect Kingfisher support in
# recipes.
AGL_FEATURES:append = " ccpfsk"

# Basic packages
IMAGE_INSTALL:append:ulcb = " \
	can-utils \
	iproute2 \
	ccpfsk-fancontrol \
	nvme-cli \
"

# Mask Chromium recipe
BBMASK .= "|chromium-ozone-wayland"

# Reference hardware has USB3
MACHINE_FEATURES:append = " usb3"

# Configuration for CSI cameras
# Enable a following line if camera0/camera1 connecters are used.
#USE_CSI_CAMERA = "1"

# Copied from packagegroup-gstreamer1.0-plugins.bbappend
#RDEPENDS_packagegroup-gstreamer1.0-plugins-base:append = " \
#        "gstreamer1.0-plugins-base-apps", \
#"

#RDEPENDS_packagegroup-gstreamer1.0-plugins-video:append = " \
#        gstreamer1.0-plugins-good-imagefreeze \
#        gstreamer1.0-plugins-bad-bayer \
#"

