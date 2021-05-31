PROVIDES_remove = "udev"
RDEPENDS_${PN}_remove = "(= ${EXTENDPKGV})"
PACKAGES_remove = "udev udev-hwdb"
RRECOMMENDS_${PN}_remove = "udev-hwdb"
RDEPENDS_udev-hwdb = ""
FILES_udev = ""
FILES_udev-hwdb = ""

DEPENDS_append = " libudev-zero"

do_install_append(){
# remove libudev files
	rm ${D}${includedir}/libudev.h
	rm ${D}${datadir}/pkgconfig/udev.pc
	rm ${D}${libdir}/pkgconfig/libudev.pc
	rm ${D}${base_libdir}/libudev.so*

#remove udev files
	rm ${D}${base_sbindir}/udevd
	rm ${D}${rootlibexecdir}/systemd/network/99-default.link
	rm ${D}${rootlibexecdir}/systemd/systemd-udevd
	rm -r ${D}${rootlibexecdir}/udev/
	rm -r ${D}${sysconfdir}/udev
	if [ -s ${D}${sysconfdir}/init.d/systemd-udevd ]; then
		rm ${D}${sysconfdir}/init.d/systemd-udevd
	fi
	rm ${D}${systemd_unitdir}/system/*udev*
	rm ${D}${systemd_unitdir}/system/*.wants/*udev*
	rm ${D}${base_bindir}/systemd-hwdb
	rm ${D}${base_bindir}/udevadm
	rm ${D}${base_sbindir}/udevadm
	#rm ${D}${libexecdir}/${MLPREFIX}udevadm
	rm -r ${D}${libexecdir}
	rm ${D}${datadir}/bash-completion/completions/udevadm
	rm ${D}${systemd_unitdir}/system/systemd-hwdb-update.service
}
