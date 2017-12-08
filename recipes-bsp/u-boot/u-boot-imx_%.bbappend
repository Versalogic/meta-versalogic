# Copyright (C) 2017 Versalogic 
# Based on u-boot-fslc.inc Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

#require recipes-bsp/u-boot/u-boot.inc
#inherit fsl-u-boot-localversion

DEPENDS_mxs += "elftosb-native openssl-native"

SUMMARY = "U-Boot bootloader with support for Versalogic i.MX6 board"
DESCRIPTION = "U-Boot bootloader with support for Versalogic i.MX6 board. "

LICENSE = "GPLv2+"
#LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx6ul|mx7|imx6qtetra|imx6solozebra|imx6dlzebra)"

PROVIDES += "u-boot"

# PV = "v2015.10+git${SRCPV}"

SRCBRANCH = "master"

SRC_URI = "git://github.com/Versalogic/u-boot-imx.git;branch=${SRCBRANCH};protocol=git"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "AUTOINC"

S = "${WORKDIR}/git"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

