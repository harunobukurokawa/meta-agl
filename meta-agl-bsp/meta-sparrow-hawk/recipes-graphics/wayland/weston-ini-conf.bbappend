FILESEXTRAPATHS:prepend:rcar-gen3 := "${THISDIR}/${PN}:"

SRC_URI:append:rcar-gen3 = " \
	file://sparrow-hawk_output.cfg \
"

WESTON_FRAGMENTS:append:sparrowhawk = " sparrow-hawk_output"

do_configure:append() {
    echo repaint-window=34 >> ${WORKDIR}/core.cfg
}
