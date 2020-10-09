SUMMARY = "agl-service-ns-backupmanager for AGL software"
DESCRIPTION = "agl-service-ns-backupmanager to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common agl-basesystem-capability

CAPABILITY = "cap_dac_override+ep:/usr/agl/bin/NS_BackupMgr"

FILES_${PN} += " \
    /usr/agl/conf/backup_manager/* \
    /usr/agl/bin/* \
"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/toyota.git;protocol=https;branch=sandbox/ToshikazuOhiwa/ns-backupmanager"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " \
    libxml2-native \
    ns-frameworkunified \
    ns-backupmanager \
    ss-interfaceunified \
    ss-romaccesslibrary \
"
RDEPENDS_${PN} += " \
    ns-frameworkunified \
    ns-backupmanager \
    ss-interfaceunified \
    ss-romaccesslibrary \
"
EXTRA_MAKEFILE = " -f Makefile.server"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"
MAKE_DIR = "backup_manager"


