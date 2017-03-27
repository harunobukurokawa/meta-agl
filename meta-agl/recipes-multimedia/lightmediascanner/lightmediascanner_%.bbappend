# Disable everything but the roygalty-free formats
PACKAGECONFIG = "ogg flac wave m3u pls jpeg png"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://lightmediascanner.service \
            file://plugin-ogg-fix-chucksize-issue.patch \
            file://lightmediascanner.rules \
            file://lightmediascanner.sh \
           "

inherit systemd

do_install_append() {
       # Install LMS systemd service
       if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
              install -m 644 -p -D ${WORKDIR}/lightmediascanner.service ${D}${systemd_user_unitdir}/lightmediascanner.service

              # Execute these manually on behalf of systemctl script (from systemd-systemctl-native.bb)
              # because it does not support systemd's user mode.
              mkdir -p ${D}/etc/systemd/user/default.target.wants/
              ln -sf ${systemd_user_unitdir}/lightmediascanner.service ${D}/etc/systemd/user/dbus-org.lightmediascanner.service
              ln -sf ${systemd_user_unitdir}/lightmediascanner.service ${D}/etc/systemd/user/default.target.wants/lightmediascanner.service
       fi

       if ${@bb.utils.contains('DISTRO_FEATURES', 'automount', 'true', 'false', d)}; then
              install -m 644 -p -D ${WORKDIR}/lightmediascanner.rules ${D}/etc/udev/rules.d/lightmediascanner.rules
              install -m 755 -p -D ${WORKDIR}/lightmediascanner.sh ${D}/etc/udev/scripts/lightmediascanner.sh
       fi
}

FILES_${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${systemd_user_unitdir}/lightmediascanner.service', '', d)} \
    "
