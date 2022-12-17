DESCRIPTION = "Linux Backports"
HOMEPAGE = "https://backports.wiki.kernel.org"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = "file://laird-backport-6.0.0.121.tar.gz"

S = "${WORKDIR}"

EXTRA_OEMAKE = "V=1 KLIB_BUILD=${STAGING_KERNEL_BUILDDIR} \
                KLIB=${base_libdir}/modules/${KERNEL_VERSION} \
		"

DEPENDS += "coreutils-native"

inherit module

FILES_${PN} += "${base_libdir}/kernel/net/bluetooth/bluetooth.ko"

EXCLUDE_FROM_WORLD = "1"

do_configure () {
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
