require conf/include/agl_ulcb.inc
SOC_FAMILY = "r8a77990"
MACHINE = "ebisu"

DISTRO_FEATURES_remove = " use_eva_pkg"

# Configuration for USB 3.0
MACHINE_FEATURES_append = " usb3"
