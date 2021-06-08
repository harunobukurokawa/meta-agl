DESCRIPTION = "AGL IC Cluster API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
           file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984 \
"

DEPENDS = " libclusteripc"

RDEPENDS_${PN} = " libclusteripc"

S = "${WORKDIR}/git"
BRANCH = "main"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/agl-ic-eg/cluster_api;protocol=https;branch=${BRANCH}"

EXTRA_OECMAKE_append = " \
        -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
"

inherit cmake pkgconfig

