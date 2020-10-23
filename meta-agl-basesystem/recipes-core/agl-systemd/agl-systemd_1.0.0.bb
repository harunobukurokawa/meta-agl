SUMMARY = "Systemd related file for launching sample application"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit systemd
S = "${WORKDIR}"
ALLOW_EMPTY_${PN} = "1"
BB_VERBOSE_LOGS = "1"

SRC_URI += " \
    file://LICENSE \
    file://env.txt \
    file://setup_refhw.service \
    file://launch_sm.service \
    file://systemd-udev-trigger.service \
    file://99-agl.rules \
    file://agl-trigger.service \
    file://options.conf \
    file://tool_9E_SI \
    file://usr \
"
FILES_${PN} += "\
    /tool_9E_SI/* \
    /usr/target/* \
    /usr/agl/* \
    /nv/* \
    /ramd/bkup \
    /etc/systemd/system/tmp.mount.d \
"
SYSTEMD_SERVICE_${PN} = " \
    setup_refhw.service \
    launch_sm.service \
    agl-trigger.service \
"
DEPENDS += " \
    libxml2-native \
    agl-basefiles-native \
"
RDEPENDS_${PN} += " \
    procps \
    agl-basefiles \
    bash \
"
do_compile[depends] += "agl-basefiles:do_populate_sysroot"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/setup_refhw.service ${D}/${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/agl-trigger.service ${D}/${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/launch_sm.service ${D}/${systemd_unitdir}/system
	install -d ${D}/etc/systemd/system
	install -m 644 ${WORKDIR}/systemd-udev-trigger.service ${D}/etc/systemd/system
	install -d ${D}/tool_9E_SI
	install -m 644 ${WORKDIR}/*.txt ${D}/tool_9E_SI
	install -m 755 ${WORKDIR}/tool_9E_SI/*.sh ${D}/tool_9E_SI
	install -d ${D}/usr/target 
	install -m 644 ${WORKDIR}/usr/target/*.lst ${D}/usr/target
	install -d ${D}/etc/systemd/system
        install -d ${D}/lib/udev/rules.d
	install -m 644 ${WORKDIR}/99-agl.rules ${D}/lib/udev/rules.d
	install -d -m 777 ${D}/nv/export
	install -d -m 777 ${D}/nv/backup
	install -d -m 777 ${D}/nv/log/frameworkunifiedlog
	install -d -m 777 ${D}/ramd/bkup
	install -d ${D}/etc/systemd/system/tmp.mount.d
	install -m 644 ${WORKDIR}/options.conf ${D}/etc/systemd/system/tmp.mount.d
}

sysroot_stage_all_append(){
	sysroot_stage_dir ${D}/tool_9E_SI ${SYSROOT_DESTDIR}/tool_9E_SI
	sysroot_stage_dir ${D}/usr/target ${SYSROOT_DESTDIR}/usr/target
	sysroot_stage_dir ${D}/usr/agl ${SYSROOT_DESTDIR}/usr/agl
	sysroot_stage_dir ${D}/nv/BS/ns/npp/rwdata ${SYSROOT_DESTDIR}/nv/BS/ns/npp/rwdata
	sysroot_stage_dir ${D}/etc/systemd/system/tmp.mount.d ${SYSROOT_DESTDIR}/etc/systemd/system/tmp.mount.d
}
