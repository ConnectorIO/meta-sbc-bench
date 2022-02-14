SUMMARY = "CPU frequency measurement utility"
HOMEPAGE = "https://github.com/wtarreau/mhz"
BUGTRACKER = "https://github.com/wtarreau/mhz/issues"

# License is undefined
LICENSE = "Custom"

SRC_URI = " \
    git://github.com/wtarreau/mhz.git;protocol=https \
    file://Makefile \
"
SRCREV = "d1ed90e3523ab0300d6e7960eaaa49ef8c41845d"
S = "${WORKDIR}/git"


do_populate_lic[noexec] = "1"

# Copy our makefile which has all the flags to make cross compile work
do_patch() {
    cp ${WORKDIR}/Makefile ${S}/
}

do_install () {
    oe_runmake install DESTDIR=${D}
    install -d ${D}${bindir}
    install -Dm 0755 ${S}/mhz ${D}${bindir}/
}

FILES_${PN} += "\
  ${bindir}/mhz \
"
