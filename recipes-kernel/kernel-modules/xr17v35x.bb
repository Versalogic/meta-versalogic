SUMMARY = "AccessI/O mini-PCIe driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

#PV .= "+git${SRCPV}"

inherit module

SRC_URI = " file://xr17v35x.c \
            file://Makefile"

S = "${WORKDIR}"

KERNEL_MODULE_AUTOLOAD = "xr17v35x"

COMPATIBLE_MACHINE = "imx6qtetra"
