SUMMARY = "Example of how to build an external Linux kernel module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "file://Makefile \
           file://compat.ko \
           file://COPYING \
          "

S = "${WORKDIR}"

MODULES_MODULE_SYMVERS_LOCATION = "kernel/compat"

do_compile (){
    oe_runmake 'DESTDIR=${D}' modules_install
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

KERNEL_MODULE_AUTOLOAD = "compat"


