# VS Practical Exam 1
(c) 2015 by CaDS Haw Hamburg

## Info
Includes the files to start with the VS practical exam part 1

Contact: Martin.Becke@haw-hamburg.de

Visit: http://cads.informatik.haw-hamburg.de


## For more lecture information see
https://github.com/Transport-Protocol/CaDSPracticalExamVS/wiki

## HAW Internal Usage
### VS-FAQ
#### Linux image for raspberry pi
- Backup SD card as image file:
```bash
sudo dd if=/dev/diskN of=sdcard.img bs=1m
```
Note: N is the number of the disk to backup

- Write image on SD card (MAC):
```bash
diskutil unmountDisk /dev/diskN
sudo dd of=/dev/diskN if=sdcard.img bs=1m
```
Note: N is the number of the disk to override (Warning: Current data on /dev/diskN will be lost!)

- Config IP (simple)
```bash
dwc_otg.lpm_enable=0 console=ttyAMA0,115200 console=tty1 root=/dev/mmcblk0p2 rootfstype=ext4 elevator=deadline fsck.repair=yes rootwait ip=172.16.1.61::172.16.1.140:255.255.255.0:rpi:eth0:off
```

- Access
```bash
ssh pi@172.16.1.{NR}
```
Note: user: pi - passwd: raspberry

#### leJOS
- Install
  - Copy all files of SD-BRICK to the SD card
  - (Boot: Initial Boot needs some time)

- Access (Connection established by IP over USB (with Raspberry PI))
```bash
ssh root@10.0.1.1
```
Note: user: root - No passwd

#### Initial Setup
https://github.com/Transport-Protocol/CaDSPracticalExamVS/wiki

## External Usage
### Create Basic setup
In this project Eclipse is used with the leJOS Eclipse Plugin.
Please follow the steps described here: http://sourceforge.net/p/lejos/wiki/Installing%20the%20Eclipse%20plugin/

#### Download and extract leJOS
- [Download](https://sourceforge.net/projects/ev3.lejos.p/files/) leJOS EV3 (For the initial Setup, 0.9.1 beta was used) from https://sourceforge.net/projects/ev3.lejos.p/files/
- Extract leJOS_EV3_X.X.X-YYYY.tar.gz as leJOS to your root development directory

#### Clone Repo
Call `git clone https://github.com/Transport-Protocol/CaDSPracticalExamVS` to create local repo.

#### Implementation hints
Implementation hints can be found in the `src/cads/test/junit` folder.

#### For more information see
https://github.com/Transport-Protocol/CaDSPracticalExamVS/wiki
