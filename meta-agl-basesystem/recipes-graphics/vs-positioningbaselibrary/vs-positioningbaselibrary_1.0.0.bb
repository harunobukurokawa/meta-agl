SUMMARY = "vs-positioningbaselibrary for AGL software"
DESCRIPTION = "vs-positioningbaselibrary to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common
FILES_${PN} += " \
    /usr/agl/lib/* \
    /nv/BS/vs/positioning_base_library/* \
"
FILES_${PN}-dev += "/usr/agl/include/*"


SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/toyota.git;protocol=https;branch=sandbox/ToshikazuOhiwa/vs-positioningbaselibrary"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " \
    ns-frameworkunified \
    os-eventlibrary \
    os-vehicleparameterlibrary \
"
RDEPENDS_${PN} += " \
    ns-frameworkunified \
    os-eventlibrary \
    os-vehicleparameterlibrary \
"

EXTRA_MAKEFILE=" -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"
MAKE_DIR ="positioning_base_library"

