SUMMARY = "vs-positioning for AGL software"
DESCRIPTION = "vs-positioning to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common

FILES_${PN} += " \
    /usr/agl/lib/* \
"
FILES_${PN}-dev += "/usr/agl/include/*"
 
FILES_${PN}-staticdev = "/usr/agl/lib/*.a"
 
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/toyota.git;protocol=https;branch=sandbox/ToshikazuOhiwa/vs-positioning"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " \
    ns-frameworkunified \
    os-vehicleparameterlibrary \
    vs-positioningbaselibrary \
    libpositioning-hal \
"
RDEPENDS_${PN} += " \
    ns-frameworkunified \
    os-vehicleparameterlibrary \
    vs-positioningbaselibrary \
    libpositioning-hal \
"
EXTRA_MAKEFILE=" -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}  -j 1 'CXX=${CXX} -Wl,--warn-unresolved-symbols' 'CC=${CC} -Wl,--warn-unresolved-symbols'"
MAKE_DIR ="positioning"


