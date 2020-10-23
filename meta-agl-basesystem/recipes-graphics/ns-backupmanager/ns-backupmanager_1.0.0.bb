SUMMARY = "ns-backupmanager for AGL software"
DESCRIPTION = "ns-backupmanager to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common

FILES_${PN} += " \
    /usr/agl/lib/* \
    /usr/agl/conf/BS/ns/backup_manager/rodata/* \
"
FILES_${PN}-dev += "/usr/agl/include/*"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/toyota.git;protocol=https;branch=sandbox/ToshikazuOhiwa/ns-backupmanager"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " \
    libxml2-native \
    ns-frameworkunified \
    libnv-hal \
"
RDEPENDS_${PN} += " \
    ns-frameworkunified \
    libnv-hal \
"
EXTRA_MAKEFILE=" -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"
MAKE_DIR ="backup_manager"

