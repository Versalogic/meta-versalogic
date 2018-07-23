# Copyright (C) 2017 Versalogic 
# Based on u-boot-fslc.inc Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion

# DEPENDS_mxs += "elftosb-native openssl-native"

SUMMARY = "U-Boot bootloader with support for Versalogic i.MX6 board"
DESCRIPTION = "U-Boot bootloader with support for Versalogic i.MX6 board. "

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

COMPATIBLE_MACHINE = "(imx6qtetra|imx6zebra)"

PROVIDES += "u-boot"

#PV = "v2016.03+git${SRCPV}"

SRCBRANCH = "2017.03-1.0.0-versalogic"
LOCALVERSION = "-1.0.0-versalogic"

SRC_URI = "git://github.com/Versalogic/u-boot-versalogic.git;branch=${SRCBRANCH};protocol=git"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "AUTOINC"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

