SUMMARY = "Kernel warnings for potential UEFI firmware bugs"
DESCRIPTION = "Simple tool to look for warnings generated by the Linux kernel \
when it finds potential UEFI firmware bugs"
HOMEPAGE = "https://www.kernel.org/pub/linux/kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://kernel-efi-warnings \
           file://luv-parser-kernel-efi-warnings \
          "
DEPENDS = "grep"

inherit luv-test

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${WORKDIR}/kernel-efi-warnings ${D}${bindir}
}

LUV_TEST_LOG_PARSER="luv-parser-kernel-efi-warnings"
LUV_TEST="kernel-efi-warnings"
LUV_TEST_ARGS=""