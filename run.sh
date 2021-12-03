#mvn clean install

oc new-project wireshark-1
oc apply -f target/classes/openshift.yml -n wireshark-1
echo "Waiting for image streams"
sleep 20
oc start-build app --from-dir=target/quarkus-app --follow
oc expose svc/app --port=8080 -n wireshark-1 -lscenarioId=OpenShiftRestIT-wrs1
oc scale dc/app --replicas=1 -n wireshark-1
echo "Deployment finished"
oc status --suggest -n wireshark-1

#curl http://app-wireshark-1.apps.ocp49.dynamic.quarkus/hello/broken
