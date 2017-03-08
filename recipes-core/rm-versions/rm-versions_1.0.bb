DESCRIPTION = "Get RM version info"
SECTION = "core"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=082b4b727e4aa05e111f61cd44674430"

PR = "r0"

SRC_URI =  "file://rmversions.sh \
			file://pkg-info \
			file://rfs-info \
			file://LICENSE.md"

S = "${WORKDIR}"

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/
    install -m 0755 ${S}/rmversions.sh ${D}${sysconfdir}/
    install -m 0744 ${S}/pkg-info ${D}${sysconfdir}/
	install -m 0744 ${S}/rfs-info ${D}${sysconfdir}/
}

