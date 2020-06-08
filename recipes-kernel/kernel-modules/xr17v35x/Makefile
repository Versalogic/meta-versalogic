#makefile for XR17v35x PCIe UARTs for Linux 2.6.32 and newer
#KERNEL_SRC = /lib/modules/`uname -r`/build

obj-m += xr17v35x.o

xrpci-objs :=	xr17v35x.o

EXTRA_CFLAGS +=  -DDEBUG=1

all:
	$(MAKE) -C $(KERNEL_SRC) M=$(PWD)

modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(PWD) modules_install
clean:
	rm -f *~ *.o
	rm -f *~ *.ko
