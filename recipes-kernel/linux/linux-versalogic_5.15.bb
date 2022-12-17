# Copyright (C) 2022 Versalogic
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"

SUMMARY = "Linux Kernel for Versalogic i.MX6 board"
DESCRIPTION = "Linux Kernel for Versalogic i.MX6 board."

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc
#require recipes-kernel/linux/linux-dtb.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "5.15-versalogic"
LOCALVERSION = "-versalogic"
#Always update SRCREV based on your last commit
#SRCREV = "b89386b65491eb176923d6150a7088dbb4f3cc55"
SRCREV = "${AUTOREV}"

KERNEL_SRC = "git://github.com/nbinford-versalogic/linux-versalogic;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} "

#SRC_URI:append = " file://versalogic_defconfig"

LINUX_VERSION = "5.15.32"

S = "${WORKDIR}/git"

KERNEL_VERSION_SANITY_SKIP = "1"

COMPATIBLE_MACHINE = "(imx6qtetra|imx6zebra|imx6swordtail)"

KBUILD_DEFCONFIG ?= "versalogic_defconfig"

#addtask copy_defconfig after do_kernel_configme before do_kernel_localversion
#do_copy_defconfig () {
#    install -d ${B}
#    mkdir -p ${B}
#    cp ${S}/arch/arm/configs/versalogic_defconfig ${B}/.config
