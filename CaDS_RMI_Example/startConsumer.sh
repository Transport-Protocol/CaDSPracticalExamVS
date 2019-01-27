#!/bin/bash

java -cp CaDSRMI.jar org.cads.vs.roboticArm.rmi.consumer.CaDSRMIConsumer -h localhost -p 8888 -ID mind-I -Gr 1000
