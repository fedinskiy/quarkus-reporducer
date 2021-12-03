oc scale dc/app --replicas=0 -n wireshark-1
oc delete project wireshark-1
