#!/bin/bash

java -cp CaDSRMI.jar org.cads.vs.roboticArm.rmi.provider.CaDSRMIProvider -h 127.0.0.1 -S false -p 8888 -Rh 172.16.1.61 -Rp 50055 -ID mind-I
