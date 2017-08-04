# Copyright (C) 2017 Versalogic 
# Based on u-boot-fslc.inc Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion

DEPENDS_mxs += "elftosb-native openssl-native"

SUMMARY = "U-Boot bootloader with support for Versalogic Tetra board"
DESCRIPTION = "U-Boot bootloader with support for Versalogic Tetra board. "

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx6ul|mx7|imx6q-tetra|imx6s-tetra"

PROVIDES += "u-boot"

# PV = "v2015.10+git${SRCPV}"

SRCBRANCH ??= "master"

SRC_URI = "git://github.com/Versalogic/uboot-imx.git;branch=${SRCBRANCH}"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "7d8ddd7de7b37753f5a2a8a0509af9c4134a67c3"

S = "${WORKDIR}/git"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

