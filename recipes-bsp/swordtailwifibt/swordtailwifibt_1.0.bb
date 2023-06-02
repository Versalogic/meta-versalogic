SUMMARY = "Wifi and BT files"
DESCRIPTION = "Adds wifi and bt files to swordtail image."

LICENSE = "CLOSED"
PV = "1.0"

SRC_URI += "file://usr"
SRC_URI += "file://lib"


do_install() {
cp -r ${WORKDIR}/usr ${D}/
cp -r ${WORKDIR}/lib ${D}/
}

FILES:${PN} += "/"

