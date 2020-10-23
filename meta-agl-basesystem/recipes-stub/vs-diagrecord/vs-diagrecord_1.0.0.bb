SUMMARY = "vs-diagrecord for AGL software"
DESCRIPTION = "vs-diagrecord to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common
FILES_${PN} += " /usr/agl/lib/* "
FILES_${PN}-dev += "/usr/agl/include/*"

FILES_${PN}-staticdev = "/usr/agl/lib/*.a"
 
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/toyota.git;protocol=https;branch=sandbox/ToshikazuOhiwa/stub"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " ns-frameworkunified"

MAKE_DIR ="diag_record"

EXTRA_MAKEFILE = " -f Makefile"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"

