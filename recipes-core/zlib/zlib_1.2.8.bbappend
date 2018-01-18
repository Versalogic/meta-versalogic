FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI := "https://zlib.net/fossils/${BPN}-${PV}.tar.gz \
           file://remove.ldconfig.call.patch \
           file://Makefile-runtests.patch \
           file://ldflags-tests.patch \
           file://run-ptest \
           "

SRC_URI[md5sum] := "44d667c142d7cda120332623eab69f40"
SRC_URI[sha256sum] := "36658cb768a54c1d4dec43c3116c27ed893e88b02ecfcb44f2166f9c0b7f2a0d"

