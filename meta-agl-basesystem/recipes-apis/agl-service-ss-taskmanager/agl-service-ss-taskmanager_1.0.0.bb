SUMMARY = "agl-service-ss-taskmanager for AGL software"
DESCRIPTION = "agl-service-ss-taskmanager to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common agl-basesystem-capability

CAPABILITY = "cap_sys_nice,cap_setuid,cap_setgid=ep:/usr/agl/bin/tskmgr"

FILES_${PN} += " \
    /usr/agl/bin/* \
"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/toyota.git;protocol=https;branch=sandbox/ToshikazuOhiwa/ss-taskmanager"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

# Common Dependencies
DEPENDS += " \
    os-rpclibrary-tool-native \
    ss-interfaceunified \
    ss-resourcemanager \
    ss-romaccesslibrary \
    ss-taskmanager \
    ns-frameworkunified \
    ns-commonlibrary \
    os-eventlibrary \
    os-rpclibrary \
    os-vehicleparameterlibrary \
    libxml2-native \
"
RDEPENDS_${PN} += " \
    ss-interfaceunified \
    ss-resourcemanager \
    ss-romaccesslibrary \
    ss-taskmanager \
    ns-frameworkunified \
    ns-commonlibrary \
    os-eventlibrary \
    os-rpclibrary \
    os-vehicleparameterlibrary \
"
EXTRA_MAKEFILE=" -f Makefile.server"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE} -j 1 'CXX=${CXX} -Wl,--warn-unresolved-symbols' 'CC=${CC} -Wl,--warn-unresolved-symbols'"
MAKE_DIR ="task_manager"

do_compile_prepend() {
    cd ${S}/${MAKE_DIR}
    oe_runmake -f Makefile.client
}

