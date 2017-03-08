DESCRIPTION = "RM board init script"
SECTION = "core"
LICENSE = "GPLv2"
PR = "r0"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=082b4b727e4aa05e111f61cd44674430"

SRC_URI = " \
    file://rminit.sh \
    file://exports \
    file://LICENSE.md \
"

S = "${WORKDIR}"

RDEPENDS_${PN} = " \
    ocs \
    rackmanager \
"

# This is purposely wrong to force update-rc.d to be installed in the rootfs.
INITSCRIPT_NAME = "rminit"
INITSCRIPT_PARAMS = "start 95 2 3 4 5 ."

inherit update-rc.d

do_install_append() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 rminit.sh ${D}${sysconfdir}/init.d
	update-rc.d -r ${D} ${INITSCRIPT_NAME}.sh ${INITSCRIPT_PARAMS}
	
	install -m 0755 exports ${D}${sysconfdir}/
}
