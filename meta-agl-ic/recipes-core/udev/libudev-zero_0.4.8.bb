SUMMARY = "Daemonless replacement for libudev"
HOMEPAGE = "https://github.com/illiliti/libudev-zero"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=69c8aad36ed352f4a792582e756ae5c6"

DEPENDS = ""

PROVIDES = "udev"

SRC_URI = "git://github.com/illiliti/libudev-zero.git \
           file://udev.pc \
           file://0001-Fix-install-path.patch \
          "

SRCREV = "1aef09bf8425b486ec6ceb536d3c5d0089d9e56d"

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
	
	install -m 0755 -d ${D}${datadir}/pkgconfig
	install -m 0644 ${WORKDIR}/udev.pc ${D}${datadir}/pkgconfig/
}

PACKAGES = "libudev1 udev libudev1-dev libudev1-staticdev libudev1-dbg"

FILES_udev         = ""
FILES_libudev1     = "${base_libdir}/libudev.so.*"
FILES_libudev1-dbg = "${base_libdir}/.debug/libudev.so.*"
FILES_libudev1-dev = "${datadir}/pkgconfig/udev.pc \
                      ${includedir}/libudev.h ${base_libdir}/libudev.so \
                      ${includedir}/udev.h ${base_libdir}/libudev.la \
                      ${libdir}/pkgconfig/libudev.pc"
FILES_libudev1-staticdev = "${base_libdir}/libudev.a"

ALLOW_EMPTY_udev = "1"
