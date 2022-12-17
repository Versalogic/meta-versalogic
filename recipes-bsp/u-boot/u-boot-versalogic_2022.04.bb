# Copyright (C) 2017 Versalogic 
# Based on u-boot-fslc.inc Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion

DEPENDS += "flex-native bison-native bc-native dtc-native gnutls-native"

SUMMARY = "U-Boot bootloader with support for Versalogic i.MX6 board"
DESCRIPTION = "U-Boot bootloader with support for Versalogic i.MX6 board. "

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

COMPATIBLE_MACHINE = "(imx6qtetra|imx6zebra|imx6swordtail)"

PROVIDES += "u-boot virtual/bootloader u-boot-versalogic" 

#PV = "v2017.03+git${SRCPV}"

SRCBRANCH = "2022.04-versalogic"
LOCALVERSION = "-versalogic"

SRC_URI = "git://github.com/nbinford-versalogic/u-boot-versalogic.git;branch=${SRCBRANCH};protocol=https"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

PACKAGE_ARCH = "${MACHINE_ARCH}"

