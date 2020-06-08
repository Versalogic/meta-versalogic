**How to Compile and Install the MaxLinear driver module (xr17v35x.ko) in Ubuntu Linux**

This driver supports the following Acces I/O cards:
P104-COM232-8

The first thing to do is to download and install the current Linux kernel headers.
```bash
	sudo apt-get install linux-headers-$(uname -r)
```
The kernel headers should now be installed at /usr/src/linux-headers-$(uname -r)

Note that "uname -r" produces the current Linux kernel version name (i.e. 5.0.0-23-generic).

Also notice that in Ubuntu Linux there is no administrator account and all activities requiring root user privileges must done using "sudo".
 
Next, the driver sources need to be downloaded from the github repository.
``` bash
	cd ~
	git clone https://github.com/accesio/AIOSerial.git
```
Then we need to compile them.
```bash
	cd AIOSerial/XR/
	make
```	
The XR directory should now include the compiled driver module "xr17v35x.ko".

Now we can load the driver module and use it.
```bash
	sudo insmod xr17v35x.ko
```
There should now be device nodes in /dev named: ttyXR* that can be used to access the card's serial ports.

The automated way to load (install) the driver module is to copy it to the /lib/modules/$(uname -r)/ directory so that the Linux kernel can find it at boot time.

In the /lib/modules/$(uname -r) directory, create a sub-directory named "extra" (for external modules). Then copy the driver module (xr17v35x.ko) from the XR directory to the "extra" directory.
```bash
	cd /lib/modules/$(uname -r)
	sudo mkdir extra

	cd extra
	sudo cp ~/XR/xr17v35x.ko .
```
Now we need to specify that we want the xr17v35x.ko driver module to be loaded at boot time. For that we need to modify the modules.conf file in the /etc/modules-load.d/ directory.
```bash
	cd /etc/modules-load.d
	sudo vi modules.conf
```
 (add the driver module name "xr17v35x" to the end of the comments section)

The kernel should now be able to load the xr17v35x.ko driver module at boot time.

To use the driver we need to first identify the location on the PCI bus that our serial card is using.

We do this by looking at the output of the lspci command.
```bash
	jimmy@jimmy-desktop:~$ lspci
	00:00.0 Host bridge: Intel Corporation 82G33/G31/P35/P31 Express DRAM Controller (rev 10)
	00:01.0 PCI bridge: Intel Corporation 82G33/G31/P35/P31 Express PCI Express Root Port (rev 10)
	00:02.0 VGA compatible controller: Intel Corporation 82G33/G31 Express Integrated Graphics Controller (rev 10)
	00:1c.0 PCI bridge: Intel Corporation NM10/ICH7 Family PCI Express Port 1 (rev 01)
	00:1c.1 PCI bridge: Intel Corporation NM10/ICH7 Family PCI Express Port 2 (rev 01)
	00:1d.0 USB controller: Intel Corporation NM10/ICH7 Family USB UHCI Controller #1 (rev 01)
	00:1d.1 USB controller: Intel Corporation NM10/ICH7 Family USB UHCI Controller #2 (rev 01)
	00:1d.2 USB controller: Intel Corporation NM10/ICH7 Family USB UHCI Controller #3 (rev 01)
	00:1d.3 USB controller: Intel Corporation NM10/ICH7 Family USB UHCI Controller #4 (rev 01)
	00:1d.7 USB controller: Intel Corporation NM10/ICH7 Family USB2 EHCI Controller (rev 01)
	00:1e.0 PCI bridge: Intel Corporation 82801 PCI Bridge (rev e1)
	00:1f.0 ISA bridge: Intel Corporation 82801GB/GR (ICH7 Family) LPC Interface Bridge (rev 01)
	00:1f.1 IDE interface: Intel Corporation 82801G (ICH7 Family) IDE Controller (rev 01)
	00:1f.2 IDE interface: Intel Corporation NM10/ICH7 Family SATA Controller [IDE mode] (rev 01)
	00:1f.3 SMBus: Intel Corporation NM10/ICH7 Family SMBus Controller (rev 01)
	03:00.0 Ethernet controller: Realtek Semiconductor Co., Ltd. RTL8111/8168/8411 PCI Express Gigabit Ethernet Controller (rev 01)
	04:06.0 Serial controller: ACCES I/O Products, Inc. P104-COM232-8 8x RS232 PC-104+ Board (rev 09)
```
From the output of lspci we can see that our card is identified as:
```bash
	04:06.0 Serial controller: ACCES I/O Products, Inc. P104-COM232-8 8x RS232 PC-104+ Board (rev 09)
```
Using this information we can now locate the serial ports implemented by our card in the kernel message buffer (dmesg).
```bash
	jimmy@jimmy-desktop:~$ dmesg | grep ttyXR*
	[  779.340648] 0000:04:06.0: ttyXR0 at MMIO 0xff707000 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.341482] 0000:04:06.0: ttyXR1 at MMIO 0xff707200 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.343977] 0000:04:06.0: ttyXR2 at MMIO 0xff707400 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.344120] 0000:04:06.0: ttyXR3 at MMIO 0xff707600 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.344236] 0000:04:06.0: ttyXR4 at MMIO 0xff707800 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.344347] 0000:04:06.0: ttyXR5 at MMIO 0xff707a00 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.344459] 0000:04:06.0: ttyXR6 at MMIO 0xff707c00 (irq = 21, base_baud = 921600) is a XR17v35x
	[  779.344572] 0000:04:06.0: ttyXR7 at MMIO 0xff707e00 (irq = 21, base_baud = 921600) is a XR17v35x
	jimmy@jimmy-desktop:~$ 
```
The serial ports shown should now have devices nodes in /dev and we can begin to make use of them.

Any terminal emulator program can be used to communicate with the serial ports. I used "seyon" for my testing purposes.
```bash
	jimmy@jimmy-desktop:~$ seyon -modems /dev/ttyXR0
```
