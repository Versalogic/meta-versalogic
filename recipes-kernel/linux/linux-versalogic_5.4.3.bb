# Copyright (C) 2017 Versalogic
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"

SUMMARY = "Linux Kernel for Versalogic i.MX6 board"
DESCRIPTION = "Linux Kernel for Versalogic i.MX6 board."

require recipes-kernel/linux/linux-imx.inc
#require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "5.4.3-1.0.0-versalogic"
LOCALVERSION = "-versalogic"

#Always update SRCREV based on your last commit
#SRCREV = "aba8070ca2dbb941788a5f5eea714e3cf8a44b65"
SRCREV = "AUTOINC"

FSL_KERNEL_DEFCONFIG = "${BUILDDIR}/../meta-versalogic/recipes-kernel/linux/linux-versalogic/defconfig"
KERNEL_SRC = "https://github.com/Versalogic/linux-versalogic;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} file://defconfig"
#SRC_URI += " file://dts.patch "


COMPATIBLE_MACHINE = "(imx6qtetra|imx6zebra|imx6swordtail)"
