SUMMARY = "Simple benchmark for single board computers "
HOMEPAGE = "https://github.com/ThomasKaiser/sbc-bench"
BUGTRACKER = "https://github.com/ThomasKaiser/sbc-bench/issues"

LICENSE = "BSD3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0cd3e019b4a96d1582507148ebe7592a"

SRC_URI = "git://github.com/ThomasKaiser/sbc-bench.git;protocol=https"
SRCREV = "2d8fcf07e29ef2ded7800a99415ee0dfa689c6c0"
S = "${WORKDIR}/git"

RDEPENDS_${PN} += "mhz tinymembench sysstat p7zip openssl cpuminer-multi bash"

do_compile[noexec] = "1"

do_install () {
    sed -i -e 's,"${InstallLocation}"/cpuminer-multi,/usr/bin,g' \
      -e 's,"${InstallLocation}"/tinymembench,/usr/bin,g' \
      -e 's,"${InstallLocation}"/mhz,/usr/sbin,g' \
      ${S}/sbc-bench.sh

    install -d ${D}${bindir}
    install -Dm 0755 ${S}/sbc-bench.sh ${D}${bindir}/
}

FILES_${PN} += "\
  ${bindir}/sbc-bench.sh \
"
