# Copyright (C) 2017 Versalogic
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for Versalogic Tetra board"
DESCRIPTION = "Linux Kernel for Versalogic Tetra board."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

include linux-fslc.inc

#PV .= "+git${SRCPV}"
PV .= ""

SRCBRANCH = "krogoth"
LOCALVERSION = "-yocto"

#Always update SRCREV based on your last commit
#SRCREV = "aba8070ca2dbb941788a5f5eea714e3cf8a44b65"
SRCREV = "AUTOINC"


KERNEL_SRC ?= "git://github.com/Versalogic/linux-imx.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} file://defconfig"

COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-tetra|imx6s-tetra)"
